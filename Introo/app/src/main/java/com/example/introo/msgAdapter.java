package com.example.introo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

    public class msgAdapter extends ArrayAdapter<msg> {

        private static final String LOG_TAG = msgAdapter.class.getSimpleName();

        /**
         * This is our own custom constructor (it doesn't mirror a superclass constructor).
         * The context is used to inflate the layout file, and the list is the data we want
         * to populate into the lists.
         *
         * @param context        The current context. Used to inflate the layout file.
         * @param desserts A List of Dessert objects to display in a list
         */
        public msgAdapter(msg_main context, ArrayList<msg> desserts) {

            super(context, 0, desserts);
        }

        public msgAdapter(@NonNull Context context, int resource) {
            super(context, resource);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View listItemView = convertView;
            if(listItemView == null) {
                listItemView = LayoutInflater.from(getContext()).inflate(
                        R.layout.list_items, parent, false);
            }

            msg currentDesert = getItem(position);
            TextView nameTextView = (TextView) listItemView.findViewById(R.id.dessert_name);
            assert currentDesert != null;
            nameTextView.setText(currentDesert.getDessertName());
            TextView numberTextView = (TextView) listItemView.findViewById(R.id.dessert_number);
            numberTextView.setText(String.valueOf(currentDesert.getDessertNumber()));

            ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
            iconView.setImageResource(currentDesert.getImageResourceId());

            return listItemView;
        }
    }
