/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileDetails;

import java.io.File;

/**
 *
 * @author user
 */
public class FileDetails {
    
       public String getFileDetails(String path) {
        File f = new File(path);
        StringBuilder sb = new StringBuilder();
        sb.append("File Name" + "," + "FileSize\n");
      
            sb.append(f.getName() + "," + f.length() + "\n");
       //     System.out.println("File:::" + ff[i].getName() + "," + ff[i].length() + "\n");
   return sb.toString(); 
        }
        
    }
    
