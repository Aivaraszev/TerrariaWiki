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

    public class HswordListAdapter  extends ArrayAdapter<hsword> {
        public HswordListAdapter(Context context, int resource, List<hsword> hsword) {
            super(context, resource, hsword);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Hswords hsword = getHsword(position);

            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.hsword_list_hsword, parent, false);
            }

            if (hsword != null) {
                TextView hswordName = convertView.findViewById(R.id.hswordName);
                ImageView hswordPicture = convertView.findViewById(R.id.hswordPicture);

                hswordName.setText(hsword.name);
                hswordPicture.setImageResource(hsword.picture);
            }

            return convertView;
        }
    }

}
