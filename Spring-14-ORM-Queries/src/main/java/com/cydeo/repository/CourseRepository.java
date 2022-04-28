package com.cydeo.repository;

import com.cydeo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Stream;

public interface CourseRepository extends JpaRepository<Course,Long> {

    //find all courses by category
    List<Course> findByCategory(String category);

    //find all coursees by category and order the entity by name
    List<Course> findByCategoryOrderByName(String category);

    //checks if course with provided name exisst return true if course exsists , false otherwise
    boolean existsByName(String name);

    //return the count of courses for the provided category
    int countByCategory(String category);

    //find all courses that start with provided course name
    List<Course> findByNameStartingWith(String name);

    //find all courses by category and returns a stream
    Stream<Course> streamByCategory(String category);



}
