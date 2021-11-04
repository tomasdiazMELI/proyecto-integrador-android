package com.example.integrador_android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.integrador_android.databinding.FragmentSuggestionBinding


/**
 * A simple [Fragment] subclass.
 * Use the [SuggestionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SuggestionFragment : Fragment() {

    companion object {
        const val ACTIVITY = "activity"
    }


    private var _binding: FragmentSuggestionBinding? = null
    private val binding get() = _binding!!

    private lateinit var activity: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        arguments?.let {
            activity = it.get(ACTIVITY).toString()
        }
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

        binding.tvActivity.text = activity
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}