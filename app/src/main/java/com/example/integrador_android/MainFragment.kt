package com.example.integrador_android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.integrador_android.databinding.FragmentMainBinding
import androidx.appcompat.app.AppCompatActivity




// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstaceState: Bundle?){
        super.onCreate(savedInstaceState)
        // Oculta el action bar de todas las vistas, debido a que oculta de la actividad
        // activity as AppCompatActivity?)!!.supportActionBar!!.hide()
        setHasOptionsMenu(false)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstaceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvTermsAndConditions.setOnClickListener{
            val action = MainFragmentDirections.actionMainFragmentToTermsAndConditionsFragment()

            findNavController().navigate(action)
        }

        binding.btnStart.setOnClickListener{
            val action = MainFragmentDirections.actionMainFragmentToActivityListFragment()

            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}