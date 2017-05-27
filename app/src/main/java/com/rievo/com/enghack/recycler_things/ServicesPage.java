package com.rievo.com.enghack.recycler_things;

import android.content.Context;
import android.rievo.com.enghack.R;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by kevin on 2017-05-27.
 */

public class ServicesPage extends RelativeLayout{

    int color;

    public ServicesPage(Context context, int color) {
        super(context);
        init();
        this.color=color;
    }

    private void init(){
        View view = LayoutInflater.from(getContext()).inflate(R.layout.services_template, this, true);
    }
}
