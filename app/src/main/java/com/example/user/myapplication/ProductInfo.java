package com.example.user.myapplication;

/**
 * Created by Bertrand on 08-01-18.
 */

public class ProductInfo {

    private int id;
    private String title;
    private String shortdesc;
    //  private double rating;
    //  private double price;
    private int image;

    public ProductInfo(int id, String title, int image, String shortdesc) {
        this.id = id;
        this.title = title;
        this.shortdesc = shortdesc;
        // this.rating = rating;
        //  this.price = price;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

     public String getShortdesc() {
         return shortdesc;
     }

     /*public double getRating() {
         return rating;
     }

     public double getPrice() {
         return price;
     }
 */
    public int getImage() {
        return image;
    }
}
