package com.example.diego.cadastroveiculoseproprietarios;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.diego.cadastroveiculoseproprietarios.adapter.ProprietarioAdapter;
import com.example.diego.cadastroveiculoseproprietarios.adapter.VeiculoAdapter;
import com.example.diego.cadastroveiculoseproprietarios.model.Proprietario;
import com.example.diego.cadastroveiculoseproprietarios.model.Veiculo;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btn_VerProprietarios, btn_NovoVeiculo;
    private ArrayAdapter<Veiculo> adapter;

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

        btn_NovoVeiculo = (Button) findViewById(R.id.btn_NovoVeiculo);
        btn_NovoVeiculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, NovoVeiculo.class);
                startActivity(it);
            }
        });

        ListView lista = (ListView) findViewById(R.id.list_Veiculos);
        final ArrayList<Veiculo> veiculos;
        veiculos = (ArrayList<Veiculo>) Veiculo.listAll(Veiculo.class);
        ArrayAdapter adapter = new VeiculoAdapter(this, veiculos);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int i, long l) {
                //Toast.makeText(getBaseContext(), "Proprietario: "+proprietarios.get(i).getNome()+" selecionado com sucesso", Toast.LENGTH_SHORT).show();
            }
        });

        lista.setAdapter(adapter);
    }
}
