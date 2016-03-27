package net.agusharyanto.productcatalog;

/**
 * Created by agus on 3/27/16.
 * agus.superwriter@gmail.com
 * http://agusharyanto.net
 */

public class Product {
    private String id="";
    private String name="";
    private String image="";
    private String price="";

    public Product(String id, String name, String image, String price) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
    }

    private Product() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
