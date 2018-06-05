package com.abhishek.TargetDeals.model;

import java.util.ArrayList;

/**
    Created by Akarmakar
    The first layer of elements present in the API
    _id, data, type
    Traverse through Data element to get all the details.
 **/

public class ResponseModel {

    String _id;
    ArrayList<TargetDealModel> data;
    String type;


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public ArrayList<TargetDealModel> getData() {
        return data;
    }

    public void setData(ArrayList<TargetDealModel> data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
