package com.example.dicodingsubmission2made.presentation.adapters

import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.dicodingsubmission2made.presentation.main.movie.MovieListFragment
import com.example.dicodingsubmission2made.presentation.main.tvshow.TvShowFragment

class SectionPagerAdapter(@NonNull fragmentManager : FragmentManager,
                          @NonNull lifecycle : Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment =
                MovieListFragment()
            1 -> fragment =
                TvShowFragment()
        }
        return fragment as Fragment
    }
}