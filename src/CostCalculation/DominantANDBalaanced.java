/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CostCalculation;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author lucky
 */
public class DominantANDBalaanced {
      
      
////  dominat and bance set
   public static ArrayList<Double> StorageDominant=new ArrayList<Double>();
   public static  ArrayList<Double> GetDominant=new ArrayList<Double>();
   public static  ArrayList<Double> PutDominant=new ArrayList<Double>();
   public static  ArrayList<Double> BalancedSet=new ArrayList<Double>();

   
    public static void main(String[] args) {
        
        DominantANDBalaanced db=new DominantANDBalaanced();


           double i2=10/3;
           System.out.println("i2="+i2);
          System.out.println(""+new DecimalFormat("##.####").format(i2));
    }
 
}
