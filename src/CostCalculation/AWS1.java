/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CostCalculation;

import static CostCalculation.GCS1.StorageUnitPrice;
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
public class AWS1 {

    double Storagesize;
    double getRequest;
    double putRequest;

    int time;
    double Sp;
    double Gp;
    double Pp;
    double Tp;

    public static final String Hostid = "167.71.104.48";////18.222.130.75
    public static final String Username = "tarun";//tarun
    public static final String Password = "tarun@4321";////Tarunsharma@4321
    


    public static double StorageUnitPrice = 0.095;
    public static double GetUnitPrice = 0.004;
    public static double PutUnitPrice = 0.0001;
    public static double TxferCost = 0.12;

    QueryFunction qf = new QueryFunction();
    public String Email = UserLogin.email;

    public AWS1() {
    }

    public AWS1(double Storagesize, double getRequest, double putRequest) throws Exception {

        this.Storagesize = Storagesize;
        this.getRequest = getRequest;
        this.putRequest = putRequest;

    }
    // 1073741824

    public double TawsCost() throws Exception {
        double Tc = calStoragePrice() + calgetPrice() + calputPrice() + calTxfrPrice();

        System.out.println("TotalCost of AWS $" + Tc);

        return Tc;
    }

    public double calStoragePrice() throws SQLException {

        Sp = StorageUnitPrice * Storagesize;
        return Sp;
    }

    public double calgetPrice() throws Exception {  ////getRequest is no of used request in billing time period tk

        Gp = GetUnitPrice * (getRequest);

        return Gp;
    }

    public double calputPrice() throws Exception {  /////putRequest is no of used request in billing time period tk

        Pp = PutUnitPrice * putRequest;

        return Pp;
    }

    public double calTxfrPrice() {

        Tp = TxferCost * Storagesize / 1073741824;
        return Tp;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Storage Size");
        int StorageSize = sc.nextInt();

        System.out.println("Enter GetRequest Size");
        int GetRequest = sc.nextInt();

        System.out.println("Enter PutRequest Size");
        int PutRequest = sc.nextInt();

        AWS1 a = new AWS1(StorageSize, GetRequest, PutRequest);

        System.out.println(" total cost " + a.TawsCost());
    }

}
