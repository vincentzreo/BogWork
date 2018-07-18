package com.example.vz.bogwork;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.litepal.crud.DataSupport;

import java.util.List;


public class FruitActivity extends AppCompatActivity {
    public static final String FRUIT_NAME = "fruit_name";
    public static final String FRUIT_IMAGE_ID = "fruit_image_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);
        Intent intent = getIntent();
        final String fruitName = intent.getStringExtra(FRUIT_NAME);
        int fruitImageId = intent.getIntExtra(FRUIT_IMAGE_ID,0);
        Toolbar toolbar = findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        ImageView fruitImageView = findViewById(R.id.fruit_image_view);
        TextView fruitContentText = findViewById(R.id.fruit_content_text);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbar.setTitle(fruitName);
        Glide.with(this).load(fruitImageId).into(fruitImageView);
        /*String fruitContent = generateFruitContent(fruitName);
        fruitContentText.setText(fruitContent);*/
        List<fruits> fs = DataSupport.findAll(fruits.class);
        for(fruits f : fs){
            if(fruitName.equals(f.getName())){
                fruitContentText.setText("数量: " + f.getNumbers()+" 价格：" + f.getPrice());
            }
        }
        Button button = findViewById(R.id.buy);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<fruits> f = DataSupport.findAll(fruits.class);
                for(fruits f1 : f){
                    if(f1.getName().equals(fruitName)){
                        int i = f1.getNumbers();
                        i = i -1;
                        f1.setNumbers(i);
                        f1.save();
                    }
                }


            }
        });
    }
    private String generateFruitContent(String fruitName){
        StringBuilder fruitContent = new StringBuilder();
        for(int i = 0 ; i < 500 ; i ++){
            fruitContent.append(fruitName);
        }
        return fruitContent.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
