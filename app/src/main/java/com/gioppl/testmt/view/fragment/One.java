package com.gioppl.testmt.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class One extends BaseFragment {
    private TextView tv_name;
    private TextView tv_gender;
    private TextView tv_all;
    private TextView tv_phone;
    private TextView tv_academy;
    private TextView tv_jobNumber;
    private TextView tv_registerTime;
    private TextView tv_number;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_one, container, false);
        return null;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
    }

    @Override
    public void initView() {
    }

    @Override
    public void initData() {

    }
}
