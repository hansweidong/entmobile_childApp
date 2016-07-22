package com.ca.mobile.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ca.mobile.BaseFragment;
import com.ca.mobile.widget.TitleBarLayout;
import com.mobile.ca.R;

/**
 * Created by weidong_wu on 16/7/17.
 * 地图定位
 */
public class Fragment_MapLocation extends BaseFragment {

    public static final String FRAGMENT_TAG = "Fragment_MapLocation";

    private TitleBarLayout titleBarLayout;

    class TitleBarClickedListener implements TitleBarLayout.ITitleBarClickedListener{
        @Override
        public void onClickedTitleBar(int type) {
            getActivity().getSupportFragmentManager().popBackStack();
        }
    }

    private TitleBarClickedListener titleBarClickedListener = new TitleBarClickedListener();

    public static Fragment_MapLocation newInstance(){
        Fragment_MapLocation fragment_mapLocation = new Fragment_MapLocation();
        return fragment_mapLocation;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        mRootView = inflater.inflate(R.layout.fragment_map_location,container,false);
        mRootView.setClickable(true);
        initTitleBar();
        return mRootView;
    }

    private void initTitleBar(){
        titleBarLayout = (TitleBarLayout)mRootView.findViewById(R.id.ui_titleBar);
        titleBarLayout.setTitleBarTextInfo("定位地址");
        titleBarLayout.setLeftButtonInfo();
        titleBarLayout.setITitleBarClickedListener(titleBarClickedListener);
    }
}
