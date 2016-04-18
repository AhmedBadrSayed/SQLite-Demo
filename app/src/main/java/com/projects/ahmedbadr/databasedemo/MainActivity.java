package com.projects.ahmedbadr.databasedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DataBase db;
    EditText first_name;
    EditText last_name;
    EditText email;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DataBase(this);
        first_name = (EditText) findViewById(R.id.first_name);
        last_name = (EditText) findViewById(R.id.last_name);
        email = (EditText) findViewById(R.id.email);
        button = (Button) findViewById(R.id.save);
        final String first = first_name.getText().toString();
        final String last = last_name.getText().toString();
        final String mail = email.getText().toString();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.addUser(first,last,mail);
                Toast.makeText(MainActivity.this,"Done",Toast.LENGTH_SHORT).show();
            }
        });
    }


}
