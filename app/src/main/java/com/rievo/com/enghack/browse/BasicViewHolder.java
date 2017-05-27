package com.rievo.com.enghack.browse;

import android.rievo.com.enghack.R;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kevin on 2017-05-27.
 */

public class BasicViewHolder extends RecyclerView.ViewHolder{

    @BindView(R.id.entry_text) TextView title;

    public BasicViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
