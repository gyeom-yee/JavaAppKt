package com.example.javaappkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.javaappkt.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var mBinding:ActivityMainBinding? = null
    private val binding get() = mBinding!!

    private val fragment1 by lazy { Fragment1() }
    private val fragment2 by lazy { Fragment2() }
    private val fragment3 by lazy { Fragment3() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*네비게이션 바*/
        binding.btnNavi.setOnClickListener {
            binding.layoutDrawer.openDrawer(GravityCompat.START) // START : left, END : right랑 같은 말
        }
        binding.naviView.setNavigationItemSelectedListener(this) //네비게이션 메뉴 아이템에 클릭 속성 부여

        /*툴바*/
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false) //액션바에 표시되는 제목의 표시유무

        /*하단 네비게이션*/
        initNavigationBar()
    }

    /*바텀 네비게이션 프래그먼트*/
    private fun initNavigationBar() {
        binding.mainFrame.run { binding.bottomView?.setOnItemSelectedListener {
                when(it.itemId) {
                    R.id.bottomCocktail -> {
                        changeFragment(fragment1)
                    }
                    R.id.bottomIngredient -> {
                        changeFragment(fragment2)
                    }
                    R.id.bottomShop -> {
                        changeFragment(fragment3)
                    }
                }
                true
            }
            binding.bottomView?.selectedItemId = R.id.bottomCocktail
        }
    }
    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.mainFrame, fragment)
            .commit()
    }

    /*햄버거바 네비게이션*/
    override fun onNavigationItemSelected(item: MenuItem): Boolean { //네비게이션 메뉴 아이템 클릭 시 수행
        when (item.itemId) {
            R.id.naviLogin -> Toast.makeText(applicationContext, "로그인을 클릭했습니다.", Toast.LENGTH_SHORT).show()
            R.id.naviNotice -> Toast.makeText(applicationContext, "공지사항을 클릭했습니다.", Toast.LENGTH_SHORT).show()
            R.id.naviHelp -> Toast.makeText(applicationContext, "도움말을 클릭했습니다.", Toast.LENGTH_SHORT).show()
            R.id.naviSetting -> Toast.makeText(applicationContext, "설정을 클릭했습니다.", Toast.LENGTH_SHORT).show()
        }
        binding.layoutDrawer.closeDrawers() //네비게이션 뷰 닫기
        return false
    }

    /*툴바 네비게이션*/
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.tb_menu, menu)
        val search = menu?.findItem(R.id.tbSearch)?.actionView as SearchView
        return super.onCreateOptionsMenu(menu) // 옵션 메뉴 생성 부분
    }

    override fun onBackPressed() { // back 버튼 누를 시 수행하는 메소드
        if (binding.layoutDrawer.isDrawerOpen(GravityCompat.START)) {
            binding.layoutDrawer.closeDrawers()
        }
        else {
            super.onBackPressed() //일반 Back버튼 기능 실행 (finish 역할)
        }
    }
}