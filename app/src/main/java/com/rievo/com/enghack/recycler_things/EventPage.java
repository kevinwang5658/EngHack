package com.rievo.com.enghack.recycler_things;

import android.content.Context;
import android.rievo.com.enghack.R;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by kevin on 2017-05-27.
 */

public class EventPage extends RelativeLayout{

    public EventPage(Context context) {
        super(context);
        init();
    }

    private void init(){
        View view = LayoutInflater.from(getContext()).inflate(R.layout.events_template, this, true);
    }
}
