package com.example.medical_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;

import java.util.ArrayList;


public class bloodbank_recycle extends AppCompatActivity {
    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bloodbank_recycle);
        rv =findViewById(R.id.rvv);

        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(R.drawable.ic_man,"ابراهيم","A+","منياالفمح"));
        items.add(new Item(R.drawable.ic_man,"محمد","bb","زفازيف"));
        items.add(new Item(R.drawable.ic_man,"محمد","b+","منيا القمح"));
        items.add(new Item(R.drawable.ic_man,"ابراهيم","A+","منياالفمح"));
        items.add(new Item(R.drawable.ic_man,"محمد","bb","زفازيف"));
        items.add(new Item(R.drawable.ic_man,"محمد","b+","مينيا القمح"));
        items.add(new Item(R.drawable.ic_man,"ابراهيم","A+","منياالفمح"));
        items.add(new Item(R.drawable.ic_man,"محمد","bb","زفازيف"));
        items.add(new Item(R.drawable.ic_man,"محمد","b+","منيا القمح"));



        ItemAdapter adapter = new ItemAdapter(items);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater= getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        MenuItem mI = menu.findItem(R.id.search_view);
//       SearchView searchView = (SearchView) MenuItemCompat.getActionView(mI);
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String s) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String s) {
//                return false;
//            }
//        });
        return super.onCreateOptionsMenu(menu);
    }
}