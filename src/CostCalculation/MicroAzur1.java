/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CostCalculation;

import static CostCalculation.AWS1.GetUnitPrice;
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
public class MicroAzur1 {

    double Storagesize;
    double getRequest;
    double putRequest;


    int time;
    double Sp;
    double Gp;
    double Pp;
    double Tp;

     public static final String Hostid = "142.93.178.43";//40.76.29.47
    public static final String Username = "tarun";
    public static final String Password = "tarun@4321";
    // public static final String Username="tarun";
//        public static final String Password="Tarunsharma@4321";

    public static double StorageUnitPrice = 0.095;
    public static double GetUnitPrice = 0.001;
    public static double PutUnitPrice = 0.005;
    public static double TxferCost = 0.12;

    QueryFunction qf = new QueryFunction();
    // public String Email = Finalmainframe.mail;
    public String Email = UserLogin.email;
    BinarySearchBaesdResourceReservation bb = new BinarySearchBaesdResourceReservation();

    public MicroAzur1() {
    }

    public MicroAzur1(double Storagesize, double getRequest, double putRequest) throws Exception {

        this.Storagesize = Storagesize;
        this.getRequest = getRequest;
        this.putRequest = putRequest;

    }

    public double TCost() throws Exception {
        double Tc = calStoragePrice() + calgetPrice() + calputPrice() + calTxfrPrice();

        System.out.println("TotalCost of Microsoft Azur $" + Tc);

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
