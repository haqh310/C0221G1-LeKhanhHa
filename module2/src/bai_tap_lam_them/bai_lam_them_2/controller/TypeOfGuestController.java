package bai_tap_lam_them.bai_lam_them_2.controller;

import bai_tap_lam_them.bai_lam_them_2.commons.FileUtils;

import java.util.List;
import java.util.Scanner;

public class TypeOfGuestController {
    static Scanner scanner = new Scanner(System.in);
    static final String FIlE_TYPE_GUEST = "type_guest.csv";
    static List<String>  typeList = FileUtils.readFile(FIlE_TYPE_GUEST);
    public static String chooseType(){
        String type=null;
        int choice;
       do{
           try {
               System.out.println("---List type of guest---");
               for(String typeStr: typeList){
                   System.out.println(typeList.indexOf(typeStr)+1+". "+ typeStr);
               }
               System.out.print("Enter choice type of guest(1-"+typeList.size()+"): ");
               choice = Integer.parseInt(scanner.nextLine());
               if(choice>0 && choice <=typeList.size()){
                   return typeList.get(choice-1).split(",")[1];
               }
           }catch (Exception e){
               e.printStackTrace();
           }
           System.out.println("You input error!!!");
       }while (true);
    }
}
