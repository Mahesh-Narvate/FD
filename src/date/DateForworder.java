/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package date;


import Database.DBConnection;
import Database.QueryFunction;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.year;
import java.text.ParseException;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import static javafx.util.Duration.hours;

/**
 *
 * @author pc2
 */
public class DateForworder {
     QueryFunction ff;
     DBConnection con;
    
    public Date forwordBymonth( java.util.Date Sdate, int n )
    {
       GregorianCalendar cal = new GregorianCalendar();
        Date fromTime = Sdate;
		cal.setTime(fromTime);
		cal.add(Calendar.MONTH, 12);
	///              end date      |-till day
		Date dates = fromTime;
                Date toTime = cal.getTime();
		
		
		while (dates.before(toTime)) {
			
			cal.setTime(dates);
	       dates = new Date(dates.getTime() +  n* 24* 60 * 60 * 1000);
       //                                          |   |   |    |    |
       //                                        day  hour  min  sec milies unit
                     
                    System.out.println("dates ="+dates);
     }
                return dates;
    }
    
    
     public Date forwordByYear( java.util.Date Sdate,int n )
    {
       GregorianCalendar cal = new GregorianCalendar();
        Date fromTime = Sdate;
		cal.setTime(fromTime);
		cal.add(Calendar.DAY_OF_YEAR, 365);
	///              end date      |-till day
		Date dates = fromTime;
                Date toTime = cal.getTime();
		
		
		while (dates.before(toTime)) {
			
			cal.setTime(dates);
		dates = new Date(dates.getTime()+n*24* 60 * 60 * 1000);
       //                                         |    |   |    |    |
       //                                        day hour  min  sec  milies unit
                     
                    System.out.println("dates ="+dates);
     }
                return dates;
    }
       
    
    public void forwordByWeek( java.util.Date Sdate,int n)
    {
        GregorianCalendar cal = new GregorianCalendar();
        Date fromTime = Sdate;
		cal.setTime(fromTime);
		cal.add(Calendar.DATE, 7);
	///              end date      |-till day
		Date dates = fromTime;
                Date toTime = cal.getTime();
		
		
		while (dates.before(toTime)) {
			
			cal.setTime(dates);
			dates = new Date(dates.getTime() +n*7*24* 60 * 60 * 1000);
       //                                                 |   |    |    |
       //                                               hour  min  sec  milies unit
                     
                    System.out.println("dates ="+dates);
     }
       
    }
    
    
     public Date forwordByDay( java.util.Date Sdate ,int n)
    {
       GregorianCalendar cal = new GregorianCalendar();
        Date fromTime = Sdate;
		cal.setTime(fromTime);
		cal.add(Calendar.DATE, 7);
	///              end date      |-till day
		Date dates = fromTime;
                Date toTime = cal.getTime();
		
		
		while (dates.before(toTime)) {
			
			cal.setTime(dates);
			dates = new Date(dates.getTime() +n*24* 60 * 60 * 1000);
       //                                                 |   |    |    |
       //                                               hour  min  sec  milies unit
                     
                    System.out.println("dates ="+dates);
     }
               return dates;
    }        
     public void forwordByHour( java.util.Date Sdate)
    {
       GregorianCalendar cal = new GregorianCalendar();
        Date fromTime = Sdate;
		cal.setTime(fromTime);
		cal.add(Calendar.HOUR_OF_DAY, 24);
	///                     end date      |-till hour
        
		Date dates = fromTime;
                Date toTime = cal.getTime();
		
		
		while (dates.before(toTime)) {
			
			cal.setTime(dates);
			dates = new Date(dates.getTime() +1* 60 * 60 * 1000);
       //                                                 |   |    |    |
       //                                               hour  min  sec  milies unit
               System.out.println("dates ="+dates);      
     }     
		  
    
    }
     
     public double strg(java.sql.Date date) throws Exception
    {
         int strg1=0;
         forwordByHour(date);
         double dd=ff.getUsedStorageCount11("a@gmail.com", date);
         System.out.println("dd="+dd);
         
         
      
        return strg1;
    }            
         
     
     public static void main(String[] args) throws ParseException, Exception {
        
         DateForworder ac=new  DateForworder();
        DateCalc dc=new DateCalc();
        
        java.sql.Date Sdate=dc.getCurrentSqlDate();
       QueryFunction ff=new QueryFunction();
       java.sql.Date Sdate1 =ff.getUserRegisterDate("a@gmail.com");
  
       // ac.forwordByDay(Sdate);
      // ac.forwordByHour(Sdate);
       // ac.forwordBymonth(Sdate1);
       int year=1;
       ac.forwordByYear(Sdate1,year);
    }
}
