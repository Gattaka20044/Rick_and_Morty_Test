package com.bignerdranch.android.rickandmortytest.person

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.bignerdranch.android.rickandmortytest.R
import com.bignerdranch.android.rickandmortytest.databinding.PersonItemBinding
import com.bumptech.glide.Glide

private const val ARG_URL_PERSON = "ARG_URL_PERSON"


class PersonFragment : Fragment() {

    private lateinit var personViewModel: PersonViewModel
    private lateinit var bindingClass: PersonItemBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        bindingClass = PersonItemBinding.inflate(inflater)

        return bindingClass.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initPersonsViewModel()

    }

    @SuppressLint("StringFormatInvalid")
    private fun initPersonsViewModel() {
        personViewModel = ViewModelProvider(this).get(PersonViewModel::class.java)
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            val person = personViewModel.getItemPerson(getUrlPerson())

            bindingClass.apply {
                namePerson.text = getString(R.string.name, person.name)
                statusPerson.text = getString(R.string.status, person.status)
                speciesPerson.text = getString(R.string.species, person.species)
                genderPerson.text = getString(R.string.gender, person.gender)
                lastLocation.text = getString(R.string.last_location, person.location)
                numberOfEpisodes.text = getString(R.string.number_of_episodes, person.episode.size.toString())

                Glide.with(imageView)
                    .load(person.image)
                    .into(imageView)

            }
        }
    }

    private fun getUrlPerson(): Int = requireArguments().getInt(ARG_URL_PERSON)!!

    companion object {
        fun newInstance(urlPerson: Int): PersonFragment {
            val args = Bundle().apply {
                putInt(ARG_URL_PERSON, urlPerson)
            }

            val fragment = PersonFragment()
            fragment.arguments = args
            return fragment

        }
    }
}