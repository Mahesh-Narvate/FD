/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CostCalculation;

import Database.QueryFunction;
import GUI.UserDashBord;
import static GUI.UserDashBord.CompressedLength;
import static GUI.UserDashBord.WithoutCompressedLength;
import static GUI.UserDashBord.click_to_upload;
import GUI.UserLogin;
import cloudinfo.Cloud1Info;

import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author lucky
 */
public class DominantSet {

// public  int DataSize= Foldersize;
    public static double DataSize;
    public static double GetRequest;
    public static double PutRequest;
    public static HashMap<String, Double> TotalCostOFclouds = new HashMap<String, Double>();
    QueryFunction qf = new QueryFunction();
    public String Email = UserLogin.email;
    Cloud1Info c1 = new Cloud1Info();
    SloRequirments slo = new SloRequirments();

    ArrayList<Double> StorageCostList = new ArrayList<>();
    ArrayList<Double> GetCostList = new ArrayList<>();
    ArrayList<Double> PutCostList = new ArrayList<>();
//    
    public static HashMap<String, Double> TStorageCostList = new HashMap<String, Double>();
    public static HashMap<String, Double> TGetCostList = new HashMap<String, Double>();
    public static HashMap<String, Double> TPutCostList = new HashMap<String, Double>();

    public DominantSet() {
    }

    public DominantSet(double DataSize, double GetRequest, double PutRequest) {
        this.DataSize = DataSize;
        this.GetRequest = GetRequest;
        this.PutRequest = PutRequest;

    }

    public DominantSet(String DataSize, String GetRequest, String PutRequest) {
        this.DataSize = Storageconverter.getConvertedStorage(DataSize);
        this.GetRequest = Storageconverter.getConverterGet(GetRequest);
        this.PutRequest = Storageconverter.getConverterPut(PutRequest);

    }

    public void addelement() {

        StorageCostList.add(AWS1.StorageUnitPrice);
        StorageCostList.add(GCS1.StorageUnitPrice);
        StorageCostList.add(MicroAzur1.StorageUnitPrice);

        TStorageCostList.put("aws", AWS1.StorageUnitPrice);
        TStorageCostList.put("gcs", GCS1.StorageUnitPrice);
        TStorageCostList.put("azur", MicroAzur1.StorageUnitPrice);

        GetCostList.add(AWS1.GetUnitPrice);
        GetCostList.add(GCS1.GetUnitPrice);
        GetCostList.add(MicroAzur1.GetUnitPrice);

        TGetCostList.put("aws", AWS1.GetUnitPrice);
        TGetCostList.put("gcs", GCS1.GetUnitPrice);
        TGetCostList.put("azur", MicroAzur1.GetUnitPrice);

        PutCostList.add(AWS1.PutUnitPrice);
        PutCostList.add(GCS1.PutUnitPrice);
        PutCostList.add(MicroAzur1.PutUnitPrice);

        TPutCostList.put("aws", AWS1.PutUnitPrice);
        TPutCostList.put("gcs", GCS1.PutUnitPrice);
        TPutCostList.put("azur", MicroAzur1.PutUnitPrice);

    }
//  /// function to sort arraylists  

    public void sort() {
        // ArrayList<Double>Ssort=new ArrayList<>();
        Collections.sort(StorageCostList);
        Collections.sort(GetCostList);
        Collections.sort(PutCostList);

        ///  sort list according to storage Cost
        HashMap<String, Double> Stotemp = sortHashMapByValue(TStorageCostList);

        System.out.println("stotemp size= " + Stotemp.size());
        System.out.println(" storage sorted lists");
        System.out.println("------------");
        for (Map.Entry<String, Double> entry : Stotemp.entrySet()) {

            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("------------");
        ///  sort list according to get Cost
        HashMap<String, Double> TGtemp = sortHashMapByValue(TGetCostList);
        System.out.println(" Get sorted lists");
        for (Map.Entry<String, Double> entry : TGtemp.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("------------");
        ///  sort list according to put Cost
        HashMap<String, Double> TPtotemp = sortHashMapByValue(TPutCostList);
        System.out.println(" put sorted lists");
        for (Map.Entry<String, Double> entry : TPtotemp.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("------------");
    }

    // sort hashMap by value
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

    public void display() {

        Iterator itr = StorageCostList.iterator();
        while (itr.hasNext()) {
            System.out.println("Storage_Cost(/GB)=" + itr.next());
        }
        System.out.println("   ");

        Iterator itr1 = GetCostList.iterator();
        while (itr1.hasNext()) {
            System.out.println("gateCost(/10000)=" + itr1.next());
        }
        System.out.println("   ");

        Iterator itr2 = PutCostList.iterator();
        while (itr2.hasNext()) {
            System.out.println("PutCost(/1000)=" + itr2.next());
        }

        // Now let's sort HashMap by keys first 
        // all you need to do is create a TreeMap with mappings of HashMap
    }

    ///functions to get  dominant cost for Storage /Get/Put from array list
    public double minStorage() {
        Double Strgmin = 0.0;

        Strgmin = Collections.min(StorageCostList);
        System.out.println("minStorage=" + Strgmin);
        return Strgmin;
    }

    public double minGet() {
        Double Getmin = 0.0;

        Getmin = Collections.min(GetCostList);
        //System.out.println("minGet=" + Getmin);
        return Getmin;
    }

    public double minPut() {
        Double Putmin = 0.0;

        Putmin = Collections.min(PutCostList);
        //System.out.println("minPut=" + Putmin);
        return Putmin;
    }

    ///functions to get  dominant cost for Storage /Get/Put from array list
    public double maxStorage() {
        double Strgmax;

        Strgmax = Collections.max(StorageCostList);
        //   System.out.println("maxStorage=" + Strgmax);
        return Strgmax;
    }

    public double maxGet() {
        double Getmax;

        Getmax = Collections.max(GetCostList);
        //System.out.println("maxGet=" + Getmax);
        return Getmax;
    }

    public double maxPut() {
        double Putmax;

        Putmax = Collections.max(PutCostList);
        // System.out.println("maxPut=" + Putmax);
        return Putmax;
    }

    /// functions for calculating maximum Data Storage/Get?put Cost 
    public double maxStorageCostForData() {

        double MxStrgCstFDta = 0.0;

        MxStrgCstFDta = maxStorage() * DataSize;
        //System.out.println("MxStrgCstFDta===" + MxStrgCstFDta);
        return MxStrgCstFDta;
    }

    public double maxGetCostForData() {

        double MxGetCstFDta = 0.0;

        MxGetCstFDta = maxGet() * GetRequest;
        //System.out.println("max get===" + MxGetCstFDta);
        return MxGetCstFDta;
    }

    public double maxPutCostForData() {

        double MxPutCstFDta = 0.0;

        MxPutCstFDta = maxPut() * PutRequest;
        // System.out.println("MxPutCstFDta===" + MxPutCstFDta);

        return MxPutCstFDta;
    }

    ///
    /// functions for calculating maximum Data Storage/Get?put Cost 
    public double minStorageCostForData() {

        double MnStrgCstFDta = 0.0;

        MnStrgCstFDta = minStorage() * DataSize;
        //  System.out.println("MnStrgCstFDta===" + MnStrgCstFDta);

        return MnStrgCstFDta;
    }

    public double minGetCostForData() {

        double MnGetCstFDta = 0.0;

        MnGetCstFDta = minGet() * GetRequest;
        // System.out.println("MnGetCstFDta===" + MnGetCstFDta);

        return MnGetCstFDta;
    }

    public double minPutCostForData() {

        double MnPutCstFDta = 0.0;

        MnPutCstFDta = minPut() * PutRequest;
        //  System.out.println("MnPutCstFDta===" + MnPutCstFDta);

        return MnPutCstFDta;
    }

    //// function to calculate Dominant cost  and classify data
    public double DomiBalset(double StorageSize, double GetRequest, double PutRequest) throws Exception {
        double H = 100.0;
        double DominantCost = 0.0;
        System.out.println("minStorageCostForData=" + minStorageCostForData() + " maxGetCostForData=" + maxGetCostForData() + " maxPutCostForData=" + maxPutCostForData());
        System.out.println("minGetCostForData=" + minGetCostForData() + " maxPutCostForData=" + maxPutCostForData() + " maxStorageCostForData=" + maxStorageCostForData());
        System.out.println("minPutCostForData=" + minPutCostForData() + " maxStorageCostForData=" + maxStorageCostForData() + " maxGetCostForData=" + maxGetCostForData());

        if (minStorageCostForData() > (maxGetCostForData() + maxPutCostForData())) {

            JOptionPane.showMessageDialog(null, "Storage Dominant");

            qf.updateDominantData("StogageDominant", Email);
            System.out.println("value added in StorageDominant set");
            HashMap<String, Double> scost = sortHashMapByValue(TStorageCostList);
            int flag = 0;
            double ta = 0;
            for (Map.Entry<String, Double> entry : scost.entrySet()) {
                String key = entry.getKey();
                Double value = entry.getValue();
                if (key.contains("aws")) {
                    AWS1 aa = new AWS1(StorageSize, GetRequest, PutRequest);
                    if (flag == 0) {

                        TotalCostOFclouds.put("aws", aa.TawsCost() * qf.getDiscount(Email));
                        //               TotalCostOFclouds.put("aws", aa.TawsCost());

                    } else {

                        TotalCostOFclouds.put("aws", aa.TawsCost());
                    }
                }

                if (key.contains("azur")) {
                    MicroAzur1 mm = new MicroAzur1(StorageSize, GetRequest, PutRequest);

                    if (flag == 0) {

                        TotalCostOFclouds.put("azur", mm.TCost() * qf.getDiscount(Email));
                        //      TotalCostOFclouds.put("azur", mm.TCost());

                    } else {

                        TotalCostOFclouds.put("azur", mm.TCost());
                    }
                }

                if (key.contains("gcs")) {
                    GCS1 gg = new GCS1(StorageSize, GetRequest, PutRequest);
                    if (flag == 0) {

                        TotalCostOFclouds.put("gcs", gg.TawsCost() * qf.getDiscount(Email));
                        // TotalCostOFclouds.put("gcs", gg.TawsCost());

                    } else {

                        TotalCostOFclouds.put("gcs", gg.TawsCost());

                    }
                }

                flag++;
            }

        } else if (minGetCostForData() > (maxStorageCostForData() + maxPutCostForData())) {

            HashMap<String, Double> scost = sortHashMapByValue(TStorageCostList);

            qf.updateDominantData("GetDominant", Email);
            int flag = 0;
            double ta = 0;
            for (Map.Entry<String, Double> entry : scost.entrySet()) {
                String key = entry.getKey();
                Double value = entry.getValue();
                if (key.contains("aws")) {

                    AWS1 aa = new AWS1(StorageSize, GetRequest, PutRequest);
                    if (flag == 0) {

                        TotalCostOFclouds.put("aws", aa.TawsCost() * qf.getDiscount(Email));
//                        TotalCostOFclouds.put("aws", aa.TawsCost());

                    } else {

                        TotalCostOFclouds.put("aws", aa.TawsCost());
                    }
                }

                if (key.contains("azur")) {

                    MicroAzur1 mm = new MicroAzur1(StorageSize, GetRequest, PutRequest);

                    if (flag == 0) {

                        TotalCostOFclouds.put("azur", mm.TCost() * qf.getDiscount(Email));
//                        TotalCostOFclouds.put("azur", mm.TCost());

                    } else {

                        TotalCostOFclouds.put("azur", mm.TCost());
                    }
                }

                if (key.contains("gcs")) {

                    GCS1 gg = new GCS1(StorageSize, GetRequest, PutRequest);

                    if (flag == 0) {

                        TotalCostOFclouds.put("gcs", gg.TawsCost() * qf.getDiscount(Email));
                        //                    TotalCostOFclouds.put("gcs", gg.TawsCost());

                        System.out.println("total cost of gcs with discount = " + gg.TawsCost());
                    } else {

                        TotalCostOFclouds.put("gcs", gg.TawsCost());
                        System.out.println("total cost of gcs without discount " + gg.TawsCost());

                    }
                }

                flag++;
            }
            JOptionPane.showMessageDialog(null, "Get Dominant");
            System.out.println("value added in GetDominant set");

        } else if (minPutCostForData() > (maxStorageCostForData() + maxGetCostForData())) {

            HashMap<String, Double> scost = sortHashMapByValue(TStorageCostList);

            qf.updateDominantData("PutDominant", Email);
            int flag = 0;
            double ta = 0;
            for (Map.Entry<String, Double> entry : scost.entrySet()) {
                String key = entry.getKey();
                Double value = entry.getValue();
                if (key.contains("aws")) {
                    AWS1 aa = new AWS1(StorageSize, GetRequest, PutRequest);
                    if (flag == 0) {

                        TotalCostOFclouds.put("aws", aa.TawsCost() * qf.getDiscount(Email));
                        //        TotalCostOFclouds.put("aws", aa.TawsCost());

                    } else {

                        TotalCostOFclouds.put("aws", aa.TawsCost());
                    }
                }

                if (key.contains("azur")) {
                    MicroAzur1 mm = new MicroAzur1(StorageSize, GetRequest, PutRequest);

                    if (flag == 0) {

                        TotalCostOFclouds.put("azur", mm.TCost() * qf.getDiscount(Email));
                        //     TotalCostOFclouds.put("azur", mm.TCost());

                    } else {

                        TotalCostOFclouds.put("azur", mm.TCost());
                    }
                }

                if (key.contains("gcs")) {
                    GCS1 gg = new GCS1(StorageSize, GetRequest, PutRequest);
                    if (flag == 0) {

                        TotalCostOFclouds.put("gcs", gg.TawsCost() * qf.getDiscount(Email));
                        //  TotalCostOFclouds.put("gcs", gg.TawsCost());

                    } else {

                        TotalCostOFclouds.put("gcs", gg.TawsCost());

                    }
                }

                flag++;
            }
            JOptionPane.showMessageDialog(null, "Put Dominant");
            System.out.println("value added in PutDominant set");

        } else {
            HashMap<String, Double> scost = sortHashMapByValue(TStorageCostList);

            qf.updateDominantData("Balanced Set", Email);
            int flag = 0;
            double ta = 0;
            for (Map.Entry<String, Double> entry : scost.entrySet()) {
                String key = entry.getKey();
                Double value = entry.getValue();
                if (key.contains("aws")) {
                    AWS1 aa = new AWS1(StorageSize, GetRequest, PutRequest);
                    if (flag == 0) {

                        //      TotalCostOFclouds.put("aws", aa.TawsCost() * qf.getDiscount(Email));
                        TotalCostOFclouds.put("aws", aa.TawsCost());

                    } else {

                        TotalCostOFclouds.put("aws", aa.TawsCost());

                    }
                }

                if (key.contains("azur")) {
                    MicroAzur1 mm = new MicroAzur1(StorageSize, GetRequest, PutRequest);

                    if (flag == 0) {
                        System.out.println("");

                        System.out.println("totalCost=" + mm.TCost() + " Discount=" + qf.getDiscount(Email));
                        //     TotalCostOFclouds.put("azur", mm.TCost() * qf.getDiscount(Email));
                        TotalCostOFclouds.put("azur", mm.TCost());

                    } else {

                        TotalCostOFclouds.put("azur", mm.TCost());
                    }
                }

                if (key.contains("gcs")) {
                    GCS1 gg = new GCS1(StorageSize, GetRequest, PutRequest);
                    if (flag == 0) {

                        //       System.out.println("totalCost=" + gg.TawsCost() + " Discount=" + qf.getDiscount(Email));
                        //     TotalCostOFclouds.put("gcs", gg.TawsCost() * qf.getDiscount(Email));
                        TotalCostOFclouds.put("gcs", gg.TawsCost());

                    } else {

                        TotalCostOFclouds.put("gcs", gg.TawsCost());

                    }
                }

                flag++;
            }

            System.out.println("value added in Balanced set");
            JOptionPane.showMessageDialog(null, "Balanced Set");

        }

        return DominantCost;
    }

    public double DomiBalset() throws Exception {
        double H = 100.0;
        double DominantCost = 0.0;

        System.out.println("minStorageCostForData=" + minStorageCostForData() + " maxGetCostForData=" + maxGetCostForData() + " maxPutCostForData=" + maxPutCostForData());
        System.out.println("minGetCostForData=" + minGetCostForData() + " maxPutCostForData=" + maxPutCostForData() + " maxStorageCostForData=" + maxStorageCostForData());
        System.out.println("minPutCostForData=" + minPutCostForData() + " maxStorageCostForData=" + maxStorageCostForData() + " maxGetCostForData=" + maxGetCostForData());

        if (minStorageCostForData() > (maxGetCostForData() + maxPutCostForData())) {

            JOptionPane.showMessageDialog(null, "Storage Dominant");

            qf.updateDominantData("StogageDominant", Email);
            System.out.println("value added in StorageDominant set");
            HashMap<String, Double> scost = sortHashMapByValue(TStorageCostList);
            int flag = 0;
            double ta = 0;
            for (Map.Entry<String, Double> entry : scost.entrySet()) {
                String key = entry.getKey();
                Double value = entry.getValue();
                if (key.contains("aws")) {
                    AWS1 aa = new AWS1(DataSize, GetRequest, PutRequest);
                    if (flag == 0) {
                        System.out.println("discount value=" + qf.getDiscount(Email));
                        TotalCostOFclouds.put("aws", aa.TawsCost() * qf.getDiscount(Email));
                        //     TotalCostOFclouds.put("aws", aa.TawsCost());

                    } else {

                        TotalCostOFclouds.put("aws", aa.TawsCost());
                    }
                }

                if (key.contains("azur")) {
                    MicroAzur1 mm = new MicroAzur1(DataSize, GetRequest, PutRequest);

                    if (flag == 0) {

                        TotalCostOFclouds.put("azur", mm.TCost() * qf.getDiscount(Email));
                        //     TotalCostOFclouds.put("azur", mm.TCost());

                    } else {

                        TotalCostOFclouds.put("azur", mm.TCost());
                    }
                }

                if (key.contains("gcs")) {
                    GCS1 gg = new GCS1(DataSize, GetRequest, PutRequest);
                    if (flag == 0) {

                        TotalCostOFclouds.put("gcs", gg.TawsCost() * qf.getDiscount(Email));
                        //  TotalCostOFclouds.put("gcs", gg.TawsCost());

                    } else {

                        TotalCostOFclouds.put("gcs", gg.TawsCost());

                    }
                }

                flag++;
            }

        } else if (minGetCostForData() > (maxStorageCostForData() + maxPutCostForData())) {

            HashMap<String, Double> scost = sortHashMapByValue(TStorageCostList);

            qf.updateDominantData("GetDominant", Email);
            int flag = 0;
            double ta = 0;
            for (Map.Entry<String, Double> entry : scost.entrySet()) {
                String key = entry.getKey();
                Double value = entry.getValue();
                if (key.contains("aws")) {

                    AWS1 aa = new AWS1(DataSize, GetRequest, PutRequest);
                    if (flag == 0) {

                        TotalCostOFclouds.put("aws", aa.TawsCost() * qf.getDiscount(Email));
                        //    TotalCostOFclouds.put("aws", aa.TawsCost());

                    } else {

                        TotalCostOFclouds.put("aws", aa.TawsCost());
                    }
                }

                if (key.contains("azur")) {

                    MicroAzur1 mm = new MicroAzur1(DataSize, GetRequest, PutRequest);

                    if (flag == 0) {

                        TotalCostOFclouds.put("azur", mm.TCost() * qf.getDiscount(Email));
                        //    TotalCostOFclouds.put("azur", mm.TCost());

                    } else {

                        TotalCostOFclouds.put("azur", mm.TCost());
                    }
                }

                if (key.contains("gcs")) {

                    GCS1 gg = new GCS1(DataSize, GetRequest, PutRequest);

                    if (flag == 0) {

                        TotalCostOFclouds.put("gcs", gg.TawsCost() * qf.getDiscount(Email));
                        //    TotalCostOFclouds.put("gcs", gg.TawsCost());

                        System.out.println("total cost of gcs with discount = " + gg.TawsCost());
                    } else {

                        TotalCostOFclouds.put("gcs", gg.TawsCost());
                        System.out.println("total cost of gcs without discount " + gg.TawsCost());

                    }
                }

                flag++;
            }
            JOptionPane.showMessageDialog(null, "Get Dominant");
            System.out.println("value added in GetDominant set");
        } else if (minPutCostForData() > (maxStorageCostForData() + maxGetCostForData())) {

            HashMap<String, Double> scost = sortHashMapByValue(TStorageCostList);

            qf.updateDominantData("PutDominant", Email);
            int flag = 0;
            double ta = 0;
            for (Map.Entry<String, Double> entry : scost.entrySet()) {
                String key = entry.getKey();
                Double value = entry.getValue();
                if (key.contains("aws")) {
                    AWS1 aa = new AWS1(DataSize, GetRequest, PutRequest);
                    if (flag == 0) {

                        TotalCostOFclouds.put("aws", aa.TawsCost() * qf.getDiscount(Email));
                        //   TotalCostOFclouds.put("aws", aa.TawsCost());

                    } else {

                        TotalCostOFclouds.put("aws", aa.TawsCost());
                    }
                }

                if (key.contains("azur")) {
                    MicroAzur1 mm = new MicroAzur1(DataSize, GetRequest, PutRequest);

                    if (flag == 0) {

                        TotalCostOFclouds.put("azur", mm.TCost() * qf.getDiscount(Email));
                        //    TotalCostOFclouds.put("azur", mm.TCost());

                    } else {

                        TotalCostOFclouds.put("azur", mm.TCost());
                    }
                }

                if (key.contains("gcs")) {
                    GCS1 gg = new GCS1(DataSize, GetRequest, PutRequest);
                    if (flag == 0) {

                        TotalCostOFclouds.put("gcs", gg.TawsCost() * qf.getDiscount(Email));
                        // TotalCostOFclouds.put("gcs", gg.TawsCost());

                    } else {

                        TotalCostOFclouds.put("gcs", gg.TawsCost());

                    }
                }

                flag++;
            }
            JOptionPane.showMessageDialog(null, "Put Dominant");
            System.out.println("value added in PutDominant set");

        } else {
            HashMap<String, Double> scost = sortHashMapByValue(TStorageCostList);

            qf.updateDominantData("Balanced Set", Email);
            int flag = 0;
            double ta = 0;
            for (Map.Entry<String, Double> entry : scost.entrySet()) {
                String key = entry.getKey();
                Double value = entry.getValue();
                if (key.contains("aws")) {
                    AWS1 aa = new AWS1(DataSize, GetRequest, PutRequest);
                    if (flag == 0) {

//                        TotalCostOFclouds.put("aws", aa.TawsCost() * qf.getDiscount(Email));
                        TotalCostOFclouds.put("aws", aa.TawsCost());

                    } else {

                        TotalCostOFclouds.put("aws", aa.TawsCost());

                    }
                }

                if (key.contains("azur")) {
                    MicroAzur1 mm = new MicroAzur1(DataSize, GetRequest, PutRequest);

                    if (flag == 0) {
                        System.out.println("");

                        // System.out.println("totalCost=" + mm.TCost() + " Discount=" + qf.getDiscount(Email));
//                        TotalCostOFclouds.put("azur", mm.TCost() * qf.getDiscount(Email));
                        TotalCostOFclouds.put("azur", mm.TCost());

                    } else {

                        TotalCostOFclouds.put("azur", mm.TCost());
                    }
                }

                if (key.contains("gcs")) {
                    GCS1 gg = new GCS1(DataSize, GetRequest, PutRequest);
                    if (flag == 0) {

                        System.out.println("totalCost=" + gg.TawsCost() + " Discount=" + qf.getDiscount(Email));
//                        TotalCostOFclouds.put("gcs", gg.TawsCost() * qf.getDiscount(Email));
                        TotalCostOFclouds.put("gcs", gg.TawsCost());

                    } else {

                        TotalCostOFclouds.put("gcs", gg.TawsCost());

                    }
                }

                flag++;
            }

            System.out.println("value added in Balanced set");
            JOptionPane.showMessageDialog(null, "Balanced Set");

        }

        return DominantCost;
    }

    ////// function to check slo
    public boolean checkSlo(double UpStorageSize, String email) throws Exception {

        boolean b = false;
        int cnt = 0;
        Cloud1Info c1 = new Cloud1Info();
        SloRequirments slo = new SloRequirments();

        if (c1.GLatency <= slo.GPprecentage_of_latency && c1.getPLatency() <= slo.GPprecentage_of_latency) {

            cnt++;
            System.out.println(" cnt=" + cnt);
        }

        if (c1.getGD() <= SloRequirments.GetDeadline && c1.getPDH() <= SloRequirments.PutDeadlineH) {
            cnt++;
            System.out.println(" cnt=" + cnt);
        }
        System.out.println(" UsedMemory " + UpStorageSize + " StorageCapacity  " + Storageconverter.getConvertedStorage(qf.getUserExpectedStorage(email))+" email :: "+email);
        try{
        System.out.println("Storageconverter.getByteToGBConversion(CompressedLength)  "+Storageconverter.getByteToGBConversion(CompressedLength));
        System.out.println(" converted WithoutCompressedLength "+Storageconverter.getByteToGBConversion(WithoutCompressedLength));
        }catch(NullPointerException e){System.out.println("Clicked on without compression option..");}
        
        if (UpStorageSize < Storageconverter.getConvertedStorage(qf.getUserExpectedStorage(email))) {
            if (click_to_upload) {
                if (Storageconverter.getByteToGBConversion(CompressedLength) < Storageconverter.getConvertedStorage(qf.getUserExpectedStorage(email))) {
                    cnt++;
                }
            } else {
                if (Storageconverter.getByteToGBConversion(WithoutCompressedLength) < Storageconverter.getConvertedStorage(qf.getUserExpectedStorage(email))) {
                    cnt++;
                }
            }

            System.out.println(" cnt=" + cnt);
        }

        if (cnt > 2) {
            System.out.println("Final cnt=" + cnt);

            b = true;
            JOptionPane.showMessageDialog(null, "Slo Requirments are Satisfied");

        } else {
            JOptionPane.showMessageDialog(null, "Slo Requirments are not Satisfied");
            JOptionPane.showMessageDialog(null, "There is not enough space on cloud You need to increase Storage size of Cloud.....!");
        }

        return b;
    }

    public boolean checkSlo() throws Exception {
        boolean b = false;
        int cnt = 0;
        System.out.println(" in slo check method....!");
        System.out.println("c1.GLatency:::" + c1.GLatency + " slo.GPprecentage_of_latency::: " + slo.GPprecentage_of_latency);
        if (c1.GLatency <= slo.GPprecentage_of_latency && c1.getPLatency() <= slo.GPprecentage_of_latency) {

            cnt++;
            System.out.println(" cnt=" + cnt);
        }

        if (c1.getGD() <= SloRequirments.GetDeadline && c1.getPDH() <= SloRequirments.PutDeadlineH) {
            cnt++;
            System.out.println(" cnt=" + cnt);
        }
        System.out.println(" UsedMemory() " + c1.getUsedMemory() + " free memory " + c1.getFreeMemory() + " StorageCapacity" + c1.getStorageCapacity());
        if (c1.getUsedMemory() < c1.getFreeMemory()) {

            cnt++;
            System.out.println(" cnt=" + cnt);
        }
        if (cnt > 2) {
            // System.out.println("njghgh cnt=" + cnt);

            b = true;
            JOptionPane.showMessageDialog(null, "Slo Requirments are Satisfied");

        }

        return b;
    }

}
