/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author pc2
 */
public class AscendingOrder {

    public static double[] getSortedElement(Double d1, double d2, double d3) {
        double[] dd = {d1, d2, d3};
        double temp = 0.0;
        for(int j=0;j<dd.length;j++){
        for (int i = 0; i < dd.length - 1; i++) {
            if (dd[i] > dd[i + 1]) {
                temp = dd[i];
                dd[i] = dd[i + 1];
                dd[i + 1] = temp;
            }
        }
        }
        return dd;
    }
    public static HashMap<String, Double> sortHashMapByValue(HashMap<String, Double> hm) {
        // Create a list from elements of HashMap 
        List<Map.Entry<String, Double>> list
                = new LinkedList<Map.Entry<String, Double>>(hm.entrySet());

        // Sort the list 
        Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
            @Override
            public int compare(Map.Entry<String, Double> o1,
                    Map.Entry<String, Double> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap  
        HashMap<String, Double> temp = new LinkedHashMap<String, Double>();
        for (Map.Entry<String, Double> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    
    public static void main(String[] args) {
        double d[]=AscendingOrder.getSortedElement(10.1, 5.0, 1.0);
       for (int i = 0; i < d.length; i++) {
              System.out.println(""+d[i]);  
            }
        
        
    }
        
}
