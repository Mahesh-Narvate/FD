/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CostCalculation;

/**
 *
 * @author pc2
 */
public class Storageconverter {
    public static void main(String[] args) {
        System.out.println(" storage "+getConvertedStorage("10GB"));
    }
    
    public static double getConvertedStorage(String storage){
     double storageSize=0.0;
     
     if (storage.contains("MB")) {
                String Size = storage.replace("MB", "");
                storageSize = Double.parseDouble(Size);
                storageSize = storageSize/1024;
                System.out.println("Storagesize :: "+storageSize);
            }
            if (storage.contains("GB")) {
                String Size = storage.replace("GB", "");
                storageSize = Double.parseDouble(Size);
                storageSize = storageSize ;
                System.out.println("Storagesize :: "+storageSize);
            }
            if (storage.contains("TB")) {
                String Size = storage.replace("TB", "");
                storageSize = Double.parseDouble(Size);
                storageSize = storageSize*1024;
                System.out.println("Storagesize :: "+storageSize);
            }

     
      return storageSize;
    } 
    public static double getByteToGBConversion(double bytees){
        double gb=0.0;
        gb=bytees/1073741824;
    return gb;
    }
    
    public static double getConverterGet(String get){
            double NofGet=0.0;
            NofGet=Double.parseDouble(get)/10000;
      return NofGet;      
    }
    
    public static double getConverterPut(String put){
            double NofPut=0.0;
            NofPut=Double.parseDouble(put)/1000;
      return NofPut;      
    }
    
}
