package com.example.stevtymez.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class list extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView=findViewById(R.id.list);

        final ArrayList<String>arrayList=new ArrayList<>();
        arrayList.add("canvas");
        arrayList.add("caps");
        arrayList.add("sandals");
        arrayList.add("blezars");
        arrayList.add("trousers");
        arrayList.add("bags");
        arrayList.add("jacket");
        arrayList.add("shirt");
        arrayList.add("T-shirt");
        arrayList.add("handbags");
        arrayList.add("neckless");
        arrayList.add("tops");

        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(list.this,"clicked item:"+1+""+arrayList.get(1).toString(),Toast.LENGTH_SHORT).show();
            }
        });

    }
}
