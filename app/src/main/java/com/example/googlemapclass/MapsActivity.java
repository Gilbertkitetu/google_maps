package com.example.googlemapclass;

import androidx.fragment.app.FragmentActivity;

import android.location.Location;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.googlemapclass.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        double startLat = -0.416665;
        double startLog = 36.9499962;

        double endLat = -1.286389;
        double endLog = 36.817223;

        // Add a marker in Sydney and move the camera
        LatLng nyeri = new LatLng(startLat, startLog);
        mMap.addMarker(new MarkerOptions().position(nyeri).title("Marker in nyeri"));
       // mMap.moveCamera(CameraUpdateFactory.newLatLng(nyeri);
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        LatLng Nairobi = new LatLng(endLat, endLog);
        mMap.addMarker(new MarkerOptions().position(Nairobi).title("Marker in Nairobi"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(nyeri);

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(startLat, startLog), 15.0f));

        //calculate distanse
        float[] results = new float[1];
        Location.distanceBetween(startLat, startLog, endLat, endLog, results);
        float distance = results[0];

        //distance in kilometres
        int kilometers = (int)(distance/1000);
        Toast.makeText(this, String.valueOf(kilometers)+"KM", Toast.LENGTH_SHORT).show();






    }
}