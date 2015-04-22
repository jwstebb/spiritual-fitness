package org.spiritualfitness.course.domain;

import org.spiritualfitness.shared.domain.DomainObject;

public class CoursePost extends DomainObject implements CourseActivity {
    private final String post;

    public CoursePost(String id, String post) {
        super(id);
        this.post = post;
    }

    @Override
    public String getDescription() {
        return post;
    }

    @Override
    public CourseActivityType getType() {
        return CourseActivityType.POST;
    }
}
