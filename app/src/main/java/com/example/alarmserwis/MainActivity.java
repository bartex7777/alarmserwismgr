package com.example.alarmserwis;


import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.ofirmie:
                Intent intent1 = new Intent(this, ofirmie.class);
                this.startActivity(intent1);
                return true;
            case R.id.realizacje:
                Intent intent2 = new Intent(this, realizacje.class);
                this.startActivity(intent2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
            case R.id.kontakt:
                Intent intent3 = new Intent(this, kontakt.class);
                this.startActivity(intent3);
                return true;

        }

    }
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.alarm);
        button.setOnClickListener(v -> alarm());

        button = (Button) findViewById(R.id.kamera);
        button.setOnClickListener(v -> kamera());

        button = (Button) findViewById(R.id.sieclan);
        button.setOnClickListener(v -> sieclan());

        button = (Button) findViewById(R.id.kd);
        button.setOnClickListener(v -> kd());

        button = (Button) findViewById(R.id.ppoz);
        button.setOnClickListener(v -> ppoz());

        button = (Button) findViewById(R.id.wifi2);
        button.setOnClickListener(v -> wifi());
    }
    public void  alarm() {
        Intent intent = new Intent(this, kam_2.class);
        startActivity(intent);
    }
    public void  kamera() {
        Intent intent = new Intent(this, kam_1_activity.class);
        startActivity(intent);
    }
    public void  sieclan() {
        Intent intent = new Intent(this, kam_4.class);
        startActivity(intent);
    }
    public void  kd() {
        Intent intent = new Intent(this, kam_3.class);
        startActivity(intent);
    }
    public void  ppoz() {
        Intent intent = new Intent(this, podzial_4.class);
        startActivity(intent);
    }
    public void  wifi() {
        Intent intent = new Intent(this, ustawienia.class);
        startActivity(intent);
    }
}

