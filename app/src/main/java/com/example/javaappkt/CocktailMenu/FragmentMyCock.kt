package com.example.javaappkt.CocktailMenu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.javaappkt.databinding.FragMyCocktailBinding

class FragmentMyCock : Fragment() {

    private var mBinding : FragMyCocktailBinding? = null
    private val binding get() = mBinding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = FragMyCocktailBinding.inflate(inflater, container, false)
        return binding.root
    }
}