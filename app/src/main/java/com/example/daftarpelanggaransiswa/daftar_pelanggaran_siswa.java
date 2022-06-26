package com.example.daftarpelanggaransiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class daftar_pelanggaran_siswa extends AppCompatActivity {

    String urladd="http://192.168.252.29/DataPelanggaran/tampil.php";
    String[] nis;
    String[] nama;
    String[] poin;
    String[] tempat;
    String[] data;
    BufferedInputStream is;
    String line = null;
    String result = null;

    ListView lv, lp;

    private TextView tvnama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_pelanggaran_siswa);
        lv = (ListView) findViewById(R.id.listterakhir);

        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
        ambilData();
        listAdapt clv = new listAdapt(this, nis, nama, poin);
        lv.setAdapter(clv);
    }

    private void ambilData(){
        try{
            URL url=new URL(urladd);
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
}