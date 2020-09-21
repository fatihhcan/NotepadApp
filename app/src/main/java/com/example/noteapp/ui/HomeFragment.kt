package com.example.noteapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.noteapp.R
import com.example.noteapp.db.NoteDatabase
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.launch


class HomeFragment : BaseFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        launch {
            context?.let {
                val notes = NoteDatabase(it).getNoteDao().getAllNotes()

            }
        }

        button_add.setOnClickListener {

            val action = HomeFragmentDirections.actionAddNote()
            Navigation.findNavController(it).navigate(action)
        }
    }

}