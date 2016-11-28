package com.example.gener_000.parkingproject;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class UsageGraph extends AppCompatActivity {

    LineGraphSeries<DataPoint> series;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usage_graph);
        Button go_to_map_from_graph = (Button)findViewById(R.id.go_to_map_from_graph_page);
        go_to_map_from_graph.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UsageGraph.this, Google_Maps_Page.class));
            }
        });

        Button go_to_report_from_graph = (Button) findViewById(R.id.go_to_report_from_graph_page);
        go_to_report_from_graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UsageGraph.this,MainActivity.class));
            }
        });
    }
}
