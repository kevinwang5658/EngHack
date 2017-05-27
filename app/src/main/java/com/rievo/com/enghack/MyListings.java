package com.rievo.com.enghack;

import android.content.Context;
import android.rievo.com.enghack.R;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by kevin on 2017-05-27.
 */

public class MyListings extends RelativeLayout{

    public static final String TAG = "my listings";

    public MyListings(Context context) {
        super(context);
        init();
    }

    private void init(){
        View view = LayoutInflater.from(getContext()).inflate(R.layout.mylistings, this, true);
    }
}
