package com.ca.mobile;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by wuweidong on 16-7-4.
 * email:wwdhao163@163.com
 * 类型的描述:
 */
public class BaseFragment extends Fragment {

    protected View mRootView;

    protected Context getBaseFragmentContext(){
        return getActivity();
    }
}
