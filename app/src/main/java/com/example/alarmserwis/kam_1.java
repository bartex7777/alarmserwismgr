package com.example.alarmserwis;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.alarmserwis.db.DatabaseHelper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class kam_1 extends AppCompatActivity {

    private static Bitmap photo = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kam_1);

        ImageButton imageButton = findViewById(R.id.bnSnapshot);
        Button addButton = findViewById(R.id.add_photo_button);
        EditText opis = findViewById(R.id.editTextKam1);

        imageButton.setOnClickListener(view -> {
            Intent zrobZdjecie = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (zrobZdjecie.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(zrobZdjecie, 1);
            }
        });

        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        addButton.setOnClickListener(view -> {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            photo.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
            databaseHelper.getWritableDatabase().execSQL(
                    "insert into zdjecia (" + byteArrayOutputStream + " , " + opis + ")"
            );
            databaseHelper.close();

            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            wlaczKamereIZrobZdjecie(data);
        }
    }

    private void wlaczKamereIZrobZdjecie(Intent data) {
        photo = (Bitmap) data.getExtras().get("data");
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
            //case R.id.ofirmie:
              //  Intent intent1 = new Intent(this, ofirmie.class);
              //  this.startActivity(intent1);
               // return true;
           // case R.id.realizacje:
              //  Intent intent2 = new Intent(this, realizacje.class);
              //  this.startActivity(intent2);
               // return true;
            default:
                return super.onOptionsItemSelected(item);
            case R.id.kontakt:
                Intent intent3 = new Intent(this,kontakt.class);
                this.startActivity(intent3);
                return true;

        }
    }
}