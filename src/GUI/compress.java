package GUI;


import java.io.FileInputStream; 
import java.io.FileOutputStream; 
import java.io.IOException; 
import java.util.zip.DeflaterOutputStream; 
  
class zip 
{ 
    public   zip(String s) throws IOException { 
        //Assign the original file : file to 
        //FileInputStream for reading data 
        FileInputStream fis=new FileInputStream("file1"); 
  
        //Assign compressed file:file2 to FileOutputStream 
        FileOutputStream fos=new FileOutputStream("file2"); 
  
        //Assign FileOutputStream to DeflaterOutputStream 
        DeflaterOutputStream dos=new DeflaterOutputStream(fos); 
  
        //read data from FileInputStream and write it into DeflaterOutputStream 
        int data; 
        while ((data=fis.read())!=-1) 
        { 
            dos.write(data); 
        } 
  
        //close the file 
        fis.close(); 
        dos.close(); 
    } 
} 
