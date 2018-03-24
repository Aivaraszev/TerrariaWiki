package com.zevzikovas.aivaras.terraria.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.models.Item;

import java.util.List;

public class ItemListAdapter extends ArrayAdapter<Item> {
    public ItemListAdapter(Context context, int resource, List<Item> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Item item = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_list_item, parent, false);
        }

        if (item != null) {
            TextView itemName = convertView.findViewById(R.id.itemName);
            ImageView itemPicture = convertView.findViewById(R.id.itemPicture);

            itemName.setText(item.name);
            itemPicture.setImageResource(item.picture);
        }

        return convertView;
    }
}
