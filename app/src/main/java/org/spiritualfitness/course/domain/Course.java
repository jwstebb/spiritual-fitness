package org.spiritualfitness.course.domain;

import org.spiritualfitness.shared.domain.DomainObject;

import java.util.List;

public class Course extends DomainObject {
    private final String description;
    private final List<CourseLesson> lessons;
    private final List<CoursePost> posts;

    public Course(String id, String description, List<CourseLesson> lessons, List<CoursePost> posts) {
        super(id);

        this.description = description;
        this.lessons = lessons;
        this.posts = posts;
    }

    public String getDescription() {
        return description;
    }

    public List<CourseLesson> getLessons() {
        return lessons;
    }

    public List<CoursePost> getPosts() {
        return posts;
    }
}
