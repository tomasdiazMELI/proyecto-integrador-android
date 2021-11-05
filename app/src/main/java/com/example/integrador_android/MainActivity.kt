package com.example.integrador_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.integrador_android.databinding.ActivityMainBinding
import com.example.integrador_android.model.ActivityClass
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    private val activities = mutableListOf<ActivityClass>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getActionBar()?.hide();

        // Obtener una referencia al Host de la navegación
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
            as NavHostFragment
        navController = navHostFragment.navController

        //Garantiza que se vean los botones de la barra de direcciones.
        setupActionBarWithNavController(navController)
    }

    // Permite controlar la navegación hacía atras
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }


    // permite conectar con la api breed
    private fun getRetroFit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breed/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}



