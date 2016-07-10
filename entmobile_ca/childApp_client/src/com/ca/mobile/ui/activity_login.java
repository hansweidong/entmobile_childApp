package com.ca.mobile.ui;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ca.mobile.BaseActivity;
import com.ca.mobile.widget.CircularImage;
import com.ca.mobile.widget.TitleBarLayout;
import com.mobile.ca.R;

/**
 * Created by wuweidong on 16-7-10.
 * email:wwdhao163@163.com
 */
public class activity_login extends BaseActivity {

    private CircularImage ca_icon;

    private TitleBarLayout titleBarLayout;

    class TitleBarClickedListener implements TitleBarLayout.ITitleBarClickedListener{
        @Override
        public void onClickedTitleBar(int type) {
            if (type==TitleBarLayout.RIGHT){

            }
        }
    }

    private TitleBarClickedListener titleBarClickedListener = new TitleBarClickedListener();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    private void init(){
        initTitleBar();
        ca_icon = (CircularImage)findViewById(R.id.ca_icon);
        ca_icon.setImageBitmap(BitmapFactory.decodeResource(mContext.getResources(),R.drawable.ca_icon));
    }

    private void initTitleBar(){
        titleBarLayout = (TitleBarLayout)findViewById(R.id.title_bar);
        titleBarLayout.setTitleBarTextInfo("登陆");
        titleBarLayout.setRightButtonTextInfo("注册");
        titleBarLayout.setITitleBarClickedListener(titleBarClickedListener);
    }


}
