package com.zevzikovas.aivaras.terraria.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.models.Hswords;

import java.util.List;

public class HswordsListAdapter extends ArrayAdapter<Hswords> {
    public HswordsListAdapter(Context context, int resource, List<Hswords> hsword) {
        super(context, resource, hsword);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Hswords hswords = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.hswords_list_item, parent, false);
        }

        if (hswords != null) {
            TextView hswordsName = convertView.findViewById(R.id.hswordsName);
            ImageView hswordsPicture = convertView.findViewById(R.id.hswordsPicture);

            hswordsName.setText(hswords.name);
            hswordsPicture.setImageResource(hswords.picture);
        }

        return convertView;
    }

}


