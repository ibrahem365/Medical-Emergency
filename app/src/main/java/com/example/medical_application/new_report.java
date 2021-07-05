package com.example.medical_application;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.medical_application.UI.Diabetes;
import com.example.medical_application.UI.MainActivity;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

import java.util.zip.Inflater;

public class new_report extends AppCompatActivity {

    FirebaseDatabase mDatabase;
    DatabaseReference addDbRef;

    int counter=0;
    FloatingActionButton plus;
    FloatingActionButton minus;
    TextView count;
    int counter1=0;
    FloatingActionButton plus1;
    FloatingActionButton minus1;
    TextView count1;
    int counter2=0;
    FloatingActionButton plus2;
    FloatingActionButton minus2;
    TextView count2;
    Button send ;
    Button fa;
    TextView fa_text;
    Button bl;
    TextView bl_text;
    private AlertDialog.Builder dialogbuilder;
    private AlertDialog dialog;
    Button getLoc;
    TextView locTextView;
    String cLocation;
    EditText pName;
    Spinner rType;


    private FusedLocationProviderClient fusedLocationProviderClient;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_report);
        plus=findViewById(R.id.p);
        minus=findViewById(R.id.m);
        count=findViewById(R.id.c);
        plus1=findViewById(R.id.p1);
        minus1=findViewById(R.id.m1);
        count1=findViewById(R.id.c1);
        plus2=findViewById(R.id.p2);
        minus2=findViewById(R.id.m2);
        count2=findViewById(R.id.c2);
        getLoc= findViewById(R.id.btnGetLoc);
        locTextView= findViewById(R.id.locTxtView);
        pName= findViewById(R.id.description);
        rType= findViewById(R.id.spinner_type_of_report);


        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        count.setText(counter+"");
        count1.setText(counter+"");
        count2.setText(counter+"");

plus.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        counter ++;
        count.setText(counter+" ");
    }
});
minus.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        counter--;
        count.setText(counter+" ");
    }
});
plus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter1 ++;
                count1.setText(counter1+" ");
            }
});
minus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter1--;
                count1.setText(counter1+" ");
            }
});
plus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter2 ++;
                count2.setText(counter2+" ");
            }
});
minus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter2--;
                count2.setText(counter2+" ");
            }
});
        send=findViewById(R.id.send_btn);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertSendData();
                popup();

            }
        });




        getLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if (getApplication().checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){

                        // get our location
                        fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                            @Override
                            public void onSuccess(Location location) {

                                if (location != null){

                                    String lat= String.valueOf(location.getLatitude());
                                    String longt= String.valueOf(location.getLongitude());

                                    cLocation = lat+","+longt;

                                    locTextView.setText(cLocation);
                                    Toast.makeText(new_report.this,"Success",Toast.LENGTH_SHORT).show();

                                }

                            }
                        });


                    }else{
                        requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION},0);
                    }
                }

            }
        });

        mDatabase=FirebaseDatabase.getInstance();
        addDbRef = mDatabase.getReference().child("ReceiveReports");



    }
    public void popup(){
        dialogbuilder=new AlertDialog.Builder(this);
        final View dilaog_sc=getLayoutInflater().inflate(R.layout.dialog,null);
        fa_text=findViewById(R.id.fa_text);
        fa=dilaog_sc.findViewById(R.id.fa_btn);
        bl_text=findViewById(R.id.bl_text);
        bl=dilaog_sc.findViewById(R.id.bl_btn);
        //rType.setSelection(3);{
           // fa.setText("yomna");
          //  fa.setOnClickListener(new View.OnClickListener() {
               // @Override
               // public void onClick(View v) {
                   // Intent i=new Intent(new_report.this,poisoning2.class);
                    //startActivity(i);

               // }
           // });


      //  }
      // rType.setSelection(2);{
            //fa.setText("salma");
           // fa.setOnClickListener(new View.OnClickListener() {
              //  @Override
               // public void onClick(View v) {
                   // Intent i=new Intent(new_report.this,traffic_accidents.class);
                   // startActivity(i);

              //  }
          //  });

       // }
        if (rType.getSelectedItemPosition()==1){
            fa.setText(R.string.traffic);
           fa.setOnClickListener(new View.OnClickListener() {
             @Override
            public void onClick(View v) {
            Intent i=new Intent(new_report.this,traffic_accidents.class);
            startActivity(i);

              }
              });

        }
        if (rType.getSelectedItemPosition()==2){
            fa.setText(R.string.explo);
            fa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(new_report.this,explosion_act.class);
                    startActivity(i);

                }
            });

        }
        if (rType.getSelectedItemPosition()==3){
            fa.setText(R.string.heartatt);
            fa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(new_report.this,heartattacks.class);
                    startActivity(i);

                }
            });

        }
        if (rType.getSelectedItemPosition()==4){
            fa.setText(R.string.dia);
            fa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(new_report.this, Diabetes.class);
                    startActivity(i);

                }
            });

        }
        if (rType.getSelectedItemPosition()==5){
            fa.setText(R.string.poiso);
            fa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(new_report.this,poisoning2.class);
                    startActivity(i);

                }
            });

        }
        if (rType.getSelectedItemPosition()==6){
            fa.setText(R.string.brain);
            fa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(new_report.this,brainattack.class);
                    startActivity(i);

                }
            });

        }
        if (rType.getSelectedItemPosition()==7){
            fa.setText(R.string.bur);
            fa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(new_report.this,burns.class);
                    startActivity(i);

                }
            });

        }


        bl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b=new Intent(new_report.this,bloodbank_recycle.class);
                startActivity(b);
            }
        });

//        fa.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent f= new Intent(new_report.this,first_aid_lv.class);
//                startActivity(f);
//            }
//        });
        
        dialogbuilder.setView(dilaog_sc);
        dialogbuilder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();

            }
        });
        dialog=dialogbuilder.create();
        dialog.setCanceledOnTouchOutside(false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.dialog_shape));


        }



        dialog.show();


    }



    private void insertSendData(){

        final String pname = pName.getText().toString().trim();
        final String rtype = rType.getSelectedItem().toString().trim();
        final String locText = locTextView.getText().toString().trim();
        final String manText = count.getText().toString().trim();
        final String womanText = count1.getText().toString().trim();
        final String childText = count2.getText().toString().trim();


        if (!(pname.isEmpty() && rtype.isEmpty() && locText.isEmpty() && manText.isEmpty() && womanText.isEmpty() && childText.isEmpty())){

            RepItem ditem = new RepItem(pname,rtype,locText,manText,womanText,childText);

            addDbRef.push().setValue(ditem);

//            notification();

            Toast.makeText(new_report.this,"Report send",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(new_report.this,"Field is Empty",Toast.LENGTH_SHORT).show();
        }
    }

    public void notification(){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel =
                    new NotificationChannel("n","n", NotificationManager.IMPORTANCE_DEFAULT);

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"n")
                .setContentText("Code sphere")
                .setSmallIcon(R.drawable.ic_baseline_message_24)
                .setAutoCancel(true)
                .setContentText(" يوجد بلاغ جديد ");

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(999,builder.build());

    }


}