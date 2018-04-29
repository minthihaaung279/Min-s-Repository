package com.thirdcs.team_pe_cake.paper.Fragment;

import android.app.ActivityOptions;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thirdcs.team_pe_cake.paper.Activity.PostCreateActivity;
import com.thirdcs.team_pe_cake.paper.R;

/**
 * Created by minthihaaung on 4/9/18.
 */

public class HomeFragment extends android.support.v4.app.Fragment {

    FloatingActionButton fabWritePost;

    public static HomeFragment newInstance() {
        HomeFragment homeFragment = new HomeFragment();
        return homeFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fabWritePost = view.findViewById(R.id.fabWritePost);
        fabWritePost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
                    Bundle bundle = ActivityOptions.makeCustomAnimation(getActivity(), R.anim.slide_in, R.anim.slide_out).toBundle();
                    Intent intent = new Intent();
                    intent.setClass(getActivity(), PostCreateActivity.class);
                    getActivity().startActivity(intent, bundle);
                }

            }
        });
    }
}
