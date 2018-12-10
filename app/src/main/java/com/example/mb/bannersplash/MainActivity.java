package com.example.mb.bannersplash;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mb.bannersplash.GuideAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements ViewPager.OnPageChangeListener {


    private LinearLayout mLinearLayout;
    private ViewPager viewPager;
    private ImageView imageView;//显示数组图片的View
    private ImageView[] diandianArray;//点数组
    private TextView mxperience;//立即体验

    private List<Fragment> mFragments;
    private GuideAdapter mGuideAdapter;
    private TextView oneTitle;//大标题
    private TextView twoTitle;//小标题
    private ImageView leftImage;//左边虚线
    private ImageView rightImage;
    private ImageView ivImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mxperience = findViewById(R.id.tv_skip);
        mFragments = new ArrayList<Fragment>();

        mFragments.add(GuideFragment.newInstance("风景引导页demo", "采用Fragment和ViewPager", R.drawable.guide_img__one, R.drawable.guide_line_left_short, R.drawable.guide_line_right_short));
        mFragments.add(GuideFragment.newInstance("解决Fragment不能写有参构造方法", "如丝般的顺滑体验", R.drawable.guide_img_two, R.drawable.guide_line_left_long, R.drawable.guide_line_right_long));
        mFragments.add(GuideFragment.newInstance("在学习技术的同时", "尽情的享受丰富的风景图", R.drawable.guide_img_three, R.drawable.guide_line_left_long, R.drawable.guide_line_right_long));
        mFragments.add(GuideFragment.newInstance("代码中详细的注释", "让你更加容易理解", R.drawable.guide_img__four, R.drawable.guide_line_left_long, R.drawable.guide_line_right_long));
        mFragments.add(GuideFragment.newInstance(" 看完GIF图 ", "让我们开始写demo吧", R.drawable.guide_img_five, R.drawable.guide_line_left_long, R.drawable.guide_line_right_long));
        mGuideAdapter = new GuideAdapter(getSupportFragmentManager(), mFragments);

        //xml中的LinearLayout布局
        mLinearLayout = (LinearLayout) findViewById(R.id.layout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.addOnPageChangeListener(this);
        //设置底部点的view
        diandianArray = new ImageView[5];
        for (int i = 0; i < diandianArray.length; i++) {
            imageView = new ImageView(this);
            diandianArray[i] = imageView;
            if (i == 0) {
                diandianArray[i].setImageResource(R.drawable.guide_point_sel);
            } else {
                diandianArray[i].setImageResource(R.drawable.guide_point_nor);
            }

            //此处为设置底部点的属性
            LinearLayout.LayoutParams linearLayout = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            linearLayout.leftMargin = 15;
            linearLayout.rightMargin = 15;

            mLinearLayout.addView(imageView, linearLayout);
        }
        viewPager.setAdapter(mGuideAdapter);
    }


    @Override
    public void onPageScrollStateChanged(int arg0) {

    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < diandianArray.length; i++) {
            mxperience.setVisibility(View.GONE);
            mLinearLayout.setVisibility(View.VISIBLE);
            diandianArray[position].setImageResource(R.drawable.guide_point_sel);
            if (i != position) {
                diandianArray[i].setImageResource(R.drawable.guide_point_nor);
            }
        }

        if (position == diandianArray.length - 1) {
            //当在最后一个的时候把立即体验按钮显示出来
            mLinearLayout.setVisibility(View.GONE);
            mxperience.setVisibility(View.VISIBLE);
        }
    }
}
