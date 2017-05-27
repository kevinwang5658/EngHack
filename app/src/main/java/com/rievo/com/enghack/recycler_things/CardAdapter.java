package com.rievo.com.enghack.recycler_things;

import android.rievo.com.enghack.R;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by kevin on 2017-05-27.
 */

public class CardAdapter extends RecyclerView.Adapter<CardDisplay> {
    @Override
    public CardDisplay onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CardDisplay(LayoutInflater.from(parent.getContext()).inflate(R.layout.flyer, parent, false));
    }

    @Override
    public void onBindViewHolder(CardDisplay holder, int position) {
        holder.textView.setText("Text");
    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
