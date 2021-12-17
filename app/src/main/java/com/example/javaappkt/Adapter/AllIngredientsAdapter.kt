package com.example.javaappkt.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.javaappkt.IngredientMenu.Ingredients
import com.example.javaappkt.R

class AllIngredientsAdapter(val ingredientList: ArrayList<Ingredients>) : RecyclerView.Adapter<AllIngredientsAdapter.CustomViewHolder>() { //CustomViewHolder 클래스 생성

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllIngredientsAdapter.CustomViewHolder { // 화면 붙이는 초기 작업
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_ingredient, parent, false)
        return CustomViewHolder(view)//CustomViewHolder에서 itemView와 연결
    }

    override fun onBindViewHolder(holder: AllIngredientsAdapter.CustomViewHolder, position: Int) { //아이템 바꼈을 때
        // 뷰에 대해 안정적이도록 데이터 매치
        // position 현재 클릭(바인딩)되는 인덱스 연동
        holder.ingredients.setImageResource(ingredientList[position].ingredients)
        holder.name.text = ingredientList[position].name
        holder.possible.text = ingredientList[position].possible

        holder.checkBox!!.setOnCheckedChangeListener { _, isChecked ->
            ingredientList[position].currentState = !(ingredientList[position].currentState)
            println("바뀜")
        }

        if (ingredientList[position].currentState) { //체크 되야함
            holder.checkBox!!.isChecked = true
            println(ingredientList[position].name+"선택됨")
        } else { //체크해제 해야함
            holder.checkBox!!.isChecked = false
            println(ingredientList[position].name+"해제됨")
        }
    }

    override fun getItemCount(): Int {
        return ingredientList.size // 리스트 총 길이 리턴
    }

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) { //변수 할당
        val ingredients = itemView.findViewById<ImageView>(R.id.ivIngredient) // 재료 사진
        val name = itemView.findViewById<TextView>(R.id.tvIngredientName) // 재료 이름
        val possible = itemView.findViewById<TextView>(R.id.tvPossible) // 관련 주조 레시피 개수
        val checkBox = itemView.findViewById<CheckBox>(R.id.cbIngredient) // 체크박스
    }
}