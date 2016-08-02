
package com.shilpa.recordfilter.dao;

import com.shilpa.recordfilter.entity.Course;
import java.util.List;


public interface CourseDAO {
    boolean insert(Course c);
     List <Course> getAll();
      boolean  searchById(int id1);
}
