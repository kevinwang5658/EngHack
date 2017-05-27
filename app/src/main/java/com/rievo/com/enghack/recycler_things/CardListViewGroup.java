package com.rievo.com.enghack.recycler_things;

import android.content.Context;
import android.rievo.com.enghack.R;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by kevin on 2017-05-27.
 */

public class CardListViewGroup extends RelativeLayout{

    public CardListViewGroup(Context context) {
        super(context);
    }

    private void init(){
        View view = LayoutInflater.from(getContext()).inflate(R.layout.cardviewgroup, this, true);
    }
}
