package com.jabber.topicline;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.jabber.R;

import java.util.ArrayList;

public class TopicLineAdapter extends ArrayAdapter<Topic> {

    private final Context context;
    private final ArrayList<Topic> topicList;
    private TextView title;
    private TextView desc;

    public TopicLineAdapter(Context context, ArrayList<Topic> topicList) {
        super(context, R.layout.custom_topicline_list, topicList);
        this.context = context;
        this.topicList = topicList;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        rowView = inflater.inflate(R.layout.custom_topicline_list, parent,
                false);
        title = (TextView) rowView.findViewById(R.id.titleTV);
        desc = (TextView) rowView.findViewById(R.id.descTV);

        // Setting Values...
        title.setText(topicList.get(position).getTitle());
        desc.setText(topicList.get(position).getDesc());

        return rowView;

    }

}