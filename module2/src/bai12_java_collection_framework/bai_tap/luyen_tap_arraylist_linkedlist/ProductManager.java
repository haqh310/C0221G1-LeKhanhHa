package bai12_java_collection_framework.bai_tap.luyen_tap_arraylist_linkedlist;

import java.io.InputStream;
import java.util.*;

public class ProductManager {
    public static List<Product> products = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void add() {
        System.out.print("Enter id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter price: ");
        int price = Integer.parseInt(scanner.nextLine());
        products.add(new Product(id, name, price));
    }

    public static void edit(int id) {
        for (Product p : products) {
            if (p.getId() == id) {
                System.out.print("Enter new  name: ");
                String name = scanner.nextLine();
                System.out.print("Enter new price: ");
                int price = Integer.parseInt(scanner.nextLine());
                p.setName(name);
                p.setPrice(price);
                return;
            }
        }
        System.out.println("Not id in List Product");
    }

    public static Product remove(int id) {
        for (Product p : products) {
            if (p.getId() == id) {
                products.remove(p);
                return p;
            }
        }
        return null;
    }

    public static void display() {
        System.out.println("Element of Array: ");
        for (Product p : products) {
            System.out.println(p);
        }
    }

    public static void search(String name){
        for (Product p : products) {
           if(p.getName().equals(name)){
               System.out.println(p);
               return;
           }
        }
    }

    public static void sort() {
        Comparator<Product> comparator = new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getPrice() - o2.getPrice();
            }
        };
        products.sort(comparator);
        //products.sort(Comparator.comparing(Product::getName).thenComparing());
    }

    public static void main(String[] args) {
        int number = 0;
        int id;
        String name;
        do {
            System.out.println("1.\tAdd Product.\n" +
                    "2.\tEdit Product By Id.\n" +
                    "3.\tRemove Product\n" +
                    "4.\tDisplay List Product\n" +
                    "5.\tSearch Product By Name\n" +
                    "6.\tSort product\n" +
                    "7.\tExit\n");
            System.out.print("Enter a number: ");
            number = Integer.parseInt(scanner.nextLine());
            switch (number) {
                case 1:
                    add();
                    break;
                case 2:
                    System.out.print("Enter id need find: ");
                    id = Integer.parseInt(scanner.nextLine());
                    edit(id);
                    break;
                case 3:
                    System.out.print("Enter id need remove: ");
                    id = Integer.parseInt(scanner.nextLine());
                    remove(id);
                    break;
                case 4:
                    display();
                    break;
                case 5:
                    System.out.print("Enter name need search: ");
                    name = scanner.nextLine();
                    search(name);
                    break;
                case 6:
                    sort();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("You input error!!!");

            }
        }
        while (number != 7);
    }
}
