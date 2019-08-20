/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package date;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author pc2
 */
public class BillingPeriod {
       GregorianCalendar cal = new GregorianCalendar();
    //Date fromtime=System.
    public static void main(String[] args) {
        getCurrentTimeUsingDate();
}
public static String getCurrentTimeUsingDate() {

   // Date date = new Date();
String formattedDate="";
       Calendar cal = Calendar.getInstance();

           java.util.Date date= cal.getTime();
    String strDateFormat = "hh:mm a";

    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);

  formattedDate  = dateFormat.format(date);

    System.out.println("Current time of the day using Date - 12 hour format: " + formattedDate);
return formattedDate;
}


    
}
