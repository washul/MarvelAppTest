package com.wsl.marvelapptest.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.wsl.domain.characters.models.CharacterEntity
import com.wsl.marvelapptest.R
import com.wsl.marvelapptest.databinding.CharacterHomeListCardViewBinding
import kotlinx.android.synthetic.main.character_home_list_card_view.view.*

class CharactersListAdapter(private val onItemClick: (id: Int) -> Unit):
    ListAdapter<CharacterEntity, CharactersListAdapter.ItemViewHolder>(CustomDiffUtils()) {

    private lateinit var binding: CharacterHomeListCardViewBinding

    class ItemViewHolder(private val binding: CharacterHomeListCardViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CharacterEntity) = with(itemView) {
            binding.item = item
            val path = "${item.thumbnail.path}.${item.thumbnail.extension}"
            Picasso.get()
                .load(path)
                .fit()
                .placeholder(R.drawable.placeholder)
                .into(this.characterImage)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int): ItemViewHolder {
        binding = CharacterHomeListCardViewBinding
            .inflate(
                LayoutInflater
                    .from(
                        parent.context
                    ),
                parent,
                false
            )
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.itemView.setOnClickListener { onItemClick(getItem(position).id) }
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

