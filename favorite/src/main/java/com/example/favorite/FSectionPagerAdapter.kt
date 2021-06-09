package com.example.favorite

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.favorite.movie.FavoriteMovieListFragment
import com.example.favorite.tvshow.FavoriteTvShowListFragment


class FSectionPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
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