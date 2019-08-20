package Table;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author com
 */
public class TableCreater {
    
    public DefaultTableModel GetTableModel(String fileData) {
        ArrayList<String[]> cache = new ArrayList<>();
        String[] allData = fileData.split("\n");
        for (String line : allData) {
            String[] values = line.trim().split(",");
            
            cache.add(values);
        }
        
        int size = 7;
        String[][] hList = new String[size][];
        String[] headers = new String[size];
        String[][] data = new String[cache.size()][];
        try {
            
            for (int i = 0; i < cache.size(); i++) {
                
                if (i == 0) {
                    for (String s : cache.get(i)) {
//                System.out.println("\nCACHE_________"+s);
                    }
                    hList[i] = cache.remove(i);
//            System.out.println("HLIST**********"+hList.toString());
                    for (int j = 0; j < hList.length; j++) {
                        headers[j] = hList[0][j];
//                System.out.println("HEADERS**********"+headers[j]);
                    }
                }
                data[i] = cache.get(i);
            }
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Data is not available of this user on cloud");
        }
        DefaultTableModel tableModel = new DefaultTableModel(data, headers) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;//This causes all cells to be not editable
            }
        };
        return tableModel;
    }

    public DefaultTableModel GetTableModel1(String fileData) {
        int tmp = 0;
        int size1 = 0;
        ArrayList<String[]> cache = new ArrayList<>();
        String[] allData = fileData.split("\n");
        
        for (String lin1 : allData) {
            if (tmp == 0) {
                String[] val = lin1.trim().split("\\|");
                size1 = val.length;
                tmp++;
            } else {
                break;
            }
        }
        
        for (String line : allData) {
//            System.out.println("*****************************Line::"+line);
            String[] values = line.trim().split("\\|");
//            for(String st:values)
//            {
//                System.out.println("sttttttttt==="+st);
//            }
            cache.add(values);
        }

//        int size=AllDataExcelReader.colsize;
        String[][] hList = new String[size1][];
        String[] headers = new String[size1];
        String[][] data = new String[cache.size()][];
        
        for (int i = 0; i < cache.size(); i++) {
            
            if (i == 0) {
                for (String s : cache.get(i)) {
//                System.out.println("\nCACHE_________"+s);
                }
                hList[i] = cache.remove(i);
//            System.out.println("HLIST**********"+hList.toString());
                for (int j = 0; j < hList.length; j++) {
                    headers[j] = hList[0][j];
                    System.out.println("HEADERS**********" + headers[j]);
                }
            }
            data[i] = cache.get(i);
        }
        DefaultTableModel tableModel = new DefaultTableModel(data, headers) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;//This causes all cells to be not editable
            }
        };
        return tableModel;
    }
}
