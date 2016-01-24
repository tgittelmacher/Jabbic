package com.example.troy.jabbic.fragments;

import android.app.Application;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.troy.jabbic.R;
import com.example.troy.jabbic.activities.MainActivity;
import com.example.troy.jabbic.clarifai.ImageAdapter;

/**
 * Created by Troy on 1/23/2016.
 */
public class MainFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //super.onCreateView( inflater, container, savedInstanceState );

        View rootView = inflater.inflate(R.layout.main_view, container, false);

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();

        GridView gridview = (GridView) getView().findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(getActivity()));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(getActivity(), "YA CLICKED SOMETHING", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
