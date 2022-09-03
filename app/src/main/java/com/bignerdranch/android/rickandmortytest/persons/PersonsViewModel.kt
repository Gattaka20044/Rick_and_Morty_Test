package com.bignerdranch.android.rickandmortytest.Persons

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.bignerdranch.android.rickandmortytest.PersonsPagingSource
import com.bignerdranch.android.rickandmortytest.api.PersonsApi
import com.bignerdranch.android.rickandmortytest.api.RetrofitInstance
import com.bignerdranch.android.rickandmortytest.model.persons.Result
import kotlinx.coroutines.flow.Flow


class PersonsViewModel : ViewModel() {

    val personApi: PersonsApi

    init {
        personApi = RetrofitInstance.getRetrofitInstance().create(PersonsApi::class.java)
    }

    fun getListData(): Flow<PagingData<Result>> {
        return Pager(config = PagingConfig(pageSize = 20, maxSize = 200),
            pagingSourceFactory = { PersonsPagingSource(personApi) }).flow.cachedIn(viewModelScope)

    }
}