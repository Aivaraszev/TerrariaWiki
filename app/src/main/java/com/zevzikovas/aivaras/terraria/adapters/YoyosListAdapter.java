package com.zevzikovas.aivaras.terraria.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zevzikovas.aivaras.terraria.R;

import com.zevzikovas.aivaras.terraria.models.Yoyos;

import java.util.List;

public class YoyosListAdapter extends ArrayAdapter<Yoyos> {
    public YoyosListAdapter(Context context, int resource, List<Yoyos> yoyo) {
        super(context, resource, yoyo);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Yoyos yoyos = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.yoyos_list_item, parent, false);
        }

        if (yoyos != null) {
            TextView hswordsName = convertView.findViewById(R.id.hswordsName);
            ImageView hswordsPicture = convertView.findViewById(R.id.hswordsPicture);

            hswordsName.setText(yoyos.name);
            hswordsPicture.setImageResource(yoyos.picture);
        }

        return convertView;
    }

}


