package com.example.medical_application.EmerNum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.medical_application.R;

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
        numList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse(("tel:"+"123")));
                    startActivity(intent);
                }
                if(position==1)
                {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse(("tel:"+"180")));
                    startActivity(intent);
                }
                if(position==2)
                {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse(("tel:"+"122")));
                    startActivity(intent);
                }
                if(position==3)
                {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse(("tel:"+"012111000")));
                    startActivity(intent);
                }
                if(position==4)
                {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse(("tel:"+"16023")));
                    startActivity(intent);
                }
                if(position==5)
                {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse(("tel:"+"137")));
                    startActivity(intent);
                }
                if(position==6)
                {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse(("tel:"+"105")));
                    startActivity(intent);
                }
            }
        });
    }
}