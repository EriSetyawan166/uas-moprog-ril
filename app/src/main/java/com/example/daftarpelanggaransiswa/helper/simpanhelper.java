package com.example.daftarpelanggaransiswa.helper;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.example.daftarpelanggaransiswa.ActivityDetail;
import com.example.daftarpelanggaransiswa.daftar_pelanggaran_siswa;
import com.example.daftarpelanggaransiswa.utama;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URLEncoder;

public class simpanhelper extends AsyncTask<String, Void, String> {
    private Context context;

    public simpanhelper(Context context){ this.context = context;}

    @Override
    protected void onPreExecute() {
    }

    @Override
    protected String doInBackground(String... arg) {
        String hasil = "";
        //Get method
        try {
            String nis = (String) arg[0];
            String nama = (String) arg[1];
            String jenpel = (String) arg[2];
            String ket = (String) arg[3];

            String link = "http://192.168.140.29/DataPelanggaran/simpanData.php?nis=" + nis + "&nama=" + URLEncoder.encode(nama, "utf-8") + "&jenpel=" + URLEncoder.encode(jenpel, "utf-8") + "&keterangan=" + URLEncoder.encode(ket, "utf-8");
            Log.d("url =", link.toString());
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet();
            request.setURI(new URI(link));
            HttpResponse response = client.execute(request);
            BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

            StringBuffer sb = new StringBuffer("");
            String line = "";
            while ((line = in.readLine()) != null) {
                sb.append(line);
                break;
            }
            in.close();
            hasil = sb.toString();
            return hasil;
        } catch (Exception e) {
            Log.d("loghehe=", e.toString());
        }
        return hasil;
    }

    @Override
    protected void onPostExecute(String result) {
        Intent intent = new Intent(context, utama.class);
        context.startActivity(intent);
    }


}