package com.springrest.springrest.services;

import com.springrest.springrest.entity.Course;

import java.util.List;

public interface CourseService {

    public List<Course> getCourses();

    public Course getCourse(int courseId);

    public Course addCourse(Course course);

    public Course updateCourse(Course course);

    public Course deleteCourse(int courseId);
}
