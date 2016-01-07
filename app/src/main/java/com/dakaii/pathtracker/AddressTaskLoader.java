package com.dakaii.pathtracker;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.util.Log;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by dnakashi on 12/21/15.
 */
public class AddressTaskLoader extends AsyncTaskLoader<Address> {
    private Geocoder geocoder = null;
    private double lat;
    private double lon;

    public AddressTaskLoader(Context context, double lat, double lon){
        super(context);
        geocoder = new Geocoder(context, Locale.getDefault());
        this.lat = lat;
        this.lon = lon;
    }

    @Override
    public Address loadInBackground(){
        Address result = null;
        try {
            List<Address> results = geocoder.getFromLocation(lat, lon, 1);
            if (results != null && !results.isEmpty()) {
                result = results.get(0);
            }
        }catch (IOException e){
            Log.e("AddressTaskLoader", e.getMessage());
        }
        return result;
    }

    @Override
    protected void onStartLoading(){
        forceLoad();
    }
}
