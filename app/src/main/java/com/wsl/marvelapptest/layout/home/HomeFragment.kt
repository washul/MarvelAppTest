package com.wsl.marvelapptest.layout.home

import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wsl.marvelapptest.R
import com.wsl.marvelapptest.base.BaseViewModelFragment
import com.wsl.marvelapptest.common.layout.LayoutFragment
import com.wsl.marvelapptest.databinding.FragmentHomeBinding
import com.wsl.marvelapptest.ui.CharactersListAdapter
import kotlinx.android.synthetic.main.fragment_home.view.*

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@LayoutFragment(R.layout.fragment_home)
class HomeFragment : BaseViewModelFragment<FragmentHomeBinding, HomeViewModel> (
    HomeViewModel::class) {

    private lateinit var listAdapter: CharactersListAdapter

    override fun subscribeToViewModel(viewModel: HomeViewModel) {
        createRecycler()

        //CharacterList
        viewModel.charactersList.observe(viewLifecycleOwner) {
            listAdapter.submitList(it)
        }
        //ShowLoading
        viewModel.showLoading.observe(viewLifecycleOwner) {
            showLoading(it)
        }
    }

    private fun createRecycler() {
        listAdapter = CharactersListAdapter { itemId ->
            goToDetails(itemId)
        }
        binding.root.homeCharactersList.apply {
            adapter = listAdapter
            layoutManager = GridLayoutManager(context, 1)
        }.addOnScrollListener(object: RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                if (!recyclerView.canScrollVertically(1) && newState==RecyclerView.SCROLL_STATE_IDLE){
                    viewModel.getAllCharacters()
                }
            }
        })
    }

    private fun goToDetails(id: Int) {
        navController.navigate(HomeFragmentDirections.actionHomeFragmentToDetailsFragment(id))
    }

    private fun showLoading(show: Boolean ){
        binding.homeLoading.visibility = if ( show ) View.VISIBLE else View.GONE
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}