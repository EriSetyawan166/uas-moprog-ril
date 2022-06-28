package com.example.daftarpelanggaransiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.daftarpelanggaransiswa.helper.Daftarhelper;
import com.example.daftarpelanggaransiswa.helper.loginhelper;

public class RegistActivity extends AppCompatActivity {

    private EditText inputuser, inputpassword, inputpasswordlagi;
    private Button btnDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        inputuser = (EditText) findViewById(R.id.inputusername);
        inputpassword = (EditText) findViewById(R.id.inputpassword);
        inputpasswordlagi = (EditText) findViewById(R.id.inputpasswordlagi);
        btnDaftar = (Button) findViewById(R.id.btnDaftar);

    }

    public void btnDaftar(View view){
        String user = inputuser.getText().toString();
        String pass = inputpassword.getText().toString();
        String passlagi = inputpasswordlagi.getText().toString();

        if (user.equals("")){
            Toast.makeText(this, "Username Tidak belum diisi", Toast.LENGTH_SHORT).show();
            return;
        }

        if (pass.equals("")){
            Toast.makeText(this, "Password belum diisi", Toast.LENGTH_SHORT).show();
            return;
        }

        if (! passlagi.equals(pass)){
            Toast.makeText(this, "Password salah", Toast.LENGTH_SHORT).show();
            return;
        }



        new Daftarhelper(this).execute(user,pass);
    }
}