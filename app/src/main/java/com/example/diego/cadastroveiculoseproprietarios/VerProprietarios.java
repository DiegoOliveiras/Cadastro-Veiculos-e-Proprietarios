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
import com.example.diego.cadastroveiculoseproprietarios.model.Proprietario;

import java.util.ArrayList;
import java.util.List;

public class VerProprietarios extends AppCompatActivity {

    private Button btn_NovoProprietario;
    private ArrayAdapter<Proprietario> adapter;
    private Proprietario p = new Proprietario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_proprietarios);

        btn_NovoProprietario = (Button) findViewById(R.id.btn_NovoProprietario);
        btn_NovoProprietario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(VerProprietarios.this, NovoProprietario.class);
                startActivity(it);
            }
        });

        ListView lista = (ListView) findViewById(R.id.list_Proprietarios);
        final ArrayList<Proprietario> proprietarios;
        proprietarios = (ArrayList<Proprietario>) Proprietario.listAll(Proprietario.class);
        ArrayAdapter adapter = new ProprietarioAdapter(this, proprietarios);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int i, long l) {
                Toast.makeText(getBaseContext(), "Proprietario: "+proprietarios.get(i).getNome(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        lista.setAdapter(adapter);

    }
}
