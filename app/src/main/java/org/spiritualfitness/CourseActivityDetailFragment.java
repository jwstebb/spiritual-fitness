package org.spiritualfitness;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import org.spiritualfitness.course.domain.CourseActivity;
import org.spiritualfitness.course.domain.CourseActivityType;
import org.spiritualfitness.course.domain.CourseLesson;
import org.spiritualfitness.course.domain.CoursePost;
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String activityId = getArguments().getString(ARG_ITEM_ID);
        CourseActivity courseActivity = courseService.getCourseActivity(activityId);

        if (courseActivity.getType() == CourseActivityType.LESSON) {
            return createCourseLessonView((CourseLesson) courseActivity, inflater, container);
        } else {
            return createCoursePostView((CoursePost) courseActivity, inflater, container);
        }
    }

    private View createCourseLessonView(CourseLesson courseLesson, LayoutInflater inflater, ViewGroup container) {
        View rootView = inflater.inflate(R.layout.fragment_courselesson_detail, container, false);
        ((TextView) rootView.findViewById(R.id.lesson_description)).setText(courseLesson.getDescription());

        VideoView videoView = (VideoView) rootView.findViewById(R.id.lesson_video);
        Uri videoUri = Uri.parse(courseLesson.getVideoUrl());

        videoView.setVideoURI(videoUri);

        MediaController videoControl = new MediaController(inflater.getContext());
        videoControl.setMediaPlayer(videoView);
        videoView.setMediaController(videoControl);

        videoView.requestFocus();
        videoView.start();

        return rootView;
    }

    private View createCoursePostView(CoursePost coursePost, LayoutInflater inflater, ViewGroup container) {
        View rootView = inflater.inflate(R.layout.fragment_coursepost_detail, container, false);
        ((TextView) rootView.findViewById(R.id.post_id)).setText(coursePost.getId());

        return rootView;
    }
}
