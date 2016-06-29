package com.example.dot;

import java.util.ArrayList;
import java.util.List;

import com.example.test3.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;

public class DoTView extends BaseDoTView {
/**
 * 小圆点集合
 */
protected List<Dot> mDots;

public DoTView(Context context) {
    super(context);
}

public DoTView(Context context, AttributeSet attrs) {
    super(context, attrs);
}

@Override
protected void initViews() {
    LayoutInflater.from(getContext()).inflate(R.layout.default_indicator, this);
}

@Override
public void initialize(int slideCount, int first_page_num) {
    mDots = new ArrayList<>();
    mSlideCount = slideCount;

    for (int i = 0; i < slideCount; i++) {
        Dot dot = new Dot(getContext());
        dot.setColor(getUnselectedIndicatorColor());
        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        dot.setCircleRadius(getCircleRadius());
        addView(dot, params);
        mDots.add(dot);
    }
    setSelectPosition(first_page_num);
}

@Override
public void setSelectPosition(int index) {
    setCurrentposition(index);
    for (int i = 0; i < mSlideCount; i++) {
        if (i == index)
            mDots.get(i).setColor(getSelectedIndicatorColor());
        else
            mDots.get(i).setColor(getUnselectedIndicatorColor());
        mDots.get(i).postInvalidate();
    }
    postInvalidate();//刷新界面
}
}
