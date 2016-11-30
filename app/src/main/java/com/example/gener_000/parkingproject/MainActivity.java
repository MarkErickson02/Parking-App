package com.example.gener_000.parkingproject;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Button;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.internal.PlaceOpeningHoursEntity;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import org.apache.http.*;

public class MainActivity extends AppCompatActivity {


    private String parkingLot;
    private String busyness;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    public void setParkingLot(String parkingLot) {
        this.parkingLot = parkingLot;
    }

    public String getParkingLot() {
        return parkingLot;
    }

    public void setBusiness(String busyness) {
        this.busyness = busyness;
    }

    public String getBusyness() {
        return busyness;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d("Test","");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Call refresh for server.
        RefreshTableWorker refresh = new RefreshTableWorker();
        refresh.execute();
        try {
            String test = "failed";
            test = refresh.get();
            Log.d("Test",test);
        }catch(Exception e) {
            e.printStackTrace();
        }

        Spinner parkingLotSpinner = (Spinner) findViewById(R.id.spinner); // Spinner object.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.parking_lots, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        parkingLotSpinner.setAdapter(adapter);
        parkingLotSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long l) {
                String itemSelectedInSpinner = parent.getItemAtPosition(pos).toString();
                setParkingLot(itemSelectedInSpinner);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                setParkingLot("");
            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
        Button go_to_maps = (Button) findViewById(R.id.go_to_map);
        go_to_maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Google_Maps_Page.class));
            }
        });
        Button go_to_graph = (Button) findViewById(R.id.go_to_graph_from_report);
        go_to_graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, UsageGraph.class));
            }
        });

        Button sendReport = (Button) findViewById(R.id.button_send_report);
        sendReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String busyness = getBusyness();
                Log.d("Test",busyness);
                String lot = getParkingLot();
                Log.d("Test",lot);
                PutWorker task = new PutWorker();
                task.execute(lot,busyness);

                try {
                    String test = "failed";
                    test = task.get();
                    Log.d("Test",test);
                }catch(Exception e) {
                    e.printStackTrace();
                }
                startActivity(new Intent(MainActivity.this, Google_Maps_Page.class));
            }
        });

    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.emptyRadioButton:
                if (checked) {
                    setBusiness("empty");
                }
                break;
            case R.id.mostlyEmptyRadioButton:
                if (checked) {
                    setBusiness("mostlyEmpty");
                }
                break;
            case R.id.mostlyFullRadioButton:
                if (checked) {
                    setBusiness("mostlyFull");
                }
                break;
            case R.id.fullRadioButton:
                if (checked) {
                    setBusiness("full");
                }
                break;
        }
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
class RefreshTableWorker extends AsyncTask<Void, Void, String>{

    @Override
    protected String doInBackground(Void... voids) {
        String url = "https://mysterious-atoll-40779.herokuapp.com/refreshTable";
        String result = "Failed";
        try{
            InputStream response = new URL(url).openStream();
            Scanner scanner = new Scanner(response);
            String responseBody = scanner.useDelimiter("\\A").next();
            JSONObject json = new JSONObject(responseBody);
            result = json.getString("results");

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
}

/** PutWorker class
 *  This class handles Put requests to the server that are created when a report is sent.
 */
class PutWorker extends AsyncTask<String,Void,String>{

    protected String getASCIIContentFromEntity(HttpEntity entity) throws IllegalStateException, IOException{
        InputStream in = entity.getContent();
        StringBuffer out = new StringBuffer();
        int n = 1;
        while (n>0){
            byte[] b = new byte[4096];
            n = in.read(b);
            if (n>0){
                out.append(new String(b,0,n));
            }
        }
        return out.toString();
    }

    @Override
    protected String doInBackground(String... strings) {
        try{
            HttpClient httpClient = new DefaultHttpClient();
            HttpContext localContxt = new BasicHttpContext();
            HttpPut httpPut = new HttpPut("https://mysterious-atoll-40779.herokuapp.com/updateLot");
            httpPut.setHeader("Content-Type","application/json");
            JSONObject json = new JSONObject();
            json.put("name",strings[0]);
            json.put("capacityLevel", strings[1]);
            StringEntity se = new StringEntity(json.toString());
            se.setContentEncoding("UTF-8");
            se.setContentType("application/json");
            httpPut.setEntity(se);
            String text = null;
            try{
                HttpResponse response = httpClient.execute(httpPut,localContxt);
                HttpEntity entity = response.getEntity();
                text = getASCIIContentFromEntity(entity);
            } catch(Exception e){
                e.printStackTrace();
            }
            return text;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

