package com.example.javaappkt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.javaappkt.databinding.FragAllIngredientBinding

class FragAllIngredient : Fragment() {

    private var mBinding:FragAllIngredientBinding? = null
    private val binding get() = mBinding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = FragAllIngredientBinding.inflate(inflater, container, false)

        return binding.root
    }
}