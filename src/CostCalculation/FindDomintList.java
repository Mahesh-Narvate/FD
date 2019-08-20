/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CostCalculation;

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
public class FindDomintList {
    
    AWS1 aa = new AWS1();
    GCS1 gg = new GCS1();
    MicroAzur1 mm = new MicroAzur1();
    
   HashMap<String,Double> TStorageCostList=new HashMap<String,Double>();
   HashMap<String,Double> TGetCostList=new HashMap<String,Double>();
   HashMap<String,Double> TPutCostList=new HashMap<String,Double>();
    
    public List getDominant(List list)
    {
     
        return list;
    }
    
    public void addElement(){
        
        TStorageCostList.put("AStorageCost",aa.StorageUnitPrice);
        TStorageCostList.put("GStorageCost",gg.StorageUnitPrice);
        TStorageCostList.put("MStorageCost",mm.StorageUnitPrice);
        
        TGetCostList.put("AGetCost",aa.GetUnitPrice);
        TGetCostList.put("GetCost",gg.GetUnitPrice);
        TGetCostList.put("MGetCost",mm.GetUnitPrice);
         
        TPutCostList.put("APutCost",aa.PutUnitPrice);
        TPutCostList.put("GPutCost",gg.PutUnitPrice);
        TPutCostList.put("MPutCost",mm.PutUnitPrice);
    }
    
     // sort hashMap by value
    public static HashMap<String ,Double> sortHashMapByValue(HashMap<String, Double> hm) {
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
    
    public double getMinGetUnitPrice(HashMap map){
        Double GUP=0.0;
        GUP=(Double) Collections.min(map.values());
        return GUP;
    }
    
    public double getMinPutUnitPrice(HashMap map){
        Double PUP=0.0;
        PUP=(Double) Collections.min(map.values());
        return PUP;
    }
    public double getMinStorageUnitPrice(HashMap map){
        Double SUP=0.0;
        SUP=(Double) Collections.min(map.values());
        return SUP;
    }
    
}
