package com.rievo.com.enghack;

import android.rievo.com.enghack.R;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.RelativeLayout;

import com.daimajia.easing.linear.Linear;
import com.rievo.android.library.BackStackManager;
import com.rievo.android.library.ClusterBackStack;
import com.rievo.android.library.LinearBackStack;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.view.View.GONE;

public class MainActivity extends AppCompatActivity {

    public static final String MAIN_BACKSTACK_TAG = "main backstack tag";

    @BindView(R.id.root) RelativeLayout root;
    @BindView(R.id.bottombar) BottomBar bottomBar;
    ViewGroup previousView;

    ClusterBackStack clusterBackStack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        BackStackManager.install(this);
        clusterBackStack = ClusterBackStack.create(MAIN_BACKSTACK_TAG, 0);

        LinearBackStack.create(MainPage.TAG, root, (layoutInflater, viewGroup) -> {
            return new MainPage(layoutInflater.getContext());
        });
        LinearBackStack.create(BrowsePage.TAG, root, (layoutInflater, viewGroup) -> {
            return new BrowsePage(layoutInflater.getContext());
        });
        LinearBackStack.create(MyListings.TAG, root, (layoutInflater, viewGroup) -> {
            return new MyListings(layoutInflater.getContext());
        });

        clusterBackStack.add(0, LinearBackStack.get(MainPage.TAG));
        clusterBackStack.add(1, LinearBackStack.get(BrowsePage.TAG));
        clusterBackStack.add(2, LinearBackStack.get(MyListings.TAG));

        BackStackManager.setRootBackStack(clusterBackStack);

        bottomBar.setOnTabSelectListener(tabId -> {

            for (int counter = 0; counter < root.getChildCount(); counter++){
                root.getChildAt(counter).setVisibility(GONE);
            }

            switch (tabId){
                case (R.id.tab_main_page): {
                    clusterBackStack.switchContext(0);
                    LinearBackStack.get(MainPage.TAG).getCurrentViewGroup().setVisibility(View.VISIBLE);
                    break;
                }
                case (R.id.tab_browse): {
                    clusterBackStack.switchContext(1);
                    LinearBackStack.get(BrowsePage.TAG).getCurrentViewGroup().setVisibility(View.VISIBLE);
                    break;
                }
                case (R.id.tab_my_listings): {
                    clusterBackStack.switchContext(2);
                    LinearBackStack.get(MyListings.TAG).getCurrentViewGroup().setVisibility(View.VISIBLE);
                    break;
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        BackStackManager.getBackStackManager().goBack();
    }
}