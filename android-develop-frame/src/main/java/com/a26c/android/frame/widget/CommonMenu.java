/**
 *
 */
package com.a26c.android.frame.widget;


import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.a26c.android.frame.R;
import com.a26c.android.frame.util.FrameDensityUtils;

public class CommonMenu extends ConstraintLayout {

    private Context context;
    private TextView mLeftTextView;
    private TextView mRightTextView;
    private ImageView mLeftImageView;
    private ImageView mRightImageView;
    private View mTopDividerView;
    private View mBottomDividerView;
    private ConstraintLayout mConstraintLayout;

    public CommonMenu(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        this.context = context;
        LayoutInflater.from(context).inflate(R.layout.frame_layout_common_item2, this, true);

        mLeftTextView = findViewById(R.id.leftTextView);
        mRightTextView = findViewById(R.id.rightTextView);
        mRightImageView = findViewById(R.id.rightImageView);
        mLeftImageView = findViewById(R.id.leftImageView);
        mTopDividerView = findViewById(R.id.topDividerView);
        mBottomDividerView = findViewById(R.id.bottomDividerView);
        mConstraintLayout = findViewById(R.id.parentLayout);

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CommonMenu);

        //配置左边文字
        setLeftText(array.getString(R.styleable.CommonMenu_cm_LeftText));
        int leftTextSize = array.getDimensionPixelOffset(R.styleable.CommonMenu_cm_LeftTextSize, getResources().getDimensionPixelOffset(R.dimen.sp15));
        setLeftTextSize(FrameDensityUtils.px2sp(context, leftTextSize));
        setLeftTextColor(array.getColor(R.styleable.CommonMenu_cm_LeftTextColor, 0xff2B2B2B));

        //配置右边文字
        setRightText(array.getString(R.styleable.CommonMenu_cm_RightText));
        int rightTextSize = array.getDimensionPixelOffset(R.styleable.CommonMenu_cm_RightTextSize, getResources().getDimensionPixelOffset(R.dimen.sp15));
        setRightTextSize(FrameDensityUtils.px2sp(context, rightTextSize));
        setRightTextColor(array.getColor(R.styleable.CommonMenu_cm_RightTextColor, 0xff868686));

        //配置四个边距
//        1     2                          3     4
//     【   图片   文字                 文字   图片   】
        int dp13 = (int) getResources().getDimension(R.dimen.dp13);
        int dp5 = (int) getResources().getDimension(R.dimen.dp5);
        setMargin1(array.getDimension(R.styleable.CommonMenu_cm_margin1, dp13));
        setMargin2(array.getDimension(R.styleable.CommonMenu_cm_margin2, dp5));
        setMargin3(array.getDimension(R.styleable.CommonMenu_cm_margin3, dp5));
        setMargin4(array.getDimension(R.styleable.CommonMenu_cm_margin4, dp13));

        //配置左边图片
        int dp20 = getResources().getDimensionPixelOffset(R.dimen.dp20);
        setLeftImage(array.getResourceId(R.styleable.CommonMenu_cm_LeftImage, 0));
        setLeftImageHeight(array.getDimensionPixelOffset(R.styleable.CommonMenu_cm_LeftImageHeight, dp20));
        setLeftImageWidth(array.getDimensionPixelOffset(R.styleable.CommonMenu_cm_LeftImageWidth, dp20));

        //配置右边图片
        setRightImage(array.getResourceId(R.styleable.CommonMenu_cm_RightImage, 0));
        int dp15 = getResources().getDimensionPixelOffset(R.dimen.dp15);
        setRightImageHeight(array.getDimensionPixelOffset(R.styleable.CommonMenu_cm_RightImageHeight, dp15));
        setRightImageWidth(array.getDimensionPixelOffset(R.styleable.CommonMenu_cm_RightImageWidth, dp15));


        //配置是否显示隐藏 view
        setTopDividerVisable(array.getBoolean(R.styleable.CommonMenu_cm_ShowTopDivider, false));
        setBottomDividerVisable(array.getBoolean(R.styleable.CommonMenu_cm_ShowBottomDivider, false));
        setLeftImageViewVisable(array.getBoolean(R.styleable.CommonMenu_cm_ShowLeftImage, true));
        setRightImageViewVisable(array.getBoolean(R.styleable.CommonMenu_cm_ShowRightImage, true));
        setClickColorChange(array.getBoolean(R.styleable.CommonMenu_cm_ClickColor, false));
        array.recycle();

    }


    /**
     * 设置左边文字
     */
    public CommonMenu setLeftText(CharSequence text) {
        mLeftTextView.setText(text);
        return this;
    }

    /**
     * 设置右边文字
     */
    public CommonMenu setRightText(CharSequence text) {
        mRightTextView.setText(text);
        return this;
    }

    /**
     * 设置左边文字颜色
     */
    public CommonMenu setLeftTextColor(int colorId) {
        mLeftTextView.setTextColor(colorId);
        return this;
    }

    /**
     * 设置右边文字颜色
     */
    public CommonMenu setRightTextColor(int colorId) {
        mRightTextView.setTextColor(colorId);
        return this;
    }

    /**
     * 设置左边文字字体大小
     */
    public CommonMenu setLeftTextSize(float size) {
        mLeftTextView.setTextSize(size);
        return this;
    }

    /**
     * 设置右边文字字体大小
     */
    public CommonMenu setRightTextSize(float size) {
        mRightTextView.setTextSize(size);
        return this;
    }


    public CommonMenu setRightImage(int imgId) {
        if(imgId!=0){
            mRightImageView.setImageResource(imgId);
        }
        return this;
    }

    public CommonMenu setLeftImage(int imgId) {
        if(imgId!=0){
            mLeftImageView.setImageResource(imgId);
        }
        return this;
    }

    public CommonMenu setLeftImageHeight(int height) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) mLeftImageView.getLayoutParams();
        layoutParams.height = height;
        mLeftImageView.setLayoutParams(layoutParams);
        return this;
    }

    public CommonMenu setLeftImageWidth(int width) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) mLeftImageView.getLayoutParams();
        layoutParams.width = width;
        mLeftImageView.setLayoutParams(layoutParams);
        return this;

    }

    public CommonMenu setRightImageHeight(int height) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) mRightImageView.getLayoutParams();
        layoutParams.height = height;
        mRightImageView.setLayoutParams(layoutParams);
        return this;
    }

    public CommonMenu setRightImageWidth(int width) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) mRightImageView.getLayoutParams();
        layoutParams.width = width;
        mRightImageView.setLayoutParams(layoutParams);
        return this;
    }

    public CommonMenu setTopDividerVisable(boolean visable) {
        mTopDividerView.setVisibility(visable ? View.VISIBLE : View.GONE);
        return this;
    }

    public CommonMenu setBottomDividerVisable(boolean visable) {
        mBottomDividerView.setVisibility(visable ? View.VISIBLE : View.GONE);
        return this;
    }

    public CommonMenu setLeftImageViewVisable(boolean visable) {
        mLeftImageView.setVisibility(visable ? View.VISIBLE : View.GONE);
        return this;
    }

    public CommonMenu setRightImageViewVisable(boolean visable) {
        mRightImageView.setVisibility(visable ? View.VISIBLE : View.GONE);
        return this;
    }


    /**
     * 设置点击时变色
     */
    public CommonMenu setClickColorChange(boolean b) {
        mConstraintLayout.setClickable(true);
        mConstraintLayout.setFocusable(true);
        if (b) {
            if (Build.VERSION.SDK_INT >= 16) {
                mConstraintLayout.setBackground(context.getResources().getDrawable(R.drawable.frame_bg_common_item_pressed));
            } else {
                mConstraintLayout.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.frame_bg_common_item_pressed));
            }
        }
        return this;
    }

    public void setMargin1(float margin) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) mLeftImageView.getLayoutParams();
        layoutParams.leftMargin = (int) margin;
        mLeftImageView.setLayoutParams(layoutParams);
    }

    public void setMargin2(float margin) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) mLeftTextView.getLayoutParams();
        layoutParams.leftMargin = (int) margin;
        mLeftTextView.setLayoutParams(layoutParams);
    }

    public void setMargin3(float margin) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) mRightTextView.getLayoutParams();
        layoutParams.rightMargin = (int) margin;

        mRightTextView.setLayoutParams(layoutParams);
    }

    public void setMargin4(float margin) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) mRightImageView.getLayoutParams();
        layoutParams.rightMargin = (int) margin;
        mRightImageView.setLayoutParams(layoutParams);
    }

}