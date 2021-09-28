package com.example.recyclerviewretrofit.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.recyclerviewretrofit.api.ApiSet
import com.example.recyclerviewretrofit.models.Names

class NameDataRepository(private val NamesData: ApiSet) {

    private val namesLiveData= MutableLiveData<Names>()

    val names:LiveData<Names>
    get()=namesLiveData

    suspend fun getNames(){
        val result=NamesData.getNames()
        if(result?.body() != null)
        {
            namesLiveData.postValue(result.body())
        }
    }
}