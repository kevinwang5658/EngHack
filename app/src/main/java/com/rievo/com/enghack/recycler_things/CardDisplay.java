package com.rievo.com.enghack.recycler_things;

import android.rievo.com.enghack.R;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.esotericsoftware.kryo.serializers.FieldSerializer;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kevin on 2017-05-27.
 */

public class CardDisplay extends RecyclerView.ViewHolder{

    @BindView(R.id.card_name) TextView textView;
    @BindView(R.id.description_card) TextView descriptionCard;

    public CardDisplay(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
