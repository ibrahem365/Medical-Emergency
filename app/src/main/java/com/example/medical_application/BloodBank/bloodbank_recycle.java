package com.example.medical_application.BloodBank;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

import com.example.medical_application.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;


public class bloodbank_recycle extends AppCompatActivity {
    FirebaseDatabase mDatabase;
    DatabaseReference dbRef;
    FirebaseStorage mStorage ;

    RecyclerView rv;
    ArrayList<Item> items ;
    ItemAdapter itemAdapter;

    FloatingActionButton fab;
    Button btn;
    String phoneNum;
    SearchView searchView;

    private String selectedFilter= "all";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bloodbank_recycle);


        rv =findViewById(R.id.rvv);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(lm);

        fab =findViewById(R.id.fab);
        btn = findViewById(R.id.btn);
        searchView= findViewById(R.id.searchBlood);

        mDatabase=FirebaseDatabase.getInstance();
        dbRef = mDatabase.getReference().child("Blood Bank User");
        mStorage =FirebaseStorage.getInstance();

        items = new ArrayList<>();
        itemAdapter= new ItemAdapter(bloodbank_recycle.this,items);
        rv.setAdapter(itemAdapter);

        dbRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                Item item = snapshot.getValue(Item.class);
                phoneNum= snapshot.child("Phone").getValue().toString();
                item.setTxt1(snapshot.child("Name").getValue().toString());
                item.setTxt2(snapshot.child("BloodType").getValue().toString());
                item.setTxt3(snapshot.child("Address").getValue().toString());
                item.setTxt4(snapshot.child("Phone").getValue().toString());
                item.setImage1(snapshot.child("image").getValue().toString());
                items.add(item);
                itemAdapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(bloodbank_recycle.this, AddData.class);
                startActivity(i);
//                Toast.makeText(bloodbank_recycle.this,"حاسك عايز تلعب ههههه جرب علي الي موجود وخلاص ",Toast.LENGTH_SHORT).show();
            }
        });


    /*    btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:"+phoneNum));
                startActivity(i);
            }
        });*/

    }

    @Override
    protected void onStart() {
        super.onStart();

        if (searchView != null){
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String s) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    search(s);
                    return true;
                }
            });
        }

    }

    private void search(String str){
        ArrayList<Item> myList = new ArrayList<>();
        for (Item object : items){
            if (object.getTxt2().toLowerCase().contains(str.toLowerCase())){
                myList.add(object);
            }
        }
        ItemAdapter iAdapter = new ItemAdapter(myList);
        rv.setAdapter(iAdapter);

    }

    private void filterList(String status){

        selectedFilter = status;
        ArrayList<Item> myList = new ArrayList<>();
        for (Item object : items){
            if (object.getTxt2().toLowerCase().contains(status.toLowerCase())){
                myList.add(object);
            }
        }
        ItemAdapter iAdapter = new ItemAdapter(myList);
        rv.setAdapter(iAdapter);

    }

    public void apFilter(View view) {
        filterList("a+");
    }

    public void bpFilter(View view) {
        filterList("b+");
    }

    public void opFilter(View view) {
        filterList("o+");
    }

    public void amFilter(View view) {
        filterList("a-");
    }

    public void bmFilter(View view) {
        filterList("b-");
    }

    public void omFilter(View view) {
        filterList("o-");
    }

    public void abpFilter(View view) {
        filterList("ab+");
    }

    public void abmFilter(View view) {
        filterList("ab-");
    }

    public void allFilter(View view) {
        selectedFilter="all";
        ItemAdapter iAdapter = new ItemAdapter(items);
        rv.setAdapter(iAdapter);
    }

/*    private void GetDataFromFirebase() {

        Query query = dbRef.child("massages");

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                ClearAll();

                for(DataSnapshot snapshot1 : snapshot.getChildren() ){
                    Item item = new Item();

                    item.setTxt1(snapshot1.child("name").getValue().toString());
                    item.setTxt2(snapshot1.child("blood").getValue().toString());
                    item.setTxt3(snapshot1.child("address").getValue().toString());
                    item.setTxt4(snapshot1.child("phone").getValue().toString());

                    items.add(item);

                }

                itemAdapter = new ItemAdapter(getApplicationContext(),items);
                rv.setAdapter(itemAdapter);
                itemAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void ClearAll(){
        if (items != null){
            items.clear();

            if (itemAdapter != null){
                itemAdapter.notifyDataSetChanged();
            }

        }
        items = new ArrayList<>();
    }*/

/*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater= getMenuInflater();
        menuInflater.inflate(R.menu.menu_search,menu);
        MenuItem mI = menu.findItem(R.id.search_view);
//        SearchView searchView = (SearchView) MenuItemCompat.getActionView(mI);
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
    }*/
}