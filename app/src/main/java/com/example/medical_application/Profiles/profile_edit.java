

package com.example.medical_application.Profiles;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.medical_application.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class profile_edit extends AppCompatActivity {
     private EditText name,phone,gover, etcity,etage,etlenthg,etweight;
     private Spinner gender, bloodtype;
    private Button user_udate;
    private String selectGender, selectBloodType;
    private FirebaseDatabase database;
    private DatabaseReference UserRef;
    public static final String user="NormalUser";
    private String sfullname,sphone,sgovernorte,scity,sage,sgender,slengt,sweight ,sbloodtype;



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit);


        //inflate icon

        name=findViewById(R.id.udatename);
        phone=findViewById(R.id.updatephone);
        gover=findViewById(R.id.updategovernorate);
        etcity=findViewById(R.id.updatecity);
        etage=findViewById(R.id.updateage);
        etlenthg=findViewById(R.id.updatelenthg);
        etweight=findViewById(R.id.updateweight);
        gender=findViewById(R.id.update_sp_sex);
        bloodtype=findViewById(R.id.update_sp_blood);
        //item select to string
        gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               selectGender=parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        bloodtype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectBloodType=parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        user_udate=findViewById(R.id.user_update);

        //updata data
        user_udate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String upfullName = name.getText().toString().trim();
                final String upnumberphone=phone.getText().toString().trim();
                final String upgovernorate = gover.getText().toString().trim();
                final String upcity=etcity.getText().toString().trim();
                final String upage=etage.getText().toString().trim();
                final String uplength=etlenthg.getText().toString().trim();
                final String upweight=etweight.getText().toString().trim();
                if (upfullName.isEmpty()) {
                   name.setError("enter your name");
                   name.requestFocus();
                    return;
                }
                if(upnumberphone.isEmpty()) {
                    phone.setError("enter your number phone");
                    phone.requestFocus();
                }
                if (upgovernorate.isEmpty()) {
                    gover.setError("enter your governorate");
                    gover.requestFocus();
                    return;
                }
                if (upcity.isEmpty()) {
                    etcity.setError("enter your city");
                    etcity.requestFocus();
                    return;
                }
                if(upage.isEmpty()) {
                    etage.setError("enter age ");
                    etage.requestFocus();
                    return;
                }
                if(uplength.isEmpty()) {
                    etage.setError("enter length ");
                    etage.requestFocus();
                    return;
                }
                if(upweight.isEmpty()) {
                    etage.setError("enter weight ");
                    etage.requestFocus();
                    return;
                }
                database =FirebaseDatabase.getInstance();
                UserRef=database.getReference().child("NormalUser");
                String ID = FirebaseAuth.getInstance().getCurrentUser().getUid();
                UserRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for(DataSnapshot ds : snapshot.getChildren())
                        {
                            sfullname =ds.child("FullName").getValue(String.class);
                            sphone=ds.child("PhoneNumber").getValue(String.class);
                            sgovernorte=(ds.child("Governorate").getValue(String.class));
                            scity=ds.child("City").getValue(String.class);
                            sage=ds.child("Age").getValue(String.class);
                            sgender=ds.child("Gender").getValue(String.class);
                            slengt=ds.child("Length").getValue(String.class);
                            sweight=ds.child("Weight").getValue(String.class);
                            sbloodtype=ds.child("NBloodType").getValue(String.class);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                HashMap map =new HashMap();

                map.replace(sfullname,upfullName);
                map.replace(sphone,upnumberphone);
                map.replace(sgovernorte,upgovernorate);
                map.replace(scity,upcity);
                map.replace(sage,upage);
                map.replace(slengt,uplength);
                map.replace(sweight,upweight);
                map.replace(sbloodtype,selectBloodType);
                map.replace(sgender,selectGender);
               // UserRef.updateChildren(map);
                UserRef.child(ID).updateChildren(map);
              


                Toast.makeText(profile_edit.this ,"تم تعديل البيانات  ",Toast.LENGTH_LONG).show();



            }
        });





    }
}