package com.example.retrofitpractise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

class CustomAdapter extends BaseAdapter {
    String[] country;
    Context context;
    String[] capital;
    TextView textView, view;
    private LayoutInflater layoutInflater;
    public CustomAdapter(Context context, String[] countryName, String[] capitalName) {
        this.context = context;
        this.country = countryName;
        this.capital = capitalName;
    }

    @Override
    public int getCount() {
        return country.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.view, parent, false);
            Toast.makeText(context, "Enter", Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(context, "false", Toast.LENGTH_SHORT).show();

        }
        textView = convertView.findViewById(R.id.viewtv);
        view = convertView.findViewById(R.id.viewtv1);
        textView.setText(country[position]);
        view.setText(capital[position]);
        Toast.makeText(context, "Enter2", Toast.LENGTH_SHORT).show();
        return convertView;
    }
}
