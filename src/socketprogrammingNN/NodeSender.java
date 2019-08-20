/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socketprogrammingNN;

import CostCalculation.AWS1;
import CostCalculation.DominantSet;
import CostCalculation.GCS1;
import CostCalculation.MicroAzur1;
import CostCalculation.Storageconverter;
import Database.QueryFunction;
import GUI.ProgressBar;
import GUI.UserDashBord;
import static GUI.UserDashBord.BanswidthListCloud;
import static GUI.UserDashBord.BrowseFile;
import static GUI.UserDashBord.click_to_upload;
import static GUI.UserDashBord.sortedCloudlist;
import GUI.UserLogin;
import com.colloquial.arithcode.demo.PPMCompress;
import date.BillingPeriod;
import date.DateCalc;
import ftp.FTPUploader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import progressbar88.PregressBarDemo88;

import ftp.FTPCheckFileExists;
import ftp.FileStoragePath;
import java.io.IOException;

/**
 *
 * @author hp
 */
public class NodeSender extends Thread {

    PPMCompress pc = new PPMCompress();
    QueryFunction q = new QueryFunction();
    DateCalc dc = new DateCalc();
    BillingPeriod b = new BillingPeriod();
    PregressBarDemo88 pb1;
    DominantSet ds = new DominantSet();

    public void uploadData(LinkedHashMap<String, String> clouds, LinkedHashMap<String, Long> Bandwidthlist, String fileName, int NOfreplication) {
        long ETA = 0;
        try {
            for (int i = 0; i < NOfreplication; i++) {

                String Key = (String) clouds.keySet().toArray()[i];
                String valueForKey = clouds.get(Key);
                System.out.println("key ::::: " + Key + " value ::: " + valueForKey);
                String[] splitdata = valueForKey.split(",");

                String Key1 = (String) Bandwidthlist.keySet().toArray()[i];
                long valueForKey1 = Bandwidthlist.get(Key1);
                System.out.println("BanswidthListCloud_key1 ::::: " + Key1 + "BanswidthListCloud_value1 ::: " + valueForKey1);

                boolean flag = ds.checkSlo(Storageconverter.getByteToGBConversion(q.getUsedStorageByUser(UserLogin.email)), UserLogin.email);

                if (flag) {
                    Object[] options1 = {"yes", "No"};

                    int result = JOptionPane.showOptionDialog(null,  // 
                            "Want to upload data on " + Key + " server  and Bandwidth is "+ valueForKey1,
                            "User Input to upload data",
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            options1,
                            null);
                    System.out.println(" result=" + result + " flag=" + flag);
                    if (result == 0) {
                        System.out.println(" in if loop of check slo");
                        System.out.println(" splitdata[0] ::" +splitdata[0]+" splitdata[1] :: "+splitdata[1]+" splitdata[2] :: "+splitdata[2]);
                        FTPUploader fileFtp = new FTPUploader(splitdata[0], splitdata[1], splitdata[2]);

                        System.out.println("on click  " + click_to_upload);

                        if (!click_to_upload) {
                              System.out.println("BrowseFile.getAbsolutePath()  " + BrowseFile.getAbsolutePath() + "  BrowseFile.getName  " + BrowseFile.getAbsolutePath());

//                            ETA = fileFtp.uploadFile(BrowseFile.getAbsolutePath(), BrowseFile.getName(), "/var/www/www-root/data/tarun/Download/");
                              ETA = fileFtp.uploadFile(BrowseFile.getAbsolutePath(), BrowseFile.getName(), FileStoragePath.getCloudStoragePath());
                              q.insertUploadedDataToFPSUD(UserLogin.email, q.getCloudId(UserLogin.email), UserDashBord.BrowseFile.getName(), BrowseFile.length(), dc.getCurrentSqlDate(), BillingPeriod.getCurrentTimeUsingDate(), Key);

                        } else {

                            ETA = fileFtp.uploadFile(System.getProperty("user.dir") + File.separator + "CompressedFileByPPm" + File.separator + pc.convertFname(BrowseFile.getName()), pc.convertFname(BrowseFile.getName()), FileStoragePath.getCloudStoragePath());

                            q.insertUploadedDataToFPSUD(UserLogin.email, q.getCloudId(UserLogin.email), new File(UserDashBord.CompressedFileName).getName(), new File(UserDashBord.CompressedFileName).length(), dc.getCurrentSqlDate(), BillingPeriod.getCurrentTimeUsingDate(), Key);

                        }

                        pb1 = new PregressBarDemo88(ETA, Key);
                        pb1.setVisible(true);
                        try {
                            this.wait(100);
                            pb1.dispose();
                        } catch (Exception ex) {
                            // Logger.getLogger(UserDashBord.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        fileFtp.disconnect();
                        try {
                            this.wait(100);
                        } catch (Exception e) {
                        }
                        JOptionPane.showMessageDialog(null, "data uploaded sucessfully on " + Key + " cloud....!");
                    }
                }else{
                    break;
                } //// flag

            }
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, " Please check your internate connection and try again......!");
        } catch (Exception ex) {
            Logger.getLogger(NodeSender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public LinkedHashMap<String, String> getCloudConnectionInfo(HashMap<String, Double> sortedCloudList) {
        LinkedHashMap<String, String> CloudConnectionDetails = new LinkedHashMap<>();
        String valueForKey = "";
        try {
            for (int i = 0; i < sortedCloudList.size(); i++) {
                //  System.out.println(" in  send data....!");
                String Key = (String) sortedCloudList.keySet().toArray()[i];
                //  System.out.println("key==" + Key);
                if (Key.contains("aws")) {
                    System.out.println("keyy :::::::::: " + Key);
                    valueForKey = AWS1.Hostid + StaticIpAddress.Delimeter + AWS1.Username + StaticIpAddress.Delimeter + AWS1.Password;
                    CloudConnectionDetails.put(Key, valueForKey);
                }
                if (Key.contains("azur")) {
                    System.out.println("keyy :::::::::: " + Key);

                    valueForKey = MicroAzur1.Hostid + StaticIpAddress.Delimeter + MicroAzur1.Username + StaticIpAddress.Delimeter + MicroAzur1.Password;
                    CloudConnectionDetails.put(Key, valueForKey);
                }
                if (Key.contains("gcs")) {
                    System.out.println("keyy :::::::::: " + Key);

                    valueForKey = GCS1.Hostid + StaticIpAddress.Delimeter + GCS1.Username + StaticIpAddress.Delimeter + GCS1.Password;
                    CloudConnectionDetails.put(Key, valueForKey);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CloudConnectionDetails;
    }

    public LinkedHashMap<String, Long> getBandwidth(LinkedHashMap<String, String> ConnectionINfoDetails) {
        LinkedHashMap<String, Long> Bwdata = new LinkedHashMap<>();

        for (int i = 0; i < ConnectionINfoDetails.size(); i++) {

            String Key = (String) ConnectionINfoDetails.keySet().toArray()[i];
            String valueForKey = ConnectionINfoDetails.get(Key);

            String[] split = valueForKey.split(",");

            String hostname = split[0];
            int port = 21;
            String username = split[1];
            String password = split[2];
            String dirPath = FileStoragePath.getCloudStoragePath();
           
            String filePath = BrowseFile.getAbsolutePath();

            FTPCheckFileExists ftpApp = new FTPCheckFileExists();

            try {
                ftpApp.connect(hostname, port, username, password);
                System.out.println("Host name ::"+hostname +" port ::"+port+" username "+username +" passsword "+password);

                boolean exist = ftpApp.checkDirectoryExists(dirPath);
                System.out.println("Is directory " + dirPath + " exists? " + exist);

                long Stime = System.currentTimeMillis();
                  
                exist = ftpApp.checkFileExists(filePath);
         
                long Etime = System.currentTimeMillis();
                Bwdata.put(Key, Etime - Stime);
                System.out.println("Size of bandwidth map :: " + Bwdata.size());
                System.out.println("total time required =" + (Etime - Stime));
                System.out.println("Is file " + filePath + " exists? " + exist);

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "check your internet connection and try again....!");
                break;
            } finally {
                try {
                    ftpApp.logout();
                } catch (IOException ex) {
                    //  ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Network is unreachable (connect failed).....!");
                    break;
                }
            }

        }

        return Bwdata;
    }

}
