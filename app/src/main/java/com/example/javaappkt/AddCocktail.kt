package com.example.javaappkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.javaappkt.databinding.ActivityAddCocktailBinding

class AddCocktail : AppCompatActivity() {

    private var mBinding : ActivityAddCocktailBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityAddCocktailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.tbBack)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        binding.tbBack.title = "칵테일 추가하기"
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