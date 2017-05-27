package com.rievo.com.enghack;

import android.content.Context;
import android.rievo.com.enghack.R;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.rievo.android.library.LinearBackStack;
import com.rievo.com.enghack.browse.BrowseAdapter;
import com.rievo.com.enghack.recycler_things.CardListViewGroup;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

/**
 * Created by kevin on 2017-05-27.
 */

public class BrowsePage extends RelativeLayout{

    public static final String TAG = "browse page";

    @BindView(R.id.browse_list) RecyclerView categoryRecycler;

    BrowseAdapter browseAdapter;

    public BrowsePage(Context context) {
        super(context);
        init();
    }

    private void init(){
        View view = LayoutInflater.from(getContext()).inflate(R.layout.browsepage, this, true);

        ButterKnife.bind(this);

        browseAdapter = new BrowseAdapter(this);
        categoryRecycler.setAdapter(browseAdapter);
        categoryRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        categoryRecycler.addItemDecoration(new HorizontalDividerItemDecoration.Builder(getContext()).build());
    }

    public void onItemClick(int index){
        LinearBackStack.get(TAG).replaceView((layoutInflater, viewGroup) -> {
           return new CardListViewGroup(layoutInflater.getContext());
        }).done();
    }
}
