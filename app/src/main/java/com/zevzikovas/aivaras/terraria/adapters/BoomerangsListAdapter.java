package com.zevzikovas.aivaras.terraria.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.models.Boomerangs;

import java.util.List;

public class BoomerangsListAdapter extends ArrayAdapter<Boomerangs> {
    public BoomerangsListAdapter(Context context, int resource, List<Boomerangs> boomerang) {
        super(context, resource, boomerang);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Boomerangs boomerangs = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.boomerangs_list_item, parent, false);
        }

        if (boomerangs != null) {
            TextView boomerangsName = convertView.findViewById(R.id.boomerangsName);
            ImageView boomerangsPicture = convertView.findViewById(R.id.boomerangsPicture);

            boomerangsName.setText(boomerangs.name);
            boomerangsPicture.setImageResource(boomerangs.picture);
        }

        return convertView;
    }

}