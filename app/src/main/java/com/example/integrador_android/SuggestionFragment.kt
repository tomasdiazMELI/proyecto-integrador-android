package com.example.integrador_android

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.integrador_android.databinding.FragmentSuggestionBinding
import kotlin.properties.Delegates

class SuggestionFragment : Fragment() {

    companion object {
        const val ACTIVITY = "activity"
    }

    private var _binding: FragmentSuggestionBinding? = null
    private val binding get() = _binding!!

    private lateinit var activityValue: String
    private var participantsValue: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        arguments?.let {
            activityValue = it.get(ACTIVITY).toString()
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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvActivity.text = activityValue

        binding.tvCantParticipants.text = participantsValue.toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}