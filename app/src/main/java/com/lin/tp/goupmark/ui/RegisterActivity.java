package com.lin.tp.goupmark.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.lin.tp.goupmark.R;


/**
 * Created by TP on 2016/7/13.
 */

public class RegisterActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regedit);
    }
    public void register(View view)
    {
        Toast.makeText(RegisterActivity.this,"正在验证",Toast.LENGTH_SHORT).show();
    }
}
