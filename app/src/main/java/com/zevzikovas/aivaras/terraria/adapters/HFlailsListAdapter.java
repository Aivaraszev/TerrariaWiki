package com.zevzikovas.aivaras.terraria.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.models.HFlails;

import java.util.List;

public class HFlailsListAdapter extends ArrayAdapter<HFlails> {
    public HFlailsListAdapter(Context context, int resource, List<HFlails> hflails) {
        super(context, resource, hflails);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HFlails hflails = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.hflails_list_item, parent, false);
        }

        if (hflails != null) {
            TextView hflailsName = convertView.findViewById(R.id.hflailsName);
            ImageView hflailsPicture = convertView.findViewById(R.id.hflailsPicture);

            hflailsName.setText(hflails.name);
            hflailsPicture.setImageResource(hflails.picture);
        }

        return convertView;
    }

}


