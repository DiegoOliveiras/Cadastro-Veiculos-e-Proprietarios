package com.example.diego.cadastroveiculoseproprietarios.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.diego.cadastroveiculoseproprietarios.R;
import com.example.diego.cadastroveiculoseproprietarios.adapter.ProprietarioAdapter;
import com.example.diego.cadastroveiculoseproprietarios.model.Proprietario;
import com.example.diego.cadastroveiculoseproprietarios.model.Veiculo;

import java.util.ArrayList;

public class NovoVeiculo extends AppCompatActivity {

    private EditText txt_Modelo, txt_Ano, txt_Placa;
    private Button btn_Ok;
    private ArrayAdapter<Proprietario> adapter;
    //private Proprietario p = new Proprietario();
    private Proprietario p = new Proprietario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_veiculo);

        txt_Modelo = (EditText) findViewById(R.id.txt_Modelo);
        txt_Ano = (EditText) findViewById(R.id.txt_Ano);

        txt_Placa = (EditText) findViewById(R.id.txt_Placa);

        ListView lista = (ListView) findViewById(R.id.list_Proprietarios);
        final ArrayList<Proprietario> proprietarios;
        proprietarios = (ArrayList<Proprietario>) Proprietario.listAll(Proprietario.class);
        ArrayAdapter adapter = new ProprietarioAdapter(this, proprietarios);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int i, long l) {
                Toast.makeText(getBaseContext(), "Proprietario: "+proprietarios.get(i).getNome()+" selecionado com sucesso",
                        Toast.LENGTH_SHORT).show();
                p = new Proprietario(proprietarios.get(i).getNome(), proprietarios.get(i).getEndereco(), proprietarios.get(i).getTelefone(), proprietarios.get(i).getData());
            }
        });

        lista.setAdapter(adapter);

        btn_Ok = (Button) findViewById(R.id.btn_Ok);
        btn_Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (p != null) {
                    Veiculo v = new Veiculo(txt_Modelo.getText().toString(), txt_Ano.getText().toString(), txt_Placa.getText().toString(), p);
                    if (v.proprietario != null){
                        v.save();
                        Toast.makeText(getApplicationContext(), "Veículo cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(getBaseContext(), "proprietario null", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
