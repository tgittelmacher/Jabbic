package com.example.troy.jabbic.fragments;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.troy.jabbic.R;
import com.example.troy.jabbic.activities.MainActivity;
import com.example.troy.jabbic.clarifai.ClarifaiMaster;
import com.example.troy.jabbic.clarifai.ImageAdapter;

import java.io.File;
import java.net.URI;

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
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ClarifaiMaster master = ClarifaiMaster.getInstance();
                        final String[] results = master.getTags("http://www.cise.ufl.edu/~dts/personal/who/CamelBack.jpg");
                        if (results != null) {
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    for (int i=0; i < results.length; ++i) {
                                        Toast.makeText(getActivity(), results[i], Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }
                    }
                }).start();

            }
        });

    }

}
