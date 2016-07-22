package com.ca.mobile.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ca.mobile.BaseActivity;
import com.ca.mobile.BaseFragment;
import com.ca.mobile.ui.login.Activity_SelectedRole;
import com.ca.mobile.widget.TitleBarLayout;
import com.mobile.ca.R;

/**
 * Created by weidong_wu on 16/7/17.
 * 创建/加入 机构
 */
public class Fragment_JoinAgency extends BaseFragment{

    private static final int CREATEAGENCY = 1;//创建机构

    private static final int JOINAGENCY = 2;//加入机构

    public static final String FRAGMENT_TAG = "Fragment_JoinAgency";

    class RoleInfo{
        public String name;
        public int maleType;
        private int roleType;
    }

    private RoleInfo roleInfo;

    private TitleBarLayout titleBarLayout;

    private ImageView select_type_btn;

    private ImageView role_type_icon;

    private TextView create_agency_tx_title;

    private TextView join_agency_tx_title;

    private TextView type_tips_tx;

    private View create_agency_container;

    private View join_agency_container;

    private int type = CREATEAGENCY;

    private TextView agency_location_address;

    class TitleBarClickedListener implements TitleBarLayout.ITitleBarClickedListener{
        @Override
        public void onClickedTitleBar(int type) {
            getActivity().getSupportFragmentManager().popBackStack();
        }
    }

    private TitleBarClickedListener titleBarClickedListener = new TitleBarClickedListener();

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
        titleBarLayout.setITitleBarClickedListener(titleBarClickedListener);
    }

    private void init(){
        if (roleInfo == null){
            roleInfo = new RoleInfo();
            roleInfo.name = bundle.getString("name");
            roleInfo.maleType = bundle.getInt("maleType");
            roleInfo.roleType = bundle.getInt("roleType");
        }
        select_type_btn = (ImageView) mRootView.findViewById(R.id.select_type_btn);
        role_type_icon = (ImageView) mRootView.findViewById(R.id.role_type_icon);
        type_tips_tx = (TextView) mRootView.findViewById(R.id.type_tips_tx);
        create_agency_tx_title = (TextView) mRootView.findViewById(R.id.create_agency_tx_title);
        create_agency_tx_title.setText("创建机构");
        join_agency_tx_title = (TextView) mRootView.findViewById(R.id.join_agency_tx_title);
        join_agency_tx_title.setText("加入机构");
        create_agency_container = mRootView.findViewById(R.id.create_agency_container);
        join_agency_container = mRootView.findViewById(R.id.join_agency_container);
        agency_location_address = (TextView) mRootView.findViewById(R.id.agency_location_address);

        agency_location_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message msg = new Message();
                msg.what = Activity_SelectedRole.MapLocation_Code;
                ((BaseActivity)getActivity()).getHandler().sendMessage(msg);
            }
        });

        select_type_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedTypeOnEvent();
            }
        });

        if (roleInfo.roleType == Activity_SelectedRole.Teacher_Type){
            selectedTypeOnEvent();
        }else{
            if (type==CREATEAGENCY) {
                type_tips_tx.setText(String.format(getResources().getString(R.string.join_agency_tips), "园长先生").toString());
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        titleBarClickedListener = null;
    }

    /**
     * 加入机构类型响应事件
     */
    private void selectedTypeOnEvent(){
        if (type == CREATEAGENCY){
            type = JOINAGENCY;
            select_type_btn.setBackgroundResource(R.drawable.join_agency_right);
            create_agency_tx_title.setTextColor(getActivity().getResources().getColor(R.color.app_main_color));
            join_agency_tx_title.setTextColor(Color.WHITE);
            join_agency_container.setVisibility(View.VISIBLE);
            create_agency_container.setVisibility(View.GONE);
        }else if (type== JOINAGENCY){
            type = CREATEAGENCY;
            select_type_btn.setBackgroundResource(R.drawable.join_agency_left);
            create_agency_tx_title.setTextColor(Color.WHITE);
            join_agency_tx_title.setTextColor(getActivity().getResources().getColor(R.color.app_main_color));
            join_agency_container.setVisibility(View.GONE);
            create_agency_container.setVisibility(View.VISIBLE);
        }

        if (roleInfo!=null){
            if (roleInfo.roleType==Activity_SelectedRole.Agency_Type){
                role_type_icon.setBackgroundResource(R.drawable.agency_selected);
                if (type==CREATEAGENCY) {
                    type_tips_tx.setText(String.format(getResources().getString(R.string.join_agency_tips), "园长先生").toString());
                }else if (type==JOINAGENCY){
                    type_tips_tx.setText(String.format(getResources().getString(R.string.join_teacher_tips), "园长先生").toString());
                }
            }else if (roleInfo.roleType==Activity_SelectedRole.Teacher_Type){
                role_type_icon.setBackgroundResource(R.drawable.teacher_selected);
                if (type==CREATEAGENCY) {
                    type_tips_tx.setText(String.format(getResources().getString(R.string.join_agency_tips), "亲爱的老师").toString());
                }else if (type==JOINAGENCY){
                    type_tips_tx.setText(String.format(getResources().getString(R.string.join_teacher_tips), "亲爱的老师").toString());
                }
            }
        }
    }
}
