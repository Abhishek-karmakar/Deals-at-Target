package com.abhishek.TargetDeals.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by akarmakar.
 *
 * _id	"548917fabeb9b0cadc529af3"
 aisle	"b2"
 description	"minim ad et minim ipsum duis irure pariatur deserunt eu cillum anim ipsum velit tempor eu pariatur sunt mollit tempor ut tempor exercitation occaecat ad et veniam et excepteur velit esse eu et ut ipsum consectetur aliquip do quis voluptate cupidatat eu ut consequat adipisicing occaecat adipisicing proident laborum laboris deserunt in laborum est anim ad non"
 guid	"f78e1c4d-93c5-4b92-ae47-7ea26be48c7c"
 image	"http://lorempixel.com/400/400/"
 index	0
 price	"$184.06"
 salePrice	null
 title	"non mollit veniam ex"
 */

public class TargetDealModel implements Serializable{

    @SerializedName("_id")
    private String _id;

    @SerializedName("aisle")
    private String aisle;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getAisle() {
        return aisle;
    }

    public void setAisle(String aisle) {
        this.aisle = aisle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   /* public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }*/

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @SerializedName("description")
    private String description;

   /* @SerializedName("guid")
    private String guid;*/


    @SerializedName("image")
    private String image;

    @SerializedName("index")
    private String index;

    @SerializedName("price")
    private String price;

    @SerializedName("salePrice")
    private String salePrice;

    @SerializedName("title")
    private String title;


}
