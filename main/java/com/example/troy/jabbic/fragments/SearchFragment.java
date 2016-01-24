package com.example.troy.jabbic.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.troy.jabbic.R;
import com.example.troy.jabbic.clarifai.ImageAdapter;

/**
 * Created by Troy on 1/23/2016.
 */
public class SearchFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //super.onCreateView( inflater, container, savedInstanceState );

        View rootView = inflater.inflate(R.layout.search_view, container, false);

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();

        GridView gridview = (GridView) getView().findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(getActivity()));

        //ASK TROY IF YOU NEED TO ADJUST SEARCH SCREEN PICTURE LIST PADDING, ETC
        gridview.setPadding(gridview.getPaddingLeft(), 200, gridview.getPaddingRight(), gridview.getBottom() + 200);
    }
}
