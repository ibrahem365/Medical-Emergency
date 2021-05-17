package com.example.medical_application.UI.Admin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.example.medical_application.R;
import com.example.medical_application.bloodbank_recycle;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class AddData extends AppCompatActivity {

    FirebaseDatabase mDatabase;
    DatabaseReference addDbRef;
    FirebaseStorage mStorage ;

    ImageButton imageButton;
    EditText addName, addAddr, addPhone;
    Spinner addSpin;
    Button addBtn;

    private static final int Gallary_Code=1;
    Uri imageUri=null;


    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        imageButton =findViewById(R.id.imageButton2);
        addName = findViewById(R.id.addName);
        addAddr = findViewById(R.id.addAddr);
        addPhone = findViewById(R.id.addFhone);
        addSpin = findViewById(R.id.addSpin);
        addBtn = findViewById(R.id.addBtn);

        mDatabase=FirebaseDatabase.getInstance();
        addDbRef = mDatabase.getReference().child("Blood Bank User");
        mStorage =FirebaseStorage.getInstance();

        progressDialog=new ProgressDialog(this);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,Gallary_Code);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Gallary_Code && resultCode == RESULT_OK){
            imageUri = data.getData();
            imageButton.setImageURI(imageUri);
        }

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name = addName.getText().toString().trim();
                final String address = addAddr.getText().toString().trim();
                final String phone = addPhone.getText().toString().trim();
                final String bloodType = addSpin.getSelectedItem().toString().trim();

                if (!(name.isEmpty() && address.isEmpty() && phone.isEmpty() && bloodType.isEmpty() && imageUri!=null)){

                    progressDialog.setTitle("Uploading...");
                    progressDialog.show();

                    StorageReference filePath= mStorage.getReference().child("imagePost").child(imageUri.getLastPathSegment());
                    filePath.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Task<Uri> downloadUri=taskSnapshot.getStorage().getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                                @Override
                                public void onComplete(@NonNull Task<Uri> task) {
                                    String t= task.getResult().toString();
                                    DatabaseReference newPost = addDbRef.push();

                                    newPost.child("Name").setValue(name);
                                    newPost.child("Address").setValue(address);
                                    newPost.child("Phone").setValue(phone);
                                    newPost.child("BloodType").setValue(bloodType);
                                    newPost.child("image").setValue(task.getResult().toString());
                                    progressDialog.dismiss();

                                    Intent intent = new Intent(AddData.this, bloodbank_recycle.class);
                                    startActivity(intent);

                                }
                            });
                        }
                    });

                }
            }
        });

    }
}