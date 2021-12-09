package com.example.javaappkt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.javaappkt.databinding.FragIngredientBinding

class Fragment2 : Fragment() {

    private var mBinding:FragIngredientBinding? = null
    private val binding get() = mBinding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = FragIngredientBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onDestroyView() {
        // onDestroyView 에서 binding class 인스턴스 참조를 정리
        mBinding = null
        super.onDestroyView()
    }
}