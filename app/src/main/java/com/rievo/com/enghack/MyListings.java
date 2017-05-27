package com.rievo.com.enghack;

import android.content.Context;
import android.rievo.com.enghack.R;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.rievo.android.library.LinearBackStack;
import com.rievo.com.enghack.recycler_things.CardAdapter;
import com.rievo.com.enghack.recycler_things.CardListViewGroup;
import com.rievo.com.enghack.recycler_things.ItemClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

/**
 * Created by kevin on 2017-05-27.
 */

public class MyListings extends RelativeLayout implements ItemClickListener{

    int color;

    public static final String TAG = "my listings";

    @BindView(R.id.my_listings_list) RecyclerView recyclerView;
    CardAdapter cardAdapter;

    public MyListings(Context context) {
        super(context);
        init();
    }

    private void init(){
        View view = LayoutInflater.from(getContext()).inflate(R.layout.mylistings, this, true);
        ButterKnife.bind(this);

        cardAdapter = new CardAdapter(this);

        recyclerView.setAdapter(cardAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onClick(int index, int color) {
        LinearBackStack.get(TAG).replaceView((layoutInflater, viewGroup) -> {
            return new CardListViewGroup(layoutInflater.getContext());
        }).done();
    }
}
