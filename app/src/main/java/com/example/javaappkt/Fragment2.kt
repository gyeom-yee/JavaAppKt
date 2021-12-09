package com.example.javaappkt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.javaappkt.databinding.FragIngredientBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class Fragment2 : Fragment() {

    private var mBinding:FragIngredientBinding? = null
    private val binding get() = mBinding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = FragIngredientBinding.inflate(inflater,container,false)

        binding.tabLayoutIngredient.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                // 탭이 선택되었을때
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // 탭이 선택되지 않은 상태로 변경 되었을 때
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                //이미 선택된 탭이 다시 선택 되었을 때
            }
        })

        binding.pagerIngredient.adapter = ViewPagerAdapter2(requireActivity())
        TabLayoutMediator(binding.tabLayoutIngredient, binding.pagerIngredient) {tab, position ->
            when(position) {
                0 -> tab.text = "내 재료"
                1 -> tab.text = "모든 재료"
            }
        }.attach()

        return binding.root
    }

    override fun onDestroyView() {
        // onDestroyView 에서 binding class 인스턴스 참조를 정리
        mBinding = null
        super.onDestroyView()
    }
}