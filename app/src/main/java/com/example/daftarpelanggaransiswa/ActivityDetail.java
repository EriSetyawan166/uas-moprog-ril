package com.example.daftarpelanggaransiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.daftarpelanggaransiswa.helper.hapushelper;
import com.example.daftarpelanggaransiswa.helper.simpanhelper;
import com.example.daftarpelanggaransiswa.helper.ubahhelper;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.w3c.dom.Text;

public class ActivityDetail extends AppCompatActivity {

    private TextInputLayout inputNis, inputNama, inputKeterangan, inputPoin;
    private Spinner spnPelanggaran;
    private Button btnHapus, btnUbah;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        inputNis = (TextInputLayout) findViewById(R.id.nis);
        inputNama = (TextInputLayout) findViewById(R.id.nama);
        inputKeterangan = (TextInputLayout) findViewById(R.id.keterangan);
        spnPelanggaran = (Spinner) findViewById(R.id.tampilPelanggaran);

        btnHapus = (Button)findViewById(R.id.btnHapus);


        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        String nis = (String) b.get("nis");
        String nama = (String) b.get("nama");
        String poin = (String) b.get("poin");
        String keterangan = (String) b.get("keterangan");
        String jenpel = (String) b.get("jenpel");
        String id = (String) b.get("id");
        String[] arrayPelanggaran = getResources().getStringArray(R.array.pelanggaran);
        String container;

        inputNis.getEditText().setText(nis);
        inputNama.getEditText().setText(nama);
        inputKeterangan.getEditText().setText(keterangan);
        Log.d("Testing", id);

        for (int i=0; i<arrayPelanggaran.length;i++){
                Log.d("nama", String.valueOf(i));
            container = arrayPelanggaran[i];
            if (arrayPelanggaran[i].equals(jenpel)){
                Log.d("jalan di", String.valueOf(i));
                spnPelanggaran.setSelection(i);
            }
        }
    }



    public void btnHapus(View view){
        Intent i = getIntent();
        Bundle b = i.getExtras();
        String id = (String) b.get("id");
        new hapushelper(this).execute(id);
    }

    public void btnUbah(View view){
        Intent i = getIntent();
        Bundle b = i.getExtras();
        String id = (String) b.get("id");
        String nis = inputNis.getEditText().getText().toString();
        String nama = inputNama.getEditText().getText().toString();
        String keterangan = inputKeterangan.getEditText().getText().toString();
        String jenpel = spnPelanggaran.getSelectedItem().toString();

        new ubahhelper(this).execute(id, nis, nama, jenpel,keterangan);
    }
}