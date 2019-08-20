package com.colloquial.arithcode.demo;

import GUI.UserLogin;
import GUI.UserDashBord;
import static GUI.UserDashBord.msg;
import com.colloquial.arithcode.ppm.PPMModel;
import com.colloquial.arithcode.ppm.ArithCodeOutputStream;

import static com.colloquial.io.Util.copy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;

/** 
 * Command-line function for compression.
 *
 * <P>
 * <b>Usage:</b>
 *
 * <blockquote><pre>java PPMCompress <i>Order FileIn FileOut</i></pre></blockquote>
 * 
 * <ul>
 * <li> <code><i>Order</i></code>: Order of PPM model to use.
 * <li><code><i>FileIn</i></code>: Input file to compress. 
 * <li><code><i>FileOut</i></code>: Output for compressed file.
 * </ul>
 *
 * <p>This is just meant as a demo.  A more sophisticated version
 * would name arguments and allow input or output files to be ommitted
 * and use standard input and output.
 * 
 * @author <a href="http://www.colloquial.com/carp/">Bob Carpenter</a>
 * @version 1.2
 * @since 1.1
 */
public final class PPMCompress {
    
    /** Compress according to the command line specification.  See
     * class documentation for description.
     *
     * @param args Command-line arguments naming order, input file and
     * output file.
     * @throws IOException If there is an underlying IO exception.
     */
    public static void main(String[] args) throws IOException {
//        if (args.length != 3) {
//            System.err.println(USAGE_MESSAGE);
//            System.exit(1);
//        }
       
        File inFile = new File("/home/pc2/NetBeansProjects/newPPMComp/5ItemInput/Helpful commands.txt");
        File outFile = new File("/home/pc2/NetBeansProjects/newPPMComp/Helpful commands.txt");
       int order = Integer.valueOf("2");
        PPMModel model = new PPMModel(order);
        InputStream fileIs = new FileInputStream(inFile);
        InputStream bufIs = new BufferedInputStream(fileIs);
        OutputStream fileOs = new FileOutputStream(outFile);
        OutputStream bufOs = new BufferedOutputStream(fileOs);
        OutputStream arithOs = new ArithCodeOutputStream(bufOs,model);
        copy(bufIs,arithOs);
    }

    /** String detailing usage of class as a main.
     */
    private static String USAGE_MESSAGE 
        = "\nUSAGE:  java PPMCompress Order FileIn FileOut";

    public void compressFile(File outFile, File inFile) throws FileNotFoundException, IOException {
        
         int order = Integer.valueOf("2");
        PPMModel model = new PPMModel(order);
        InputStream fileIs = new FileInputStream(inFile);
        InputStream bufIs = new BufferedInputStream(fileIs);
        OutputStream fileOs = new FileOutputStream(outFile);
        OutputStream bufOs = new BufferedOutputStream(fileOs);
        OutputStream arithOs = new ArithCodeOutputStream(bufOs,model);
        copy(bufIs,arithOs);
        
      //  getMsgToTxfer(outFile);
      
    }
    public void getFile(File inFile) throws IOException{
    
        System.out.println("inFilename="+convertFname(inFile.getName()));
      
     File outFile = new File(System.getProperty("user.dir")+File.separator+"CompressedFileByPPm"+File.separator+convertFname(inFile.getName()));
        System.out.println("outFile path "+outFile.getName());
        compressFile(outFile, inFile);
    }
    
    public String getMsgToTxfer(String fname) throws FileNotFoundException, IOException{
     if(fname.contains(".txt")){
     fname=convertFname(fname);
     }
     File outFile = new File(System.getProperty("user.dir")+File.separator+"CompressedFileByPPm"+File.separator+fname);
     StringBuilder sb=new StringBuilder();
        BufferedReader br=new BufferedReader(new FileReader(System.getProperty("user.dir")+File.separator+"CompressedFileByPPm"+File.separator+fname));
        String line="";
     while((line=br.readLine())!=null){
         
         sb.append(line);
     }
     br.close();
     
     msg="Mahesh"+"#"+UserLogin.email+"#"+fname+"#"+outFile.length()+"#"+sb.toString();
       // System.out.println("PPMCompress :: msg="+ Finalmainframe.msg);
        return  msg;
    }
    
    public String convertFname(String name){
        
        if(name.contains(".txt"))
             name=name.replace(".txt", ".ppm");
        if(name.contains(".pdf"))
             name=name.replace(".pdf", ".ppm");
        if(name.contains(".doc"))
             name=name.replace(".doc", ".ppm");
        if(name.contains(".mp4"))
             name=name.replace(".mp4", ".ppm");
        if(name.contains(".docx"))
             name=name.replace(".docx", ".ppm");
        if(name.contains(".xlsx"))
             name=name.replace(".xlsx", ".ppm");
        if(name.contains(".xls"))
             name=name.replace(".xls", ".ppm");
        if(name.contains(".xml"))
             name=name.replace(".xml", ".ppm");
        if(name.contains(".odt"))
             name=name.replace(".odt", ".ppm");
        if(name.contains(".tex"))
             name=name.replace(".tex", ".ppm");
         if(name.contains(".xhtml"))
             name=name.replace(".xhtml", ".ppm");
        if(name.contains(".key"))
             name=name.replace(".key", ".ppm");
        if(name.contains(".ppt"))
             name=name.replace(".ppt", ".ppm");
        if(name.contains(".pptx"))
             name=name.replace(".pptx", ".ppm");
        if(name.contains(".jpg"))
             name=name.replace(".jpg", ".ppm");
        if(name.contains(".jpeg"))
             name=name.replace(".jpeg", ".ppm");
        if(name.contains(".png"))
             name=name.replace(".png", ".ppm");
        if(name.contains(".bmp"))
             name=name.replace(".bmp", ".ppm");
        if(name.contains(".wks"))
             name=name.replace(".wks", ".ppm");
        if(name.contains(".wpd"))
             name=name.replace(".wpd", ".ppm");
        if(name.contains(".mp3 "))
             name=name.replace(".mp3", ".ppm");
        if(name.contains(".zip"))
             name=name.replace(".zip", ".ppm");
        if(name.contains(".rar"))
             name=name.replace(".rar", ".ppm");
        if(name.contains(".sql"))
             name=name.replace(".sql", ".ppm");
        if(name.contains(".jar"))
             name=name.replace(".jar", ".ppm");
        if(name.contains(".py"))
             name=name.replace(".py", ".ppm");
        if(name.contains(".java"))
             name=name.replace(".java", ".ppm");
        if(name.contains(".apk"))
             name=name.replace(".apk", ".ppm");
        if(name.contains(".bat"))
             name=name.replace(".bat", ".ppm");
        if(name.contains(".gif"))
             name=name.replace(".gif", ".ppm");
        if(name.contains(".ico"))
             name=name.replace(".ico", ".ppm");
        if(name.contains(".html"))
             name=name.replace(".html", ".ppm");
        if(name.contains(".mkv"))
             name=name.replace(".mkv", ".ppm");
        if(name.contains(".3gp"))
             name=name.replace(".3gp", ".ppm");
        if(name.contains(".wmv"))
             name=name.replace(".wmv", ".ppm");
        if(name.contains(".rtf"))
             name=name.replace(".rtf", ".ppm");
        if(name.contains(".m4v"))
             name=name.replace(".m4v", ".ppm");
        if(name.contains(".avi"))
             name=name.replace(".avi", ".ppm");
        if(name.contains(".bak"))
             name=name.replace(".bak", ".ppm");
        
        
  
        System.out.println("name="+name);
    return name;
    }
}

