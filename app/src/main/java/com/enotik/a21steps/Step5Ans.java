package com.enotik.a21steps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

/**
 * Created by User on 13.08.2017.
 */

public class Step5Ans extends AppCompatActivity {

    RadioButton rb1, rb2, rb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.step5_answers);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        rb1 = (RadioButton) findViewById(R.id.radioButtonStep5Right);
        rb2 = (RadioButton) findViewById(R.id.radioButtonStep5Wrong);
        rb3 = (RadioButton) findViewById(R.id.radioButtonStep5Medium);

        Button clear = (Button) findViewById(R.id.button2);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rb1.isChecked()){
                    Intent intent = new Intent(Step5Ans.this, Step5Right.class);
                    Step5Ans.this.startActivity(intent);
                    finish();
                } else if(rb2.isChecked()){
                    Intent intent = new Intent(Step5Ans.this, Step5Wrong.class);
                    Step5Ans.this.startActivity(intent);
                    finish();
                } else if(rb3.isChecked()) {
                    Intent intent = new Intent(Step5Ans.this, Step5Medium.class);
                    Step5Ans.this.startActivity(intent);
                    finish();
                }
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
                Intent settings = new Intent(Step5Ans.this, MainActivity.class);
                Step5Ans.this.startActivity(settings);
                return true;
            case R.id.miProfile:
                Intent profile = new Intent(Step5Ans.this, UserProfile.class);
                Step5Ans.this.startActivity(profile);
                return true;
            case R.id.miAboutUs:
                Intent aboutUs = new Intent(Step5Ans.this, AboutUs.class);
                Step5Ans.this.startActivity(aboutUs);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

