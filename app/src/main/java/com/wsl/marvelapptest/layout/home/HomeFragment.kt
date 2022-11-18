package com.wsl.marvelapptest.layout.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wsl.marvelapptest.databinding.FragmentHomeBinding
import com.wsl.marvelapptest.ui.CharactersListAdapter
import kotlinx.android.synthetic.main.fragment_home.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    val viewModel: HomeViewModel by viewModel(clazz = HomeViewModel::class)

    private val listAdapter = CharactersListAdapter()
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        createRecycler()

        viewModel.getAllCharacters()
        setObservers()

        // Inflate the layout for this fragment
        return binding.root
    }

    private fun setObservers() {
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
        binding.root.homeCharactersList.apply {
            adapter = listAdapter
            layoutManager = GridLayoutManager(context, 2)
        }.addOnScrollListener(object: RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                if (!recyclerView.canScrollVertically(1) && newState==RecyclerView.SCROLL_STATE_IDLE){
                    viewModel.getAllCharacters()
                }
            }
        })
    }

    private fun showLoading(show: Boolean ){
        binding.homeLoading.visibility = if ( show ) View.VISIBLE else View.GONE
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}