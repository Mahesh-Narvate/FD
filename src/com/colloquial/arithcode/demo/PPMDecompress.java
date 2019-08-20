package com.colloquial.arithcode.demo;

import static GUI.UserDashBord.BrowseFile;
import com.colloquial.arithcode.ppm.PPMModel;
import com.colloquial.arithcode.ppm.ArithCodeInputStream;

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
import java.util.logging.Level;
import java.util.logging.Logger;

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
 * <li><code><i>FileIn</i></code>: Input file to decompress.
 * <li><code><i>FileOut</i></code>: Output for decompressed file.
 * </ul>
 *
 * <p>
 * This is just meant as a demo. A more sophisticated version would name
 * arguments and allow input or output files to be ommitted and use standard
 * input and output. And would write the order as the first byte of the output
 * so that it didn't need to be specified.
 *
 * @author <a href="http://www.colloquial.com/carp/">Bob Carpenter</a>
 * @version 1.2
 * @since 1.1
 */
public final class PPMDecompress {

    /**
     * Decompress the specified file using the specified order of PPM. See the
     * class documentation for more information.
     *
     * @param args Command-line argument.
     * @throws IOException If there is an underlying IO exception.
     */
    public static void main(String[] args) throws IOException {
//        if (args.length != 3) {
//            System.err.println(USAGE_MESSAGE);
//            System.exit(1);
//        }
        int order = Integer.valueOf("2");
        File inFile = new File("/home/pc2/NetBeansProjects/newPPMComp/Helpful commands.txt");
        File outFile = new File("/home/pc2/NetBeansProjects/newPPMComp/abc/Helpful commands.txt");

        PPMModel model = new PPMModel(order);
        InputStream fileIs = new FileInputStream(inFile);
        InputStream bufIs = new BufferedInputStream(fileIs);
        InputStream arithIs = new ArithCodeInputStream(bufIs, model);
        OutputStream fileOs = new FileOutputStream(outFile);
        OutputStream bufOs = new BufferedOutputStream(fileOs);
        copy(arithIs, bufOs);
        bufOs.close();
    }

    private static String USAGE_MESSAGE
            = "\nUSAGE: java PPMDecompress Order FileIn FileOut";

    public void deCompress(File outFile, File inFile) throws FileNotFoundException, IOException {
        int order = Integer.valueOf("2");
        PPMModel model = new PPMModel(order);
        InputStream fileIs = new FileInputStream(inFile);
        InputStream bufIs = new BufferedInputStream(fileIs);
        InputStream arithIs = new ArithCodeInputStream(bufIs, model);
        OutputStream fileOs = new FileOutputStream(outFile);
        OutputStream bufOs = new BufferedOutputStream(fileOs);
        copy(arithIs, bufOs);
        bufOs.close();
    }

    public void getFile(File inFile) throws IOException {
        File outFile = new File(System.getProperty("user.dir") + File.separator + "DecompressFileByPPm" + File.separator + Convert(inFile.getName()));
        deCompress(outFile, inFile);
    }

    public String Convert(String fname) {
        if (fname.contains(".ppm")) {
            fname = fname.replace(".ppm", ".txt");
        }
        return fname;
    }

    public String convertFname(String name) {
        if (name.contains(".ppm")) {
            name = name.replace(".ppm", ".txt");
        }

        if (name.contains(".ppm")) {
            name = name.replace(".doc", ".ppm");
        }
        if (name.contains(".ppm")) {
            name = name.replace(".mp4", ".ppm");
        }
        if (name.contains(".docx")) {
            name = name.replace(".docx", ".ppm");
        }
        if (name.contains(".xlsx")) {
            name = name.replace(".xlsx", ".ppm");
        }
        if (name.contains(".xls")) {
            name = name.replace(".xls", ".ppm");
        }
        if (name.contains(".xml")) {
            name = name.replace(".xml", ".ppm");
        }
        if (name.contains(".odt")) {
            name = name.replace(".odt", ".ppm");
        }
        if (name.contains(".tex")) {
            name = name.replace(".tex", ".ppm");
        }
        if (name.contains(".xhtml")) {
            name = name.replace(".xhtml", ".ppm");
        }
        if (name.contains(".key")) {
            name = name.replace(".key", ".ppm");
        }
        if (name.contains(".ppt")) {
            name = name.replace(".ppt", ".ppm");
        }
        if (name.contains(".pptx")) {
            name = name.replace(".pptx", ".ppm");
        }
        if (name.contains(".jpg")) {
            name = name.replace(".jpg", ".ppm");
        }
        if (name.contains(".jpeg")) {
            name = name.replace(".jpeg", ".ppm");
        }
        if (name.contains(".png")) {
            name = name.replace(".png", ".ppm");
        }
        if (name.contains(".bmp")) {
            name = name.replace(".bmp", ".ppm");
        }
        if (name.contains(".wks")) {
            name = name.replace(".wks", ".ppm");
        }
        if (name.contains(".wpd")) {
            name = name.replace(".wpd", ".ppm");
        }
        if (name.contains(".mp3 ")) {
            name = name.replace(".mp3", ".ppm");
        }
        if (name.contains(".zip")) {
            name = name.replace(".zip", ".ppm");
        }
        if (name.contains(".rar")) {
            name = name.replace(".rar", ".ppm");
        }
        if (name.contains(".sql")) {
            name = name.replace(".sql", ".ppm");
        }
        if (name.contains(".jar")) {
            name = name.replace(".jar", ".ppm");
        }
        if (name.contains(".py")) {
            name = name.replace(".py", ".ppm");
        }
        if (name.contains(".java")) {
            name = name.replace(".java", ".ppm");
        }
        if (name.contains(".apk")) {
            name = name.replace(".apk", ".ppm");
        }
        if (name.contains(".bat")) {
            name = name.replace(".bat", ".ppm");
        }
        if (name.contains(".gif")) {
            name = name.replace(".gif", ".ppm");
        }
        if (name.contains(".ico")) {
            name = name.replace(".ico", ".ppm");
        }
        if (name.contains(".html")) {
            name = name.replace(".html", ".ppm");
        }
        if (name.contains(".mkv")) {
            name = name.replace(".mkv", ".ppm");
        }
        if (name.contains(".3gp")) {
            name = name.replace(".3gp", ".ppm");
        }
        if (name.contains(".wmv")) {
            name = name.replace(".wmv", ".ppm");
        }
        if (name.contains(".rtf")) {
            name = name.replace(".rtf", ".ppm");
        }
        if (name.contains(".m4v")) {
            name = name.replace(".m4v", ".ppm");
        }
        if (name.contains(".avi")) {
            name = name.replace(".avi", ".ppm");
        }
        if (name.contains(".bak")) {
            name = name.replace(".bak", ".ppm");
        }

        System.out.println("name=" + name);
        return name;
    }

    public String Show(String f) {
        StringBuilder sb = new StringBuilder();
        String Data = "";
        try {

            File outFile = new File(System.getProperty("user.dir") + File.separator + "DecompressFileByPPm" + File.separator + f.replace(".ppm", ".txt"));

            FileReader reader = new FileReader(outFile);
            BufferedReader br = new BufferedReader(reader);
            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            Data = sb.toString();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return Data;

    }

}
