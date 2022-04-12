package com.example.alarmserwis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class kontakt extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.l_kontakt);
        SendMessageButton();
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
                Intent intent3 = new Intent(this, kontakt.class);
                this.startActivity(intent3);
                return true;

        }
    }

    private void SendMessageButton() {
        Button btn1 = (Button) findViewById(R.id.SMS);
        EditText text =(EditText) findViewById(R.id.editTextTextMultiLine);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage("517181670", null, text.getText().toString(), null, null);
                    Toast.makeText(
                            kontakt.this,
                            "Wiadomość została wysłana",
                            Toast.LENGTH_LONG
                    ).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),
                            "Nie udało się wysłać SMSa",
                            Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });


    }
}


