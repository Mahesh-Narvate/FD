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
import java.io.InputStream;
import java.net.SocketException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showConfirmDialog;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

/**
 * This program demonstrates how to determine existence of a specific
 * file/directory on a remote FTP server.
 *
 * @author www.codejava.net
 *
 */
public class FTPCheckFileExists {

    private FTPClient ftpClient;
    private int returnCode;

    /**
     * Determines whether a directory exists or not
     *
     * @param dirPath
     * @return true if exists, false otherwise
     * @throws IOException thrown if any I/O error occurred.
     */
    public boolean checkDirectoryExists(String dirPath) throws IOException {
        ftpClient.changeWorkingDirectory(dirPath);
        returnCode = ftpClient.getReplyCode();
        if (returnCode == 550) {
            return false;
        }
        return true;
    }

    /**
     * Determines whether a file exists or not
     *
     * @param filePath
     * @return true if exists, false otherwise
     * @throws IOException thrown if any I/O error occurred.
     */
    public boolean checkFileExists(String filePath) throws IOException {
        InputStream inputStream = ftpClient.retrieveFileStream(filePath);
        returnCode = ftpClient.getReplyCode();
        if (inputStream == null || returnCode == 550) {
            return false;
        }
        return true;
    }

    /**
     * Connects to a remote FTP server
     * @param hostname
     */
    public void connect(String hostname, int port, String username, String password) throws IOException {
       
            ftpClient = new FTPClient();
            ftpClient.connect(hostname, port);
            returnCode = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(returnCode)) {
                throw new IOException("Could not connect");
            }
            boolean loggedIn = ftpClient.login(username, password);
            if (!loggedIn) {
                throw new IOException("Could not login");
            }
            System.out.println("Connected and logged in.");
        
    }

    /**
     * Logs out and disconnects from the server
     */
    public void logout() throws IOException {
        if (ftpClient != null && ftpClient.isConnected()) {
            ftpClient.logout();
            ftpClient.disconnect();
            System.out.println("Logged out");
        }
    }

    /**
     * Runs this program
     */
    
}
