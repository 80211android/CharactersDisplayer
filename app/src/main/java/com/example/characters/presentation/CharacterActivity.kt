package com.example.characters.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.characters.R
import com.example.characters.data.Repository
import com.example.characters.data.mapper.CharacterMapper
import com.example.characters.data.service.RemoteService
import com.example.characters.presentation.model.CharacterPresentation
import kotlinx.android.synthetic.main.activity_main.*

class CharacterActivity : AppCompatActivity(), CharacterContract.View {

    lateinit var recyclerView: RecyclerView
    lateinit var characterAdapter: CharacterAdapter
    lateinit var characterPresenter: CharacterPresenter
    val characterList = mutableListOf(CharacterPresentation())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        characterPresenter = CharacterPresenter(
            CharacterModel(Repository(RemoteService, CharacterMapper())),
            this
        )
        initRecyclerView()

        characterPresenter.getCharacters()
    }

    override fun onPause() {
        super.onPause()
        characterPresenter.clear()
    }

    fun initRecyclerView() {
        recyclerView = characterRecyclerView as RecyclerView
        characterAdapter = CharacterAdapter(characterList, this)

        recyclerView.apply {
            setHasFixedSize(true)
            adapter = characterAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun updateCharacters(characters: List<CharacterPresentation>) {
        characterAdapter.updateCharacters(characters)
    }
}
