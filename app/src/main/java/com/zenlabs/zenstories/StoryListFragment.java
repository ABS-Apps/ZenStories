package com.zenlabs.zenstories;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StoryListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StoryListFragment extends Fragment {

    RecyclerView recyclerView;
    StoryListAdapter adapter;
    ArrayList<StoryData> storyListData;

    public StoryListFragment() {
        // Required empty public constructor
    }

    public static StoryListFragment newInstance() {
        StoryListFragment fragment = new StoryListFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.story_fragment, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        parseData();
        setupRecyclerView();
        return view;
    }

    private void parseData() {

    }

    private void setupRecyclerView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);

        adapter = new StoryListAdapter(getActivity(), storyListData, new BaseRecyclerAdapter.OnRecyclerViewInteractionListener() {
            @Override
            public void onClick(View view) {
                int clickedPosition = (int) view.getTag();
                switch (view.getId()) {
                    case R.id.title_text:
                        goToStoryFragment(clickedPosition);
                        break;
                    default:
                        break;
                }
            }
        });
        recyclerView.setAdapter(adapter);
    }

    private void goToStoryFragment(int clickedPosition) {
        StoryFragment fragment = new StoryFragment();
        Bundle args = new Bundle();
        args.putSerializable("STORY", storyListData.get(clickedPosition));
        fragment.setArguments(args);
        ((MainActivity) getActivity()).addFragment(fragment);
    }

}
