package com.springrest.springrest.services;

import com.springrest.springrest.entity.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImplementation implements CourseService{

  List<Course> list;

  public CourseServiceImplementation(){

      list = new ArrayList<>();
      list.add(new Course(145,"java","This course will teach java"));
      list.add(new Course(150,"react","This course will teach react"));
  }
    @Override
    public List<Course> getCourses() {

        return list;
    }

    @Override
    public Course getCourse(int courseId) {
        Course c = null;

        for(Course course: list){
            if(course.getId()==courseId){
                c=course;
                break;
            }
        }
        return c;
    }

    @Override
    public Course addCourse(Course course) {
       list.add(course);
       return course;
    }

    @Override
    public Course updateCourse(Course course){

      list.forEach(e->{
          if(e.getId()==course.getId()){
              e.setTitle(course.getTitle());
              e.setDescription((course.getDescription()));
          }
      });
      return course;
    }

    @Override
    public Course deleteCourse(int courseId){
        list = this.list.stream()
                .filter(obj -> obj.getId()!=courseId)
                .collect(Collectors.toList());

        return new Course();
    }

}
