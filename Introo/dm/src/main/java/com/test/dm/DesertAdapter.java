package com.test.dm;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class DesertAdapter extends ArrayAdapter<Dessert> {

    private static final String LOG_TAG = DesertAdapter.class.getSimpleName();

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param desserts A List of Dessert objects to display in a list
     */
    public DesertAdapter(Activity context, ArrayList<Dessert> desserts) {

        super(context, 0, desserts);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Dessert currentDesert = getItem(position);
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