package com.example.javaappkt.CocktailMenu

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.javaappkt.Adapter.AllCocktailAdapter
import com.example.javaappkt.CommonInfo.MainActivity
import com.example.javaappkt.R
import com.example.javaappkt.databinding.FragAllCocktailBinding

class FragmentAllCock :Fragment() {

    private var mBinding: FragAllCocktailBinding? = null
    private val binding get() = mBinding!!

    // 1. Context를 할당할 변수를 프로퍼티로 선언(어디서든 사용할 수 있게)
    lateinit var mainActivity: MainActivity
    override fun onAttach(context: Context) {
        super.onAttach(context)

        // 2. Context를 액티비티로 형변환해서 할당
        mainActivity = context as MainActivity
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = FragAllCocktailBinding.inflate(inflater, container, false)

        val cocktailList = arrayListOf(
            Cocktails(R.drawable.black_russian, "블랙 러시안", "보드카, 깔루아", true),
            Cocktails(R.drawable.cape_cod, "케이프 코드", "보드카, 크렌베리 주스", false),
            Cocktails(R.drawable.greyhound, "그레이 하운드", "보드카, 자몽 주스", false),
            Cocktails(R.drawable.mind_eraser, "마인드 이레이저", "보드카, 깔루아, 토닉워터", false),
            Cocktails(R.drawable.screwdriver, "스크류 드라이버", "보드카, 오렌지 주스", false),
            Cocktails(R.drawable.sea_breeze, "씨브리즈", "보드카, 크렌베리 주스, 자몽 주스", false),
            Cocktails(R.drawable.sex_on_the_beach, "섹스 온더 비치", "보드카, 피치트리, 크렌베리 주스, 오렌지 주스", false),
            Cocktails(R.drawable.madras, "마드라스", "보드카, 크렌베리 주스, 오렌지 주스", false),
            Cocktails(R.drawable.tootsie_roll, "토시 롤", "깔루아, 오렌지 주스, 보드카(선택)", false)
        )

        //인자 설명: 액티비티를 담고있는 정보 context를 this로 삽입, *프래그먼트에서는 this 안되므로 context를 형변환하여 이용
        binding.rvAllCocktail.layoutManager = LinearLayoutManager(mainActivity, LinearLayoutManager.VERTICAL, false)
        binding.rvAllCocktail.setHasFixedSize(true) //리사이클러뷰 성능 개선 방안

        binding.rvAllCocktail.adapter = AllCocktailAdapter(cocktailList)
        return binding.root
    }
}