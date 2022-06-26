package com.example.daftarpelanggaransiswa.helper;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daftarpelanggaransiswa.MainActivity;
import com.example.daftarpelanggaransiswa.utama;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;



public class loginhelper extends AsyncTask<String,Void,String> {
    private Context context;



    public loginhelper(Context context) {
        this.context = context;

    }


    @Override
    protected void onPreExecute() {
    }

    @Override
    protected String doInBackground(String... arg0) {
        String hasil = "";
        //Get method
        try {
            //Request
            String username = (String) arg0[0];
            String password = (String) arg0[1];
            String link = "http://192.168.252.29/DataPelanggaran/login.php?username=" + username + "&password=" + password;
            Log.d("Url = ", link);
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet();
            request.setURI(new URI(link));
            HttpResponse response = client.execute(request);
            BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));


            //Responses
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

            return new String("Exception: " + e.getMessage());
        }
    }

    @Override
    protected void onPostExecute(String result){
        Log.d("Log =", result);
        if(result.equals("Berhasil")){
            Log.d("Status = ", "Berhasil");
            Intent intent = new Intent(context, utama.class);
            context.startActivity(intent);
            Toast.makeText(context, "Login Berhasil", Toast.LENGTH_SHORT).show();

        }
        else{
            Log.d("Status = ", "Gagal");
            Toast.makeText(context, "Username/Password Salah", Toast.LENGTH_SHORT).show();
        }
    }
}

