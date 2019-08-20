/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ftp;

/**
 *
 * @author pc2
 */
import static GUI.UserDashBord.BrowseFile;
import java.awt.Desktop;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Timestamp;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class FTPUploader {

    FTPClient ftp = null;

    public FTPUploader(String host, String user, String pwd) throws Exception {
        ftp = new FTPClient();
        ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
        int reply;
        ftp.connect(host);
        reply = ftp.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftp.disconnect();
            throw new Exception("Exception in connecting to FTP Server");
        }
        ftp.login(user, pwd);
        ftp.setFileType(FTP.BINARY_FILE_TYPE);
        ftp.enterLocalPassiveMode();
    }

    public long uploadFile(String localFileFullName, String fileName, String hostDir)
            throws Exception {
        try (InputStream input = new FileInputStream(new File(localFileFullName))) {
            Long start = System.currentTimeMillis();

            this.ftp.storeFile(hostDir + fileName, input);
            Long end = System.currentTimeMillis();
            long ETA = end - start;
//                    long size = BrowseFile.length();
//                    double duration =  (double) (size / ETA);
            return ETA;
        }
    }

    public void disconnect() {
        if (this.ftp.isConnected()) {
            try {
                this.ftp.logout();
                this.ftp.disconnect();
            } catch (IOException f) {
                // do nothing as file is already saved to server
            }
        }
    }

}
