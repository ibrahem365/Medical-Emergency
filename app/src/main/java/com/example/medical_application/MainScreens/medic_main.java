package com.example.medical_application.MainScreens;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.medical_application.R;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class medic_main extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    FirebaseAuth mAuth;
    FirebaseUser currentUser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Firebase init
        mAuth= FirebaseAuth.getInstance();
        currentUser= mAuth.getCurrentUser();

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        medic_home_frag fragment=new medic_home_frag();
        FragmentManager manager=getSupportFragmentManager();
        manager.beginTransaction().add(R.id.nav_layout,fragment).commit();
        medic_home_frag medicprof_fragment=new medic_home_frag();
        FragmentManager fmanager=getSupportFragmentManager();
        fmanager.beginTransaction().add(R.id.nav_layout,medicprof_fragment).commit();
        drawer=findViewById(R.id.drawer_layout);
        NavigationView navigationView =findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle =new ActionBarDrawerToggle(this,drawer,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new medic_home_frag()).commit();
            navigationView.setCheckedItem(R.id.nav_home);}

        updateNav();

    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new medic_prof_frag()).commit();
                break;
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new medic_home_frag()).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);

        }
        else{
            super.onBackPressed();}
    }

    public void updateNav(){

        NavigationView navigationView =(NavigationView) findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
//        TextView txNavName = headerView.findViewById(R.id.nav_name);
        TextView txNavMail = headerView.findViewById(R.id.nav_email);

        txNavMail.setText(currentUser.getEmail());
//        txNavName.setText(currentUser.getDisplayName());


    }


}