package com.example.uitest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

//프래그먼트 수
private const val NUM_PAGES = 5

class ScreenSlidePagerActivity : FragmentActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_slide)

        // Instantiate a ViewPager2 and a PagerAdapter.
        //activity_screen_slide.xml의 pager
        viewPager = findViewById(R.id.pager)

        // The pager adapter, which provides the pages to the view pager widget.
        val pagerAdapter = ScreenSlidePagerAdapter(this)
        //viewpager에 어댑터 연결
        viewPager.adapter = pagerAdapter
        //viewpager와 bottom navi를 연결하는 함수
        viewPager.registerOnPageChangeCallback(PageChangeCallback())
        //viewpager animation
        viewPager.setPageTransformer(ZoomOutPageTransformer())
        //bottom navigation
        bottomnavi.setOnNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (viewPager.currentItem == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed()
        } else {
            // Otherwise, select the previous step.
            viewPager.currentItem = viewPager.currentItem - 1
        }
    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private inner class ScreenSlidePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = NUM_PAGES
        //fragment위치
        override fun createFragment(position: Int): Fragment{
            return when(position){
                0 -> ScreenSlidePageFragment()
                1 -> testfragment()
                2 -> ScreenSlidePageFragment()
                3 -> testfragment()
                4 -> ScreenSlidePageFragment()
                else-> ScreenSlidePageFragment()
            }
        }
    }

    override fun onNavigationItemSelected(p0:MenuItem): Boolean {
        when(p0.itemId){
            R.id.aitem -> {
                viewPager.currentItem = 0
                return true
            }
            R.id.bitem -> {
                viewPager.currentItem = 1
                return true
            }
            R.id.citem -> {
                viewPager.currentItem = 2
                return true
            }
            R.id.ditem -> {
                viewPager.currentItem = 3
                return true
            }
            R.id.eitem -> {
                viewPager.currentItem = 4
                return true
            }
        }
        return true
    }
    //
    private inner class PageChangeCallback: ViewPager2.OnPageChangeCallback(){
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            bottomnavi.selectedItemId = when(position){
                0 -> R.id.aitem
                1 -> R.id.bitem
                2 -> R.id.citem
                3 -> R.id.ditem
                4 -> R.id.eitem
                else-> R.id.aitem
            }
        }
    }
}
