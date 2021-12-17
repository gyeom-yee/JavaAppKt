package com.example.javaappkt.IngredientMenu

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.javaappkt.Adapter.AllIngredientsAdapter
import com.example.javaappkt.CommonInfo.MainActivity
import com.example.javaappkt.R
import com.example.javaappkt.databinding.FragAllIngredientBinding

class FragAllIngredient : Fragment() {

    private var mBinding:FragAllIngredientBinding? = null
    private val binding get() = mBinding!!

    // 1. Context를 할당할 변수를 프로퍼티로 선언(어디서든 사용할 수 있게)
    lateinit var mainActivity: MainActivity
    override fun onAttach(context: Context) {
        super.onAttach(context)

        // 2. Context를 액티비티로 형변환해서 할당
        mainActivity = context as MainActivity
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = FragAllIngredientBinding.inflate(inflater, container, false)

        val ingredientList = arrayListOf(
            Ingredients(R.drawable.vodka, "보드카", "관련 조주 레시피: n 개", true),
            Ingredients(R.drawable.kahlua, "깔루아", "관련 조주 레시피: n 개", false),
            Ingredients(R.drawable.orange_juice, "오렌지 주스", "관련 조주 레시피: n 개", false),
            Ingredients(R.drawable.cranberry_juice, "크렌베리 주스", "관련 조주 레시피: n 개", false),
            Ingredients(R.drawable.cider, "사이다", "관련 조주 레시피: n 개", false),
            Ingredients(R.drawable.cola, "콜라", "관련 조주 레시피: n 개", false),
            Ingredients(R.drawable.grapefruit_juice, "자몽 주스", "관련 조주 레시피: n 개", false),
            Ingredients(R.drawable.peachtree, "피치트리", "관련 조주 레시피: n 개", false),
            Ingredients(R.drawable.tonic, "토닉워터", "관련 조주 레시피: n 개", false)
        )

        //인자 설명: 액티비티를 담고있는 정보 context를 this로 삽입, *프래그먼트에서는 this 안되므로 context를 형변환하여 이용
        binding.rvAllIngerdient.layoutManager = LinearLayoutManager(mainActivity, LinearLayoutManager.VERTICAL, false)
        binding.rvAllIngerdient.setHasFixedSize(true) //리사이클러뷰 성능 개선 방안

        binding.rvAllIngerdient.adapter = AllIngredientsAdapter(ingredientList)
        return binding.root
    }
}