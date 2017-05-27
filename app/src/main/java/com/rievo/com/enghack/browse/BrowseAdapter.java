package com.rievo.com.enghack.browse;

import android.rievo.com.enghack.R;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by kevin on 2017-05-27.
 */

public class BrowseAdapter extends RecyclerView.Adapter<BasicViewHolder>{

    String[] titleList = new String[]{
            "Popular",
            "New",
            "For Sale",
            "Services",
            "Events",
            "Miscellaneous"
    };

    @Override
    public BasicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BasicViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.basic_listing, parent, false));
    }

    @Override
    public void onBindViewHolder(BasicViewHolder holder, int position) {
        holder.title.setText(titleList[position]);
    }

    @Override
    public int getItemCount() {
        return titleList.length;
    }
}
