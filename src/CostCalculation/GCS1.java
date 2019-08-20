/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CostCalculation;

import static CostCalculation.AWS1.GetUnitPrice;
import static CostCalculation.MicroAzur1.PutUnitPrice;
import Database.QueryFunction;
import java.util.ArrayList;
import java.util.Scanner;
import GUI.MainFrame;
import GUI.UserDashBord;
import GUI.UserLogin;
import java.sql.SQLException;

/**
 *
 * @author lucky
 */
public class GCS1 {

    double Storagesize;
    double getRequest;
    double putRequest;


    int time;
    double Sp;
    double Gp;
    double Pp;
    double Tp;

    public static final String Hostid = "121.94.45.78";//change according to your Cloud IPS
    public static final String Username = "tarun";//change according to your Cloud IPS username
    public static final String Password = "tarun@4321";//change according to your Cloud IPS password

    public static double StorageUnitPrice = 0.085;
    public static double GetUnitPrice = 0.01;
    public static double PutUnitPrice = 0.01;
    public static double TxferCost = 0.12;

    QueryFunction qf = new QueryFunction();
    
    public String Email = UserLogin.email;
    BinarySearchBaesdResourceReservation bb = new BinarySearchBaesdResourceReservation();

    public GCS1() {
    }

    public GCS1(double Storagesize, double getRequest, double putRequest) throws Exception {

        this.Storagesize = Storagesize;
        this.getRequest = getRequest;
        this.putRequest = putRequest;

    }

    public double TawsCost() throws Exception {
        double Tc = calStoragePrice() + calgetPrice() + calputPrice() + calTxfrPrice();

        System.out.println("TotalCost of GCS $" + Tc);

        return Tc;
    }

    public double calStoragePrice() throws SQLException {

        Sp = StorageUnitPrice * Storagesize;
        return Sp;
    }

    public double calgetPrice() throws Exception {

        Gp = GetUnitPrice * getRequest;

        return Gp;
    }

    public double calputPrice() throws Exception {

        Pp = PutUnitPrice * putRequest;

        return Pp;
    }

    public double calTxfrPrice() {

        Tp = TxferCost * Storagesize / 1073741824;
        return Tp;
    }

}
