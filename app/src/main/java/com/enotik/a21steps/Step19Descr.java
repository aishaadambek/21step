package com.enotik.a21steps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by User on 15.08.2017.
 */

public class Step19Descr extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.step19_description);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        Button btn = (Button) findViewById(R.id.buttonInfo);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Step19Descr.this, Step19Info.class);
                Step19Descr.this.startActivity(intent);
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
                Intent settings = new Intent(Step19Descr.this, MainActivity.class);
                Step19Descr.this.startActivity(settings);
                return true;
            case R.id.miProfile:
                Intent profile = new Intent(Step19Descr.this, UserProfile.class);
                Step19Descr.this.startActivity(profile);
                return true;
            case R.id.miAboutUs:
                Intent aboutUs = new Intent(Step19Descr.this, AboutUs.class);
                Step19Descr.this.startActivity(aboutUs);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}


