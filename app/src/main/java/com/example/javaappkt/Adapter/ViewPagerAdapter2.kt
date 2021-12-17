package com.example.javaappkt.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.javaappkt.IngredientMenu.FragAllIngredient
import com.example.javaappkt.IngredientMenu.FragMyIngredient

class ViewPagerAdapter2 (fragment : FragmentActivity) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FragMyIngredient()
            else -> FragAllIngredient()
        }
    }
}