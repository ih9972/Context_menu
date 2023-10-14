package com.example.contextmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity implements View.OnCreateContextMenuListener{
    String type_of_series;
    double a1,d,sn;
    ListView listV;
    TextView info_display;
    int position;
    ArrayAdapter<Double> adp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        info_display = (TextView) findViewById(R.id.info);
        listV = findViewById(R.id.listV);

        Intent gi = getIntent();
        type_of_series = gi.getStringExtra("type_series");
        a1 = gi.getDoubleExtra("a1",-999999);
        d = gi.getDoubleExtra("d",-999999);
        Double[] arry = new Double[20];
        if (type_of_series.equals("arithmetic")){
            for (int i = 0; i < arry.length; i++) {
                arry[i] = a1 + (i * d);
            }
        }
        else{
            for (int i = 0; i < arry.length; i++) {
                arry[i] = a1 * Math.pow(d,(i));
            }
        }
        ArrayAdapter<Double> adp = new ArrayAdapter<Double>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arry);
        listV.setAdapter(adp);
        registerForContextMenu(listV);
    }

    /**
     * Called when the dropdown item is clicked
     * @param menu The context menu that is being built
     * @param v The view for which the context menu is being built
     * @param info Extra information about the item for which the
     *            context menu should be shown. This information will vary
     *            depending on the class of v.
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,ContextMenu.ContextMenuInfo info) {
        AdapterView.AdapterContextMenuInfo infoInfo = (AdapterView.AdapterContextMenuInfo) info;
        position = infoInfo.position;
        menu.setHeaderTitle("Info");
        menu.add("N sum");
        menu.add("N");
    }

    public boolean onContextItemSelected(MenuItem item) {
        String oper=item.getTitle().toString();
        if (oper.equals("N sum")){
            if(type_of_series.equals("arithmetic")){
                sn=((2*a1+(d*position))*(position+1))/2;
            }
            else {
                if (d==1){
                    sn = (position+1)*a1;
                }
                else{
                    sn = a1*((Math.pow(d,(position+1))-1)/(d-1));
                }
            }
            info_display.setText(""+sn);

        }
        else{
            info_display.setText(""+(position+1));
        }
        return true;
    }

    public void movetocradit(View view) {
        Intent si2 = new Intent(this, MainActivity3.class);
        startActivity(si2);
    }
}
