package com.example.user.myapplication;

/**
 * Created by Bertrand on 08-01-18.
 */

public class Product {

    private int id;
    private String title;
  //  Private String shortdesc;
//    private double rating;
  //  private double price;
    private int image;

    public Product(int id, String title, int image) {
        this.id = id;
        this.title = title;
       // this.shortdesc = shortdesc;
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

   /* public String getShortdesc() {
        return shortdesc;
    }

    public double getRating() {
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
