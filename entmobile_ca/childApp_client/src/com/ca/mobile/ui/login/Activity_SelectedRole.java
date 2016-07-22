package com.ca.mobile.ui.login;

import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.ca.mobile.BaseActivity;
import com.ca.mobile.BaseFragment;
import com.ca.mobile.ui.fragment.Fragment_JoinAgency;
import com.ca.mobile.ui.fragment.Fragment_MapLocation;
import com.ca.mobile.widget.TitleBarLayout;
import com.mobile.ca.R;

/**
 * Created by weidong_wu on 16/7/17.
 */
public class Activity_SelectedRole extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    public static final int Male = 1;//男
    public static final int Female = 2;//女
    public static final int Agency_Type = 1;//园长
    public static final int Teacher_Type = 2;//老师
    public static final int Parent_Type = 3;//家长
    public static final int MapLocation_Code = 1;//定位Fragment

    private Button completedBtn;

    private TitleBarLayout titleBarLayout;

    private int roleType = Agency_Type;

    private String userName = "";

    private int maleType = 0;

    private RadioGroup role_type_rg;

    private RadioGroup role_sex_rg;

    @Override
    protected void HandlerMessage(Message msg) {
        super.HandlerMessage(msg);
        if (msg.what == MapLocation_Code){
            BaseFragment fragment_joinAgency = (BaseFragment) getSupportFragmentManager().findFragmentByTag(Fragment_JoinAgency.FRAGMENT_TAG);
            if (fragment_joinAgency!=null){
                BaseFragment to = (BaseFragment) getSupportFragmentManager().findFragmentByTag(Fragment_MapLocation.FRAGMENT_TAG);
                if (to==null){
                    to = Fragment_MapLocation.newInstance();
                }
                switchContent(fragment_joinAgency,to,R.id.selected_role_FragmentContaier,Fragment_MapLocation.FRAGMENT_TAG,true);
            }
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_role);
        initTitleBar();
        init();
    }

    private void initTitleBar(){
        titleBarLayout = (TitleBarLayout)findViewById(R.id.ui_titleBar);
        titleBarLayout.setTitleBarTextInfo("完善资料");
    }

    private void init(){
        role_type_rg = (RadioGroup) findViewById(R.id.role_type_rg);
        role_type_rg.setOnCheckedChangeListener(this);
        role_sex_rg = (RadioGroup) findViewById(R.id.role_sex_rg);
        role_sex_rg.setOnCheckedChangeListener(this);
        completedBtn = (Button)findViewById(R.id.completed_btn);
        completedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (roleType == Agency_Type || roleType == Teacher_Type){
                    Bundle bundle = new Bundle();
                    bundle.putString("name",userName);
                    bundle.putInt("maleType",maleType);
                    bundle.putInt("roleType",roleType);
                    BaseFragment fragment_joinAgency = (BaseFragment) getSupportFragmentManager().findFragmentByTag(Fragment_JoinAgency.FRAGMENT_TAG);
                    if (fragment_joinAgency==null){
                        fragment_joinAgency = Fragment_JoinAgency.newInstance(bundle);
                    }else{
                        fragment_joinAgency.setArguments(bundle);
                    }
                    showFragment(fragment_joinAgency,R.id.selected_role_FragmentContaier,Fragment_JoinAgency.FRAGMENT_TAG,true);
                }else if (roleType == Parent_Type){

                }
            }
        });
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId==R.id.male_rbtn){
            maleType = Male;
        }else if (checkedId==R.id.female_rbtn){
            maleType = Female;
        }else if (checkedId==R.id.agency_rbtn){
            roleType = Agency_Type;
        }else if (checkedId==R.id.teacher_rbtn){
            roleType = Teacher_Type;
        }else if (checkedId==R.id.parent_rbtn){
            roleType = Parent_Type;
        }
    }
}
