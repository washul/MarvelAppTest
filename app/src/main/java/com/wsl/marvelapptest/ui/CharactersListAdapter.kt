package com.wsl.marvelapptest.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.wsl.domain.characters.models.CharacterEntity
import com.wsl.marvelapptest.R
import kotlinx.android.synthetic.main.character_home_list_card_view.view.*
import java.lang.Exception

class CharactersListAdapter: ListAdapter<CharacterEntity, CharactersListAdapter.ItemViewHolder>(CustomDiffUtils()) {

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: CharacterEntity) = with(itemView) {
            this.characterName.text = item.name
            val path = "${item.thumbnail.path}.${item.thumbnail.extension}"
            Picasso.get()
                .load(path)
                .placeholder(R.drawable.placeholder)
                .into(this.characterImage)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int): ItemViewHolder =
        ItemViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(
                    R.layout.character_home_list_card_view,
                    parent,
                    false
                )
        )

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private class CustomDiffUtils: DiffUtil.ItemCallback<CharacterEntity>() {
        override fun areItemsTheSame(
            oldItem: CharacterEntity,
            newItem: CharacterEntity
        ): Boolean = oldItem == newItem
        override fun areContentsTheSame(
            oldItem: CharacterEntity,
            newItem: CharacterEntity
        ): Boolean = oldItem.id == newItem.id
    }
}

