package com.rievo.com.enghack.mysaved;

import android.content.Context;
import android.rievo.com.enghack.R;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kevin on 2017-05-27.
 */

public class MySavedListings extends RelativeLayout{

    @BindView(R.id.my_recycler_view) RecyclerView recyclerView;

    public static final String TAG = "main page";

    public MySavedListings(Context context) {
        super(context);
        init();
    }

    private void init(){

        View view = LayoutInflater.from(getContext()).inflate(R.layout.mysavedlistings, this, true);
        ButterKnife.bind(this);
    }
}
