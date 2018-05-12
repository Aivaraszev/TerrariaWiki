package com.zevzikovas.aivaras.terraria.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.models.HBows;

import java.util.List;

public class HBowsListAdapter extends ArrayAdapter<HBows> {
    public HBowsListAdapter(Context context, int resource, List<HBows> hbows) {
        super(context, resource, hbows);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HBows hbows = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.hbows_list_item, parent, false);
        }

        if (hbows != null) {
            TextView hbowsName = convertView.findViewById(R.id.hbowsName);
            ImageView hbowsPicture = convertView.findViewById(R.id.hbowsPicture);

            hbowsName.setText(hbows.name);
            hbowsPicture.setImageResource(hbows.picture);
        }

        return convertView;
    }

}


