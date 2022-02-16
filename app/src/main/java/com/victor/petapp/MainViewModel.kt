package com.victor.petapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.victor.petlibrary.apisource.VehicleFlagsApiSource
import com.victor.petlibrary.apisource.buildVehicleFlagsApiSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val vehicleFlagsApi: VehicleFlagsApiSource = buildVehicleFlagsApiSource()

    fun fetchVehicleFlags(): StateFlow<List<String>> {
        val response = MutableStateFlow<List<String>>(emptyList())

        viewModelScope.launch {
            vehicleFlagsApi.invoke("YV149MSS3H1337307", "US")
                .onSuccess { list ->
                    response.value = list
                }
        }

        return response
    }
}