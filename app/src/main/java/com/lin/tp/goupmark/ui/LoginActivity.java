package com.lin.tp.goupmark.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.lin.tp.goupmark.R;

/**
 * Created by TP on 2016/7/12.
 */

public class LoginActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }
    public void click(View view)
    {
        switch (view.getId())
        {
            case R.id.bt_login:
//                Toast.makeText(LoginActivity.this,"登录",Toast.LENGTH_SHORT).show();
                Intent intent1=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent1);
                break;
            case R.id.tv_forget_password:
                Toast.makeText(LoginActivity.this,"忘记密码",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_regedit:
//                Toast.makeText(LoginActivity.this,"注册",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }
}
