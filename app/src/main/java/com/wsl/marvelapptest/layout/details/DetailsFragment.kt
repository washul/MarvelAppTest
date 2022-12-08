package com.wsl.marvelapptest.layout.details

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.wsl.marvelapptest.R
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.wsl.marvelapptest.base.BaseViewModelFragment
import com.wsl.marvelapptest.common.layout.LayoutFragment
import com.wsl.marvelapptest.databinding.FragmentDetailsBinding
import com.wsl.marvelapptest.ui.CharacterComicListAdapter
import kotlinx.android.synthetic.main.fragment_details.view.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import org.koin.core.parameter.parametersOf

@LayoutFragment(R.layout.fragment_details)
class DetailsFragment : BaseViewModelFragment<FragmentDetailsBinding, DetailsViewModel> (
    DetailsViewModel::class
) {

    private val args: DetailsFragmentArgs by navArgs()
    override val viewModel: DetailsViewModel by viewModel {
        parametersOf(args.characterID)
    }

    private lateinit var comicsListAdapter: CharacterComicListAdapter

    override fun subscribeToViewModel(viewModel: DetailsViewModel) {
        //CharacterComicList
        viewModel.comics.observe(viewLifecycleOwner) {
            comicsListAdapter.submitList(it)
        }
        //ShowLoading
        viewModel.showLoading.observe(viewLifecycleOwner) {
            showLoading(it)
        }
    }

    override fun setupViews(savedInstanceState: Bundle?) {
        super.setupViews(savedInstanceState)
        createRecycler()
    }

    private fun createRecycler() {
        comicsListAdapter = CharacterComicListAdapter { }
        binding.root.comicsList.apply {
            adapter = comicsListAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
    }


    private fun showLoading(show: Boolean ){
        binding.detailLoading.visibility = if ( show ) View.VISIBLE else View.GONE
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            DetailsFragment()
    }
}