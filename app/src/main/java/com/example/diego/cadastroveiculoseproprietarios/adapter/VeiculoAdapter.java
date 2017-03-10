package com.example.diego.cadastroveiculoseproprietarios.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.diego.cadastroveiculoseproprietarios.R;
import com.example.diego.cadastroveiculoseproprietarios.model.Proprietario;
import com.example.diego.cadastroveiculoseproprietarios.model.Veiculo;

import java.util.ArrayList;

/**
 * Created by Diego on 10/03/2017.
 */

public class VeiculoAdapter extends ArrayAdapter<Veiculo> {

    private final Context context;
    private final ArrayList<Veiculo> list;

    public VeiculoAdapter(Context context, ArrayList<Veiculo> list){
        super(context, R.layout.linha_veiculo, list);
        this.context = context;
        this.list = list;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.linha_veiculo, parent, false);
        TextView modelo = (TextView) rowView.findViewById(R.id.modelo);
        TextView ano = (TextView) rowView.findViewById(R.id.ano);
        TextView placa = (TextView) rowView.findViewById(R.id.placa);
        TextView nome = (TextView) rowView.findViewById(R.id.nome);
        TextView telefone = (TextView) rowView.findViewById(R.id.telefone);
        modelo.setText(list.get(position).getModelo());
        ano.setText(list.get(position).getAno());
        placa.setText(list.get(position).getPlaca());

        //Proprietario proprietario = Proprietario.findById(Proprietario.class, list.get(position).getProprietario().getId());
        //nome.setText(list.get(position).getProprietario().getNome());
        //telefone.setText(proprietario.getTelefone());

        return rowView;
    }
}
