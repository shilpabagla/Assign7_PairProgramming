
package com.shilpa.recordfilter.dao;

import com.shilpa.recordfilter.entity.Enquiry;
import java.util.List;


public interface EnquiryDAO {
    
    
    boolean insert(Enquiry e);
      List<Enquiry> getAll();
    boolean  searchByemail(String email);
     
     
}
