package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Models.UserHelper;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView username =(TextView) findViewById(R.id.username);
        TextView password =(TextView) findViewById(R.id.password);



        MaterialButton registerbtn = (MaterialButton) findViewById(R.id.registernbtn);

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database = FirebaseDatabase.getInstance("https://my-application-68bc6-default-rtdb.firebaseio.com/");
                reference = database.getReference("users");

                String name = username.getText().toString();
                String passwor = password.getText().toString();

                UserHelper helper = new UserHelper(name, passwor);

                reference.child(name).setValue(helper);
                Toast.makeText(RegisterActivity.this, "Register Successfull",Toast.LENGTH_SHORT).show();


            }
        });
    }
}