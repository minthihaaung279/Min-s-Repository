package com.thirdcs.team_pe_cake.paper.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thirdcs.team_pe_cake.paper.R;

/**
 * Created by minthihaaung on 4/9/18.
 */

public class BookMarkFragment extends android.support.v4.app.Fragment {

    public static BookMarkFragment newInstance(){
        BookMarkFragment bookMarkFragment = new BookMarkFragment();
        return bookMarkFragment;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bookmark, container, false);

    }
}
