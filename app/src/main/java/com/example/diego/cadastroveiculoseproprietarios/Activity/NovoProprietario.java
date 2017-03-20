package com.example.diego.cadastroveiculoseproprietarios.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.diego.cadastroveiculoseproprietarios.R;
import com.example.diego.cadastroveiculoseproprietarios.model.Proprietario;

public class NovoProprietario extends AppCompatActivity {

    private EditText txt_Nome, txt_Endereco, txt_Telefone, txt_Data;
    private Button btn_Ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_proprietario);

        txt_Nome = (EditText) findViewById(R.id.txt_Nome);
        txt_Endereco = (EditText) findViewById(R.id.txt_Endereco);
        txt_Telefone = (EditText) findViewById(R.id.txt_Telefone);
        txt_Data = (EditText) findViewById(R.id.txt_Data);
        btn_Ok = (Button) findViewById(R.id.btn_Ok);

        btn_Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Proprietario p = new Proprietario(txt_Nome.getText().toString(),
                        txt_Endereco.getText().toString(),
                        txt_Telefone.getText().toString(),
                        txt_Data.getText().toString()
                );
                p.save();
                Toast.makeText(getApplicationContext(), "Proprietário cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
