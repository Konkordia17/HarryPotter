package com.example.harrypotter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.harrypotter.databinding.CharacterBinding

class HPAdapter : ListAdapter<Character, HPAdapter.HPViewHolder>(DiffUtilCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HPViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CharacterBinding.inflate(inflater, parent, false)
        return HPViewHolder(binding)

    }

    override fun onBindViewHolder(holder: HPViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class HPViewHolder(private val binding: CharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(character: Character) {
            with(binding) {
                nameTextView.text = character.name
                houseTextView.text = character.house
                speciesTextView.text = character.species
                Glide.with(itemView)
                    .load(character.image)
                    .into(avatar)
            }
        }
    }

    class DiffUtilCallBack : DiffUtil.ItemCallback<Character>() {
        override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem == newItem
        }
    }
}