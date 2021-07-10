package com.example.medical_application.Reports;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;

import com.example.medical_application.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ReceivingReports extends AppCompatActivity {
    FirebaseDatabase mDatabase;
    DatabaseReference addDbRef;

//    new_report newReport;

    RecyclerView rvRep;
    ArrayList<RepItem> repItems;
    RepAdapter repAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiving_reports);

        rvRep= findViewById(R.id.rvRecRep);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        rvRep.setHasFixedSize(true);
        rvRep.setLayoutManager(lm);

//        newReport = new new_report();

        repItems = new ArrayList<>();
        repAdapter = new RepAdapter(ReceivingReports.this,repItems);
        rvRep.setAdapter(repAdapter);

        mDatabase=FirebaseDatabase.getInstance();
        addDbRef = mDatabase.getReference().child("ReceiveReports");

        addDbRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                RepItem item = snapshot.getValue(RepItem.class);
                item.setPatName(snapshot.child("patName").getValue().toString());
                item.setRepType(snapshot.child("repType").getValue().toString());
                item.setLocaTxt(snapshot.child("locaTxt").getValue().toString());
                item.setmTxt(snapshot.child("mTxt").getValue().toString());
                item.setwTxt(snapshot.child("wTxt").getValue().toString());
                item.setChTxt(snapshot.child("chTxt").getValue().toString());
                repItems.add(item);
                repAdapter.notifyDataSetChanged();
//                newReport.notification();
                notification();

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