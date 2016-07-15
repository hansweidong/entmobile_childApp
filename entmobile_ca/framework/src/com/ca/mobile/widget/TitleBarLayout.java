package com.ca.mobile.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ca.mobile.framework.R;
import com.ca.mobile.utils.ScreenManager;

/**
 * Created by wuweidong on 16-7-7.
 * email:wwdhao163@163.com
 */
public class TitleBarLayout extends RelativeLayout {

    public static final int LEFT = 1;

    public static final int RIGHT = 2;

    public interface ITitleBarClickedListener{
        void onClickedTitleBar(int type);
    }

    private View view;

    private RelativeLayout left_container_rl;

    private RelativeLayout right_container_rl;

    private TextView title_bar_tv;

    private TextView left_container_rl_tv;

    private TextView right_container_rl_tv;

    onClickedListener mOnClickedListener;

    ITitleBarClickedListener titleBarClickedListener;

    private Context mContext;

    public TitleBarLayout(Context context){
        super(context);
        mContext = context;
        view = inflate(context,R.layout.layout_title_bar,null);
        initView();
    }

    public TitleBarLayout(Context context, AttributeSet paramAttributeSet){
        super(context,paramAttributeSet);
        mContext = context;
        view = inflate(context,R.layout.layout_title_bar,null);
        initView();
    }

    public TitleBarLayout(Context context, AttributeSet paramAttributeSet, int paramInt) {
        super(context, paramAttributeSet, paramInt);
        mContext = context;
        view = inflate(context,R.layout.layout_title_bar,null);
        initView();
    }

    /**
     * 初始化布局
     */
    private void initView(){
        if (view==null)
            return;
        mOnClickedListener = new onClickedListener();
        left_container_rl = (RelativeLayout)view.findViewById(R.id.left_container_rl);
        right_container_rl = (RelativeLayout)view.findViewById(R.id.right_container_rl);
        title_bar_tv = (TextView)view.findViewById(R.id.title_bar_tv);
        left_container_rl_tv = (TextView)view.findViewById(R.id.left_container_rl_tv);
        right_container_rl_tv = (TextView)view.findViewById(R.id.right_container_rl_tv);
        left_container_rl.setOnClickListener(mOnClickedListener);
        right_container_rl.setOnClickListener(mOnClickedListener);
        addView(view);
    }

    /**
     * 设置标题名称
     * @param info
     */
    public void setTitleBarTextInfo(String info){
        if (title_bar_tv!=null){
            title_bar_tv.setText(info);
        }
    }

    /**
     * 设置右边按钮的名称
     * @param info
     */
    public void setRightButtonTextInfo(String info){
        if (right_container_rl_tv!=null){
            right_container_rl_tv.setVisibility(VISIBLE);
            right_container_rl_tv.setText(info);
        }
    }

    /**
     * 设置左边按钮
     */
    public void setLeftButtonInfo(){
        if (left_container_rl_tv!=null){
            left_container_rl_tv.setText("");
            left_container_rl_tv.setVisibility(VISIBLE);
            Drawable drawable = mContext.getResources().getDrawable(R.drawable.nav_back);
            int w = ScreenManager.dip2px(27);
            int h = ScreenManager.px2dip(22);
            drawable.setBounds(0,0,w,h);
            left_container_rl_tv.setCompoundDrawables(drawable,null,null,null);
        }
    }

    private class onClickedListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            if (titleBarClickedListener!=null) {
                if (v == left_container_rl) {
                    titleBarClickedListener.onClickedTitleBar(LEFT);
                } else if (v == right_container_rl) {
                    titleBarClickedListener.onClickedTitleBar(RIGHT);
                }
            }
        }
    }

    public void setITitleBarClickedListener(ITitleBarClickedListener titleBarClickedListener) {
        this.titleBarClickedListener = titleBarClickedListener;
    }
}
