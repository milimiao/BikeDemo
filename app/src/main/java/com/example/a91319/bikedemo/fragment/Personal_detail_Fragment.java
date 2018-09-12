package com.example.a91319.bikedemo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a91319.bikedemo.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Personal_detail_Fragment extends Fragment {


    public Personal_detail_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_personal_detail_, container, false);
    }

}
