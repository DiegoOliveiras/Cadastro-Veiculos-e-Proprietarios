package com.example.diego.cadastroveiculoseproprietarios.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.diego.cadastroveiculoseproprietarios.R;
import com.example.diego.cadastroveiculoseproprietarios.model.Proprietario;
import com.example.diego.cadastroveiculoseproprietarios.model.Veiculo;

public class EditarVeiculo extends AppCompatActivity {

    private EditText edt_Modelo, edt_Ano, edt_Placa, edt_Nome, edt_Telefone, edt_Endereco, edt_Data;
    private Button btn_Salvar, btn_Apagar;
    private int idv, idp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_veiculo);

        Intent intent    = getIntent();

        idv = Integer.parseInt((String)intent.getSerializableExtra("id"));
        idp = Integer.parseInt((String)intent.getSerializableExtra("proprietario"));

        Veiculo v = Veiculo.findById(Veiculo.class, idv);
        Proprietario p = Proprietario.findById(Proprietario.class, idp);

        edt_Nome = (EditText) findViewById(R.id.edt_Nome);
        edt_Telefone = (EditText) findViewById(R.id.edt_Telefone);
        edt_Endereco = (EditText) findViewById(R.id.edt_Endereco);
        edt_Data = (EditText) findViewById(R.id.edt_Data);

        if (p == null){
            Toast.makeText(getApplicationContext(), "Proprietario inexistente!", Toast.LENGTH_SHORT).show();
        }
        else{
            edt_Nome.setText(p.getNome());
            edt_Telefone.setText(p.getTelefone());
            edt_Endereco.setText(p.getEndereco());
            edt_Data.setText(p.getData());
        }

        edt_Modelo = (EditText) findViewById(R.id.edt_Modelo);
        edt_Modelo.setText(v.getModelo());

        edt_Ano = (EditText) findViewById(R.id.edt_Ano);
        edt_Ano.setText(v.getAno());

        edt_Placa = (EditText) findViewById(R.id.edt_Placa);
        edt_Placa.setText(v.getPlaca());

        btn_Salvar = (Button) findViewById(R.id.btn_Salvar);
        btn_Salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(EditarVeiculo.this);
                builder.setMessage("Alterar Veículo?")
                        .setCancelable(false)
                        .setPositiveButton("Sim", new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int id){
                                Proprietario p = Proprietario.findById(Proprietario.class, idp);

                                p.setNome(edt_Nome.getText().toString());
                                p.setEndereco(edt_Endereco.getText().toString());
                                p.setData(edt_Data.getText().toString());
                                p.setTelefone(edt_Telefone.getText().toString());

                                p.save();

                                Veiculo v = Veiculo.findById(Veiculo.class, idv);

                                v.setAno(edt_Ano.getText().toString());
                                v.setModelo(edt_Modelo.getText().toString());
                                v.setPlaca(edt_Placa.getText().toString());
                                v.setProprietario(p);

                                v.save();

                                Toast.makeText(getBaseContext(), "Veículo Alterado!", Toast.LENGTH_LONG).show();
                                Intent it = new Intent(EditarVeiculo.this, MainActivity.class);
                                startActivity(it);
                                finish();
                            }
                        })
                        .setNegativeButton("Não", new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int id){}
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        btn_Apagar = (Button) findViewById(R.id.btn_Apagar);
        btn_Apagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(EditarVeiculo.this);
                builder.setMessage("Deletar Veículo?")
                        .setCancelable(false)
                        .setPositiveButton("Sim", new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int id){
                                Veiculo v = Veiculo.findById(Veiculo.class, idv);
                                v.delete();

                                Toast.makeText(getBaseContext(), "Veiculo Deletado", Toast.LENGTH_LONG).show();

                                Intent it = new Intent(EditarVeiculo.this, MainActivity.class);
                                startActivity(it);
                                finish();
                            }
                        })
                        .setNegativeButton("Não", new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int id){}
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }

    public void onBackPressed(){
        Intent intent = new Intent(EditarVeiculo.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
