package com.example.daftarpelanggaransiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.daftarpelanggaransiswa.helper.loginhelper;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

public class MainActivity extends AppCompatActivity {

    private EditText txtUser, txtPass;
    private Button btnLogin;
    String user, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtUser =(EditText)findViewById(R.id.editTextUsername);
        txtPass =(EditText) findViewById(R.id.editTextPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        user=pass="";

    }

    public void btnLogin(View view) {
        String user = txtUser.getText().toString();
        String pass = txtPass.getText().toString();
        new loginhelper(this).execute(user,pass);
    }


}
