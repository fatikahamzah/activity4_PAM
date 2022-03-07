package com.example.sampleconstraintlayout;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;



import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    //mendeklarasikan variabel dengan tipe data TextView
    TextView txEmail,txPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Menghubungkan variabel txEmail dengan componen TextView pada Layout
        txEmail = findViewById(R.id.tf_nama);

        //Menghubungkan variabel txEmail dengan componen TextView pada Layout
        txPassword = findViewById(R.id.tf_password);

        //mendeklarasikan variabel bundle yang akan digunakan untuk mengambil
        //pesan yang dikirimkan melalui method intent
        Bundle bundle = getIntent().getExtras();

        //membuat variabel string yang digunakan untuk menyimpan data yang
        //dikirimkan dari activity sebelumnya dengan kunci "a"
        String email = bundle.getString("a");
        String pass = bundle.getString("b");

        //menampilkan value dari variabel email kedalam txEmail
        txEmail.setText(email);
        //menampilkan value dari variabel pass kedalam txPassword
        txPassword.setText(pass);
    }
}