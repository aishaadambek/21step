package com.example.a21steps;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserProfile extends AppCompatActivity {

    TextView nameTV, usernameTV, ageTV;
    Button logOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        logOut = (Button) findViewById(R.id.logOut);
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(UserProfile.this,
                        R.style.AlertDialogCustom);
                builder.setTitle("Потвердите действие")
                        .setMessage("Вы уверены, что хотите выйти?")
                        .setIcon(R.drawable.ic_warning_white_24dp)
                        .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent logout = new Intent(UserProfile.this, MainActivity.class);
                                logout.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                logout.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                UserProfile.this.startActivity(logout);

                                SharedPreferences userInfo = getSharedPreferences("USER_INFO", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = userInfo.edit();
                                editor.clear();
                                editor.commit();

                                finish();
                            }
                        })
                        .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .create()
                        .show();
            }
        });

        nameTV = (TextView) findViewById(R.id.name);
        usernameTV = (TextView) findViewById(R.id.username);
        ageTV = (TextView) findViewById(R.id.age);

        displayInfo();
    }

    public void displayInfo(){

        SharedPreferences userInfo = getSharedPreferences("USER_INFO", Context.MODE_PRIVATE);
        String name = userInfo.getString("name", "");
        String username = userInfo.getString("username", "");
        int age = userInfo.getInt("age", 0);
        nameTV.setText("  " + name);
        usernameTV.setText("  " + username);
        ageTV.setText("  " + age);
    }
}
