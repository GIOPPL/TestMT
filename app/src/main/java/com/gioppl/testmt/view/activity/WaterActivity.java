package com.gioppl.testmt.view.activity;

import android.app.Activity;
import android.os.Bundle;

import com.gioppl.testmt.R;
import com.gyf.barlibrary.ImmersionBar;

public class WaterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water);
        ImmersionBar.with(this).init();
    }
}
