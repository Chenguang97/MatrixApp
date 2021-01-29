package com.lai.matrix;


import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CommentFragment extends Fragment {
    private GridView gridView;


    public CommentFragment() {
        // Required empty public constructor
    }


    public static CommentFragment newInstance(int position) {

        Bundle args = new Bundle();
        args.putInt("position", position);
        CommentFragment fragment = new CommentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        Bundle bundle = getArguments();
        if (bundle != null) {
            final int position = (int) bundle.get("position");
            gridView.post(new Runnable() {//为了把当前我点的那个东西第几个，传给下个fragment
                @Override
                public void run() {
                    onItemSelected(position);
                }
            });
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comment, container, false);
        gridView = (GridView)view.findViewById(R.id.comment_grid);
        gridView.setAdapter(new EventAdapter(getActivity()));
        return view;
    }

    public void onItemSelected(int position) {
        for (int i = 0; i < gridView.getChildCount(); i++) {
            if (position == i) {
                gridView.getChildAt(i).setBackgroundColor(Color.BLUE);
            } else {
                gridView.getChildAt(i).setBackgroundColor(Color.parseColor("#FAFAFA"));
            }
        }
    }

}
