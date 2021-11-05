package com.example.integrador_android

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.integrador_android.databinding.FragmentMainBinding
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.rememberUpdatedState
import androidx.core.widget.doOnTextChanged

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstaceState: Bundle?){
        super.onCreate(savedInstaceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstaceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        binding.btnStart.setOnClickListener {
            val isValid: Boolean = validateResponse(binding.inputParticipants.text.toString())

            if(isValid){
                val participantsValue = binding.inputParticipants.text.toString().toInt()
                val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)

                sharedPref?.let {
                    with(it.edit()){
                        putInt(getString(R.string.saved_participants_key), participantsValue)
                        apply()
                    }
                }

                val action = MainFragmentDirections.actionMainFragmentToActivityListFragment()
                findNavController().navigate(action)
            }
        }

        binding.tvTermsAndConditions.setOnClickListener{
            val action = MainFragmentDirections.actionMainFragmentToTermsAndConditionsFragment()
            findNavController().navigate(action)
        }

        return binding.root
    }

    private fun validateResponse(text: String) : Boolean {
        var response = true
        if(text.isNullOrBlank()){
            getString(R.string.error_empty).also { binding.inputParticipants.error = it }
            response = false
        } else if (text.toInt() == 0) {
            getString(R.string.error_zero).also { binding.inputParticipants.error = it }
            response = false
        }

        return response
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}