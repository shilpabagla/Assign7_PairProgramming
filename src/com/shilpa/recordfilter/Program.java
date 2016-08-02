
package com.shilpa.recordfilter;

import com.shilpa.recordfilter.dao.CourseDAO;
import com.shilpa.recordfilter.dao.EnquiryDAO;
import com.shilpa.recordfilter.dao.impl.CourseDAOImpl;
import com.shilpa.recordfilter.dao.impl.EnquiryDAOImpl;
import com.shilpa.recordfilter.operations.Operation;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Program {

    
    public static void main(String[] args) throws IOException, FileNotFoundException {
        CourseDAO courseDAO = new CourseDAOImpl();
        EnquiryDAO enquiryDAO = new EnquiryDAOImpl();
        Operation o =new Operation(courseDAO, enquiryDAO);
        o.process();
        
        
    }
    
    
}
