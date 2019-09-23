package com.example.listview;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private String[] dataName;
    private String[] dataMasaPembuatan;
    private String[] dataDeskripsi;
    private int dataPhotoId;
    private TypedArray dataPhoto;
    private SosmedAdapter adapter;
    private ArrayList<Sosmed> sosmeds;
    int[] test = new int[1000];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new SosmedAdapter(this);
        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),DetailSosmedActivity.class);
                intent.putExtra("name",dataName[i]);
                intent.putExtra("masa_pembuatan",dataMasaPembuatan[i]);
                intent.putExtra("deskripsi",dataDeskripsi[i]);
                intent.putExtra("foto",test[i]);
                //intent.putExtra("foto",dataPhoto.getResourceId(i));
                startActivity(intent);
            }
        });

        prepare();
        addItem();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.more,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.about_us:
                Intent intent = new Intent(getApplicationContext(),AboutUsActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void addItem(){
        sosmeds = new ArrayList<>();

        for(int i=0;i<dataName.length;i++){
            Sosmed sosmed = new Sosmed();
            dataPhotoId = dataPhoto.getResourceId(i,-1);
            sosmed.setPhoto(dataPhotoId);

            test[i] = dataPhotoId;
            sosmed.setNama(dataName[i]);
            sosmed.setMasa_pembuatan(dataMasaPembuatan[i]);
            sosmed.setDeskripsi(dataDeskripsi[i]);
            sosmeds.add(sosmed);
        }
        adapter.setSosmed(sosmeds);
    }

    private void prepare(){
        dataName = getResources().getStringArray(R.array.data_name);
        dataMasaPembuatan = getResources().getStringArray(R.array.data_masa_pembuatan);
        dataDeskripsi = getResources().getStringArray(R.array.data_deskripsi);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }



}
