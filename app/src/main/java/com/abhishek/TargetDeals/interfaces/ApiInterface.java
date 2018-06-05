package com.abhishek.TargetDeals.interfaces;

import com.abhishek.TargetDeals.model.ResponseModel;
import com.abhishek.TargetDeals.utils.Constants;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by akarmakar.
 * Using retrofit to make the API calls.
 */

public interface ApiInterface
{
    @GET(Constants.GET_ALL_RECORDS)
    Call<ResponseModel> getTargetDealsDetails();
}