package com.example.javaappkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.javaappkt.databinding.ActivityAddIngredientBinding

class AddIngredient : AppCompatActivity() {

    private var mBinding : ActivityAddIngredientBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityAddIngredientBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.tbBack)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        binding.tbBack.title = "재료 추가하기"
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
