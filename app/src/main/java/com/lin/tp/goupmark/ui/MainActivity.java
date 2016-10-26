package com.lin.tp.goupmark.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.lin.tp.goupmark.R;
import com.lin.tp.goupmark.ui.fragment.FragmentForTab_1;
import com.lin.tp.goupmark.ui.fragment.WineTypeListFragment;
import com.lin.tp.goupmark.ui.fragment.FragmentForTab_2;
import com.lin.tp.goupmark.ui.fragment.FragmentForTab_3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TP on 2016/7/14.
 */

public class MainActivity extends FragmentActivity implements View.OnClickListener{
    private ViewPager mViewPager;
    private FragmentPagerAdapter mAdapter;
    private List<Fragment> mFragments;

    private LinearLayout mTabWeixin;
    private LinearLayout mTabFrd;
    private LinearLayout mTabAddress;

    private ImageButton mImgWeixin;
    private ImageButton mImgFrd;
    private ImageButton mImgAddress;
    Fragment mTab01;
    Fragment mTab02;
    Fragment mTab03;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTab01 = new FragmentForTab_1();
        mTab02 = new FragmentForTab_2();
        mTab03 = new FragmentForTab_3();
        initView();
        initEvent();
        setSelect(0);
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.myViewPager);

        mTabWeixin = (LinearLayout) findViewById(R.id.id_tab_weixin);
        mTabFrd = (LinearLayout) findViewById(R.id.id_tab_frd);
        mTabAddress = (LinearLayout) findViewById(R.id.id_tab_address);

        mImgWeixin = (ImageButton) findViewById(R.id.id_tab_weixin_img);
        mImgFrd = (ImageButton) findViewById(R.id.id_tab_frd_img);
        mImgAddress = (ImageButton) findViewById(R.id.id_tab_address_img);

        mFragments = new ArrayList<Fragment>();

        mFragments.add(mTab01);
        mFragments.add(mTab02);
        mFragments.add(mTab03);

        mAdapter =new MyFragmentPagerAdapter(getSupportFragmentManager(),mFragments);
        mViewPager.setAdapter(mAdapter);
        /*
        mViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        */
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {

            @Override
            public void onPageSelected(int arg0)
            {
                int currentItem = mViewPager.getCurrentItem();
                setTab(currentItem);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2)
            {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrollStateChanged(int arg0)
            {
                // TODO Auto-generated method stub

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.id_tab_weixin:
                setSelect(0);
                break;
            case R.id.id_tab_frd:
                setSelect(1);
                break;
            case R.id.id_tab_address:
                setSelect(2);
                break;

            default:
                break;
        }
    }

    private void initEvent()
    {
        mTabWeixin.setOnClickListener(this);
        mTabFrd.setOnClickListener(this);
        mTabAddress.setOnClickListener(this);
    }
    private void setSelect(int i)
    {
        setTab(i);
        mViewPager.setCurrentItem(i);
    }

    private void setTab(int i)
    {
        resetImgs();
        // 设置图片为亮色
        // 切换内容区域
        switch (i)
        {
            case 0:
                mImgWeixin.setImageResource(R.mipmap.tab_weixin_pressed);
                break;
            case 1:
                mImgFrd.setImageResource(R.mipmap.tab_find_frd_pressed);
                break;
            case 2:
                mImgAddress.setImageResource(R.mipmap.tab_settings_pressed);
                break;
        }
    }

    /**
     * 切换图片至暗色
     */
    private void resetImgs()
    {
        mImgWeixin.setImageResource(R.mipmap.tab_weixin_normal);
        mImgFrd.setImageResource(R.mipmap.tab_find_frd_normal);
        mImgAddress.setImageResource(R.mipmap.tab_settings_normal);
    }
    public class MyFragmentPagerAdapter extends FragmentPagerAdapter{
        List<Fragment> myFragments;
        @Override
        public Fragment getItem(int position) {
            return myFragments.get(position);
        }

        @Override
        public int getCount() {
            return myFragments.size();
        }

        public MyFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            myFragments=fragments;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

        }
    }
}
