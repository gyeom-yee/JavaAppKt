package com.example.javaappkt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.javaappkt.databinding.FragCocktailBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class Fragment1 : Fragment() {

    private var mBinding:FragCocktailBinding? = null
    private val binding get() = mBinding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = FragCocktailBinding.inflate(inflater,container,false)

        // 탭 설정
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
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

        // 뷰페이저에 어댑터 연결
        binding.pager.adapter = ViewPagerAdapter(requireActivity())
        //탭과 뷰페이저 연결, 여기서 새로운 탭 다시 만드므로 레이아웃에서 꾸미지말고 여기서 꾸며야 함
        TabLayoutMediator(binding.tabLayout, binding.pager) {tab, position ->
            when(position) {
                0 -> tab.text = "My Cocktail"
                1 -> tab.text = "All Cocktail"
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