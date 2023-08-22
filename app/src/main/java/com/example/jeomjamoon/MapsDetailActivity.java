package com.example.jeomjamoon;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.jeomjamoon.databinding.ActivityMapsDetailBinding;

public class MapsDetailActivity extends FragmentActivity implements OnMapReadyCallback {

    library selectedLibrary;

    String detailname;
    String detailaddress;
    String detailnumber;
    double detaillatitude;
    double detaillongitude;
    String detailopentime;
    private GoogleMap mMap;
    private ActivityMapsDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        getSelectedLibrary();
        setValues();
    }

    private void setValues() {

        detailname = selectedLibrary.getName();
        detailaddress = selectedLibrary.getAddress();
        detailnumber = selectedLibrary.getNumber();
        detaillatitude = selectedLibrary.getLatitude();
        detaillongitude = selectedLibrary.getLongitude();
        detailopentime = selectedLibrary.getOpentime();

    }

    private void getSelectedLibrary() {
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");

        selectedLibrary = MainActivity5.libraryList.get(Integer.valueOf(id));
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
        // Add a marker in Sydney and move the camera
        LatLng librarydetails = new LatLng(detaillatitude, detaillongitude);

        String snippetText = "주소: "+detailaddress+"\n전화번호: "+detailnumber
                +"\n개장시간: "+detailopentime;

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(librarydetails);
        markerOptions.title(detailname);
        markerOptions.snippet(snippetText);
        Marker marker = mMap.addMarker(markerOptions);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(librarydetails, 15));

        mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Nullable
            @Override
            public View getInfoContents(@NonNull Marker marker) {
                LinearLayout info = new LinearLayout(MapsDetailActivity.this);
                info.setOrientation(LinearLayout.VERTICAL);

                TextView title = new TextView(MapsDetailActivity.this);
                title.setTextColor(Color.BLACK);
                title.setGravity(Gravity.CENTER);
                title.setTypeface(null, Typeface.BOLD);
                title.setText(marker.getTitle());

                TextView snippet = new TextView(MapsDetailActivity.this);
                snippet.setTextColor(Color.GRAY);
                snippet.setGravity(Gravity.LEFT);
                snippet.setText(marker.getSnippet());

                info.addView(title);
                info.addView(snippet);

                return info;
            }

            @Nullable
            @Override
            public View getInfoWindow(@NonNull Marker marker) {
                return null;
            }
        });
    }

}