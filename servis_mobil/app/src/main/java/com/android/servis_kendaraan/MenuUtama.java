package com.android.servis_kendaraan;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MenuUtama extends AppCompatActivity {

    Button btnInput,btnUpdate,btnStatus,btnLogout;
    SharedPreferences spLogin;
    DB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Beranda");
        }

        db = new DB(this);

        spLogin = getSharedPreferences(StaticVars.SP_LOGIN, MODE_PRIVATE);
//        btnInput = findViewById(R.id.btnInput);
//        btnInput.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SoundBtn.soundBtn(MenuUtama.this);
//                startActivity(new Intent(MenuUtama.this, InputKendaraan.class));
//            }
//        });
//        btnUpdate = findViewById(R.id.btnUpdate);
//        btnUpdate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SoundBtn.soundBtn(MenuUtama.this);
//                startActivity(new Intent(MenuUtama.this, UpdateKendaraan.class));
//            }
//        });
//        btnStatus = findViewById(R.id.btnStatus);
//        btnStatus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SoundBtn.soundBtn(MenuUtama.this);
//                startActivity(new Intent(MenuUtama.this, ListKendaraan.class));
//            }
//        });
//        btnLogout = findViewById(R.id.btnLogout);
//        btnLogout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SoundBtn.soundBtn(MenuUtama.this);
//                showDialog();
//            }
//        });
    }

    public void btnInput(View view)
    {
        Intent intent =new Intent(MenuUtama.this, InputKendaraan.class);
        startActivity(intent);
    }

    public void btnStatus(View view)
    {
        Intent intent =new Intent(MenuUtama.this, ListKendaraan.class);
        startActivity(intent);
    }

    public void btnUpdate(View view)
    {
        Intent intent =new Intent(MenuUtama.this, UpdateKendaraan.class);
        startActivity(intent);
    }

    public void btnLogout(View view)
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);
        alertDialogBuilder.setTitle("Apa benar anda ingin Logout ?");
        alertDialogBuilder
                .setMessage("Klik Ya untuk logout!")
                .setCancelable(false)
                .setPositiveButton("Ya",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        SoundBtn.soundBtn(MenuUtama.this);
                        SharedPreferences.Editor loginEditor = spLogin.edit();
                        loginEditor.clear();
                        loginEditor.apply();
                        finish();
                        startActivity(new Intent(MenuUtama.this,Login.class));
                    }
                })
                .setNegativeButton("Tidak",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        SoundBtn.soundBtn(MenuUtama.this);
                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    @Override
    public void onBackPressed() {
        SoundBtn.soundBtn(MenuUtama.this);
        finish();
    }
//    private void showDialog(){
//        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
//                this);
//        alertDialogBuilder.setTitle("Apa benar anda ingin Logout ?");
//        alertDialogBuilder
//                .setMessage("Klik Ya untuk logout!")
//                .setCancelable(false)
//                .setPositiveButton("Ya",new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog,int id) {
//                        SoundBtn.soundBtn(MenuUtama.this);
//                        SharedPreferences.Editor loginEditor = spLogin.edit();
//                        loginEditor.clear();
//                        loginEditor.apply();
//                        finish();
//                        startActivity(new Intent(MenuUtama.this,Login.class));
//                    }
//                })
//                .setNegativeButton("Tidak",new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        SoundBtn.soundBtn(MenuUtama.this);
//                        dialog.cancel();
//                    }
//                });
//
//        AlertDialog alertDialog = alertDialogBuilder.create();
//        alertDialog.show();
//    }
}
