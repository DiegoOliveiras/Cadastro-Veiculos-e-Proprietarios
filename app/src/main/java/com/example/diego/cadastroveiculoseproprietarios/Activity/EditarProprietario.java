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

public class EditarProprietario extends AppCompatActivity {

    private EditText edt_Nome, edt_Telefone, edt_Endereco, edt_Data;
    private Button btn_Salvar, btn_Deletar;
    private int idp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_proprietario);
        Intent intent = getIntent();

        idp = Integer.parseInt((String)intent.getSerializableExtra("id"));

        Proprietario p = Proprietario.findById(Proprietario.class, idp);

        edt_Nome = (EditText) findViewById(R.id.edt_Nome);
        edt_Nome.setText(p.getNome());

        edt_Telefone = (EditText) findViewById(R.id.edt_Telefone);
        edt_Telefone.setText(p.getTelefone());

        edt_Endereco = (EditText) findViewById(R.id.edt_Endereco);
        edt_Endereco.setText(p.getEndereco());

        edt_Data = (EditText) findViewById(R.id.edt_Data);
        edt_Data.setText(p.getData());

        btn_Salvar = (Button) findViewById(R.id.btn_Salvar);
        btn_Salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(EditarProprietario.this);
                builder.setMessage("Alterar Proprietário?")
                        .setCancelable(false)
                        .setPositiveButton("Sim", new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int id){
                                Proprietario p = Proprietario.findById(Proprietario.class, idp);

                                p.setNome(edt_Nome.getText().toString());
                                p.setEndereco(edt_Endereco.getText().toString());
                                p.setData(edt_Data.getText().toString());
                                p.setTelefone(edt_Telefone.getText().toString());

                                p.save();

                                Toast.makeText(getBaseContext(), "Proprietário Alterado!", Toast.LENGTH_LONG).show();
                                Intent it = new Intent(EditarProprietario.this, VerProprietarios.class);
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

        btn_Deletar = (Button) findViewById(R.id.btn_Deletar);
        btn_Deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(EditarProprietario.this);
                builder.setMessage("Deletar Proprietário?")
                        .setCancelable(false)
                        .setPositiveButton("Sim", new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int id){
                                Proprietario p = Proprietario.findById(Proprietario.class, idp);
                                p.delete();

                                Toast.makeText(getBaseContext(), "Proprietário Deletado!", Toast.LENGTH_LONG).show();

                                Intent it = new Intent(EditarProprietario.this, VerProprietarios.class);
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
        Intent intent = new Intent(EditarProprietario.this, VerProprietarios.class);
        startActivity(intent);
        finish();
    }
}
