package com.example.diego.cadastroveiculoseproprietarios.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.diego.cadastroveiculoseproprietarios.R;
import com.example.diego.cadastroveiculoseproprietarios.model.Proprietario;

public class EditarProprietario extends AppCompatActivity {

    private EditText edt_Nome, edt_Telefone, edt_Endereco, edt_Data;
    private Button btn_Salvar;
    private String nomep, enderecop, datap, telefonep;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proprietario);
        Intent intent    = getIntent();

        id = Integer.parseInt((String)intent.getSerializableExtra("id"));

        nomep     = (String) intent.getSerializableExtra("nome");
        enderecop = (String) intent.getSerializableExtra("endereco");
        datap     = (String) intent.getSerializableExtra("data");
        telefonep  = (String) intent.getSerializableExtra("telefone");

        edt_Nome = (EditText) findViewById(R.id.edt_Nome);
        edt_Nome.setText(nomep);

        edt_Telefone = (EditText) findViewById(R.id.edt_Telefone);
        edt_Telefone.setText(telefonep);

        edt_Endereco = (EditText) findViewById(R.id.edt_Endereco);
        edt_Endereco.setText(enderecop);

        edt_Data = (EditText) findViewById(R.id.edt_Data);
        edt_Data.setText(datap);

        btn_Salvar = (Button) findViewById(R.id.btn_Salvar);
        btn_Salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Proprietario p = Proprietario.findById(Proprietario.class, id);

                nomep = edt_Nome.getText().toString();
                enderecop = edt_Endereco.getText().toString();
                datap = edt_Data.getText().toString();
                telefonep = edt_Telefone.getText().toString();

                p.setNome(nomep);
                p.setEndereco(enderecop);
                p.setData(datap);
                p.setTelefone(telefonep);

                p.save();

                Toast.makeText(getBaseContext(), "Proprietário Alterado", Toast.LENGTH_LONG).show();
            }
        });
    }
}
