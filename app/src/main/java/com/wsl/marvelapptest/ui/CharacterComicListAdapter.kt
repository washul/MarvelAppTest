package com.wsl.marvelapptest.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.wsl.domain.characters.models.CharacterEntity
import com.wsl.domain.comics.models.ComicEntity
import com.wsl.marvelapptest.R
import com.wsl.marvelapptest.databinding.ComicCharacterDetailCvBinding
import kotlinx.android.synthetic.main.character_home_list_card_view.view.*

class CharacterComicListAdapter (private val onItemClick: (id: Int) -> Unit):
    ListAdapter<ComicEntity, CharacterComicListAdapter.ItemViewHolder>(CustomDiffUtils()) {

        private lateinit var binding: ComicCharacterDetailCvBinding

        class ItemViewHolder(private val binding: ComicCharacterDetailCvBinding) :
            RecyclerView.ViewHolder(binding.root) {

            fun bind(item: ComicEntity) = with(itemView) {
                binding.name.text = item.title
                val path = "${item.thumbnail.path}.${item.thumbnail.extension}"
                Picasso.get()
                    .load(path)
                    .fit()
                    .placeholder(R.drawable.placeholder)
                    .into(binding.image)
            }
        }

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int): ItemViewHolder {
            binding = ComicCharacterDetailCvBinding
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
            //holder.itemView.setOnClickListener { onItemClick(getItem(position).i) }
            holder.bind(getItem(position))
        }

        private class CustomDiffUtils: DiffUtil.ItemCallback<ComicEntity>() {
            override fun areItemsTheSame(
                oldItem: ComicEntity,
                newItem: ComicEntity
            ): Boolean = oldItem == newItem
            override fun areContentsTheSame(
                oldItem: ComicEntity,
                newItem: ComicEntity
            ): Boolean = oldItem.id == newItem.id
        }


}