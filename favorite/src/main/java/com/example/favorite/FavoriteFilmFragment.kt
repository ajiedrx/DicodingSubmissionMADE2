package com.example.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.dicodingsubmission2made.databinding.FilmTabsFragmentBinding
import com.example.favorite.favorite.favoriteModule
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.core.context.loadKoinModules

class FavoriteFilmFragment : Fragment() {
    private var binding: FilmTabsFragmentBinding? = null

    companion object {
        val TAB_TITLES = arrayListOf(
            "Movies",
            "TV Show"
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSectionPager()
        loadKoinModules(favoriteModule)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FilmTabsFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    private fun initSectionPager() {
        val sectionPagerAdapter = FSectionPagerAdapter(this)
        val viewPager: ViewPager2? = binding?.ffViewpager
        viewPager?.adapter = sectionPagerAdapter
        val tabs: TabLayout? = binding?.tabs
        if (tabs != null) {
            if (viewPager != null) {
                TabLayoutMediator(tabs, viewPager) { tab, position ->
                    tab.text = TAB_TITLES[position]
                }.attach()
            }
        }
    }

}