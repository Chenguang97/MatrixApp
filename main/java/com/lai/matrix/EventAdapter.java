package com.lai.matrix;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class EventAdapter extends BaseAdapter {
    Context context;
    List<Event> eventData;

    public EventAdapter(Context context) {
        this.context = context;
        eventData = DataService.getEvent();
    }
    @Override
    public int getCount() {
        return eventData.size();
    }

    @Override
    public Object getItem(int i) {
        return eventData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        if (view == null) {
            LayoutInflater inflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.event_item, parent, false);
        }

        ImageView evetImg = (ImageView)view.findViewById(R.id.event_thumbnail);
        if (i % 2 == 1) {
            evetImg.setImageDrawable(context.getDrawable(R.drawable.water));
        } else {
            evetImg.setImageDrawable(context.getDrawable(R.drawable.event_thumbnail));
        }

        TextView eventTitle = (TextView)view.findViewById(R.id.event_title);
        TextView eventAddress = (TextView)view.findViewById(R.id.event_address);
        TextView eventDescription = (TextView)view.findViewById(R.id.event_description);

        Event r = eventData.get(i);
        eventTitle.setText(r.getTitle());
        eventAddress.setText(r.getAddress());
        eventDescription.setText(r.getDescription());
        return view;
    }
}
