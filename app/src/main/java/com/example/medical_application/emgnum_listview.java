package com.example.medical_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class emgnum_listview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emgnum_listview);
        ArrayList<Number> numbers1 = new ArrayList<Number>();
        numbers1.add(new Number(R.drawable.phone,R.string.amp_1,R.string.amp_num,R.drawable.ampulance));
        numbers1.add(new Number(R.drawable.phone,R.string.fire_2,R.string.fire_num,R.drawable.ire));
        numbers1.add(new Number(R.drawable.phone,R.string.pol_3,R.string.pol_num,R.drawable.police));
        numbers1.add(new Number(R.drawable.phone,R.string.acc_4,R.string.acc_num,R.drawable.accidents));
        numbers1.add(new Number(R.drawable.phone,R.string.add_5,R.string.add_num,R.drawable.fightdd));
        numbers1.add(new Number(R.drawable.phone,R.string.hea_6,R.string.hea_num,R.drawable.healthinistry));
        numbers1.add(new Number(R.drawable.phone,R.string.med_7,R.string.med_num,R.drawable.preventive));

        userAdapter adapter1 = new userAdapter(this, numbers1);

        ListView numList = (ListView)findViewById(R.id.num_list);

        numList.setAdapter(adapter1);
    }
}