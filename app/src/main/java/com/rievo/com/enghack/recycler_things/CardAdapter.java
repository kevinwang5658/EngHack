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

        int randColor = (int) (Math.random() * 7);
        int color = 0;

        switch (randColor) {
            case 0:
                color = R.color.color1;
                break;
            case 1:
                color = R.color.color2;
                break;
            case 2:
                color = R.color.color3;
                break;
            case 3:
                color = R.color.color4;
                break;
            case 4:
                color = R.color.color5;
                break;
            case 5:
                color = R.color.color6;
                break;
            case 6:
                color = R.color.color7;
                break;
            default:
                color = 0xffffff;
        }

        holder.itemView.setBackgroundColor(holder.itemView.getContext().getResources().getColor(color));

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
