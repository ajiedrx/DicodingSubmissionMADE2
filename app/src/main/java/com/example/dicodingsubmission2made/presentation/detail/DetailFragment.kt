package com.example.dicodingsubmission2made.presentation.detail

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.dicodingsubmission2made.core.injection.domain.model.Film
import com.example.dicodingsubmission2made.databinding.DetailFragmentBinding
import org.koin.android.viewmodel.ext.android.viewModel


class DetailFragment : Fragment() {

    private var binding: DetailFragmentBinding? = null
    private val viewModel: DetailViewModel by viewModel()
    private lateinit var filmData : Film

    companion object{
        private const val IMAGE_BASE_URL = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        filmData = arguments?.getParcelable(Film.FILM)!!
        viewModel.getFilmDetail(filmData).observe(viewLifecycleOwner, {
            if (it != null) {
                binding?.filmTitle?.text = it.name
                binding?.filmGenre?.text = it.genre
                binding?.filmDuration?.text = it.duration
                Glide.with(view)
                    .load(
                        IMAGE_BASE_URL+(arguments?.getParcelable<Film>(
                        Film.FILM)!!).poster)
                    .into(binding?.filmPoster!!)
                binding?.filmOverview?.setMovementMethod(ScrollingMovementMethod())
                binding?.filmOverview?.text = it.overview
                binding?.favoriteBtn?.isChecked = viewModel.isFavorite(filmData.film_id!!)
            }
        })
        binding?.favoriteBtn?.setOnCheckedChangeListener{ _, isChecked ->
            if(isChecked){
                viewModel.addFavoriteFilm(filmData)
            }
            else{
                viewModel.removeFavoriteFilm(filmData)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = DetailFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }
}