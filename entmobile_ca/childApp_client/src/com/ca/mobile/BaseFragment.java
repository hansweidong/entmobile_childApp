package com.ca.mobile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by wuweidong on 16-7-4.
 * email:wwdhao163@163.com
 * 类型的描述:
 */
public class BaseFragment extends Fragment {

    protected View mRootView;

    protected Bundle bundle;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState!=null){
            bundle = savedInstanceState;
        }else{
            bundle = getArguments();
        }
    }

}
