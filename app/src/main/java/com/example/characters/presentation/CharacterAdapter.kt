package com.example.characters.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.characters.R
import com.example.characters.presentation.model.CharacterPresentation
import kotlinx.android.synthetic.main.character.view.*

class CharacterAdapter(var characterList: MutableList<CharacterPresentation>,  private val context: Context):
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    lateinit var characterName: TextView

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            LayoutInflater.from(context)
                .inflate(
                    R.layout.character,
                    parent,
                    false
                )
        )
    }

    fun  updateCharacters(characters: List<CharacterPresentation>) {
        characterList.addAll(characters)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int  = characterList.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characterList[position]
        val imageView = holder.itemView.characterImage
        holder.itemView.characterName.text = character.name
        holder.itemView.characterStatus.text = character.status
        holder.itemView.characterImage.load(character.url)
    }

    class CharacterViewHolder(view: View): RecyclerView.ViewHolder(view)
}