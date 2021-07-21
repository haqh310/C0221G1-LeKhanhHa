package bai17_io_binary_file_serialization.bai_tap.quan_ly_san_pham;

import bai17_io_binary_file_serialization.bai_tap.quan_ly_san_pham.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManagement {
    static String path = "src\\bai17_io_binary_file_serialization\\bai_tap\\quan_ly_san_pham\\source.dat";
    static File f = new File(path);


    public static List<Product> read() {
        List<Product> products = new ArrayList<>();
        try {
            FileInputStream fis =new FileInputStream(f);
            ObjectInputStream input = new ObjectInputStream(fis);
            products = (List<Product>) input.readObject();
            input.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return products;
    }

    public static boolean hasObject() {
        FileInputStream fi =null;
        boolean check = true;
        try {
            fi = new FileInputStream(f);
            ObjectInputStream input = new ObjectInputStream(fi);
            if (input.readObject() == null) {
                check = false;
            }
            input.close();
        } catch (FileNotFoundException e) {
            check = false;
        } catch (IOException e) {
            check = false;
        } catch (ClassNotFoundException e) {
            check = false;
            e.printStackTrace();
        }
        return check;
    }

//    public static void write(Product product) {
//        try {
//
//            FileOutputStream fo;
//            ObjectOutputStream output = null;
//
//            if (!f.exists()) {
//                fo = new FileOutputStream(f);
//                output = new ObjectOutputStream(fo);
//            } else {
//                if (!hasObject()) {
//                    fo = new FileOutputStream(f,true);
//                    output = new ObjectOutputStream(fo);
//                } else {
//
//                    fo = new FileOutputStream(f, true);
//
//                    output = new ObjectOutputStream(fo) {
//                        protected void writeStreamHeader() throws IOException {
//                            reset();
//                        }
//                    };
//                }
//            }
//
//            output.writeObject(product);
//            output.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    public static void write(List<Product> products) {
        try {
            FileOutputStream fos =new FileOutputStream(f,true);
            ObjectOutputStream output = new ObjectOutputStream(fos);
            output.writeObject(products);
            output.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void search(String name) {
        for (Product product : read()) {
            if (product.getName().equals(name)) {
                System.out.println(product);
                return;
            }
        }
        System.out.println("Not is a Product name: " + name);
    }

    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        list.add(new Product(5,"A","B",25));
        list.add(new Product(6,"C","B",30));
        write(list);
       search("A");
    }
}
