package com.rievo.com.enghack.browse;

import android.rievo.com.enghack.R;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.rievo.com.enghack.BrowsePage;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

/**
 * Created by kevin on 2017-05-27.
 */

public class BasicViewHolder extends RecyclerView.ViewHolder{

    @BindView(R.id.entry_text) TextView title;
    int index;
    BrowsePage browsePage;

    public BasicViewHolder(View itemView, BrowsePage browsePage) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.browsePage = browsePage;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                browsePage.onItemClick(index);
            }
        });
    }
}
