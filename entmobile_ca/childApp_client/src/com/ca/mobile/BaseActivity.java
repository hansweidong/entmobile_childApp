package com.ca.mobile;


import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import java.lang.ref.WeakReference;

/**
 * Created by wuweidong on 16-7-4.
 * email:wwdhao163@163.com
 */
public class BaseActivity extends FragmentActivity {

    protected Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        initInnerHandler();
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
}
