package edu.temple.coloradapters;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;


public class PaletteActivity extends Activity implements PaletteFragment.GetColorInterface{

    Spinner spinner;

    FragmentManager fm;
    CanvasFragment cf;
    String previousColor = "";

    boolean singlePane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        singlePane = findViewById(R.id.container2) == null;


        fm = getFragmentManager();
        fm.beginTransaction()
                .replace(R.id.container1, new PaletteFragment())
                .commit();
        if(!singlePane){
            cf = new CanvasFragment();
            fm.beginTransaction()
                    .replace(R.id.container2, cf)
                    .commit();

        }

    }

    @Override
    public void colorSelected(String color){

        if(singlePane){
            if(!color.equals(previousColor)){
                CanvasFragment cf = CanvasFragment.newInstance(color);
                fm.beginTransaction()
                        .replace(R.id.container1, cf)
                        .addToBackStack(null)
                        .commit();
                previousColor = color;
            }

        }
        else{
            cf.changeColor(color);
        }

    }
}
