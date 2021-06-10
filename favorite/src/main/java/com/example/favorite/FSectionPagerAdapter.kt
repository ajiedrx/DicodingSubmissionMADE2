package com.example.favorite

import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.favorite.movie.FavoriteMovieListFragment
import com.example.favorite.tvshow.FavoriteTvShowListFragment


class FSectionPagerAdapter(@NonNull fragmentManager : FragmentManager,
                           @NonNull lifecycle : Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment =
                FavoriteMovieListFragment()
            1 -> fragment =
                FavoriteTvShowListFragment()
        }
        return fragment as Fragment
    }
}