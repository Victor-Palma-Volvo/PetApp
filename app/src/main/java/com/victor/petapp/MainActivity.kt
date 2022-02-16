package com.victor.petapp

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.victor.petlibrary.apisource.buildGithubApiSource
import kotlinx.coroutines.flow.observeOn

class MainActivity : AppCompatActivity() {
    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launchWhenStarted {
            viewModel.fetchVehicleFlags().collect { list ->
                var content = "The list"
                list.map { item ->
                    content += "\n$item"
                }

                findViewById<TextView>(R.id.txt_main_title).text = content
            }
        }
    }
}