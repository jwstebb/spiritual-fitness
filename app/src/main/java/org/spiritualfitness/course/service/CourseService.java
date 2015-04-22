package org.spiritualfitness.course.service;

import org.spiritualfitness.course.domain.CourseActivity;
import org.spiritualfitness.course.domain.CourseLesson;
import org.spiritualfitness.course.domain.CoursePost;

import java.util.ArrayList;
import java.util.List;

public class CourseService {
    private static final List<CourseActivity> courseActivities = new ArrayList<>();

    static {
        CourseLesson lesson1 = new CourseLesson("1", "Course Lesson 1");
        CourseLesson lesson2 = new CourseLesson("2", "Course Lesson 2");
        CourseLesson lesson3 = new CourseLesson("3", "Course Lesson 3");
        CourseLesson lesson4 = new CourseLesson("4", "Course Lesson 4");

        CoursePost post1 = new CoursePost("5", "Course Post 1");
        CoursePost post2 = new CoursePost("6", "Course Post 2");
        CoursePost post3 = new CoursePost("7", "Course Post 3");
        CoursePost post4 = new CoursePost("8", "Course Post 4");

        courseActivities.add(lesson1);
        courseActivities.add(post1);
        courseActivities.add(lesson2);
        courseActivities.add(lesson3);
        courseActivities.add(post2);
        courseActivities.add(lesson4);
        courseActivities.add(post3);
        courseActivities.add(post4);
    }

    public List<CourseActivity> getRecentActivity(String userId) {
        return courseActivities;
    }

    public CourseActivity getCourseActivity(String activityId) {
        for (CourseActivity activity : courseActivities) {
            if (activity.getId().equals(activityId)) {
                return activity;
            }
        }
        return null;
    }
}
