package com.thirdcs.team_pe_cake.paper.Fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.thirdcs.team_pe_cake.paper.R;

/**
 * Created by minthihaaung on 4/29/18.
 */

public class BaseFragment extends android.support.v4.app.Fragment {

    BottomNavigationView bottomNavigationView;
    FragmentActivity mContext;

    public static BaseFragment newInstance() {
        BaseFragment baseFragment = new BaseFragment();
        return baseFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mContext = (FragmentActivity) context;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_base, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bottomNavigationView = getActivity().findViewById(R.id.bottomNavView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                android.support.v4.app.Fragment selectedFragment = null;
                switch (item.getItemId()) {

                    case R.id.bookMark:
                        selectedFragment = BookMarkFragment.newInstance();
                        break;
                    case R.id.home:
                        selectedFragment = HomeFragment.newInstance();
                        break;
                    case R.id.category:
                        selectedFragment = SettingFragment.newInstance();
                        break;
                }
                android.support.v4.app.FragmentTransaction transaction = mContext.getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameLayout, selectedFragment);
                transaction.commit();

                return true;

            }
        });

        android.support.v4.app.FragmentTransaction transaction = mContext.getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, HomeFragment.newInstance());
        transaction.commit();
    }

}
