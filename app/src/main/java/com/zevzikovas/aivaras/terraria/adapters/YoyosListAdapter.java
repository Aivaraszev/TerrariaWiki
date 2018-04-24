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
            TextView yoyosName = convertView.findViewById(R.id.yoyosName);
            ImageView yoyosPicture = convertView.findViewById(R.id.yoyosPicture);

            yoyosName.setText(yoyos.name);
            yoyosPicture.setImageResource(yoyos.picture);
        }

        return convertView;
    }

}


