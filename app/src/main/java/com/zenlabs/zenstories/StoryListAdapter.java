package com.zenlabs.zenstories;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class StoryListAdapter extends BaseRecyclerAdapter<StoryData, StoryListAdapter.ViewHolder> {

    public StoryListAdapter(Context context, List<StoryData> objects, OnRecyclerViewInteractionListener listener) {
        super(context, objects, listener);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.story_list_row, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StoryData storyData = getItem(position);
        holder.storyTitle.setText(storyData.getTitle());

        holder.storyTitle.setTag(position);
        holder.storyTitle.setOnClickListener(this);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView storyTitle;

        ViewHolder(View itemView) {
            super(itemView);
            storyTitle = itemView.findViewById(R.id.story_title_text);
        }
    }
}
