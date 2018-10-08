package com.example.a10016322.customlists;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView spinner;
    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList = new ArrayList<>();
        spinner = (ListView)(findViewById(R.id.listView));

        arrayList.add("Fred");
        arrayList.add("George");
        arrayList.add("Percy");
        arrayList.add("Bill");
        arrayList.add("Charlie");
        arrayList.add("Ron");
        arrayList.add("Ginny");

        CustomAdapter myAdapter = new CustomAdapter(this, R.layout.layout_spinner, arrayList);

        spinner.setAdapter(myAdapter);
        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast toast = Toast.makeText(MainActivity.this, "You have selected "+arrayList.get(position), Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    public class CustomAdapter extends ArrayAdapter {
        List list;
        Context mainContext;

        public CustomAdapter(Context context, int resource, List<String> objects) {
            super(context, resource, objects);
            list = objects; //this way we can use objects from list in main method
            mainContext = context;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater)mainContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            //use this b/c setContentView only works in main activity
            //without ContentView, xml file will not show
            View layoutView = inflater.inflate(R.layout.layout_spinner,null);
            TextView textView = (TextView)layoutView.findViewById(R.id.textView);
            ImageView imageView = (ImageView)layoutView.findViewById(R.id.imageView);

            textView.setText(list.get(position).toString());
            imageView.setImageResource(R.mipmap.ic_launcher);

            return layoutView;
        }
    }

}
