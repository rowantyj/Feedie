package com.jabber.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.jabber.R;

/**
 * Created by rowantan on 10/19/14.
 */
public class DetailTabAdapter extends ArrayAdapter<String>{


    private final Context ctx;
    private final int list;

    public DetailTabAdapter(Context ctx, int list) {
        super(ctx, list);
        this.ctx = ctx;
        this.list = list;
    }

    /**
     * {@inheritDoc}
     *
     * @param position
     * @param convertView
     * @param parent
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.fragment_detail_tab, parent, false);

        TextView detail = (TextView) convertView.findViewById(R.id.topic_detailTV);



        //get detail content from PHP-JSON script
        String detailText = list + "";
        detail.setText(detailText);


        return super.getView(position, convertView, parent);
    }
}
