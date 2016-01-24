package com.example.troy.jabbic.activities;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.troy.jabbic.R;
import com.example.troy.jabbic.fragments.CameraFragment;
import com.example.troy.jabbic.fragments.ImageViewFragment;
import com.example.troy.jabbic.fragments.SearchFragment;
import com.example.troy.jabbic.fragments.UploadFragment;
import com.example.troy.jabbic.fragments.MainFragment;

public class MainActivity extends AppCompatActivity {

    Fragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragment = new MainFragment();
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, mFragment, "MAIN")
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*
    FRAGMENT SWAP METHODS
     */

    private void makeMainFragment() {
        MainFragment fragment = new MainFragment();
        mFragment = fragment;

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment, "MAIN").addToBackStack(null).commit();
    }

    private void makeCameraFragment() {
        CameraFragment fragment = new CameraFragment();
        mFragment = fragment;

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment, "CAMERA").addToBackStack(null).commit();

    }

    private void makeUploadFragment() {
        UploadFragment fragment = new UploadFragment();
        mFragment = fragment;

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment, "UPLOAD").addToBackStack(null).commit();
    }

    private void makeSearchFragment() {
        SearchFragment fragment = new SearchFragment();
        mFragment = fragment;

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment, "SEARCH").addToBackStack(null).commit();
    }

    private void makeImageViewFragment() {
        ImageViewFragment fragment = new ImageViewFragment();
        mFragment = fragment;

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment, "IMAGE_VIEW").addToBackStack(null).commit();
    }

    /*
    ACTION LISTENERS
     */

    public void onMain(View view) {
        makeMainFragment();
    }
    public void onCamera(View view) {
        makeCameraFragment();
    }

    public void onImageView(View view) {
        makeImageViewFragment();
    }

    public void onSearch(View view) {
        makeSearchFragment();
    }

    public void onUpload(View view) {
        makeUploadFragment();
    }

}
