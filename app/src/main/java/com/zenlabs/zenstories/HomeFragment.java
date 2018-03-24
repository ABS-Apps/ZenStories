package com.zenlabs.zenstories;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static com.zenlabs.zenstories.ZenConstants.ARGS_DATA;

public class HomeFragment extends Fragment {

    TextView listBtn;
    TextView ranBtn;
    TextView aboutBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        listBtn = view.findViewById(R.id.list_button);
        ranBtn = view.findViewById(R.id.random_button);
        aboutBtn = view.findViewById(R.id.about_button);
        setupViews();
        return view;
    }

    private void setupViews() {
        ranBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StoryFragment storyFragment = new StoryFragment();
                Bundle args = new Bundle();
                StoryData storyData = new StoryData("title", 1, "story");
                args.putSerializable(ARGS_DATA, storyData);
                storyFragment.setArguments(args);
                ((MainActivity) getActivity()).addFragment(storyFragment);
            }
        });
        aboutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AboutFragment aboutFragment = new AboutFragment();
                ((MainActivity) getActivity()).addFragment(aboutFragment);
            }
        });
        listBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).addFragment(new StoryListFragment());
            }
        });

    }

}
