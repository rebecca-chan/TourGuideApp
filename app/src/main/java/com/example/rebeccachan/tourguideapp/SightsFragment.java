package com.example.rebeccachan.tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass that displays an ArrayList of Sights.
 *
 */
public class SightsFragment extends Fragment {

    // Creates keys for ListView item data
    public static final String KEY_NAME = "KEY_NAME";
    public static final String KEY_LOCATION = "KEY_LOCATION";
    public static final String KEY_DETAILS = "KEY_DETAILS";
    public static final String KEY_DESCRIPTION = "KEY_DESCRIPTION";
    public static final String KEY_DRAWABLE = "KEY_DRAWABLE";

    public SightsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_list, container, false);

        // Creates a list of restaurants
        final ArrayList<Details> details = new ArrayList<Details>();
        details.add(new Details(getContext().getString(R.string.pepsicola_name),
                getContext().getString(R.string.pepsicola_detail), R.drawable.pepsicola,
                getContext().getString(R.string.pepsicola_description), getContext().getString(R.string.pepsicola_location)));
        details.add(new Details(getContext().getString(R.string.noguchi_name),
                getContext().getString(R.string.noguchi_detail), R.drawable.noguchi,
                getContext().getString(R.string.noguchi_description), getContext().getString(R.string.noguchi_location)));
        details.add(new Details(getContext().getString(R.string.ps1_name),
                getContext().getString(R.string.ps1_detail), R.drawable.ps1,
                getContext().getString(R.string.ps1_description), getContext().getString(R.string.ps1_location)));

        // Create an {@link InfoAdapter} and populates with data sourced from {@link Details}.
        DetailsAdapter adapter = new DetailsAdapter(getActivity(), details);

        // Finds the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There is a view ID called list in the list_view.xml file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Sets the {@link ListView} to use the {@link Details} to display list items for each {@link Details} object.
        listView.setAdapter(adapter);

        // Sets an onItemClickListener(), gets the position of clicked item, and calls an explicit intent.
        // Extras sent to the {@link DetailsActivity} include all {@link Details} object data, except for distance.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Details item = details.get(position);
                Intent details = new Intent(getContext(), DetailsActivity.class);
                details.putExtra(KEY_NAME, item.getName());
                details.putExtra(KEY_LOCATION, item.getLocation());
                details.putExtra(KEY_DETAILS, item.getDetails());
                details.putExtra(KEY_DESCRIPTION, item.getDescription());
                details.putExtra(KEY_DRAWABLE, item.getImageResourceId());
                startActivity(details);
            }
        });

        return rootView;
    }
}