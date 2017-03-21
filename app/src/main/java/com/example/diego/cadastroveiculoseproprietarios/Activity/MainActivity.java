package com.example.diego.cadastroveiculoseproprietarios.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.diego.cadastroveiculoseproprietarios.R;
import com.example.diego.cadastroveiculoseproprietarios.adapter.VeiculoAdapter;
import com.example.diego.cadastroveiculoseproprietarios.model.Veiculo;
import com.example.diego.cadastroveiculoseproprietarios.activity.VerProprietarios;

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
                finish();
            }
        });

        btn_NovoVeiculo = (Button) findViewById(R.id.btn_NovoVeiculo);
        btn_NovoVeiculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, NovoVeiculo.class);
                startActivity(it);
                finish();
            }
        });

        ListView lista = (ListView) findViewById(R.id.list_Veiculos);
        final ArrayList<Veiculo> veiculos;
        veiculos = (ArrayList<Veiculo>) Veiculo.listAll(Veiculo.class);
        ArrayAdapter adapter = new VeiculoAdapter(this, veiculos);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,EditarVeiculo.class);
                intent.putExtra("id", veiculos.get(i).getId().toString());
                intent.putExtra("proprietario",veiculos.get(i).getProprietario().getId().toString());

                startActivity(intent);
                finish();
            }
        });

        lista.setAdapter(adapter);
    }

    public void onBackPressed(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Sair da Aplicação?")
                .setCancelable(false)
                .setPositiveButton("Sim", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        finish();
                    }
                })
                .setNegativeButton("Não", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){}
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
