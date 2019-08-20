/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author pc2
 */
public class DateCalc {
    
    
    //  function  to return sql date
    public java.sql.Date getCurrentSqlDate() throws ParseException
    {
        java.sql.Date CurrentDate = null;
                
                Calendar cal = Calendar.getInstance();
                 //selected date from calender
                java.util.Date d = cal.getTime();
                
                //dateformat converter
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                
                // converted into specified date format
                String ss1 = format.format(d);
             //   System.out.println("Formatted date="+ss1);
                ///
                java.util.Date KeyDate1 = (java.util.Date) format.parse(ss1);
                //conversion from util into sql 
                CurrentDate = new java.sql.Date(KeyDate1.getTime());
               
                System.out.println("KeyDate1::" + KeyDate1 + "::CurrentDate::" + CurrentDate);

        return  CurrentDate;
    }
    public java.sql.Date getConvertedSqlDate(  java.util.Date d) throws ParseException
    {
        java.sql.Date ConvertedDate = null;
                
              
                //dateformat converter
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                
                // converted into specified date format
                String ss1 = format.format(d);
                System.out.println("Formatted date="+ss1);
                ///
                java.util.Date KeyDate1 = (java.util.Date) format.parse(ss1);
                //conversion from util into sql 
                ConvertedDate = new java.sql.Date(KeyDate1.getTime());
               
              ///  System.out.println("KeyDate1::" + KeyDate1 + "::CurrentDate::" + CurrentDate);

        return  ConvertedDate;
    }
    
    
    public static void main(String[] args) throws ParseException {
        DateCalc dd=new DateCalc();
        dd.getCurrentSqlDate();
    }
}
