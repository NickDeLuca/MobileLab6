package edu.temple.coloradapters;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class CanvasFragment extends Fragment {

    public static final String COLOR_KEY = "Color";
    View frameLayout;
    TextView tv;

    public CanvasFragment() {
        // Required empty public constructor
    }


    public static CanvasFragment newInstance(String color){
        CanvasFragment cf = new CanvasFragment();
        Bundle args = new Bundle();
        args.putString(COLOR_KEY, color);
        cf.setArguments(args);

        return cf;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_canvas, container, false);
        frameLayout = layout;

        TextView t = (TextView) layout.findViewById(R.id.text);
        tv = t;
        if(getArguments() != null){
            String color = getArguments().getString(COLOR_KEY);

            t.setText(color);

            if(color.equals("Blanco")){
                layout.setBackgroundColor(Color.parseColor("White"));
            }
            else if(color.equals("Rojo")){
                layout.setBackgroundColor(Color.parseColor("Red"));
            }
            else if(color.equals("Amarillo")){
                layout.setBackgroundColor(Color.parseColor("Yellow"));
            }
            else if(color.equals("Verde")){
                layout.setBackgroundColor(Color.parseColor("Green"));
            }
            else if(color.equals("Azul")){
                layout.setBackgroundColor(Color.parseColor("Blue"));
            }
            else{
                layout.setBackgroundColor(Color.parseColor(color));
            }
        }
        else{
            t.setText("No color selected.");
            layout.setBackgroundColor(Color.WHITE);
        }


        return layout;
    }

    public void changeColor(String color){

        tv.setText(color);
        if(color.equals("Blanco")){
            frameLayout.setBackgroundColor(Color.parseColor("White"));
        }
        else if(color.equals("Rojo")){
            frameLayout.setBackgroundColor(Color.parseColor("Red"));
        }
        else if(color.equals("Amarillo")){
            frameLayout.setBackgroundColor(Color.parseColor("Yellow"));
        }
        else if(color.equals("Verde")){
            frameLayout.setBackgroundColor(Color.parseColor("Green"));
        }
        else if(color.equals("Azul")){
            frameLayout.setBackgroundColor(Color.parseColor("Blue"));
        }
        else{
            frameLayout.setBackgroundColor(Color.parseColor(color));
        }
    }

}
