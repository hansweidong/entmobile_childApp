package com.ca.mobile.ui.fragment;

import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ca.mobile.BaseActivity;
import com.ca.mobile.BaseFragment;
import com.ca.mobile.ui.login.Activity_Login;
import com.ca.mobile.widget.TitleBarLayout;
import com.mobile.ca.R;

/**
 * Created by wuweidong on 16-7-16.
 * email:wwdhao163@163.com
 */
public class Fragment_PlatformPotocol extends BaseFragment {

    public static final String FRAGMENT_TAG = "Fragment_PlatformPotocol";

    private TitleBarLayout titleBarLayout;

    class TitleBarClickedListener implements TitleBarLayout.ITitleBarClickedListener{
        @Override
        public void onClickedTitleBar(int type) {
            Message msg = new Message();
            msg.what = Activity_Login.Register_Code;
            if (type==TitleBarLayout.RIGHT){
                boolean agreeProtocol = true;
                msg.obj = agreeProtocol;
            }
            msg.arg1 = Activity_Login.Register_Code;
            ((BaseActivity)getActivity()).getHandler().sendMessage(msg);
        }
    }

    private TitleBarClickedListener titleBarClickedListener = new TitleBarClickedListener();

    public static Fragment_PlatformPotocol newInstance(){
        Fragment_PlatformPotocol fragment_platformPotocol = new Fragment_PlatformPotocol();
        return fragment_platformPotocol;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        mRootView = inflater.inflate(R.layout.fragment_protocol,container,false);
        init();
        return mRootView;
    }

    private void init(){
        if (mRootView==null)
            return;
        initTitleBar();
    }

    private void initTitleBar(){
        titleBarLayout = (TitleBarLayout)mRootView.findViewById(R.id.title_bar);
        titleBarLayout.setTitleBarTextInfo("用户协议");
        titleBarLayout.setRightButtonTextInfo("同意");
        titleBarLayout.setLeftButtonInfo();
        titleBarLayout.setITitleBarClickedListener(titleBarClickedListener);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        titleBarClickedListener = null;
    }
}
