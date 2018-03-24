package com.zenlabs.zenstories;


import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class AboutFragment extends Fragment {
    TextView link;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.about_fragement, container, false);
        link=view.findViewById(R.id.link);
        setupViews();
        return view;
    }

    private void setupViews() {
        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChromeTab("https://goo.gl/forms/lXeJup5Jsok7PzHc2");
            }
        });

    }

    public void openChromeTab(String url) {
        if (!TextUtils.isEmpty(url)) {
            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
            CustomTabsIntent customTabsIntent = builder.build();
            customTabsIntent.launchUrl(getActivity(), Uri.parse(url));
        }
    }

}
