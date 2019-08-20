/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CostCalculation;

import Database.QueryFunction;

import java.sql.SQLException;

import java.util.Collections;

import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public class BinarySearchBaesdResourceReservation {

    QueryFunction qf = new QueryFunction();

    public double getNumOGP(String EmailId, java.sql.Date Edate, double usedGp, double ExpectedGp) throws Exception {

        double NumOGP = 0;
        try {
            HashMap<java.sql.Date, Double> ss = getTransitions(EmailId, Edate);

            // sort the Hashmap
            HashMap<java.sql.Date, Double> Slist = sortHashMapByValue(ss);
//            double d1 = 0.0;
//            double d2 = 0.0;
            int cnt = 0;

            //take 2 elements from map  
            double[] dd1 = new double[Slist.size()];

            for (Map.Entry<java.sql.Date, Double> entry : Slist.entrySet()) {

                java.sql.Date key = entry.getKey();

                Double value = entry.getValue();
                dd1[cnt] = value;
                System.out.println("key=" + key + "  value=" + value);
                cnt++;
            }

            double Gc = 0.0085;
            double DGc = Gc * 0.60;
            Double Ugp[] = new Double[dd1.length];
            System.out.println("usedGp=" + usedGp + " ExpectedGp=" + ExpectedGp);
            double precentage = qf.getDiscount(EmailId);

            double Rgp = (ExpectedGp * precentage) / 100;
            System.out.println("precentage=" + precentage + " Rgp=" + Rgp);
            double df[] = new double[dd1.length];
            double x[] =new double[df.length];

            for (int i = 0; i < dd1.length; i++) {
                double Src = Rgp * Gc - Rgp * DGc;
                if (dd1[i] > ExpectedGp) {
                    Ugp[i] = dd1[i] - ExpectedGp;
                    Ugp[i]=Rgp-Ugp[i];
                } else {
                    Ugp[i] = 0.0;
                }
                 x[i]=Rgp-Ugp[i];
                double Orc =Math.abs((Rgp - Ugp[i]) * Gc);

                df[i] = getBenifitFun(Src, Orc);

            }
            /// calculate benifit function of 2 entries

            for (int i = 0; i < df.length; i++) {
                System.out.println("df[" + i + "]=" + df[i]);
            }

            double Fx1 = df[0];
            double Fx2 = df[1];
            
            
//            double Fx1 = Ugp;
//            double Fx2 = Ugp;

//Check benifit function of 1st billibng TimePeriod F(x1) and 2nd billingPeriod F(x2) and set no. of Get/Put
            // if (F(x1) >F(x2) then set NumOGP=x1 else set NumOGP=x2
            if (Fx1 >= Fx2) {
     //           NumOGP = dd1[0];
                NumOGP = x[0];

            } else {
           //     NumOGP = dd1[1];
                NumOGP = x[1];
            }

            System.out.println(" NumOGP= " + NumOGP);

        } catch (Exception e) {
//            e.printStackTrace();
        }
        return NumOGP;
    }

    public double getBenifitFun(double d1, double d2) {
        double BenFun = 0.0;
        BenFun = Math.abs(d1 + d2);

        return BenFun;
    }

    public double getUGFrmR(String EmailId) throws Exception {
        double dd=0.0;
        Date now = new Date();
        java.sql.Date Edate = new java.sql.Date(now.getTime());
        HashMap<java.sql.Date, Double> ss = getTransitions(EmailId, Edate);
        double EPutReq = qf.getUsedPutReqCount(EmailId);
        System.out.println("EPutReq=="+EPutReq);
        double UPutCnt = qf.getExpectedPut(EmailId);
        System.out.println("UPutCnt=="+UPutCnt);

      dd=getNumOGP(EmailId, Edate, EPutReq, UPutCnt);
   return dd;
    }

    public static HashMap<java.sql.Date, Double> sortHashMapByValue(HashMap<java.sql.Date, Double> hm) {
        // Create a list from elements of HashMap 
        List<Map.Entry<java.sql.Date, Double>> list
                = new LinkedList<Map.Entry<java.sql.Date, Double>>(hm.entrySet());

        // Sort the list 
        Collections.sort(list, new Comparator<Map.Entry<java.sql.Date, Double>>() {
            @Override
            public int compare(Map.Entry<java.sql.Date, Double> o1,
                    Map.Entry<java.sql.Date, Double> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap  
        HashMap<java.sql.Date, Double> temp = new LinkedHashMap<java.sql.Date, Double>();
        for (Map.Entry<java.sql.Date, Double> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    public HashMap<java.sql.Date, Double> getTransitions(String Email, java.sql.Date Edate) throws SQLException, Exception {
        GregorianCalendar cal = new GregorianCalendar();
        java.sql.Date Sdate = qf.getUserRegisterDate(Email);
        //   Date fromTime = Sdate;

        java.util.Date as = convertFromSQLDateToJAVADate(Sdate);

        cal.setTime(as);
        Date Stimeto = cal.getTime();
        //cal.add(Calendar.DATE, 365);
        cal.setTime(Edate);
        ///              end date      |-till day
        Date dates = Stimeto;
//        Date now = new Date();
//        java.sql.Date toTime = new java.sql.Date(Stimeto);
        System.out.println("" + Stimeto);

        Date toTime = cal.getTime();

        System.out.println("toTime" + toTime);

        // create object of Arraylist
        //add each entry to the list
//        ArrayList<Double> ls = new ArrayList<Double>();
        HashMap<java.sql.Date, Double> ls = new HashMap<java.sql.Date, Double>();

        while (dates.before(toTime)) {

            cal.setTime(dates);

            Date now = cal.getTime();
            java.sql.Date sqlDate = new java.sql.Date(now.getTime());

            double cnt = qf.getCnt(Email, sqlDate);
            ls.put(sqlDate, cnt);

            dates = new Date(dates.getTime() + 24 * 60 * 60 * 1000);
            //                                                 |   |    |    |
            //                                               hour  min  sec  milies unit

            // System.out.println("dates =" + dates+"   get value="+cnt);
        }

        return ls;
    }

    public static java.util.Date convertFromSQLDateToJAVADate(
            java.sql.Date sqlDate) {
        java.util.Date javaDate = null;
        if (sqlDate != null) {
            javaDate = new Date(sqlDate.getTime());
        }
        return javaDate;
    }

    public static void main(String[] args) throws Exception {

        BinarySearchBaesdResourceReservation bb = new BinarySearchBaesdResourceReservation();
        String EmailId = "zz@gmail.com";
        bb.getUGFrmR(EmailId);

    }

}
