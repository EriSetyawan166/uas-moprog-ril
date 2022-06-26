package com.example.daftarpelanggaransiswa;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class listAdapt extends ArrayAdapter<String> {

    private String[] nis;
    private String[] nama;
    private String[] poin;
    private String[] ket;
    private String[] jenpel;
    private String[] id;
    private Activity context;


    public listAdapt(Activity context, String[] nis, String[] nama, String[] poin, String[] ket, String[] jenpel, String[] id){
        super(context, R.layout.activity_list_adapt, nama);
        this.context = context;
        this.nis =nis;
        this.nama = nama;
        this.poin = poin;
        this.ket = ket;
        this.jenpel = jenpel;
        this.id = id;
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
        r.setClickable(true);
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ActivityDetail.class);
                intent.putExtra("nis", nis[position]);
                intent.putExtra("nama", nama[position]);
                intent.putExtra("poin", poin[position]);
                intent.putExtra("keterangan", ket[position]);
                intent.putExtra("jenpel", jenpel[position]);
                intent.putExtra("id", id[position]);
                context.startActivity(intent);


            }
        });

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