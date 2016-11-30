package com.example.gener_000.parkingproject;

import android.content.Intent;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class UsageGraph extends AppCompatActivity {

    BarChart barChart; // Bar chart object
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usage_graph);

        barChart = (BarChart) findViewById(R.id.bar_graph);

        // Y-axis data
        ArrayList<BarEntry> yEntries = new ArrayList<>();

        // X-axis data
        ArrayList<String> parkingLotNames = new ArrayList<>();

        GetLotsByCapacityForGraph getLots = new GetLotsByCapacityForGraph();
        getLots.execute();
        try{
            JSONArray answer = getLots.get();
            for (int i=0; i<answer.length();i++){
                JSONObject lot = (JSONObject) answer.get(i);
                String currentUsage = lot.getString("capacityLevel");
                String lotName = lot.getString("name");
                float usage;
                parkingLotNames.add(lotName);
                if (currentUsage.equalsIgnoreCase("empty")){
                    usage = 25;
                }
                else if (currentUsage.equalsIgnoreCase("mostlyEmpty")){
                    usage = 50;
                }

                else if (currentUsage.equalsIgnoreCase("mostlyFull")){
                    usage = 75;
                }
                else{
                    usage = 100;
                }
                yEntries.add(new BarEntry(usage,i));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        BarDataSet barDataSet = new BarDataSet(yEntries, "Lot Capacity");
        BarData data = new BarData(parkingLotNames,barDataSet);
        barChart.setData(data);
        barChart.getXAxis().setLabelsToSkip(0);
        barChart.getXAxis().setLabelRotationAngle(-90);

        // Button to go to map page
        Button go_to_map_from_graph = (Button)findViewById(R.id.go_to_map_from_graph_page);
        go_to_map_from_graph.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UsageGraph.this, Google_Maps_Page.class));
            }
        });

        // Button to go to report page
        Button go_to_report_from_graph = (Button) findViewById(R.id.go_to_report_from_graph_page);
        go_to_report_from_graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UsageGraph.this,MainActivity.class));
            }
        });
    }
}
class GetLotsByCapacityForGraph extends AsyncTask<Void, Void, JSONArray> {

    @Override
    protected JSONArray doInBackground(Void... voids) {
        String url = "https://mysterious-atoll-40779.herokuapp.com/getLotsByCapacity";
        JSONArray result = null;
        try{
            InputStream response = new URL(url).openStream();
            Scanner scanner = new Scanner(response);
            String responseBody = scanner.useDelimiter("\\A").next();
            JSONObject json = new JSONObject(responseBody);
            result = json.getJSONArray("results");
        } catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
