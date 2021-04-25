package com.example.medical_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.VoiceInteractor;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.telecom.Connection;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class nearst_center extends AppCompatActivity {


    SupportMapFragment supportMapFragment;
    FusedLocationProviderClient client;
    GoogleMap map;
    Spinner sp_type;
    Button pt_View;
    double currentlat = 22, currentlong=44;
    private LatLng LatLng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearst_center);

        //Assign variable
        supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.google_map);
        sp_type=findViewById(R.id.sp_type);
        pt_View=findViewById(R.id.pt_View);
        //initialize array of places type
        final String[] PlaceTypeList={"hospital","pharmacy"};
        //initialize array of place name
        String[] PlaceNameList={"Hospital","Pharmacy"};
        // adapter on spinner
        sp_type.setAdapter(new ArrayAdapter<>(nearst_center.this,android.R.layout.simple_spinner_dropdown_item,PlaceNameList));

        //initialize fused location
        client = LocationServices.getFusedLocationProviderClient(this);

        //check permission
        if (ActivityCompat.checkSelfPermission(nearst_center.this,Manifest.permission.ACCESS_FINE_LOCATION) ==PackageManager.PERMISSION_GRANTED) {
            //when permission graded call this method
            getCurrentlocation();
        }else {
            //when permission denied};
            ActivityCompat.requestPermissions(nearst_center.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},44);
        }
        pt_View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i=sp_type.getSelectedItemPosition();
                String url="https://maps.googleapis.com/maps/apis/places/MyProject/json"+
                        "?location="+currentlat+","+ currentlong +
                        "&radius=5000"+
                        "&types"+PlaceTypeList[i]+
                        "&sensor=true"+
                        "&key="+getResources().getString(R.string.google_map_key);
                new PlaceTask().execute(url);

            }
        });
    }

    private void getCurrentlocation() {
        //initialize task location
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

        }
        Task<Location> task = client.getLastLocation();
        task = task.addOnSuccessListener(new OnSuccessListener<Location>() {

            @Override
            public void onSuccess(Location location) {
                if(location!=null){
                    currentlat=location.getLatitude();
                    currentlong=location.getLongitude();
                    //sync map
                    supportMapFragment.getMapAsync(new OnMapReadyCallback() {
                        @Override
                        public void onMapReady(GoogleMap googleMap) {
                            map=googleMap;
                            //initialize lat lng
                            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(currentlat,currentlong),16));
                            googleMap.moveCamera(CameraUpdateFactory.newLatLng(LatLng));

                        }
                    });
                }

            }


        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==44){
            if(grantResults.length>0&&grantResults[0]!=PackageManager.PERMISSION_GRANTED){
                getCurrentlocation();
            }
        }
    }

    private class PlaceTask extends AsyncTask<String,Integer,String> {
        @Override
        protected String doInBackground(String... strings) {
            String data=null;
            try {
                data=downloadUrl(strings[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return data;
        }

        @Override
        protected void onPostExecute(String s) {
            new ParserTask().execute(s);
        }
    }

    private String downloadUrl(String string) throws IOException {
        URL url=new URL(string);
        HttpURLConnection connection=(HttpURLConnection) url.openConnection();
        connection.connect();
        InputStream stream=connection.getInputStream();
        BufferedReader reader=new BufferedReader( new InputStreamReader(stream));
        StringBuilder builder=new StringBuilder();
        String line="";
        while ((line=reader.readLine())!=null){
            builder.append(line);
        }

        String data=builder.toString();
        reader.close();
        return  data;
    }

    private class ParserTask extends AsyncTask<String,Integer, List<HashMap<String,String>>> {
        @Override
        protected List<HashMap<String, String>> doInBackground(String... strings) {
            com.example.medical_application.Jsonparser jsonparser=new com.example.medical_application.Jsonparser();
            List<HashMap<String,String>> mapList=null;
            JSONObject object=null;
            try {
                object=new JSONObject(strings[0]);
                mapList=jsonparser.parseResult(object);

            } catch (JSONException e) {
                e.printStackTrace();
            }
            return mapList;
        }
        @Override
        protected  void onPostExecute(List<HashMap<String,String>>hashMaps){
            map.clear();
            for (int i=0;i<hashMaps.size();i++){
                HashMap<String,String> hashMapList=hashMaps.get(i);
                double lat= Double.parseDouble(hashMapList.get("lat"));
                double lng= Double.parseDouble(hashMapList.get("lng"));
                String name=hashMapList.get("name");
                LatLng latLng=new LatLng(lat,lng);
                MarkerOptions markerOptions=new MarkerOptions();
                markerOptions.position(latLng);
                markerOptions.title(name);
                markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET));
                map.addMarker(markerOptions);
            }
        }
    }
};
