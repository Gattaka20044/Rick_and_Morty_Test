package com.bignerdranch.android.rickandmortytest.person

import androidx.lifecycle.ViewModel
import com.bignerdranch.android.rickandmortytest.api.PersonsApi
import com.bignerdranch.android.rickandmortytest.api.RetrofitInstance
import com.bignerdranch.android.rickandmortytest.model.person.Person

class PersonViewModel: ViewModel() {

    val personApi: PersonsApi

    init {
        personApi = RetrofitInstance.getRetrofitInstance().create(PersonsApi::class.java)
    }

    suspend fun getItemPerson(id: Int): Person {
        val person = personApi.fetchPerson(id)
        return person
    }
}