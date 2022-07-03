package com.example.daftarpelanggaransiswa.helper;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.daftarpelanggaransiswa.ActivityDetail;
import com.example.daftarpelanggaransiswa.utama;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URLEncoder;

public class hapushelper extends AsyncTask<String, Void, String> {
    private Context context;

    public hapushelper(Context context) {
        this.context = context;

    }

    @Override
    protected void onPreExecute() {
    }

    @Override
    protected String doInBackground(String... arg) {
        String hasil = "";
        //Get method
        try {
            String id = (String) arg[0];

            String link = "http://192.168.140.29/DataPelanggaran/hapus.php?id=" + id;
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
        Toast.makeText(context, "Data Berhasil Dihapus", Toast.LENGTH_SHORT).show();
    }
}
