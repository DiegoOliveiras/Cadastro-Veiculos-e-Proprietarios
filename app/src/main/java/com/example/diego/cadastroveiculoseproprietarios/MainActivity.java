package com.example.diego.cadastroveiculoseproprietarios;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_VerProprietarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_VerProprietarios = (Button) findViewById(R.id.btn_VerProprietarios);
        btn_VerProprietarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, VerProprietarios.class);
                startActivity(it);
            }
        });
    }


}
