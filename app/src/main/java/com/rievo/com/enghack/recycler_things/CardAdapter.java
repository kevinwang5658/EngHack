package com.rievo.com.enghack.recycler_things;

import android.rievo.com.enghack.R;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import timber.log.Timber;

/**
 * Created by kevin on 2017-05-27.
 */

public class CardAdapter extends RecyclerView.Adapter<CardDisplay> {

    ItemClickListener itemClickListener;

    public CardAdapter(ItemClickListener clickListener){
        this.itemClickListener = clickListener;
    }

    @Override
    public CardDisplay onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CardDisplay(LayoutInflater.from(parent.getContext()).inflate(R.layout.flyer, parent, false), itemClickListener);
    }

    @Override
    public void onBindViewHolder(CardDisplay holder, int position) {
        holder.textView.setText("Text");

        int randNum = (int) (Math.random() * 500) + 500;
        StringBuilder stringBuilder = new StringBuilder();
        for (int counter = 0; counter < randNum; counter++){
            stringBuilder.append("e");
        }
        String finalString = stringBuilder.toString();

        holder.descriptionCard.setText(finalString);
        holder.index = position;
    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
