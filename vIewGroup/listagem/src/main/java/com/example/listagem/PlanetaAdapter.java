package com.example.listagem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class PlanetaAdapter extends ArrayAdapter<Planeta> {
    Context mContext;
    Integer mResouse;
    List<Planeta> planetas;


    public PlanetaAdapter(@NonNull Context context, int resource, @NonNull List<Planeta> objects) {
        super(context, resource, objects);
        mContext=context;
        mResouse=resource;
       planetas = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(mResouse,parent,false);

        //recuperar obejtio
        Planeta planeta = planetas.get(position);

        TextView tvnomeplaneta = view.findViewById(R.id.textView);
        ImageView imageView = view.findViewById(R.id.imageView);

        tvnomeplaneta.setText(planeta.nome);
        imageView.setImageResource(planeta.integer);

        return view;
    }
}
