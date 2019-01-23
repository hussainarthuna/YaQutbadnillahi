package com.hussain.yaqutbadnillahi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class BundListActivity extends AppCompatActivity {

    private RecyclerView bundList;
    private BundListAdapter adapter;

    private List listOfBund;
    private String bund="Bund";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bund_list);


        listOfBund = new ArrayList();
        bundList=(RecyclerView)findViewById(R.id.bundlist);

        bundList.setLayoutManager(new LinearLayoutManager(this));




        addBund();

        Log.d("LIST",listOfBund.toString());

        adapter = new BundListAdapter(listOfBund,this);
        bundList.setAdapter(adapter);



    }

    private void addBund() {


        for(int i=0;i<35;i++){

            int bundNumber = i+1;

            // bund = bund.concat(String.valueOf(bundNumber));

            listOfBund.add(i,"Bund - ".concat(String.valueOf(bundNumber)));

        }
    }

}
