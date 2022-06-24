package com.example.daftarpelanggaransiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

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

        Log.d("Isi = ",nis);
        Log.d("Isi = ", nama);
        Log.d("Isi = ", ket);
        Log.d("Isi = ", jenpel);
        new simpanhelper(this).execute(nis,nama,jenpel,ket);
    }


}