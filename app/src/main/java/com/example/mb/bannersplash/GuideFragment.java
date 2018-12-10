package com.example.mb.bannersplash;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class GuideFragment extends Fragment {
    private TextView oneTitle;//大标题
    private TextView twoTitle;//小标题
    private ImageView imageView;//引导页图片
    private ImageView leftImage, rightImage;//字体左上角和右下角的虚线图

    private String title, subTitle;
    private int img, leftImageInt, rightImageInt;

    //解决重写Fragment带参构造方法来传参,避免使用@SuppressLint("ValidFragment")
    public static final GuideFragment newInstance(String title, String subTitle, int img, int leftImageInt, int rightImageInt) {
        GuideFragment guideFragment = new GuideFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        bundle.putString("subTitle", subTitle);
        bundle.putInt("img", img);
        bundle.putInt("leftImageInt", leftImageInt);
        bundle.putInt("rightImageInt", rightImageInt);
        guideFragment.setArguments(bundle);
        return guideFragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_guide, null);
        if (getArguments() != null) {
            //取值
            title = getArguments().getString("title");
            subTitle = getArguments().getString("subTitle");
            img = getArguments().getInt("img");
            leftImageInt = getArguments().getInt("leftImageInt");
            rightImageInt = getArguments().getInt("rightImageInt");
        }
        oneTitle = view.findViewById(R.id.oneTitle);
        twoTitle = view.findViewById(R.id.twoTitle);
        oneTitle.setText(title);
        twoTitle.setText(subTitle);
        imageView = view.findViewById(R.id.iv_image);
        imageView.setImageResource(img);

        leftImage = view.findViewById(R.id.iv_left_image);
        leftImage.setImageResource(leftImageInt);
        rightImage = view.findViewById(R.id.iv_right_image);
        rightImage.setImageResource(rightImageInt);
        return view;
    }
}
