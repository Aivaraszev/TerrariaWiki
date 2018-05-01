package com.zevzikovas.aivaras.terraria.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.models.Spears;

import java.util.List;

public class SpearsListAdapter extends ArrayAdapter<Spears> {
    public SpearsListAdapter(Context context, int resource, List<Spears> spears) {
        super(context, resource, spears);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Spears spears = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.spears_list_item, parent, false);
        }

        if (spears != null) {
            TextView spearsName = convertView.findViewById(R.id.spearsName);
            ImageView spearsPicture = convertView.findViewById(R.id.spearsPicture);

            spearsName.setText(spears.name);
            spearsPicture.setImageResource(spears.picture);
        }

        return convertView;
    }
}