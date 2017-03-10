package com.example.diego.cadastroveiculoseproprietarios.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.diego.cadastroveiculoseproprietarios.R;
import com.example.diego.cadastroveiculoseproprietarios.model.Proprietario;

import java.util.ArrayList;

/**
 * Created by Diego on 10/03/2017.
 */

public class ProprietarioAdapter extends ArrayAdapter<Proprietario> {

    private final Context context;
    private final ArrayList<Proprietario> list;

    public ProprietarioAdapter(Context context, ArrayList<Proprietario> list){
        super(context, R.layout.linha_proprietario, list);
        this.context = context;
        this.list = list;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.linha_proprietario, parent, false);
        TextView nome = (TextView) rowView.findViewById(R.id.nome);
        TextView endereco = (TextView) rowView.findViewById(R.id.endereco);
        TextView telefone = (TextView) rowView.findViewById(R.id.telefone);
        TextView data = (TextView) rowView.findViewById(R.id.data);
        nome.setText(list.get(position).getNome());
        endereco.setText(list.get(position).getEndereco());
        telefone.setText(list.get(position).getTelefone());
        data.setText(list.get(position).getData());
        return rowView;
    }
}
