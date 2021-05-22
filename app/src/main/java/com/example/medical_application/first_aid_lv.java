package com.example.medical_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.medical_application.Adapter.first_aidAdapter;
import com.example.medical_application.UI.Diabetes;
import com.example.medical_application.UI.firstaid_States.airwayobstruction;

import java.util.ArrayList;

public class first_aid_lv extends AppCompatActivity {
    private first_aidAdapter adapter;

    ListView lv;
    SearchView sv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_aid_lv);


        lv=findViewById(R.id.fa_lv);
        sv=findViewById(R.id.fa_sv);


        final ArrayList<fa_info> fa_infos = new ArrayList<>();
        fa_infos.add(new fa_info(R.drawable.azma10,R.string.item_title_azmakalbia,R.string.item_disc_azma));
        fa_infos.add(new fa_info(R.drawable.darbetshams, R.string.item_title_darbetshams,R.string.item_disc_darbet));
        fa_infos.add(new fa_info(R.drawable.ekhtnak10, R.string.item_title_ekhtnak,R.string.item_disc_ekhtnak));
        fa_infos.add(new fa_info(R.drawable.rabw, R.string.item_title_rabw,R.string.item_disc_rabw));
        fa_infos.add(new fa_info(R.drawable.modadalaelard2, R.string.item_title_momdadalaelard,R.string.item_disc_fahs));
        fa_infos.add(new fa_info(R.drawable.ksoor100, R.string.item_title_ksoor,R.string.item_disc_ksoor));
        fa_infos.add(new fa_info(R.drawable.ghrak, R.string.item_title_ghark,R.string.item_disc_ghark));
        fa_infos.add(new fa_info(R.drawable.tasmom2, R.string.item_title_tasmom,R.string.item_disc_tasmom));
        fa_infos.add(new fa_info(R.drawable.daghtat, R.string.item_title_enashkalby,R.string.item_disc_enash));
        fa_infos.add(new fa_info(R.drawable.yanzefbeghzara, R.string.item_title_yanzefbaghzara,R.string.item_dis_cynzef));
        fa_infos.add(new fa_info(R.drawable.sokar44, R.string.item_title_sokary,R.string.item_disc_sokary));
        fa_infos.add(new fa_info(R.drawable.taskef1, R.string.item_title_takef,R.string.item_disc_taskef));
        fa_infos.add(new fa_info(R.drawable.saraa4, R.string.item_title_saraa,R.string.item_disc_saraa));
        fa_infos.add(new fa_info(R.drawable.reaf2, R.string.item_title_reaf,R.string.item_disc_reaf));
        fa_infos.add(new fa_info(R.drawable.sakta100, R.string.item_title_saktademaghia,R.string.item_disc_sakta));
        fa_infos.add(new fa_info(R.drawable.hrook100, R.string.item_title_hrook,R.string.item_disc_hrook));
        fa_infos.add(new fa_info(R.drawable.accident, R.string.traffic_accidents,R.string.you_shouhdknow));
        fa_infos.add(new fa_info(R.drawable.explosives, R.string.explosion,R.string.enfgar));

        final first_aidAdapter adapter = new first_aidAdapter(this, R.layout.fa_lv_item_layout, fa_infos);

        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent i=new Intent(first_aid_lv.this,heartattacks.class);
                    startActivity(i);
                }
                if(position==1){
                    Intent i=new Intent(first_aid_lv.this,heatstroke.class);
                    startActivity(i);
                }
                if(position==2){
                    Intent i=new Intent(first_aid_lv.this, airwayobstruction.class);
                    startActivity(i);
                }
                if(position==3){
                    Intent i=new Intent(first_aid_lv.this,asthma.class);
                    startActivity(i);
                }
                if(position==4){
                    Intent i=new Intent(first_aid_lv.this,qucik_check.class);
                    startActivity(i);
                }
                if(position==5){
                    Intent i=new Intent(first_aid_lv.this,fractures.class);
                    startActivity(i);
                }
                if(position==6){
                    Intent i=new Intent(first_aid_lv.this,drowning.class);
                    startActivity(i);
                }

                if(position==7){
                    Intent i=new Intent(first_aid_lv.this,poisoning2.class);
                    startActivity(i);
                }
              if(position==8){
                  Intent i=new Intent(first_aid_lv.this,Cardiopulmonary_resuscitation.class);
                  startActivity(i);
              }
                if(position==9){
                    Intent i=new Intent(first_aid_lv.this,bleeds_profusely.class);
                    startActivity(i);
                }
                if(position==10){
                    Intent i=new Intent(first_aid_lv.this, Diabetes.class);
                    startActivity(i);
                }
                if(position==11){
                    Intent i=new Intent(first_aid_lv.this,Ambulatory_educationandawareness.class);
                    startActivity(i);
                }
                if(position==12){
                    Intent i=new Intent(first_aid_lv.this,epilepsy.class);
                    startActivity(i);
                }
                if(position==13){
                    Intent i=new Intent(first_aid_lv.this,nosebleeds.class);
                    startActivity(i);
                }
                if(position==14){
                    Intent i=new Intent(first_aid_lv.this,brainattack.class);
                    startActivity(i);
                }
                if(position==15){
                    Intent i=new Intent(first_aid_lv.this,burns.class);
                    startActivity(i);
                }
                if(position==16){
                    Intent i=new Intent(first_aid_lv.this,traffic_accidents.class);
                    startActivity(i);
                }
                if(position==17){
                    Intent i=new Intent(first_aid_lv.this,explosion_act.class);
                    startActivity(i);
                }


            }
        });

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return true;
            }
        });

    }
}