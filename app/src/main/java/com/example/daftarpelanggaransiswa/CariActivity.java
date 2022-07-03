package com.example.daftarpelanggaransiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CariActivity extends AppCompatActivity {

    String urlCari = "http://localhost/DataPelanggaran/cari.php?";

    String[] nis;
    String[] nama;
    String[] poin;
    String[] tempat;
    String[] data;
    String[] ket;
    String[] jenpel;
    String[] id;
    BufferedInputStream is;
    String line = null;
    String result = null;
    EditText txtcari2;

    ListView lv, lp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari);

        txtcari2 = (EditText) findViewById(R.id.txtcari2);


        lv = (ListView) findViewById(R.id.listterakhir2);

        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
        ambilData();
        listadaptcari clv = new listadaptcari(this, nis, nama, poin, ket, jenpel, id);
        lv.setAdapter(clv);
    }

    private void ambilData(){
        try{

            Intent i = getIntent();
            Bundle b = i.getExtras();
            String nama = (String) b.get("nama");
            Log.d("Nama = ", nama);
            String urlCari= "http://192.168.140.29/DataPelanggaran/cari.php?nama=" + nama;
            URL url=new URL(urlCari);
            HttpURLConnection con =(HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            is=new BufferedInputStream(con.getInputStream());

        }catch (Exception ex){
            ex.printStackTrace();
            Log.d("lah = ?" , ex.toString());
        }

        try{
            BufferedReader br =new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            while((line=br.readLine())!=null){
                sb.append(line+"\n");
            }
            is.close();
            result=sb.toString();
            Log.d("Hasil = ", result);


        }catch (Exception ex){

            ex.printStackTrace();
            Log.d("isi = ", ex.toString());
        }

        try{

            tempat = result.split(":");
            nis=new String[tempat.length];
            nama=new String[tempat.length];
            poin=new String[tempat.length];
            ket = new String[tempat.length];
            jenpel = new String[tempat.length];
            id = new String[tempat.length];
//            int panjang = tempat.length;
//            Log.d("hasil split = ", tempat[3]);
//            Log.d("Panjang tempat", String.valueOf(panjang));
//            int j = 0;
            for(int i=0; i< tempat.length;i++)
            {
                data = tempat[i].split("#");
                nis[i] = data[1];
                nama[i] = data[2];
                poin[i] = data[5];
                ket[i] = data[4];
                jenpel[i] = data[3];
                id[i] = data[0];
            }


//            JSONArray ja = new JSONArray(result);
//
//            JSONObject jo = null;
//            nis=new String[ja.length()];
//            nama=new String[ja.length()];
//            poin=new String[ja.length()];
//
//            for(int i=0;i<ja.length();i++){
//                jo = ja.getJSONObject(i);
//                nis[i]=jo.getString("nis");
//                nama[i]=jo.getString("nama");
//                poin[i]=jo.getString("poin");
//
//                Log.d("yeyyy = ", nis[i]);
//
//            }
        }catch (Exception ex){
            ex.printStackTrace();
            Log.d("lah",ex.toString());
        }
    }

    public void btnCari(View view){
        String cari = txtcari2.getText().toString();
        Log.d("Cari = ", cari);

        try {
            cari = txtcari2.getText().toString();
            Log.d("Cari = ", cari);
            String urlcari = "http://192.168.140.29/DataPelanggaran/login.php?nama=" + cari;
            URL url = new URL(urlcari);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            is = new BufferedInputStream(con.getInputStream());

        } catch (Exception ex) {
            ex.printStackTrace();
            Log.d("lah = ?", ex.toString());
        }

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            result = sb.toString();
            Log.d("Hasil = ", result);


        } catch (Exception ex) {

            ex.printStackTrace();
            Log.d("isi = ", ex.toString());
        }

        try {

            tempat = result.split(":");
            nis = new String[tempat.length];
            nama = new String[tempat.length];
            poin = new String[tempat.length];
            ket = new String[tempat.length];
            jenpel = new String[tempat.length];
            id = new String[tempat.length];
//            int panjang = tempat.length;
//            Log.d("hasil split = ", tempat[3]);
//            Log.d("Panjang tempat", String.valueOf(panjang));
//            int j = 0;
            for (int i = 0; i < tempat.length; i++) {
                data = tempat[i].split("#");
                nis[i] = data[1];
                nama[i] = data[2];
                poin[i] = data[5];
                ket[i] = data[4];
                jenpel[i] = data[3];
                id[i] = data[0];
            }


//            JSONArray ja = new JSONArray(result);
//
//            JSONObject jo = null;
//            nis=new String[ja.length()];
//            nama=new String[ja.length()];
//            poin=new String[ja.length()];
//
//            for(int i=0;i<ja.length();i++){
//                jo = ja.getJSONObject(i);
//                nis[i]=jo.getString("nis");
//                nama[i]=jo.getString("nama");
//                poin[i]=jo.getString("poin");
//
//                Log.d("yeyyy = ", nis[i]);
//
//            }
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.d("lah", ex.toString());
        }


        Intent intent = new Intent(CariActivity.this, CariActivity.class);
        intent.putExtra("nama", cari);
        startActivity(intent);
    }
}