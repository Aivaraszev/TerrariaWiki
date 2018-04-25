package com.zevzikovas.aivaras.terraria.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zevzikovas.aivaras.terraria.R;

import com.zevzikovas.aivaras.terraria.models.HYoyos;

import java.util.List;

public class HYoyosListAdapter extends ArrayAdapter<HYoyos> {
    public HYoyosListAdapter(Context context, int resource, List<HYoyos> hyoyo) {
        super(context, resource, hyoyo);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HYoyos hyoyos = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.hyoyos_list_item, parent, false);
        }

        if (hyoyos != null) {
            TextView hyoyosName = convertView.findViewById(R.id.hyoyosName);
            ImageView hyoyosPicture = convertView.findViewById(R.id.hyoyosPicture);

            hyoyosName.setText(hyoyos.name);
            hyoyosPicture.setImageResource(hyoyos.picture);
        }

        return convertView;
    }

}


