/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ftp;

/**
 *
 * @author image
 */
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

/**
 * An example program that demonstrates how to list files and directories on a
 * FTP server using Apache Commons Net API.
 *
 * @author www.codejava.net
 */
public class FTPListDemo {

    public static ArrayList<String> GetListOfFilesFromServer(String hostname, String username, String password) {

        ArrayList<String> data = new ArrayList<>();

        FTPClient ftpClient = new FTPClient();
        int port = 21;
        try {

            ftpClient.connect(hostname, port);
            showServerReply(ftpClient);

            boolean success = ftpClient.login(username, password);
            showServerReply(ftpClient);

            // Lists files and directories
            FTPFile[] files1 = ftpClient.listFiles("/tarun/Download/");
        // FTPFile[] files1 = ftpClient.listFiles("/");
         //   FTPFile[] files1 = ftpClient.listFiles("/var/www/www-root/data/tarun/Download/");
            data = printFileDetails(files1);
            //  System.out.println("data:: \n" + data);

        } catch (IOException ex) {
            System.out.println("Oops! Something wrong happened");
            ex.printStackTrace();
        } finally {

            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return data;
    }

    public static synchronized FTPFile[] GetListFilesFromServer(String hostname, String username, String password) {

        FTPFile[] files1 = null;

        FTPClient ftpClient = new FTPClient();
        int port = 21;
        try {

            ftpClient.connect(hostname, port);
            showServerReply(ftpClient);

            boolean success = ftpClient.login(username, password);
            showServerReply(ftpClient);

            // Lists files and directories
            files1 = ftpClient.listFiles("/tarun/Download/");
          //  files1 = ftpClient.listFiles("/");
//            files1 = ftpClient.listFiles("/var/www/www-root/data/tarun/Download/");
        } catch (IOException ex) {
            System.out.println("Oops! Something wrong happened");
            JOptionPane.showMessageDialog(null, "Oops,Internet connection is not available.........! !");
            //  ex.printStackTrace();
        } finally {

            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                // ex.printStackTrace();
            }
        }
        return files1;
    }

   
    private static ArrayList<String> printFileDetails(FTPFile[] files) {
        ArrayList<String> Filelist = new ArrayList<>();
        DateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (FTPFile file : files) {
            String details = file.getName();
            if (!details.contains("-")) {
                Filelist.add(details);
            }
            if (file.isDirectory()) {
                details = "[" + details + "]";
            }

            details += "\t\t" + file.getSize();
            //    Filelist.add(details);
            details += "\t\t" + dateFormater.format(file.getTimestamp().getTime());

            //  System.out.println(details);
        }
        return Filelist;
    }

    private static void printNames(String files[]) {
        if (files != null && files.length > 0) {
            for (String aFile : files) {
                //  System.out.println(aFile);
            }
        }
    }

    private static void showServerReply(FTPClient ftpClient) {
        String[] replies = ftpClient.getReplyStrings();
        if (replies != null && replies.length > 0) {
            for (String aReply : replies) {
                System.out.println("SERVER: " + aReply);
            }
        }
    }
}
