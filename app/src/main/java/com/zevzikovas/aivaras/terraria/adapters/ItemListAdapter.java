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

public class ItemListAdapter extends ArrayAdapter<Swords> {
    public ItemListAdapter(Context context, int resource, List<Swords> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Swords item = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_list_item, parent, false);
        }

        if (item != null) {
            TextView itemName = convertView.findViewById(R.id.itemName);
            TextView itemDamage = convertView.findViewById(R.id.hswordsDamage);
            ImageView itemPicture = convertView.findViewById(R.id.itemPicture);

            itemName.setText(item.name);
            itemPicture.setImageResource(item.picture);
        }

        return convertView;
    }
}
