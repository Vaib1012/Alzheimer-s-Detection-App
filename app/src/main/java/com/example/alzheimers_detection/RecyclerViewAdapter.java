package com.example.alzheimers_detection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views
class RecyclerViewAdapter extends
        RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

        // ... view holder defined above...

        // Store a member variable for the contacts
        private List<Element> scoreList;

        // Pass in the contact array into the constructor
        public RecyclerViewAdapter(List<Element> scoreList) {
            this.scoreList = scoreList;
        }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView scoretv;
        public TextView datetv;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            datetv = (TextView) itemView.findViewById(R.id.datefield) ;
            scoretv = (TextView) itemView.findViewById(R.id.scoretv);

           //TextView nameTextView = (TextView) itemView.findViewById(R.id.contact_name);
            //Button messageButton = (Button) itemView.findViewById(R.id.message_button);
        }
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.recyclerview_row, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Get the data model based on position
        Element element = scoreList.get(position);

        // Set item views based on your views and data model
        TextView scoretv = holder.scoretv;
        TextView datetv = holder.datetv;
        scoretv.setText(element.getScore());
        datetv.setText(element.getDate());
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return scoreList.size();
    }
}