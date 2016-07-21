package com.ca.mobile.ui.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import com.ca.mobile.BaseActivity;
import com.ca.mobile.BaseFragment;
import com.ca.mobile.ui.fragment.Fragment_JoinAgency;
import com.ca.mobile.widget.TitleBarLayout;
import com.mobile.ca.R;

/**
 * Created by weidong_wu on 16/7/17.
 */
public class Activity_SelectedRole extends BaseActivity {

    public static final int Agency_Type = 1;//园长
    public static final int Teacher_Type = 2;//老师
    private static final int Parent_Type = 3;//家长

    private Button completedBtn;

    private TitleBarLayout titleBarLayout;

    private int roleType = Agency_Type;

    private String userName = "";

    private int maleType = 0;

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
}
