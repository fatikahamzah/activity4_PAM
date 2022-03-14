package com.example.sampleconstraintlayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //deklarasi variabel untuk button
    Button btnLogin;

    //deklarasi variabel untuk EditText
    private EditText edemail, edpassword;

    //deklarasi variabel untuk menyimpan email dan password
    String nama, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //menghubungkan variabel edemail dengan component pada layout
        edemail = findViewById(R.id.edEmail);
        //menghubungkan variabel edpassword dengan component pada layout
        edpassword = findViewById(R.id.edPassword);
        //menghubungkan variabel btnLogin dengan component pada layout
        Button btnLogin = findViewById(R.id.btSignin);

        btnLogin.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nama = edemail.getText().toString();
                password = edpassword.getText().toString();

                //mengeset email yang benar
                String email = "admin@mail.com";

                //mengeset password yang benar
                String pass = "123";

                //mengecek apakah edittext email dan password terdapat isi atau tidak
                if (nama.isEmpty() || password.isEmpty()) {
                    //membuat variabel toast dan menampilkan pesan "edittext tidak boleh kosong
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Email dan password wajib diisi!!!",
                            Toast.LENGTH_LONG);
                    //menampilkan toast
                    t.show();
                } else {
                    //mengecek apakah isi dari email dan password sudah sama denngan email dan password yang sudah di set
                    if (nama.equals(email) && password.equals(pass)) {
                        //membuat variabel toast dan menampilkan pesan "Login sukses"
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Sukses",
                                Toast.LENGTH_LONG);
                        //menampilkan toast
                        t.show();

                        //membuat objek bundle
                        Bundle b = new Bundle();
                        //key parsing data dimasukan kedalam bundle
                        b.putString("a", nama.trim());
                        b.putString("b", password.trim());

                        //membuat objek untuk pindah halaman
                        Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                        //memasukan bundle kedalam intent
                        i.putExtras(b);
                        //berpindah ke halaman lain
                        startActivity(i);
                    } else {
                        //membuat variabel toast dan membuat toast dan menampilkan pesan "Login gagal
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Gagal", Toast.LENGTH_LONG);
                        //menampilkan toast
                        t.show();

                    }
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        //Mmembuat Kondisi jika yang dipilih adalah id mDaftar
        if (item.getItemId() == R.id.mnDaftar)
        {
            //Method umtuk memanggil activity "DaftarActivity"
            Intent i = new Intent(getApplicationContext(),activity_daftar.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}


