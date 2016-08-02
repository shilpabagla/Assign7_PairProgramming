
package com.shilpa.recordfilter.dao.impl;

import com.shilpa.recordfilter.dao.EnquiryDAO;
import com.shilpa.recordfilter.entity.Enquiry;
import java.util.ArrayList;
import java.util.List;


public class EnquiryDAOImpl implements EnquiryDAO {
    private int counter = 0;
   private List<Enquiry> enquiryList=new ArrayList<>();
   
    @Override
    public boolean insert(Enquiry e) {
        return enquiryList.add(e);
    }

    @Override
    public  List<Enquiry> getAll() {
       return enquiryList;
    }

    @Override
    public boolean searchByemail(String email) {
       for(Enquiry e:enquiryList)
        {
            if(e.getEmail().contentEquals(email))
            {
                return true;
            }
        }
        return false;
    }

    
    

}
   

