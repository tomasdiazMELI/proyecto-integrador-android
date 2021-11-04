package com.example.integrador_android

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.integrador_android.adapter.ItemAdapter
import com.example.integrador_android.databinding.FragmentSuggestionBinding
import com.example.integrador_android.model.ActivityClass
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



/**
 * A simple [Fragment] subclass.
 * Use the [SuggestionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SuggestionFragment : Fragment() {

    private var _binding: FragmentSuggestionBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ItemAdapter

    private lateinit var activitiesResponse : ActivityClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)


    }

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSuggestionBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment


        llamarACourutine()
        return binding.root
    }

    private fun llamarACourutine() {
        CoroutineScope(Dispatchers.IO).launch {
            //llame a retroFIT
            //agarre la query y la busque en la url

            var query: String= "education"
            var participants : Int = 1
            val llamada = getRetroFit()
                .create(APIService::class.java)


            //capturar los resultados
            try {
                val lala = llamada.obtenerActivities("$query")

                val respuesta: String? = lala.body()
            }
            catch (e:Exception ){
                throw e
            }


            getActivity()?.runOnUiThread {
              /*  if (llamada.isSuccessful) {
                    val activitiesAMostrar= respuesta?.name
                    //activitiesAMostrar?.let { activitiesResponse=it }
                    //adapter.notifyDataSetChanged()
                }*/
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getRetroFit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://www.boredapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}