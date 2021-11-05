package com.example.integrador_android

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.compose.ui.text.toLowerCase
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.example.integrador_android.databinding.FragmentSuggestionBinding
import com.example.integrador_android.network.ActivityApi
import com.example.integrador_android.network.ActivityResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SuggestionFragment : Fragment() {

    companion object {
        const val ACTIVITY = "activity"
    }

    private var _binding: FragmentSuggestionBinding? = null
    private val binding get() = _binding!!

    private lateinit var activityValue: String
    private var participantsValue: Int? = null

    private lateinit var ActivityTV: TextView
    private lateinit var CostTV: TextView
    private lateinit var ActivityCategoryTV: TextView

    private var isRandom: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        arguments?.let {
            activityValue = it.get(ACTIVITY).toString()
            if(activityValue == getString(R.string.random)) isRandom = true
        }

        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
        participantsValue = sharedPref?.getInt(getString(R.string.saved_participants_key), 1)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSuggestionBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment

        binding.btnTryAnother.setOnClickListener {
            getActivityApi()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ActivityTV = binding.tvActivity
        CostTV = binding.tvCost
        ActivityCategoryTV = binding.tvActivityCategory

        ActivityCategoryTV.isVisible = isRandom

        binding.tvCantParticipants.text = participantsValue.toString()

        getActivityApi()
    }

    private fun getActivityApi() {
        binding.progressBar.visibility = View.VISIBLE
        CoroutineScope(Dispatchers.IO).launch {
            try {
                //val querycomplete = "${participantsValue.toString()}&type=${activityValue.lowercase()}"
                //val optionsMap = mapOf<String, String>("type" to activityValue.lowercase())
                val result: ActivityResponse? = if (isRandom)
                    ActivityApi.retrofitService.getActivityRandom(participantsValue.toString())
                else
                    ActivityApi.retrofitService.getActivity(participantsValue.toString(), activityValue.lowercase())

                result?.activity?.let {
                    activity?.runOnUiThread {
                        ActivityTV.text = result?.activity
                        ActivityCategoryTV.text = result?.type
                        when(result?.price ?: 0f) {
                            0f -> CostTV.text = getString(R.string.free)
                            in 0.1..0.3 -> CostTV.text = getString(R.string.low)
                            in 0.4..0.6 -> CostTV.text = getString(R.string.medium)
                            else -> CostTV.text = getString(R.string.high)
                        }
                        binding.progressBar.visibility = View.GONE
                    }
                }

                result?.error?.let {
                    activity?.runOnUiThread {
                        try {
                            Toast.makeText(context, it, Toast.LENGTH_LONG).show()
                            findNavController().navigateUp()
                        } catch (e: Exception) {
                            throw e
                        }
                    }
                }
            } catch (e: Exception) {
                throw e
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}