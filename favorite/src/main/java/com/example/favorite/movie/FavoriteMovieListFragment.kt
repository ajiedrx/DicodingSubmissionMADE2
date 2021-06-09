package com.example.favorite.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dicodingsubmission2made.core.injection.domain.model.Film
import com.example.dicodingsubmission2made.databinding.FilmListFragmentBinding
import com.example.dicodingsubmission2made.presentation.IListFragment
import com.example.dicodingsubmission2made.presentation.adapters.ItemListAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class FavoriteMovieListFragment : Fragment(), IListFragment {
    private var binding: FilmListFragmentBinding? = null
    private val viewModel: FavoriteMovieListViewModel by viewModel()
    private lateinit var adapter: ItemListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        adapter = ItemListAdapter()
        adapter.notifyDataSetChanged()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FilmListFragmentBinding.inflate(inflater, container, false)
        showLoading(binding!!, true)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.rvFilms?.layoutManager = LinearLayoutManager(activity)
        binding?.rvFilms?.adapter = adapter
        adapter.setOnItemClickCallback(object : ItemListAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Film) {
                data.type = Film.MOVIE
                selectedItem(data, view, com.example.dicodingsubmission2made.R.id.action_favoriteFilmFragment_to_detailFragment)
            }
        })

        viewModel.getFavoritedMovie().observe(viewLifecycleOwner, {
            if (it != null) {
                adapter.setData(it)
                showLoading(binding!!, false)
            }
        })
    }
}