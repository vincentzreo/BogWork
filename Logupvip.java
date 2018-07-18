package com.example.vz.bogwork;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.List;

public class Logupvip extends AppCompatActivity {
    private EditText accountEdit;
    private EditText passwordEdit;
    private EditText rpasswordEdit;
    private Button logup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logupvip);
        accountEdit = findViewById(R.id.account);
        passwordEdit = findViewById(R.id.password);
        rpasswordEdit = findViewById(R.id.rpassword);
        logup = findViewById(R.id.logup);
        logup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = accountEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                String rpassword = rpasswordEdit.getText().toString();
                if(!password.equals(rpassword)||TextUtils.isEmpty(password)){
                    Toast.makeText(Logupvip.this,"warm",Toast.LENGTH_SHORT).show();
                }else{
                    int key = 0;
                    List<Vips> users = DataSupport.findAll(Vips.class);
                    for(Vips user1 : users){
                        if(user1.getName().equals(account)){
                            key = 1;
                        }
                    }
                    if(key == 1){
                        Toast.makeText(Logupvip.this,"用户名已存在",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Vips vip = new Vips();
                        vip.setName(account);
                        vip.setPassword(password);
                        vip.save();
                        Toast.makeText(Logupvip.this,"注册成功",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Logupvip.this,Logvip.class);
                        startActivity(intent);
                    }

                }

            }
        });
    }
}
