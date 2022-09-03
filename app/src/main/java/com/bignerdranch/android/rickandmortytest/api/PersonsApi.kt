package com.bignerdranch.android.rickandmortytest.api

import com.bignerdranch.android.rickandmortytest.model.person.Person
import com.bignerdranch.android.rickandmortytest.model.persons.Persons
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PersonsApi {
    @GET("character")
    suspend fun fetchPersons(@Query("page") query: Int): Persons

    @GET("character/{id}")
    suspend fun fetchPerson(@Path("id") query: Int): Person
}