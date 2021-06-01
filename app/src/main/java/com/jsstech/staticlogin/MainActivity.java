package com.jsstech.staticlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jsstech.staticlogin.databinding.ActivityMainBinding;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    //ActivityMainBinding binding;
    EditText username,Pass;
    Button btLogin;
    TextView tv;
    int count=5;
    Timer timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.counter);
        username = findViewById(R.id.et_user);
        Pass = findViewById(R.id.et_pass);
        btLogin = findViewById(R.id.bt_login);


        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String USERNAME = username.getText().toString().trim();
                String PASS = Pass.getText().toString().trim();

                if (USERNAME.isEmpty()) {
                   username.setError("Email cant be empty");
                    username.requestFocus();
                    return;
                }

                if (PASS.isEmpty()) {
                    Pass.setError("Password cant be empty");
                    Pass.requestFocus();
                    return;
                }

                    if (USERNAME.equals("admin") && PASS.equals("1234")){
                        //if you want to open a new activity

//                    Intent intent=new Intent(MainActivity.this,SecondAct.class);
//                    startActivity(intent);
                    Toast.makeText(MainActivity.this,"sucessfull login",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this,"Worng username &password",Toast.LENGTH_SHORT).show();
                    count--;
                    tv.setText(Integer.toString(count));

                    if (count == 0) {
                        btLogin.setVisibility(view.GONE);
                    }
                }

           }

        });




    }
}
