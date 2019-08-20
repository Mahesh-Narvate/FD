/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CostCalculation;

import cloudinfo.Cloud1Info;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import socketprogrammingNN.*;

/**
 *
 * @author pc2
 */
public class CoefficientBasedDataReallocation {

    NodeSender ns = new NodeSender();
    boolean Has_transferring = true;
    public int X = 0;

    public void dataRallocation(String msg) {
        String[] data = msg.split("#");
        String mail=data[1];
        String Fname = data[2];
        String FLength = data[3];
        String Fdata = data[4];
        System.out.println("CBDR :: "+Fdata);
        long Dsize = Long.parseLong(FLength);

        File ff = new File(Fname);

        try {
         

            
            
            // sort list of datacenter According to their unit price
            HashMap<String, Double> temp = sortHashMapByValue(DominantSet.TStorageCostList);

            for (Map.Entry<String, Double> entry : temp.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }

            int cnt = 0;

            // select 2  datacenter's     
            HashMap<String, Double> SelecteddcList = new HashMap<String, Double>();
           

            //find datacenter which has hightest capacity
            
            // sending data to cloud
            
            for (Map.Entry<String, Double> entry : SelecteddcList.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
                if (entry.getValue() > Dsize) {
                        //set has_transfetting=false
                        Has_transferring = false;
                    System.out.println(" CBDRA :: msg="+msg);
                   // ns.setNewMsg(msg);
//                     NodeReceiver nr = new NodeReceiver();
//                     nr.start();
                 // ns.senddata(entry.getKey(), ns.getNewMsg());
                  X = 1;
                }

            }
            
            

        } catch (Exception e) {
            e.printStackTrace();
        }
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

}
