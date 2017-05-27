package com.rievo.com.enghack;

import android.rievo.com.enghack.BuildConfig;
import android.rievo.com.enghack.R;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.rievo.android.library.BackStackManager;
import com.rievo.android.library.ClusterBackStack;
import com.rievo.android.library.LinearBackStack;
import com.rievo.com.enghack.mysaved.MySavedListings;
import com.roughike.bottombar.BottomBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

import static android.view.View.GONE;

public class MainActivity extends AppCompatActivity {

    public static final String MAIN_BACKSTACK_TAG = "main backstack tag";

    @BindView(R.id.root) RelativeLayout root;
    @BindView(R.id.bottombar) BottomBar bottomBar;

    ClusterBackStack clusterBackStack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree() {
                @Override
                protected String createStackElementTag(StackTraceElement element) {
                    return super.createStackElementTag(element) + ":" + element.getLineNumber();
                }
            });
        }

        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        BackStackManager.install(this);
        clusterBackStack = ClusterBackStack.create(MAIN_BACKSTACK_TAG, 0);

        LinearBackStack.create(MySavedListings.TAG, root, (layoutInflater, viewGroup) -> {
            return new MySavedListings(layoutInflater.getContext());
        });
        LinearBackStack.create(BrowsePage.TAG, root, (layoutInflater, viewGroup) -> {
            return new BrowsePage(layoutInflater.getContext());
        });
        LinearBackStack.create(MyListings.TAG, root, (layoutInflater, viewGroup) -> {
            return new MyListings(layoutInflater.getContext());
        });

        clusterBackStack.add(0, LinearBackStack.get(MySavedListings.TAG));
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
                    LinearBackStack.get(MySavedListings.TAG).getCurrentViewGroup().setVisibility(View.VISIBLE);
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
        BackStackManager.getBackStackManager().goBack();
    }
}
