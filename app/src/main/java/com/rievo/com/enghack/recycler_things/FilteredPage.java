package com.rievo.com.enghack.recycler_things;

import android.content.Context;
import android.rievo.com.enghack.R;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.rievo.android.library.LinearBackStack;
import com.rievo.com.enghack.BrowsePage;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

/**
 * Created by kevin on 2017-05-27.
 */

public class FilteredPage extends RelativeLayout implements ItemClickListener {

    @BindView(R.id.my_recycler_view)
    RecyclerView recyclerView;

    public FilteredPage(Context context) {
        super(context);
        init();
    }

    private void init(){
        View view = LayoutInflater.from(getContext()).inflate(R.layout.mysavedlistings, this, true);
        ButterKnife.bind(this);

        recyclerView.setAdapter(new CardAdapter(this));
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
    }

    @Override
    public void onClick(int index) {
        Timber.d(index % 3 + "");

        switch (index % 3) {
            case(0): {
                LinearBackStack.get(BrowsePage.TAG).replaceView((layoutInflater, viewGroup) -> {
                    return new EventPage(layoutInflater.getContext());
                }).done();
                break;
            } case(1): {
                LinearBackStack.get(BrowsePage.TAG).replaceView((layoutInflater, viewGroup) -> {
                    return new SalesPage(layoutInflater.getContext());
                }).done();
                break;
            }case(2): {
                LinearBackStack.get(BrowsePage.TAG).replaceView((layoutInflater, viewGroup) -> {
                    return new ServicesPage(layoutInflater.getContext());
                }).done();
                break;
            }
        }

    }
}
