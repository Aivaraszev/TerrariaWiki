package com.zevzikovas.aivaras.terraria.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.models.Swords;

import java.util.List;

public class SwordsListAdapter extends ArrayAdapter<Swords> {
    public SwordsListAdapter(Context context, int resource, List<Swords> swords) {
        super(context, resource, swords);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Swords swords = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.swords_list_item, parent, false);
        }

        if (swords != null) {
            TextView swordsName = convertView.findViewById(R.id.itemName);
            ImageView swordsPicture = convertView.findViewById(R.id.itemPicture);

            swordsName.setText(swords.name);
            swordsPicture.setImageResource(swords.picture);
        }

        return convertView;
    }
}