package com.assignment.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemClickListener;

import com.assignment.MainActivity;
import com.assignment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends ListFragment implements OnItemClickListener {
    private final String TAG = MenuFragment.class.toString();
    MainActivity listener;

    public MenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // get activity and type cast to MainActivity
        listener = (MainActivity) getActivity();
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.fragment_List, android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
        // get the list view and set itemclick listener.
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView <?> parent, View view, int position, long id) {
        // when user click on list item then call MainActivity onMenuItemClick method
        listener.onMenuItemClick(position + 1);
    }
}
