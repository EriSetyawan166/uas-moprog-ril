package com.example.daftarpelanggaransiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.daftarpelanggaransiswa.helper.simpanhelper;

public class InputPelanggaran extends AppCompatActivity {

    private EditText inputNis, inputNama, inputKeterangan;
    private Spinner spnPelanggaran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_pelanggaran);
        inputNis = (EditText) findViewById(R.id.inputNis);
        inputNama = (EditText) findViewById(R.id.inputNama);
        inputKeterangan = (EditText) findViewById(R.id.inputKeterangan);
        spnPelanggaran = (Spinner) findViewById(R.id.spnPelanggaran);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.pelanggaran, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnPelanggaran.setAdapter(adapter);
    }

    public void btnSimpan(View view)
    {
        String nis =inputNis.getText().toString();
        String nama = inputNama.getText().toString();
        String ket = inputKeterangan.getText().toString();
        String jenpel = spnPelanggaran.getSelectedItem().toString();

        if(inputNis.getText().length() == 0){
            Toast.makeText(InputPelanggaran.this,"NIS masih Kosong", Toast.LENGTH_SHORT).show();
            return;
        }
        if(inputNama.getText().length() == 0){
            Toast.makeText(InputPelanggaran.this,"Nama masih Kosong", Toast.LENGTH_SHORT).show();
            return;
        }
        if(jenpel.equals("Pilih Jenis Pelanggaran")){
            Toast.makeText(InputPelanggaran.this,"Jenis Pelanggaran Belum Dipilih", Toast.LENGTH_SHORT).show();
            return;
        }


        Log.d("Isi = ",nis);
        Log.d("Isi = ", nama);
        Log.d("Isi = ", ket);
        Log.d("Isi = ", jenpel);
        new simpanhelper(this).execute(nis,nama,jenpel,ket);
    }


}