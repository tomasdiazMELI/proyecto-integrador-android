package com.example.integrador_android

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.integrador_android.adapter.ItemAdapter
import com.example.integrador_android.data.Datasource
import com.example.integrador_android.databinding.FragmentActivityListBinding

/**
 * A simple [Fragment] subclass.
 * Use the [ActivityListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ActivityListFragment : Fragment() {

    private var _binding: FragmentActivityListBinding? = null
    private val binding get() = _binding!!
    private var participants: Int = 0

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentActivityListBinding.inflate(inflater, container, false)
        // Inflate the layout for this
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.recyclerView
        val myDataSet = Datasource().loadActivities()
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = ItemAdapter(requireContext(), myDataSet)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.layout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.action_random -> {
                val action = ActivityListFragmentDirections.actionActivityListFragmentToSuggestionFragment(getString(R.string.random))
                findNavController().navigate(action)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}