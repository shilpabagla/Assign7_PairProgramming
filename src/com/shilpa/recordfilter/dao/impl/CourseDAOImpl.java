
package com.shilpa.recordfilter.dao.impl;

import com.shilpa.recordfilter.dao.CourseDAO;
import com.shilpa.recordfilter.entity.Course;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CourseDAOImpl implements CourseDAO {
    private int counter = 0;
    private List<Course> courseList=new ArrayList<>();

    @Override
    public boolean insert(Course c) {
         return courseList.add(c);
    }

    @Override
    public List<Course> getAll() {
      return courseList;
    }

    @Override
    public boolean searchById(int id1) {
       for(Course c:courseList)
        {
            if(c.getC_Id()==id1)
            {
                return true;
            }
        }
        return false;
    }
}