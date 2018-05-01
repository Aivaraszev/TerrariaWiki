package com.zevzikovas.aivaras.terraria.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.models.HBoomerangs;

import java.util.List;

public class HBoomerangsListAdapter extends ArrayAdapter<HBoomerangs> {
    public HBoomerangsListAdapter(Context context, int resource, List<HBoomerangs> hboomerangs) {
        super(context, resource, hboomerangs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HBoomerangs hboomerangs = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.hboomerangs_list_item, parent, false);
        }

        if (hboomerangs != null) {
            TextView hboomerangsName = convertView.findViewById(R.id.hboomerangsName);
            ImageView hboomerangsPicture = convertView.findViewById(R.id.hboomerangsPicture);

            hboomerangsName.setText(hboomerangs.name);
            hboomerangsPicture.setImageResource(hboomerangs.picture);
        }

        return convertView;
    }

}


