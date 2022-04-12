package com.example.alarmserwis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class kam_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kam_3);
    }
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
                Intent intent3 = new Intent(this,kontakt.class);
                this.startActivity(intent3);
                return true;

        }
    }
}