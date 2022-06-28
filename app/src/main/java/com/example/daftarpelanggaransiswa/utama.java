package com.example.daftarpelanggaransiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.daftarpelanggaransiswa.InputPelanggaran;

public class utama extends AppCompatActivity {
    private Button btnInput, btnLihat, btnTest;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utama);
        btnInput = (Button) findViewById(R.id.btnInput);
        btnLihat = (Button) findViewById(R.id.btnLihat);

    }

    public void btnInput(View view){
        Intent intent = new Intent(utama.this, InputPelanggaran.class);
        startActivity(intent);
    }

    public void btnLihat(View view){
        Intent intent = new Intent(utama.this, daftar_pelanggaran_siswa.class);
        startActivity(intent);
    }

    public void btnDaftar2(View view){
        Intent intent = new Intent(utama.this, RegistActivity.class);
        startActivity(intent);
    }
}