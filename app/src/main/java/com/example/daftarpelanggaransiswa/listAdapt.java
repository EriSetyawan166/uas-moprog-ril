package com.example.daftarpelanggaransiswa;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class listAdapt extends ArrayAdapter<String> {

    private String[] nis;
    private String[] nama;
    private String[] poin;
    private Activity context;

    public listAdapt(Activity context, String[] nis, String[] nama, String[] poin){
        super(context, R.layout.activity_list_adapt, nama);
        this.context = context;
        this.nis =nis;
        this.nama = nama;
        this.poin = poin;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View r=convertView;
        listAdapt.ViewHolder viewHolder=null;
        if(r==null){
            LayoutInflater layoutInflater=context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.activity_list_adapt, null,true);
            viewHolder=new listAdapt.ViewHolder(r);
            r.setTag(viewHolder);
        }
        else {
            viewHolder=(listAdapt.ViewHolder)r.getTag();

        }
        viewHolder.textNis.setText(nis[position]);
        viewHolder.textNama.setText(nama[position]);
        viewHolder.textPoin.setText(poin[position]);
        return r;
    }

    class ViewHolder{
        TextView textNis;
        TextView textNama;
        TextView textPoin;
        ViewHolder(View v){
            textNis=(TextView)v.findViewById(R.id.txtNis);
            textNama =(TextView)v.findViewById(R.id.txtNama);
            textPoin =(TextView)v.findViewById(R.id.txtPoin);
        }
    }
}