package com.zevzikovas.aivaras.terraria.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.models.Bows;

import java.util.List;

public class BowsListAdapter extends ArrayAdapter<Bows> {
    public BowsListAdapter(Context context, int resource, List<Bows> bow) {
        super(context, resource, bow);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Bows bows = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.bows_list_item, parent, false);
        }

        if (bows != null) {
            TextView bowsName = convertView.findViewById(R.id.bowsName);
            ImageView bowsPicture = convertView.findViewById(R.id.bowsPicture);

            bowsName.setText(bows.name);
            bowsPicture.setImageResource(bows.picture);
        }

        return convertView;
    }

}