package com.example.javaappkt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.javaappkt.databinding.FragAllCocktailBinding

class FragmentAllCock :Fragment() {

    private var mBinding: FragAllCocktailBinding? = null
    private val binding get() = mBinding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = FragAllCocktailBinding.inflate(inflater, container, false)
        return binding.root
    }
}