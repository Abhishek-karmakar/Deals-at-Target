package com.abhishek.TargetDeals.fragment;


import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.abhishek.TargetDeals.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ImagePriviewFragment extends Fragment {
    @BindView(R.id.imgPreview)
    ImageView imgPriview;

    public ImagePriviewFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_image_priview, container, false);
        ButterKnife.bind(this, view);
        Bundle b = getArguments();
        if (b != null) {
            String transitionName = b.getString("transitionName");
//            Movie movie = (Movie) b.getSerializable("movie");

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                imgPriview.setTransitionName(transitionName);
            }
        }
        return view;
    }

}
