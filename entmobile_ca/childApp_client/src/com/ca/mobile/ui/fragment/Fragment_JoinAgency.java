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
 * 创建/加入 机构
 */
public class Fragment_JoinAgency extends BaseFragment{

    public static final String FRAGMENT_TAG = "Fragment_JoinAgency";

    class RoleInfo{
        public String name;
        public int maleType;
        private int roleType;
    }

    private RoleInfo roleInfo;

    private TitleBarLayout titleBarLayout;

    /**
     * 创建Fragment_JoinAgency
     * @param bundle
     * @return
     */
    public static Fragment_JoinAgency newInstance(Bundle bundle){
        Fragment_JoinAgency fragment_joinAgency = new Fragment_JoinAgency();
        fragment_joinAgency.setArguments(bundle);
        return fragment_joinAgency;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        mRootView = inflater.inflate(R.layout.fragment_join_agency,container,false);
        mRootView.setClickable(true);
        initTitleBar();
        init();
        return mRootView;
    }

    private void initTitleBar(){
        titleBarLayout = (TitleBarLayout)mRootView.findViewById(R.id.ui_titleBar);
        titleBarLayout.setTitleBarTextInfo("机构人员");
        titleBarLayout.setLeftButtonInfo();
    }

    private void init(){
        if (roleInfo == null){
            roleInfo = new RoleInfo();
            roleInfo.name = bundle.getString("name");
            roleInfo.maleType = bundle.getInt("maleType");
            roleInfo.roleType = bundle.getInt("roleType");
        }
    }
}
