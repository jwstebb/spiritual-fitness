package org.spiritualfitness.shared.service;

import org.spiritualfitness.course.service.CourseService;

import java.util.HashMap;
import java.util.Map;

public class Services {
    private static final Map<Class<?>, Object> services = new HashMap<>();

    static {
        services.put(CourseService.class, new CourseService());
        services.put(UserService.class, new UserService());
    }

    public static <T> T get(Class<T> type) {
        return (T) services.get(type);
    }
}
