package com.zevzikovas.aivaras.terraria.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.models.Flails;

import java.util.List;

public class FlailsListAdapter extends ArrayAdapter<Flails> {
    public FlailsListAdapter(Context context, int resource, List<Flails> flails) {
        super(context, resource, flails);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Flails flails = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.flails_list_item, parent, false);
        }

        if (flails != null) {
            TextView flailsName = convertView.findViewById(R.id.flailsName);
            ImageView flailsPicture = convertView.findViewById(R.id.flailsPicture);

            flailsName.setText(flails.name);
            flailsPicture.setImageResource(flails.picture);
        }

        return convertView;
    }

}


