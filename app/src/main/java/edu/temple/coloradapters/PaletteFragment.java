package edu.temple.coloradapters;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 */
public class PaletteFragment extends Fragment {

    Spinner spinner;
    Context parent;

    public PaletteFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        this.parent = context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_palette, container, false);

        spinner = (Spinner) v.findViewById(R.id.spinner);
        Resources res = getResources();
        final String[] strings = res.getStringArray(R.array.color_array);

        CustomAdapter adapter = new CustomAdapter(parent, strings.length, strings);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            boolean firstSelection = true;
            @Override
            public void onItemSelected(AdapterView<?> parentView, View view, int i, long l) {
                if(!firstSelection){
                    String color = strings[i];
                    ((GetColorInterface) parent).colorSelected(color);
                }
                firstSelection = false;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        return v;
    }

    interface GetColorInterface{
        void colorSelected(String color);
    }

}
