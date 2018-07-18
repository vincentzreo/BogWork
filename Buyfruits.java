package com.example.vz.bogwork;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.litepal.crud.DataSupport;

import java.util.List;

public class Buyfruits extends AppCompatActivity {
    private EditText numberEdit;
    private String name;
    private String s;
    private int num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyfruits);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        numberEdit = findViewById(R.id.numbers);
        s = numberEdit.getText().toString();

        Button b = findViewById(R.id.b);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<fruits> f = DataSupport.findAll(fruits.class);
                for(fruits f1 : f){
                    if(f1.getName().equals(name)){
                        Toast.makeText(Buyfruits.this,"s",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });



    }
}
