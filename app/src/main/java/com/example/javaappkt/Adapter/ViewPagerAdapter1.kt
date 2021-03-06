package com.example.javaappkt.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.javaappkt.CocktailMenu.FragmentAllCock
import com.example.javaappkt.CocktailMenu.FragmentMyCock

class ViewPagerAdapter1 (fragment : FragmentActivity) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FragmentMyCock()
            else -> FragmentAllCock()
        }
    }
}