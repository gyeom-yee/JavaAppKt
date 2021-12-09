package com.example.javaappkt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.javaappkt.databinding.FragAllCocktailBinding
import com.example.javaappkt.databinding.FragMyIngredientBinding

class FragMyIngredient : Fragment() {

    private var mBinding : FragMyIngredientBinding? = null
    private val binding get() = mBinding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = FragMyIngredientBinding.inflate(inflater, container, false)

        return binding.root
    }
}