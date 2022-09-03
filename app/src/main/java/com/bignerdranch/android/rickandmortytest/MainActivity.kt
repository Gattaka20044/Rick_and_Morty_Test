package com.bignerdranch.android.rickandmortytest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bignerdranch.android.rickandmortytest.Persons.PersonsFragment
import com.bignerdranch.android.rickandmortytest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var bindingClass: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        val isfFragmentContainerEmpty = savedInstanceState == null
        if (isfFragmentContainerEmpty) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainer, PersonsFragment.newInstance())
                .commit()
        }
    }
}