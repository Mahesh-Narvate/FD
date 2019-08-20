/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudinfo;

import Database.QueryFunction;
import GUI.MainFrame.*;
import GUI.UserDashBord;
import GUI.UserLogin;


/**
 *
 * @author pc2
 */
public class Cloud1Info {

    QueryFunction qf = new QueryFunction();

   public  final static  String  IPAddress="localhost";

   
    final static private int GD = 90;         //getdeadline is in ms
    final static private int PDH = 400;        // Putdeadline is in ms
    final static private int PDL = 250;        // Putdeadline is in ms
    final static private int GC = 100000000;         /// get requests handling capacity of datacenter is 100000000 per sec
    final static private int PC = 1000000;          ///  get requests handling capacity of datacenter is 1000000   per sec
    final static private double HGP = GC / PC;

    private final long StorageCapacity = 10*1073741824;//in bytes

    public float GLatency = 0.90f;
    public float PLatency = 0.90f;
    
     public static String getIPAddress() {
        return IPAddress;
    }

    public float getPLatency() {
        return PLatency;
    }

    public int getGD() {
        return GD;
    }

    public int getPDH() {
        return PDH;
    }

    public int getPDL() {
        return PDL;
    }

    public int getGC() {
        return GD;
    }

    public int getPC() {
        return PC;
    }

    public double getHGP() {
        return HGP;
    }

    public double getGLatency() {
        return GLatency;
    }

   
    
    public long getFreeMemory() throws Exception {
       return  (long)Math.abs(getUsedMemory()+ getStorageCapacity());   // have taken "+" operator b'cause getStorageCapacity gives negative 
    }
  
    public long getUsedMemory() throws Exception {
       return   (long) qf.getUsedStrgSize(UserLogin.email);
    }

    
    public static void main(String[] args) throws Exception {
        Cloud1Info c = new Cloud1Info();
       
        System.out.println("Capacity=" + c.getStorageCapacity()  + "  UsedMemory=" +c.getUsedMemory()+" free memory "+c.getFreeMemory());

    }

    public long getStorageCapacity() {
        return StorageCapacity;
    }
}
