
package com.shilpa.recordfilter.operations;

import com.shilpa.recordfilter.dao.CourseDAO;
import com.shilpa.recordfilter.dao.EnquiryDAO;
import com.shilpa.recordfilter.entity.Course;
import com.shilpa.recordfilter.entity.Enquiry;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Operation {
     CourseDAO courseDAO;
    EnquiryDAO enquiryDAO;

    public Operation(CourseDAO courseDAO, EnquiryDAO enquiryDAO) {
        this.courseDAO = courseDAO;
        this.enquiryDAO = enquiryDAO;
    }

    public Operation() {
    }

    
    
    public void process() throws IOException
    {
        
        course();
        System.out.println("........................");
       
        enquiry();
    }
    
    private void course() throws FileNotFoundException, IOException
    {
        System.out.println("Reading course");
        try ( 
            BufferedReader bufferedReader=new BufferedReader(new FileReader("C:\\Users\\Shilpa\\Desktop\\course.csv")))
                {
            String line="";
            while((line=bufferedReader.readLine())!=null)
            {
                Course c = new Course();
                String[] tokens=line.split(",");
                c.setC_Id(Integer.parseInt(tokens[0]));
                c.setName(tokens[1]);
                c.setPrice(Double.parseDouble(tokens[2]));
                
                courseDAO.insert(c);
                if (!courseDAO.insert(c)) {
                    System.out.println("Cannot Insert into Course!!!!");
                }
                
                
            }
            
            bufferedReader.close();
        }
    }
    
    private void enquiry() throws FileNotFoundException, IOException,ArrayIndexOutOfBoundsException
    {
         System.out.println("Reading enquiry.csv..");
         
        try ( BufferedReader bufferedReader1 = new BufferedReader(new FileReader("C:\\Users\\Shilpa\\Desktop\\enquiry.csv"))) {
            BufferedWriter errorWriter =new BufferedWriter(new FileWriter("C:\\Users\\Shilpa\\Desktop\\error.csv"));
         BufferedWriter completeWriter =new BufferedWriter(new FileWriter("C:\\Users\\Shilpa\\Desktop\\complete.csv"));
            String line1="";
            while((line1=bufferedReader1.readLine())!=null)
            {
                String[] tokens1=line1.split(",");
                Enquiry e = new Enquiry();
               try{
                   if((enquiryDAO.searchByemail(tokens1[4]))||(!courseDAO.searchById(Integer.parseInt(tokens1[1]))))
                {
                    writeToErrorFile(tokens1,errorWriter);
                } 
                
                        
                else{
                    
                    e.setId(Integer.parseInt(tokens1[0]));
                    e.setCourseId(Integer.parseInt(tokens1[1]));
                    e.setFirstName(tokens1[2]);
                    e.setLastName(tokens1[3]);
                    e.setEmail(tokens1[4]);
                    
                    enquiryDAO.insert(e);
                    
                    writeToCompleteFile(e,completeWriter);
                    
                    if (!enquiryDAO.insert(e)) {
                        System.out.println("Cannot Insert into Enquiry !!");
                    }
                }} catch (ArrayIndexOutOfBoundsException ae){
                           ae.getMessage();
                           } 
                
            }
              errorWriter.close();
              completeWriter.close();
              bufferedReader1.close();
            
        }
         
        
        
    }
    
    private void writeToErrorFile(String[] array,BufferedWriter errorWriter) throws IOException
    {
        
                
                 
            
                try {
                    
                    errorWriter.write(array[0]+","+array[1]+","+array[2]+"," +array[3]+","+array[4]);
                    errorWriter.newLine();
                    
                } catch (IOException i) {
                    System.out.println(i.getMessage());
                }
            
       
          
        
                    
    }
    
    private void writeToCompleteFile(Enquiry e,BufferedWriter completeWriter) throws IOException
    {        
                try {
                    
                    completeWriter.write(e.getId()+","+e.getCourseId()+","+e.getFirstName()+","+e.getLastName()+","+e.getEmail());
                    completeWriter.newLine();
                    
                } catch (IOException i) {
                    System.out.println(i.getMessage());
                }
           
           
         
        
                    
                
    }

    
}
