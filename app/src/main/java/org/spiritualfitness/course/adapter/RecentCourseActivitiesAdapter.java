package org.spiritualfitness.course.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.spiritualfitness.R;
import org.spiritualfitness.course.domain.CourseActivity;

import java.util.List;

public class RecentCourseActivitiesAdapter extends ArrayAdapter<CourseActivity> {
    private final LayoutInflater inflater;
    private final List<CourseActivity> courseActivities;

    public RecentCourseActivitiesAdapter(Activity context, List<CourseActivity> courseActivities) {
        super(context, R.layout.recent_course_activity_layout, courseActivities);

        this.inflater = context.getLayoutInflater();
        this.courseActivities = courseActivities;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        CourseActivity courseActivity = courseActivities.get(position);

        if (rowView == null) {
            rowView = inflater.inflate(R.layout.recent_course_activity_layout, null);
        }

        // fill data
        TextView description = (TextView) rowView.findViewById(R.id.recentActivityDescription);
        description.setText(courseActivity.getDescription());

        return rowView;
    }

    public CourseActivity getCourseActivity(int position) {
        return this.courseActivities.get(position);
    }
}
