package com.ca.mobile;


import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;

import com.mobile.ca.R;

import java.lang.ref.WeakReference;

/**
 * Created by wuweidong on 16-7-4.
 * email:wwdhao163@163.com
 */
public class BaseActivity extends FragmentActivity {

    protected BaseFragment mFragmentContent;

    protected Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        initInnerHandler();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (innerHandler!=null)
            innerHandler.removeCallbacksAndMessages(null);
    }

    protected InnerHandler innerHandler;

    public void initInnerHandler(){
        innerHandler = new InnerHandler(this);
    }

    public Handler getHandler(){
        return innerHandler;
    }

    protected void HandlerMessage(Message msg){}

    static class InnerHandler extends Handler{

        WeakReference wfc;

        public InnerHandler(BaseActivity baseActivity){
            super(Looper.getMainLooper());
            wfc = new WeakReference(baseActivity);
        }

        @Override
        public void handleMessage(Message msg) {
            if (wfc!=null) {
                Object obj = wfc.get();
                if (obj!=null&& obj instanceof BaseActivity){
                    ((BaseActivity)obj).HandlerMessage(msg);
                }
            }
        }
    }

    /**
     * 通用提示信息
     *
     * @param msg
     */
    public void ToastMessage(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 切换Fragment
     *
     * @param from
     * @param to
     * @param FragmentId
     * @param anim
     */
    public void switchContent(BaseFragment from, BaseFragment to, int FragmentId, String Tag,boolean anim) {
        if (mFragmentContent != to) {
            mFragmentContent = to;
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if (anim) {
                transaction.setCustomAnimations(
                        R.anim.slide_in_from_right, R.anim.slide_out_from_left,
                        R.anim.slide_in_from_right, R.anim.slide_out_from_left);
            }
            if (!to.isAdded()) {    // 先判断是否被add过
                transaction.addToBackStack(null);
                transaction.hide(from).add(FragmentId, to, Tag).commit(); // 隐藏当前的fragment，add下一个到Activity中
            } else {
                transaction.hide(from).show(to).commit(); // 隐藏当前的fragment，显示下一个
            }
        }
    }
}
