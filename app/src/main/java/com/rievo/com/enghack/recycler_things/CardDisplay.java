package com.rievo.com.enghack.recycler_things;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.rievo.com.enghack.R;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.esotericsoftware.kryo.serializers.FieldSerializer;
import com.rievo.com.enghack.BrowsePage;
import com.rievo.com.enghack.mysaved.MainPage;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

/**
 * Created by kevin and Josie on 2017-05-27.
 */

public class CardDisplay extends RecyclerView.ViewHolder{

    @BindView(R.id.card_name) TextView textView;
    @BindView(R.id.description_card) TextView descriptionCard;

    int index;

    public CardDisplay(View itemView, ItemClickListener itemClickListener) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = Color.TRANSPARENT;
                Drawable background = itemView.getBackground();
                if (background instanceof ColorDrawable)
                    color = ((ColorDrawable) background).getColor();

                itemClickListener.onClick(index, color);
            }
        });
    }


}
