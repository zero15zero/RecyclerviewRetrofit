package com.example.recyclerviewretrofit.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recyclerviewretrofit.models.Names
import com.example.recyclerviewretrofit.repository.NameDataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: NameDataRepository): ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO)
        {
            repository.getNames()
        }
    }

    val names:LiveData<Names>
    get() = repository.names
}