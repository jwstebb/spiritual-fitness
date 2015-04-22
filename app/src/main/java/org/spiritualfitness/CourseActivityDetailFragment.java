package org.spiritualfitness;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.spiritualfitness.course.domain.CourseActivity;
import org.spiritualfitness.course.service.CourseService;
import org.spiritualfitness.shared.service.Services;

/**
 * A fragment representing a single CourseActivity detail screen.
 * This fragment is either contained in a {@link CourseActivityListActivity}
 * in two-pane mode (on tablets) or a {@link CourseActivityDetailActivity}
 * on handsets.
 */
public class CourseActivityDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    private CourseService courseService;
    private CourseActivity courseActivity;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public CourseActivityDetailFragment() {
        this.courseService = Services.get(CourseService.class);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String activityId = getArguments().getString(ARG_ITEM_ID);
        courseActivity = courseService.getCourseActivity(activityId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_courseactivity_detail, container, false);
        ((TextView) rootView.findViewById(R.id.courseactivity_detail)).setText(courseActivity.getId());

        return rootView;
    }
}
