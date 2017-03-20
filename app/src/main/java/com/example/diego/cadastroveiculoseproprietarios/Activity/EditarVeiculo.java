package com.example.diego.cadastroveiculoseproprietarios.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.diego.cadastroveiculoseproprietarios.R;
import com.example.diego.cadastroveiculoseproprietarios.model.Proprietario;
import com.example.diego.cadastroveiculoseproprietarios.model.Veiculo;

public class EditarVeiculo extends AppCompatActivity {

    private EditText edt_Modelo, edt_Ano, edt_Placa, edt_Nome, edt_Telefone, edt_Endereco, edt_Data;
    private Button btn_Salvar;
    private String modelov, placav, anov, nomep, enderecop, datap, telefonep;
    private int idv, idp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_veiculo);

        Intent intent    = getIntent();

        idv = Integer.parseInt((String)intent.getSerializableExtra("id"));

        modelov = (String) intent.getSerializableExtra("modelo");
        placav = (String) intent.getSerializableExtra("placa");
        anov = (String) intent.getSerializableExtra("ano");

        Veiculo v = Veiculo.findById(Veiculo.class, idv);
//        idp     = Integer.parseInt((String)intent.getSerializableExtra("proprietario"));

        Proprietario p = v.proprietario;

        if (v.proprietario == null){
            Toast.makeText(getBaseContext(), "proprietario null", Toast.LENGTH_SHORT).show();
        }

        edt_Nome = (EditText) findViewById(R.id.edt_Nome);
        //edt_Nome.setText(p.getNome());

        edt_Telefone = (EditText) findViewById(R.id.edt_Telefone);
        //edt_Telefone.setText(p.getTelefone());

        edt_Endereco = (EditText) findViewById(R.id.edt_Endereco);
        //edt_Endereco.setText(p.getEndereco());

        edt_Data = (EditText) findViewById(R.id.edt_Data);
        //edt_Data.setText(p.getData());

        edt_Modelo = (EditText) findViewById(R.id.edt_Modelo);
        edt_Modelo.setText(v.getModelo());

        edt_Ano = (EditText) findViewById(R.id.edt_Ano);
        edt_Ano.setText(anov);

        edt_Placa = (EditText) findViewById(R.id.edt_Placa);
        edt_Placa.setText(placav);



    }
}
