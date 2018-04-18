package com.zevzikovas.aivaras.terraria.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.models.Pickaxes;

import java.util.List;

public class PickaxesListAdapter extends ArrayAdapter<Pickaxes> {
    public PickaxesListAdapter(Context context, int resource, List<Pickaxes> pickaxe) {
        super(context, resource, pickaxes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Pickaxes pickaxes = getPickaxes(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.pickaxes_list_item, parent, false);
        }

        if (pickaxes != null) {
            TextView pickaxesName = convertView.findViewById(R.id.pickaxesName);
            TextView pickaxesDamage = convertView.findViewById(R.id.pickaxesDamage);
            ImageView pickaxesPicture = convertView.findViewById(R.id.pickaxesPicture);

            pickaxesName.setText(pickaxes.name);
            pickaxesPicture.setImageResource(pickaxes.picture);
        }

        return convertView;
    }
}