package com.abhishek.TargetDeals.fragment;


import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abhishek.TargetDeals.R;
import com.abhishek.TargetDeals.adapter.DataListAdapter;
import com.abhishek.TargetDeals.interfaces.ApiInterface;
import com.abhishek.TargetDeals.model.ResponseModel;
import com.abhishek.TargetDeals.utils.ApiClient;
import com.abhishek.TargetDeals.utils.Constants;
import com.abhishek.TargetDeals.utils.LogManager;
import com.abhishek.TargetDeals.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * {@link TargetDealsFragment} subclass which will show all the deals. Using Recyclerview to create the list.
 *
 */
public class TargetDealsFragment extends Fragment {

    @BindView(R.id.dealsRecycler)
    RecyclerView dealsRecycler;
    DataListAdapter dataListAdapter;
    ResponseModel responseModel;
    ProgressDialog progressDialog;
    Context context;


    public TargetDealsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_deals, container, false);
        ButterKnife.bind(this, view);
        context = getActivity();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        dealsRecycler.setLayoutManager(layoutManager);
        if (Utils.isInternetConnected(context)) {
            callDealsWebService();
        }

        return view;
    }

    private void callDealsWebService() {
        ApiInterface apiService = ApiClient.getClient(Constants.BASE_URL).create(ApiInterface.class);
        Call<ResponseModel> call = apiService.getTargetDealsDetails();
        progressDialog = Utils.getProgressbar(context, "Loading data...", false);
        progressDialog.show();
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if (progressDialog != null) {
                    progressDialog.dismiss();
                }
                LogManager.debug(" callTargetDealsWebService response", response.body().toString());
                if (response.isSuccessful()) {
                    responseModel = response.body();
                    if (responseModel.getData().size() > 0) {
                     dataListAdapter = new DataListAdapter(context, responseModel.getData());
                        dealsRecycler.setAdapter(dataListAdapter);
                    } else {
                        Utils.openDailogWithSingleButton(context, getString(R.string.no_record_found));
                    }
                } else {
                    Utils.openDailogWithSingleButton(context, "No response");
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                LogManager.debug("callDealsWebService ", t.toString());
                if (progressDialog != null) {
                    progressDialog.dismiss();
                }
                Utils.openDailogWithSingleButton(context, "Some error occured");
            }
        });
    }



}
