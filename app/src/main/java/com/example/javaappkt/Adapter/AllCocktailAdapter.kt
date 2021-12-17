package com.example.javaappkt.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.javaappkt.CocktailMenu.Cocktails
import com.example.javaappkt.R

class AllCocktailAdapter(val cocktailList: ArrayList<Cocktails>) : RecyclerView.Adapter<AllCocktailAdapter.CustomViewHolder>() { //CustomViewHolder 클래스 생성

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllCocktailAdapter.CustomViewHolder { // 화면 붙이는 초기 작업
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_cocktail, parent, false)
        return CustomViewHolder(view)//CustomViewHolder에서 itemView와 연결
    }

    override fun onBindViewHolder(holder: AllCocktailAdapter.CustomViewHolder, position: Int) { //아이템 바꼈을 때
        // 뷰에 대해 안정적이도록 데이터 매치
        // position 현재 클릭(바인딩)되는 인덱스 연동
        holder.Cocktails.setImageResource(cocktailList[position].cocktails)
        holder.name.text = cocktailList[position].name
        holder.needIngredients.text = cocktailList[position].needIngredients

        if (cocktailList[position].currentState) { //true
            //visible
        } else { //false
            //nonvisible
        }
    }

    override fun getItemCount(): Int {
        return cocktailList.size // 리스트 총 길이 리턴
    }

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) { //변수 할당
        val Cocktails = itemView.findViewById<ImageView>(R.id.ivCocktail) // 재료 사진
        val name = itemView.findViewById<TextView>(R.id.tvCocktailName) // 재료 이름
        val needIngredients = itemView.findViewById<TextView>(R.id.tvNeedIngredients) // 관련 주조 레시피 개수
    }
}