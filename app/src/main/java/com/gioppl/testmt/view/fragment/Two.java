package com.gioppl.testmt.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gioppl.testmt.R;
import com.gioppl.testmt.view.utils.ViewPagerTriangleIndicator3;

import java.util.ArrayList;
import java.util.List;


public class Two extends BaseFragment {
    private List<Fragment> viewsList;
    private ViewPager viewPager;
    private ViewPagerTriangleIndicator3 mViewPagerTriangleIndicator3;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_two, container, false);
//        return null;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
        initViewPager();
        initIndicator();
    }
    private void initIndicator() {
        mViewPagerTriangleIndicator3 = (ViewPagerTriangleIndicator3) getActivity().findViewById(R.id.vpti_main_tab);
        //添加滑动监听

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                mViewPagerTriangleIndicator3.scroll(position, positionOffset);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    private void initViewPager() {
        viewPager = getActivity().findViewById(R.id.vp_devices);
        viewsList = new ArrayList<>();
        viewsList.add(new Two1());
        viewsList.add(new Two2());
        viewsList.add(new Two3());
        FragmentPagerAdapter fragmentPagerAdapter = new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public int getCount() {
                return viewsList == null ? 0 : viewsList.size();
            }

            @Override
            public Fragment getItem(int i) {
                return viewsList.get(i);
            }
        };
        viewPager.setAdapter(fragmentPagerAdapter);
    }
    @Override
    public void initView() {
    }

    @Override
    public void initData() {

    }
}
