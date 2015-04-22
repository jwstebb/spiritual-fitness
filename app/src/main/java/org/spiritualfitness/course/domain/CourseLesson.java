package org.spiritualfitness.course.domain;

import org.spiritualfitness.shared.domain.DomainObject;

public class CourseLesson extends DomainObject implements CourseActivity {
    private final String description;

    public CourseLesson(String id, String description) {
        super(id);
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public CourseActivityType getType() {
        return CourseActivityType.LESSON;
    }
}
