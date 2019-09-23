package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SosmedAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Sosmed> sosmed;

    public void setSosmed(ArrayList<Sosmed> sosmed) {
        this.sosmed = sosmed;
    }

    public SosmedAdapter(Context context) {
        this.context = context;
        sosmed = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return sosmed.size();
    }

    @Override
    public Object getItem(int i) {
        return sosmed.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_data,viewGroup,false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        Sosmed sosmed = (Sosmed) getItem(i);
        viewHolder.bind(sosmed);
        return view;
    }

    private class ViewHolder{
        private TextView txtName;
        private TextView txtMasaPembuatan;
        private TextView txtDescription;
        private ImageView imgPhoto;

        ViewHolder(View view){
            txtName = view.findViewById(R.id.txt_nama_sosmed);
            txtMasaPembuatan = view.findViewById(R.id.txt_periode);
            imgPhoto = view.findViewById(R.id.img_view);
        }
        void bind(Sosmed sosmed){
            txtName.setText(sosmed.getNama());
            txtMasaPembuatan.setText(sosmed.getMasa_pembuatan());
            imgPhoto.setImageResource(sosmed.getPhoto());
        }

    }
}
