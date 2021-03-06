package org.spiritualfitness;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import org.spiritualfitness.course.domain.CourseActivity;

/**
 * Dashboard page of app (loaded on startup)
 *
 * An activity representing a list of CourseActivities. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link CourseActivityDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 * <p/>
 * The activity makes heavy use of fragments. The list of items is a
 * {@link CourseActivityListFragment} and the item details
 * (if present) is a {@link CourseActivityDetailFragment}.
 * <p/>
 * This activity also implements the required
 * {@link CourseActivityListFragment.Callbacks} interface
 * to listen for item selections.
 */
public class CourseActivityListActivity extends FragmentActivity implements CourseActivityListFragment.Callbacks {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean twoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courseactivity_list);

        if (findViewById(R.id.courseactivity_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-large and
            // res/values-sw600dp). If this view is present, then the
            // activity should be in two-pane mode.
            twoPane = true;

            // In two-pane mode, list items should be given the
            // 'activated' state when touched.
            ((CourseActivityListFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.courseactivity_list))
                    .setActivateOnItemClick(true);
        }
    }

    @Override
    public void onItemSelected(CourseActivity activity) {
        if (twoPane) {
            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(CourseActivityDetailFragment.ARG_ITEM_ID, activity.getId());
            CourseActivityDetailFragment fragment = new CourseActivityDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.courseactivity_detail_container, fragment)
                    .commit();
        } else {
            // In single-pane mode, simply start the detail activity
            // for the selected item ID.
            Intent detailIntent = new Intent(this, CourseActivityDetailActivity.class);
            detailIntent.putExtra(CourseActivityDetailFragment.ARG_ITEM_ID, activity.getId());
            startActivity(detailIntent);
        }
    }
}
