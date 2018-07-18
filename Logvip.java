package com.example.vz.bogwork;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.litepal.crud.DataSupport;

import java.util.List;

public class Logvip extends AppCompatActivity {
    private EditText accountEdit;
    private EditText passwordEdit;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logvip);
        Button logup = findViewById(R.id.logup);
        accountEdit = findViewById(R.id.account);
        passwordEdit = findViewById(R.id.password);
        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = accountEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                if(TextUtils.isEmpty(account)||TextUtils.isEmpty(password)){
                    Toast.makeText(Logvip.this,"用户名或密码不能为空",Toast.LENGTH_SHORT).show();
                }else {
                    List<Vips> users = DataSupport.findAll(Vips.class);
                    for(Vips user : users){
                        if(user.getName().equals(account)){
                            if(user.getPassword().equals(password)){
                                Toast.makeText(Logvip.this,"登入",Toast.LENGTH_SHORT).show();
                                break;
                            }else{
                                Toast.makeText(Logvip.this,"密码错误",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else if(!user.getName().equals(account)){
                            Toast.makeText(Logvip.this,"不存在此用户",Toast.LENGTH_SHORT).show();
                        }

                    }
                }
            }
        });

        logup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Logvip.this,Logupvip.class);
                startActivity(intent);
            }
        });
    }
}
