package com.enotik.a21steps;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by User on 14.08.2017.
 */

public class Step14Right extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SharedPreferences userInfo = getSharedPreferences("USER_INFO", Context.MODE_PRIVATE);
        final String username = userInfo.getString("username", null);

        SharedPreferences pref = getSharedPreferences("Activity14" + username, Context.MODE_PRIVATE);

        if(pref.getBoolean("activity_executed", false)){
            //do nothing
        } else {
            SharedPreferences.Editor ed = pref.edit();
            ed.putBoolean("activity_executed", true);
            ed.putInt("Progress", 2);
            ed.apply();
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.step14_result_right);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        Button btn = (Button) findViewById(R.id.buttonNextStep);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences userInfo = getSharedPreferences("USER_INFO", Context.MODE_PRIVATE);
                final String username = userInfo.getString("username", null);

                MainActivity.btn15.setEnabled(true);
                SharedPreferences sharedPreferences = getSharedPreferences("Step15" + username, Context.MODE_PRIVATE);
                sharedPreferences.edit().putBoolean("Passed", true).apply();

                Intent intent = new Intent(Step14Right.this, Step15Descr.class);
                Step14Right.this.startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.miMap:
                Intent settings = new Intent(Step14Right.this, MainActivity.class);
                Step14Right.this.startActivity(settings);
                return true;
            case R.id.miProfile:
                Intent profile = new Intent(Step14Right.this, UserProfile.class);
                Step14Right.this.startActivity(profile);
                return true;
            case R.id.miAboutUs:
                Intent aboutUs = new Intent(Step14Right.this, AboutUs.class);
                Step14Right.this.startActivity(aboutUs);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
