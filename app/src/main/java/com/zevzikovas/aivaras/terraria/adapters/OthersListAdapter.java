package com.zevzikovas.aivaras.terraria.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.models.Others;

import java.util.List;

public class OthersListAdapter extends ArrayAdapter<Others> {
    public OthersListAdapter(Context context, int resource, List<Others> other) {
        super(context, resource, other);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Others others = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.hswords_list_item, parent, false);
        }

        if (others != null) {
            TextView othersName = convertView.findViewById(R.id.othersName);
            ImageView othersPicture = convertView.findViewById(R.id.othersPicture);

            othersName.setText(others.name);
            othersPicture.setImageResource(others.picture);
        }

        return convertView;
    }

}


