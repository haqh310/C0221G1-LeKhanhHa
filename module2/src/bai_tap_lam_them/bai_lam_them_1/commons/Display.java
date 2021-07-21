package bai_tap_lam_them.bai_lam_them_1.commons;

public class Display {
    public static void displayCar(){
        for(String s : FileUtils.readFile()){
            boolean check = s.split(",").length == 6;
            if(check ){
                System.out.println(s);
            }
        }
    }
    public static void displayTruck(){
        for(String s : FileUtils.readFile()){
            String[] arrStr = s.split(",");
            String regex = "^[0-9]{2}C-[0-9]{3}.[0-9]{2}$";
            if(arrStr.length == 5 && arrStr[0].matches(regex) ){
                System.out.println(s);
            }
        }
    }
    public static void displayMotorcycle(){
        for(String s : FileUtils.readFile()){
            String[] arrStr = s.split(",");
            String regex = "^[0-9]{2}-[A-Z][A-Z0-9]-[0-9]{3}.[0-9]{2}$";
            if(arrStr.length == 5 && arrStr[0].matches(regex) ){
                System.out.println(s);
            }
        }
    }
}
