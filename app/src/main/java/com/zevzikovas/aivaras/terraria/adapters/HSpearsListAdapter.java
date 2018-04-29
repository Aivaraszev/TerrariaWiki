package com.zevzikovas.aivaras.terraria.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.models.HSpears;

import java.util.List;

public class HSpearsListAdapter extends ArrayAdapter<HSpears> {
    public HSpearsListAdapter(Context context, int resource, List<HSpears> hspears) {
        super(context, resource, hspears);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HSpears hspears = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.hspears_list_item, parent, false);
        }

        if (hspears != null) {
            TextView hspearsName = convertView.findViewById(R.id.hspearsName);
            ImageView hspearsPicture = convertView.findViewById(R.id.hspearsPicture);

            hspearsName.setText(hspears.name);
            hspearsPicture.setImageResource(hspears.picture);
        }

        return convertView;
    }

}


