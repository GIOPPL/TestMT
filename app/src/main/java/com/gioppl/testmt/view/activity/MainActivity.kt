package com.gioppl.testmt.view.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentPagerAdapter
import android.widget.RadioButton
import android.widget.RadioGroup
import com.gioppl.testmt.R
import com.gioppl.testmt.view.utils.BanSlidingViewPager
import com.gioppl.testmt.view.fragment.Four
import com.gioppl.testmt.view.fragment.One
import com.gioppl.testmt.view.fragment.Three
import com.gioppl.testmt.view.fragment.Two
import com.gyf.barlibrary.ImmersionBar
import java.util.*

class MainActivity : FragmentActivity() {
    var mRadioGroup: RadioGroup? = null
    var banSlidingViewPager: BanSlidingViewPager? = null
    private var rbtn: RadioButton? = null
    var mPagerList = ArrayList<Fragment>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
        ImmersionBar.with(this).init()
        initView()
        initFragment()
    }

    private fun initFragment() {
        banSlidingViewPager = findViewById(R.id.vp_main)

        mPagerList.add(One())
        mPagerList.add(Two())
        mPagerList.add(Three())
        mPagerList.add(Four())
        var pagerAdapt = object : FragmentPagerAdapter(supportFragmentManager) {
            override fun getItem(position: Int): Fragment = mPagerList.get(position)
            override fun getCount(): Int = mPagerList.size
        }
        banSlidingViewPager!!.adapter = pagerAdapt
    }

    private fun initView() {
        rbtn = findViewById(R.id.rbtn_main_one)
        mRadioGroup = findViewById<RadioGroup>(R.id.rg_main_bottom)
        mRadioGroup!!.check(rbtn!!.id)
        mRadioGroup!!.setOnCheckedChangeListener { radioGroup, i ->
            when (i) {
                R.id.rbtn_main_one -> {
                    banSlidingViewPager!!.currentItem = 0
                }
                R.id.rbtn_main_two -> {
                    banSlidingViewPager!!.currentItem = 1
                }
                R.id.rbtn_main_three -> {
                    banSlidingViewPager!!.currentItem = 2
                }
                R.id.rbtn_main_four -> {
                    banSlidingViewPager!!.currentItem = 3
                }
            }
        }
    }
}
