package com.example.listview;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class DetailSosmedActivity extends AppCompatActivity {
    TextView name,masa_pembuatan,deskripsi;
    ImageView foto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_sosmed);

        name = findViewById(R.id.txt_intent_nama_sosmed);
        masa_pembuatan = findViewById(R.id.txt_intent_masa_pembuatan);
        //deskripsi = findViewById(R.id.txt_judul_deskripsi);
        foto = findViewById(R.id.img_fb);
        WebView webView = (WebView) findViewById(R.id.txt_judul_deskripsi);
        Intent intent = getIntent();
        String receivedName = intent.getStringExtra("name");
        String receivedMasaJabat = intent.getStringExtra("masa_pembuatan");
        String receivedDeskripsi = intent.getStringExtra("deskripsi");
        int receivedFoto = intent.getIntExtra("foto",0);

        name.setText(receivedName);
        masa_pembuatan.setText(receivedMasaJabat);
        //deskripsi.setText(receivedDeskripsi);
        foto.setImageResource(receivedFoto);
        webView.loadData("<p style=\"text-align: justify\">" +receivedDeskripsi + "</p>","text/html","UTF-8");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(receivedName);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }
}
