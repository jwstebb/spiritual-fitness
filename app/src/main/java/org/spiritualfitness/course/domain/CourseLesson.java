package org.spiritualfitness.course.domain;

import org.spiritualfitness.shared.domain.DomainObject;

public class CourseLesson extends DomainObject implements CourseActivity {
    private final String description;
    private final String videoUrl;

    public CourseLesson(String id, String description, String videoUrl) {
        super(id);

        this.description = description;
        this.videoUrl = videoUrl;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public CourseActivityType getType() {
        return CourseActivityType.LESSON;
    }

    public String getVideoUrl() {
        return videoUrl;
    }
}
