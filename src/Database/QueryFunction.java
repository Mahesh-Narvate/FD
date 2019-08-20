/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import CostCalculation.Storageconverter;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.awt.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class QueryFunction {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    DBConnection conobj = new DBConnection();

    public List st = new List();

    public QueryFunction() {
        con = new DBConnection().dbConnection();
        con = conobj.dbConnection();
    }

    //mahesh db before
    public boolean checkRegUser(String Fname, String Email, String Addr, String Mob, String Password, String CloudId) {
        boolean status = false;
        try {

            String Sql = "select Name,email,Address,password,PhonNo,cloudId from registration where Name=? and email=? and password=? and PhonNo=?";
            ps = con.prepareStatement(Sql.trim());
            ps.setString(1, Fname);
            ps.setString(2, Email);
            ps.setString(3, Password);
            ps.setString(4, Mob);
//        ps.setString(5, CloudId);

            rs = ps.executeQuery();

            while (rs.next()) {
                String fname = rs.getString(1);
                String emailid = rs.getString(2);
                String password = rs.getString(4);
                String mo_no = rs.getString(5);
                String cldid = rs.getString(6);

                System.out.println("-------------database data -----");
                System.out.println("fname=" + fname + " email=" + emailid + " Password=" + password + " mo no=" + mo_no);

                System.out.println("-------------user data -----");
                System.out.println("fname=" + Fname + " email=" + Email + " Password=" + Password + " mo no=" + Mob);

                if (fname.equals(Fname) && emailid.equals(Email) && password.equals(Password) && mo_no.equals(Mob))//checking whether result set gives SQL Null value
                {
                    // if (cldid.equals(CloudId)) {
                    status = true;

                    // }
                }

            }
        } catch (Exception e) {
            status = false;
            System.out.println("duplicate entry found.....!");
        }

        return status;
    }

    public double getUsedStorageCount11(String EmailId, java.sql.Date Date) throws Exception {

        double UsedStoragesize = 0;

        String Sql = "select sum(filesize) from finalpoolstoredudetails where Email=? and date<=?;";
        ps = con.prepareStatement(Sql);
        ps.setString(1, EmailId);
        ps.setDate(2, Date);
        rs = ps.executeQuery();

        while (rs.next()) {

            UsedStoragesize = rs.getInt(1);

        }

        return UsedStoragesize;

    }

    public double getUsedStorageByUser(String EmailId) throws Exception {

        double UsedStoragesize = 0;

        String Sql = "select sum(filesize) from finalpoolstoredudetails where Email=?;";
        ps = con.prepareStatement(Sql);
        ps.setString(1, EmailId);

        rs = ps.executeQuery();

        while (rs.next()) {

            UsedStoragesize = rs.getInt(1);

        }

        return UsedStoragesize;

    }

    public String getUserExpectedStorage(String EmailId) throws Exception {
        String ExpectedStorage = "";

        String Sql = "SELECT ExpectedStorage FROM registration where Email=?";
        ps = con.prepareStatement(Sql);
        ps.setString(1, EmailId);
        rs = ps.executeQuery();

        while (rs.next()) {
            ExpectedStorage = rs.getString(1);

        }

        return ExpectedStorage;

    }

    public java.sql.Date getUserRegisterDate(String EmailId) throws Exception {
        java.sql.Date UserRegisterDate = Date.valueOf(LocalDate.MAX);

        String Sql = "select StartDate from registration where Email=?;";
        ps = con.prepareStatement(Sql);
        ps.setString(1, EmailId);
        rs = ps.executeQuery();

        while (rs.next()) {
            UserRegisterDate = rs.getDate(1);

        }

        return UserRegisterDate;

    }

    public String getCloudId(String EmailId) throws Exception {
        String CloudId = null;

        //starting connection
        //      con = conobj.dbConnection();
        String Sql = "SELECT cloudId FROM registration where Email=?";
        ps = con.prepareStatement(Sql);
        ps.setString(1, EmailId);
        rs = ps.executeQuery();

        while (rs.next()) {
            CloudId = rs.getString(1);
            System.out.println("cCloudId:::" + CloudId);
            //CloudId=Integer.parseInt(cCloudId);
            System.out.println("Emailiddddddddddddddddddddd:::" + EmailId);
        }

        return (CloudId);

    }

    public int getNoOfReplication(String EmailId) throws Exception {
        int NOReplication = 0;

        String Sql = "SELECT NoofReplication FROM registration where Email=?";
        ps = con.prepareStatement(Sql);
        ps.setString(1, EmailId);
        rs = ps.executeQuery();

        while (rs.next()) {
            NOReplication = rs.getInt(1);

        }

        return NOReplication;

    }

    public boolean insertRegistration(String Name, String Email, String Address, String PhonNo, String Password, String ExpectedStorage, String ExpectedGetRequest, String ExpectedPutRequest, String ReplicationRequired, String NoofReplication, String cloudId, String ReservationTimeSpan, String Dominant, java.sql.Date SDate, java.sql.Date EDate) throws SQLException {

        boolean b = false;
        int row = 0;
        try {
            String sql = "insert into registration values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, Name);
            ps.setString(2, Email);
            ps.setString(3, Address);
            ps.setString(4, PhonNo);
            ps.setString(5, Password);
            ps.setString(6, ExpectedStorage);
            ps.setString(7, ExpectedGetRequest);
            ps.setString(8, ExpectedPutRequest);
            ps.setString(9, ReplicationRequired);
            ps.setString(10, NoofReplication);
            ps.setString(11, cloudId);
            ps.setString(12, ReservationTimeSpan);
            ps.setString(13, Dominant);
            ps.setDate(14, SDate);
            ps.setDate(15, EDate);

            row = ps.executeUpdate();
            b = true;
        } catch (Exception e) {
            b = false;
            JOptionPane.showMessageDialog(null, "use different Emailid.....! ");
        }

        return b;
    }

    public void updateRegisteredData(String ReservationTimeSpan, String ExpectedStorage, String ExpectedGetRequest, String ExpectedPutRequest, String NoofReplication, String Email) throws SQLException {
        String sql = "UPDATE registration SET ReservationTimeSpan=?,ExpectedStorage=?,ExpectedGetRequest=?,ExpectedPutRequest=?,NoofReplication=?  WHERE  Email=?;";
        ps = con.prepareStatement(sql);
        ps.setString(1, ReservationTimeSpan);
        ps.setString(2, ExpectedStorage);
        ps.setString(3, ExpectedGetRequest);
        ps.setString(4, ExpectedPutRequest);
        ps.setString(5, NoofReplication);
        ps.setString(6, Email);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data updated sucessfuly....!");
    }

    public void updateDominantData(String Dominant, String Email) throws SQLException {
        String sql = "UPDATE registration SET Dominant=? WHERE  Email=?;";
        ps = con.prepareStatement(sql);
        ps.setString(1, Dominant);
        ps.setString(2, Email);
        ps.executeUpdate();
        System.out.println("Dominat Updated Sucessfully...!");
    }

    public boolean insertDiscount(String UserEmail, double Discount) throws SQLException {

        boolean b = false;
        int row = 0;
        try {
            String sql = "insert into admindiscount values(?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, UserEmail);
            ps.setDouble(2, Discount);

            row = ps.executeUpdate();
            b = true;
        } catch (Exception e) {
            b = false;
        }

        return b;
    }

    public int insertUploadedDataToFPSUD(String UserName, String cloudid, String FileName, double FileSize, java.sql.Date KeyDate, String Ctime, String CloudName) throws Exception {

        int row = 0;
        String sql = "insert into finalpoolstoredudetails values(?,?,?,?,?,?,?)";
        ps = con.prepareStatement(sql);
        ps.setString(1, UserName);
        ps.setString(2, cloudid);
        ps.setString(3, FileName);
        ps.setDouble(4, FileSize);
        ps.setDate(5, KeyDate);
        ps.setString(6, Ctime);
        ps.setString(7, CloudName);

        row = ps.executeUpdate();

        System.out.println("data inserted to cloud1 successfully");

        return row;
    }

    public int doOverwitingOndata(String EmailId) {

        int status = 0;
        try {
            String Sql = "delete from finalpoolstoredudetails where Email=?;";
            ps = con.prepareStatement(Sql);
            ps.setString(1, EmailId);

            rs = ps.executeQuery();

            status = 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;

    }

    public ArrayList<String> getFinalPoolStoredUDetails() throws SQLException {
        boolean arr1 = false;
        ArrayList<String> aa1 = new ArrayList<>();
        try {
            String sql = "select * from finalpoolstoredudetails";
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            int i = 0;
            while (rs.next()) {

                String data = rs.getString(1) + "," + rs.getString(2) + "," + rs.getString(3) + "," + rs.getString(4) + "," + rs.getString(5) + "," + rs.getString(6) + "," + rs.getString(7);
                aa1.add(data);
            }
            System.out.println("arr1 ::" + aa1);

            ps.close();
        } catch (Exception e) {

            e.printStackTrace();
        }
        return aa1;
    }

    public ArrayList<String> getFinalPoolStoredUDetails(String Email) throws SQLException {
        boolean arr1 = false;
        ArrayList<String> aa1 = new ArrayList<>();
        try {
            String sql = "select * from finalpoolstoredudetails where Email=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, Email);

            rs = ps.executeQuery();

            int i = 0;
            while (rs.next()) {

                String data = rs.getString(1) + "," + rs.getString(2) + "," + rs.getString(3) + "," + rs.getString(4) + "," + rs.getString(5) + "," + rs.getString(6) + "," + rs.getString(7);
                aa1.add(data);
            }
            System.out.println("arr1 ::" + aa1);

            ps.close();
        } catch (Exception e) {

            e.printStackTrace();
        }
        return aa1;
    }

    public ArrayList<String> getUserIdDetails() throws SQLException {
        boolean arr1 = false;
        ArrayList<String> aa1 = new ArrayList<>();
        try {
            String sql = "select Email from registration";
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {

                String data = rs.getString(1);
                aa1.add(data);
            }
            System.out.println("arr1 ::" + aa1);

            ps.close();
        } catch (Exception e) {

            e.printStackTrace();
        }
        return aa1;
    }

    public ArrayList<String> getUploadedDataToAWS() throws SQLException {
        boolean arr1 = false;
        ArrayList<String> aa1 = new ArrayList<>();
        try {
            String sql = "select * from finalpoolstoredudetails where CloudName=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, "aws");
            rs = ps.executeQuery();

            int i = 0;
            while (rs.next()) {

                String data = rs.getString(1) + "," + rs.getString(2) + "," + rs.getString(3) + "," + rs.getString(4) + "," + rs.getString(5) + "," + rs.getString(6) + "," + rs.getString(7);
                aa1.add(data);
            }
            System.out.println("arr1 ::" + aa1);

            ps.close();
        } catch (Exception e) {

            e.printStackTrace();
        }
        return aa1;
    }

    public ArrayList<String> getUploadedDataToAWS(String Email) throws SQLException {
        boolean arr1 = false;
        ArrayList<String> aa1 = new ArrayList<>();
        try {
            String sql = "select * from finalpoolstoredudetails where  Email=? and CloudName=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, Email);
            ps.setString(2, "aws");

            rs = ps.executeQuery();

            int i = 0;
            while (rs.next()) {

                String data = rs.getString(1) + "," + rs.getString(2) + "," + rs.getString(3) + "," + rs.getString(4) + "," + rs.getString(5) + "," + rs.getString(6) + "," + rs.getString(7);
                aa1.add(data);
            }
            System.out.println("arr1 ::" + aa1);

            ps.close();
        } catch (Exception e) {

            e.printStackTrace();
        }
        return aa1;
    }

    public ArrayList<String> getUploadedDataToGCS(String Email) throws SQLException {
        boolean arr1 = false;
        ArrayList<String> aa1 = new ArrayList<>();
        try {
            String sql = "select * from finalpoolstoredudetails where  Email=? and CloudName=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, Email);
            ps.setString(2, "gcs");

            rs = ps.executeQuery();

            int i = 0;
            while (rs.next()) {

                String data = rs.getString(1) + "," + rs.getString(2) + "," + rs.getString(3) + "," + rs.getString(4) + "," + rs.getString(5) + "," + rs.getString(6) + "," + rs.getString(7);
                aa1.add(data);
            }
            System.out.println("arr1 ::" + aa1);

            ps.close();
        } catch (Exception e) {

            e.printStackTrace();
        }
        return aa1;
    }

    public ArrayList<String> getUploadedDataToAZUR(String Email) throws SQLException {
        boolean arr1 = false;
        ArrayList<String> aa1 = new ArrayList<>();
        try {
            String sql = "select * from finalpoolstoredudetails where  Email=? and CloudName=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, Email);
            ps.setString(2, "azur");

            rs = ps.executeQuery();

            int i = 0;
            while (rs.next()) {

                String data = rs.getString(1) + "," + rs.getString(2) + "," + rs.getString(3) + "," + rs.getString(4) + "," + rs.getString(5) + "," + rs.getString(6) + "," + rs.getString(7);
                aa1.add(data);
            }
            System.out.println("arr1 ::" + aa1);

            ps.close();
        } catch (Exception e) {

            e.printStackTrace();
        }
        return aa1;
    }

    public ArrayList<String> getUploadedDataToAzur() throws SQLException {
        boolean arr1 = false;
        ArrayList<String> aa1 = new ArrayList<>();
        try {
            String sql = "select * from finalpoolstoredudetails where CloudName=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, "azur");

            rs = ps.executeQuery();

            int i = 0;
            while (rs.next()) {

                String data = rs.getString(1) + "," + rs.getString(2) + "," + rs.getString(3) + "," + rs.getString(4) + "," + rs.getString(5) + "," + rs.getString(6) + "," + rs.getString(7);
                aa1.add(data);
            }
            System.out.println("arr1 ::" + aa1);

            ps.close();
        } catch (Exception e) {

            e.printStackTrace();
        }
        return aa1;
    }

    public ArrayList<String> getUploadedDataToGCS() throws SQLException {
        boolean arr1 = false;
        ArrayList<String> aa1 = new ArrayList<>();
        try {
            String sql = "select * from finalpoolstoredudetails where CloudName=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, "gcs");
            rs = ps.executeQuery();

            int i = 0;
            while (rs.next()) {

                String data = rs.getString(1) + "," + rs.getString(2) + "," + rs.getString(3) + "," + rs.getString(4) + "," + rs.getString(5) + "," + rs.getString(6) + "," + rs.getString(7);
                aa1.add(data);
            }
            System.out.println("arr1 ::" + aa1);

            ps.close();
        } catch (Exception e) {

            e.printStackTrace();
        }
        return aa1;
    }

    public ArrayList<String> getUploadedFileList(String Email) throws SQLException {
        boolean arr1 = false;
        ArrayList<String> aa1 = new ArrayList<>();
        try {
            String sql = "select distinct(filename) from finalpoolstoredudetails where Email=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, Email);
            rs = ps.executeQuery();

            int i = 0;
            while (rs.next()) {

                String data = rs.getString(1);
                aa1.add(data);
            }
            System.out.println("Uploaded File list ::" + aa1);

            ps.close();
        } catch (Exception e) {

            e.printStackTrace();
        }
        return aa1;
    }

    public ArrayList<String> getRegisteredData(String Email) throws SQLException {
        boolean arr = false;
        ArrayList<String> aa = new ArrayList<>();
        try {
            String sql = "select * from registration where Email=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, Email);

            rs = ps.executeQuery();

            int i = 0;
            while (rs.next()) {

                aa.add(rs.getString(12));
                aa.add(rs.getString(6));
                aa.add(rs.getString(7));
                aa.add(rs.getString(8));
                aa.add(rs.getString(9));
                aa.add(rs.getString(10));

            }
            System.out.println("arr ::" + aa);

            ps.close();
        } catch (Exception e) {

            e.printStackTrace();
        }
        return aa;
    }

    public double getExpectedGet(String EmailId) throws Exception {
        double ExpectedGet = 0;

        String Sql = "select ExpectedGetRequest from registration where Email=?";
        ps = con.prepareStatement(Sql);
        ps.setString(1, EmailId);
        rs = ps.executeQuery();

        while (rs.next()) {
            ExpectedGet = Double.parseDouble(rs.getString(1));

        }
        System.out.println("ExpectedGet :: " + ExpectedGet);
        return ExpectedGet;

    }

    //function to get expected put request
    public double getExpectedPut(String EmailId) throws Exception {
        double ExpectedPut = 0;

        String Sql = "select ExpectedPutRequest from registration where Email=?";
        ps = con.prepareStatement(Sql);
        ps.setString(1, EmailId);
        rs = ps.executeQuery();

        while (rs.next()) {
            ExpectedPut = Double.parseDouble(rs.getString(1));

        }
        return ExpectedPut;

    }

    public double getDiscount(String EmailId) throws Exception {
        double Discount = 0;

        String Sql = "select Discount from admindiscount where UserEmail=?";
        ps = con.prepareStatement(Sql);
        ps.setString(1, EmailId);
        rs = ps.executeQuery();

        while (rs.next()) {
            Discount = rs.getDouble(1);

        }
        Discount = Discount / 100;
        return Discount;

    }

    public double getUsedPutReqCount(String EmailId) throws Exception {
        double UsedPutReqCount = 0;

        String Sql = "select count(Filesize) from finalpoolstoredudetails where Email=?;";
        ps = con.prepareStatement(Sql);
        ps.setString(1, EmailId);
        rs = ps.executeQuery();

        while (rs.next()) {
            UsedPutReqCount = rs.getInt(1);

        }

        return UsedPutReqCount;

    }

    public String getFileUploaded_Cloud_Name(String EmailId, String Fname) throws Exception {
        String CloudName = "";

        String Sql = "select CloudName from finalpoolstoredudetails where Email=? and filename=?;";
        ps = con.prepareStatement(Sql);
        ps.setString(1, EmailId);
        ps.setString(2, Fname);
        rs = ps.executeQuery();

        while (rs.next()) {
            CloudName = rs.getString(1);

        }

        return CloudName;

    }

    public double getCnt(String Email, java.sql.Date dates) throws SQLException {
        double dd = .0;

        String Sql = "select count(filename) from finalpoolstoredudetails where Email=? and date>=?;";
        ps = con.prepareStatement(Sql);
        ps.setString(1, Email);
        ps.setDate(2, (Date) dates);
        rs = ps.executeQuery();

        while (rs.next()) {
            dd = rs.getDouble(1);

        }

        return dd;
    }

    public double getUsedStrgSize(String EmailId) throws Exception {
        double UsedStrgSize = 0;
        //starting connection
        // con = conobj.dbConnection();
        String Sql = "select sum(Filesize) from finalpoolstoredudetails where Email=?;";
        ps = con.prepareStatement(Sql);
        ps.setString(1, EmailId);
        rs = ps.executeQuery();

        while (rs.next()) {
            UsedStrgSize = rs.getInt(1);

        }

        return UsedStrgSize;

    }

    // function to get dominant from database
    public String getDominant(String Email) throws SQLException {
        String Dominant = "";
        String NReplica = "";

        String Sql = "select Dominant,NoofReplication from registration where Email=?";
        ps = con.prepareStatement(Sql);
        ps.setString(1, Email);

        rs = ps.executeQuery();

        while (rs.next()) {
            Dominant = rs.getString(1);
            NReplica = rs.getString(2);
        }
        return Dominant + "," + NReplica;
    }

    public ArrayList<String> getData(String mail, String CompressedFileName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
