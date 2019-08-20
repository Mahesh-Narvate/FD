package Table;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author pc2
 */
public class table {

    public String getFileDetails(String path) {
        File f = new File(path);
        File[] ff = f.listFiles();
        StringBuilder sb = new StringBuilder();
        sb.append("File Name" + "," + "FileSize\n");
        for (int i = 0; i < ff.length; i++) {

            sb.append(ff[i].getName() + "," + ff[i].length() + "\n");
            //     System.out.println("File:::" + ff[i].getName() + "," + ff[i].length() + "\n");

        }
        return sb.toString();
    }

    public boolean check(File f) {
        boolean b = false;
        if (f.isDirectory()) {
            b = true;
        }
        return b;
    }

    public String getCloudDetails(HashMap<String, Double> Cdata) {
        StringBuilder sb = new StringBuilder();
        sb.append("Server Name" + "," + "Server Capacity\n");

        for (Map.Entry<String, Double> entry : Cdata.entrySet()) {
            sb.append(entry.getKey() + ", " + entry.getValue() + "\n");
            System.out.println(entry.getKey() + " , " + entry.getValue() + "\n");
        }

        return sb.toString();
    }

    public String getViewUserDeatilsData(ArrayList Cdata) {
        StringBuilder sb = new StringBuilder();
        sb.append("Email" + "," + "cloudid" + "," + "filename" + "," + "filesize" + "," + "date" + "," + "time"+","+"Cloud Name\n");

        for (Object Strinjg : Cdata) {
            String data = (String) Strinjg;
            String[] ss = data.split(",");
            for (String s : ss) {
                sb.append(s + ",");
            }
            sb.append("\n");

            System.out.println(Strinjg + "\n");
        }

        return sb.toString();
    }
}
