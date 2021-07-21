package bai_tap_lam_them.bai_lam_them_1.controllers;

import bai_tap_lam_them.bai_lam_them_1.commons.FileUtils;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class ManufactureController {
    public static String chooseManufacture(){
        FileUtils.setPath("manufacture");
        TreeMap<Integer,String> map = new TreeMap<>();
        int i=1;
        for(String m : FileUtils.readFile() ){
            map.put(i++,m);
        }
        Set<Integer> setKey = map.keySet();
        do{
            System.out.println("\n---List manufacture---");
            for(int key : setKey){
                System.out.println(key+". "+map.get(key));
            }
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter choose: ");
            int choose = Integer.parseInt(scanner.nextLine());
            if(setKey.contains(choose)){
                return map.get(choose).split(",")[1];
            }
        }
       while (true);
    }
}
