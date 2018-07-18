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

public class Login extends AppCompatActivity {
    private EditText accountEdit;
    private EditText passwordEdit;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        accountEdit = findViewById(R.id.account);
        passwordEdit = findViewById(R.id.password);
        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = accountEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                if(TextUtils.isEmpty(account)||TextUtils.isEmpty(password)){
                    Toast.makeText(Login.this,"用户名或密码不能为空",Toast.LENGTH_SHORT).show();
                }else {
                    List<Users> users = DataSupport.findAll(Users.class);
                    for(Users user : users){
                        if(user.getName().equals(account)){
                            if(user.getPassword().equals(password)){
                                Toast.makeText(Login.this,"登入",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Login.this,MainActivity.class);
                                intent.putExtra("name",account);
                                startActivity(intent);
                                break;
                            }else{
                                Toast.makeText(Login.this,"密码错误",Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(Login.this,"不存在此用户",Toast.LENGTH_SHORT).show();
                        }

                    }
                }

            }
        });
        Button logup = findViewById(R.id.logup);
        logup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,Logup.class);
                startActivity(intent);
            }
        });
        Button other = findViewById(R.id.other);
        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,Logvip.class);
                startActivity(intent);
            }
        });
    }
}
