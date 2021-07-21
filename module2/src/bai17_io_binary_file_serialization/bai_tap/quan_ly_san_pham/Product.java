package bai17_io_binary_file_serialization.bai_tap.quan_ly_san_pham;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String name;
    private String manufacturer;
    private int price;
    public Product(){

    }
    public Product(int id, String name, String manufacturer, int price) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                '}';
    }
}
