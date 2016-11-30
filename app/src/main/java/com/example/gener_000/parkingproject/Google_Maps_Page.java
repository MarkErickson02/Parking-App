package com.example.gener_000.parkingproject;

import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Switch;

import com.android.volley.toolbox.JsonObjectRequest;
import com.google.android.gms.appdatasearch.GetRecentContextCall;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class Google_Maps_Page extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google__maps__page);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng cppLibrary = new LatLng(34.05788, -117.82152);
        mMap.addMarker(new MarkerOptions().position(cppLibrary).title("CPP"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(cppLibrary));
        mMap.setMinZoomPreference(15);

        GetLotsByCapacity getLots = new GetLotsByCapacity();
        getLots.execute();
        try {
            JSONArray answer = getLots.get();
            Log.d("Test",answer.toString());
            for(int i=0;i<answer.length();i++){
                JSONObject lot = (JSONObject) answer.get(i);
                switch (lot.getString("name")){
                    case "Parking Structure":
                        Polygon parkingStructure = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.06119924460931,-117.8162111310238), new LatLng(34.06078343393973,-117.8155745788827), new LatLng(34.06000300990652,-117.8165887758576), new LatLng(34.05964876789193,-117.8179997921154), new LatLng(34.06027968678693,-117.8181627408553), new LatLng(34.06038907375445,-117.8176711440814), new LatLng(34.06048659839711,-117.8172402357672), new LatLng(34.06066563351202,-117.8168629013882), new LatLng(34.06119924460931,-117.8162111310238)));
                        colorPolygons(parkingStructure,lot);
                        break;
                    case "Lot B":
                        Polygon lotB = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.05420068834325,-117.8146737448492), new LatLng(34.05380665860395,-117.8140965089041), new LatLng(34.05060759655908,-117.816526986451), new LatLng(34.05072547030365,-117.8169434373183), new LatLng(34.0529275076813,-117.8157124108035), new LatLng(34.0528719375862,-117.8155640332699), new LatLng(34.05420068834325,-117.8146737448492)));
                        colorPolygons(lotB,lot);
                        break;
                    case "Lot E1":
                        Polygon lotE1 = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.06102230818576,-117.8116588519016), new LatLng(34.0617329125795,-117.8109771050162), new LatLng(34.06212735600475,-117.8115376681534), new LatLng(34.06158282432502,-117.8123373979399), new LatLng(34.06102230818576,-117.8116588519016)));
                        colorPolygons(lotE1,lot);
                        break;
                    case "Lot E2":
                        Polygon lotE2 = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.06085654905797,-117.8129627928817), new LatLng(34.06054404695362,-117.8132545508526), new LatLng(34.06022270917416,-117.812759166086), new LatLng(34.06107110379668,-117.8119922019722), new LatLng(34.06120078597977,-117.8123506482976), new LatLng(34.06107015658667,-117.8126589053179), new LatLng(34.06085654905797,-117.8129627928817)));
                        colorPolygons(lotE2,lot);
                        break;
                    case "Lot F1":
                        Polygon lotF1 = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.0628104443127,-117.8170689323858), new LatLng(34.06200597417382,-117.8174007286614), new LatLng(34.06165687788728,-117.8168819773329), new LatLng(34.06259748590119,-117.8164740891396), new LatLng(34.0628104443127,-117.8170689323858)));
                        colorPolygons(lotF1,lot);
                        break;
                    case "Lot F2":
                        Polygon lotF2 = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.06195811738629,-117.8175584532644), new LatLng(34.06167536975498,-117.8169423164849), new LatLng(34.06136099125442,-117.8173488801101), new LatLng(34.06114488526155,-117.8179321973774), new LatLng(34.06110040023845,-117.818258842547), new LatLng(34.06162576101303,-117.8183590157227), new LatLng(34.06195811738629,-117.8175584532644)));
                        colorPolygons(lotF2,lot);
                        break;
                    case "Lot F3":
                        Polygon lotF3 = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.0624480348591,-117.8158770381946), new LatLng(34.06262769840713,-117.8164553380324), new LatLng(34.06164675224817,-117.816830145093), new LatLng(34.06145147611465,-117.8163005210238), new LatLng(34.0624480348591,-117.8158770381946)));
                        colorPolygons(lotF3,lot);
                        break;
                    case "Lot F4":
                        Polygon lotF4 = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.06164191312995,-117.8169415460543), new LatLng(34.06135066025252,-117.8164444802666), new LatLng(34.06084994918663,-117.8170073079399), new LatLng(34.06069031492188,-117.8174472500828), new LatLng(34.06054574857354,-117.818206376312), new LatLng(34.06098760529007,-117.8182686299437), new LatLng(34.06111225443324,-117.8180911580626), new LatLng(34.06121982937562,-117.8175861845335), new LatLng(34.06164191312995,-117.8169415460543)));
                        colorPolygons(lotF4,lot);
                        break;
                    case "Lot F5":
                        Polygon lotF5 = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.06229064043627,-117.8156344304231), new LatLng(34.06187264700342,-117.8149462954054), new LatLng(34.06093901385849,-117.8154175556302), new LatLng(34.06131274006639,-117.8161323861757), new LatLng(34.06229064043627,-117.8156344304231)));
                        colorPolygons(lotF5,lot);
                        break;
                    case "Lot F8":
                        Polygon lotF8 = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.05971114738492,-117.8166800825357), new LatLng(34.05940626431246,-117.8180465825175), new LatLng(34.05832623234057,-117.8173725081641), new LatLng(34.05929281532124,-117.816171344917), new LatLng(34.05951992634744,-117.8161961536828), new LatLng(34.05971114738492,-117.8166800825357)));
                        colorPolygons(lotF8,lot);
                        break;
                    case "Lot F9":
                        Polygon lotF9 = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.06070598373017,-117.8152674805543), new LatLng(34.06038798375073,-117.8147463986516), new LatLng(34.05959425945859,-117.8156789534857), new LatLng(34.0598372379358,-117.8164075610664), new LatLng(34.06070598373017,-117.8152674805543)));
                        colorPolygons(lotF9,lot);
                        break;
                    case "Lot F10":
                        Polygon lotF10 = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.06180601805028,-117.814689329113), new LatLng(34.06081105874627,-117.8152314437511), new LatLng(34.06046094364343,-117.814695630697), new LatLng(34.06129837748436,-117.8140916991604), new LatLng(34.06180601805028,-117.814689329113)));
                        colorPolygons(lotF10,lot);
                        break;
                    case "Lot H":
                        Polygon lotH = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.06160141839267,-117.8184673337112), new LatLng(34.06111475278459,-117.8184248457564), new LatLng(34.0609183240078,-117.8186030783294), new LatLng(34.06070709583212,-117.8189956388533), new LatLng(34.06093901645773,-117.8190994950738), new LatLng(34.06113514403748,-117.8186236266159), new LatLng(34.06121160893622,-117.8184996200147), new LatLng(34.06155628809275,-117.8185534425669), new LatLng(34.06160141839267,-117.8184673337112)));
                        colorPolygons(lotH,lot);
                        break;
                    case "Lot J":
                        Polygon lotJ = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.0589002001555,-117.8281437076521), new LatLng(34.05867443421134,-117.8289691936713), new LatLng(34.05830144817254,-117.8293767028923), new LatLng(34.05776380293005,-117.8294794927713), new LatLng(34.05731144245729,-117.8293885032575), new LatLng(34.05593232117811,-117.828661672969), new LatLng(34.05620918344528,-117.8277944857025), new LatLng(34.05768988371416,-117.8285124327289), new LatLng(34.05808897776775,-117.8283023859427), new LatLng(34.05802373322669,-117.8274051359044), new LatLng(34.05861746695594,-117.8273655340351), new LatLng(34.0589002001555,-117.8281437076521)));
                        colorPolygons(lotJ,lot);
                        break;
                    case "Lot M":
                        Polygon lotM = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.05620262508582,-117.8295228056154), new LatLng(34.05620707064467,-117.8307435793917), new LatLng(34.05536337566323,-117.8308117504884), new LatLng(34.05486872664848,-117.8305698299637), new LatLng(34.05482855964876,-117.8300675080738), new LatLng(34.05479478067391,-117.8299993460613), new LatLng(34.05477326315488,-117.8291418688103), new LatLng(34.05532640701347,-117.8291316332573), new LatLng(34.05533945389166,-117.8287698380034), new LatLng(34.05547156671925,-117.8287681731037), new LatLng(34.0555554043008,-117.8285267574207), new LatLng(34.05592515696901,-117.8274812733341), new LatLng(34.05612019631618,-117.827571837491), new LatLng(34.0560572035432,-117.8278558884045), new LatLng(34.05600736585699,-117.8280201814275), new LatLng(34.05594630552816,-117.8281623049589), new LatLng(34.05589605034486,-117.8283265142388), new LatLng(34.05584336684601,-117.828447686342), new LatLng(34.05579892850056,-117.8285685759171), new LatLng(34.05573205325216,-117.8286063772107), new LatLng(34.05570748430279,-117.8286572034474), new LatLng(34.05568345448888,-117.8286668773151), new LatLng(34.05562840636497,-117.8287860502731), new LatLng(34.05570268687433,-117.8288454134771), new LatLng(34.05578487782748,-117.8288844545202), new LatLng(34.05583805850957,-117.8288988388093), new LatLng(34.05587006763768,-117.8289439850078), new LatLng(34.05589885497549,-117.8290134347891), new LatLng(34.05590340560118,-117.8292024382296), new LatLng(34.05591511131352,-117.8292965959462), new LatLng(34.05590051926049,-117.8294351361715), new LatLng(34.0559080944575,-117.8295040677046)));
                        colorPolygons(lotM,lot);
                        break;
                    case "Paved Overflow Lot":
                        Polygon pavedOverflowLot = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.05433628451628,-117.8092053837446), new LatLng(34.05283950958133,-117.8103615126865), new LatLng(34.05241724340107,-117.8096114811795), new LatLng(34.05388484278387,-117.8083764342178), new LatLng(34.05433628451628,-117.8092053837446)));
                        colorPolygons(pavedOverflowLot,lot);
                        break;
                    case "Parking Structure 2":
                        Polygon parkingStructure2 = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.05267144802782,-117.8209680732823), new LatLng(34.05192914618127,-117.8206653252426), new LatLng(34.05056045628388,-117.8171698341826), new LatLng(34.05102100673412,-117.8168940837523), new LatLng(34.05267144802782,-117.8209680732823)));
                        colorPolygons(parkingStructure2,lot);
                        break;
                    case "Lot U":
                        Polygon lotU = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.04939301526104,-117.8171407036621), new LatLng(34.04931558901309,-117.8169484980819), new LatLng(34.04789372484903,-117.8181604513021), new LatLng(34.04798573799425,-117.8183202104472), new LatLng(34.04939301526104,-117.8171407036621)));
                        colorPolygons(lotU,lot);
                        break;
                    case "Unpaved Overflow Lot":
                        Polygon unpavedOverflowLot = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.04947280443611,-117.8142583377738), new LatLng(34.04870496212538,-117.8124138547501), new LatLng(34.05208101673772,-117.8097428471187), new LatLng(34.05257166719087,-117.8105679647591), new LatLng(34.05275912516059,-117.8118149955344), new LatLng(34.04947280443611,-117.8142583377738)));
                        colorPolygons(unpavedOverflowLot,lot);
                        break;
                }
            }

        } catch(Exception e){
            e.printStackTrace();
            Polygon lotM = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.05620262508582,-117.8295228056154), new LatLng(34.05620707064467,-117.8307435793917), new LatLng(34.05536337566323,-117.8308117504884), new LatLng(34.05486872664848,-117.8305698299637), new LatLng(34.05482855964876,-117.8300675080738), new LatLng(34.05479478067391,-117.8299993460613), new LatLng(34.05477326315488,-117.8291418688103), new LatLng(34.05532640701347,-117.8291316332573), new LatLng(34.05533945389166,-117.8287698380034), new LatLng(34.05547156671925,-117.8287681731037), new LatLng(34.0555554043008,-117.8285267574207), new LatLng(34.05592515696901,-117.8274812733341), new LatLng(34.05612019631618,-117.827571837491), new LatLng(34.0560572035432,-117.8278558884045), new LatLng(34.05600736585699,-117.8280201814275), new LatLng(34.05594630552816,-117.8281623049589), new LatLng(34.05589605034486,-117.8283265142388), new LatLng(34.05584336684601,-117.828447686342), new LatLng(34.05579892850056,-117.8285685759171), new LatLng(34.05573205325216,-117.8286063772107), new LatLng(34.05570748430279,-117.8286572034474), new LatLng(34.05568345448888,-117.8286668773151), new LatLng(34.05562840636497,-117.8287860502731), new LatLng(34.05570268687433,-117.8288454134771), new LatLng(34.05578487782748,-117.8288844545202), new LatLng(34.05583805850957,-117.8288988388093), new LatLng(34.05587006763768,-117.8289439850078), new LatLng(34.05589885497549,-117.8290134347891), new LatLng(34.05590340560118,-117.8292024382296), new LatLng(34.05591511131352,-117.8292965959462), new LatLng(34.05590051926049,-117.8294351361715), new LatLng(34.0559080944575,-117.8295040677046)));
            lotM.setFillColor(Color.GRAY);
            lotM.setStrokeColor(Color.GRAY);
            lotM.setStrokeWidth(1);

            Polygon lotJ = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.0589002001555,-117.8281437076521), new LatLng(34.05867443421134,-117.8289691936713), new LatLng(34.05830144817254,-117.8293767028923), new LatLng(34.05776380293005,-117.8294794927713), new LatLng(34.05731144245729,-117.8293885032575), new LatLng(34.05593232117811,-117.828661672969), new LatLng(34.05620918344528,-117.8277944857025), new LatLng(34.05768988371416,-117.8285124327289), new LatLng(34.05808897776775,-117.8283023859427), new LatLng(34.05802373322669,-117.8274051359044), new LatLng(34.05861746695594,-117.8273655340351), new LatLng(34.0589002001555,-117.8281437076521)));
            lotJ.setFillColor(Color.GRAY);
            lotJ.setStrokeColor(Color.GRAY);
            lotJ.setStrokeWidth(1);

            Polygon lotU = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.04939301526104,-117.8171407036621), new LatLng(34.04931558901309,-117.8169484980819), new LatLng(34.04789372484903,-117.8181604513021), new LatLng(34.04798573799425,-117.8183202104472), new LatLng(34.04939301526104,-117.8171407036621)));
            lotU.setFillColor(Color.GRAY);
            lotU.setStrokeColor(Color.GRAY);
            lotU.setStrokeWidth(1);

            Polygon parkingStructure2 = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.05267144802782,-117.8209680732823), new LatLng(34.05192914618127,-117.8206653252426), new LatLng(34.05056045628388,-117.8171698341826), new LatLng(34.05102100673412,-117.8168940837523), new LatLng(34.05267144802782,-117.8209680732823)));
            parkingStructure2.setFillColor(Color.GRAY);
            parkingStructure2.setStrokeColor(Color.GRAY);
            parkingStructure2.setStrokeWidth(1);

            Polygon lotB = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.05420068834325,-117.8146737448492), new LatLng(34.05380665860395,-117.8140965089041), new LatLng(34.05060759655908,-117.816526986451), new LatLng(34.05072547030365,-117.8169434373183), new LatLng(34.0529275076813,-117.8157124108035), new LatLng(34.0528719375862,-117.8155640332699), new LatLng(34.05420068834325,-117.8146737448492)));
            lotB.setFillColor(Color.GRAY);
            lotB.setStrokeColor(Color.GRAY);
            lotB.setStrokeWidth(1);

            Polygon unpavedOverflowLot = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.04947280443611,-117.8142583377738), new LatLng(34.04870496212538,-117.8124138547501), new LatLng(34.05208101673772,-117.8097428471187), new LatLng(34.05257166719087,-117.8105679647591), new LatLng(34.05275912516059,-117.8118149955344), new LatLng(34.04947280443611,-117.8142583377738)));
            unpavedOverflowLot.setFillColor(Color.GRAY);
            unpavedOverflowLot.setStrokeColor(Color.GRAY);
            unpavedOverflowLot.setStrokeWidth(1);

            Polygon pavedOverflowLot = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.05433628451628,-117.8092053837446), new LatLng(34.05283950958133,-117.8103615126865), new LatLng(34.05241724340107,-117.8096114811795), new LatLng(34.05388484278387,-117.8083764342178), new LatLng(34.05433628451628,-117.8092053837446)));
            pavedOverflowLot.setFillColor(Color.GRAY);
            pavedOverflowLot.setStrokeColor(Color.GRAY);
            pavedOverflowLot.setStrokeWidth(1);

            Polygon lotF8 = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.05971114738492,-117.8166800825357), new LatLng(34.05940626431246,-117.8180465825175), new LatLng(34.05832623234057,-117.8173725081641), new LatLng(34.05929281532124,-117.816171344917), new LatLng(34.05951992634744,-117.8161961536828), new LatLng(34.05971114738492,-117.8166800825357)));
            lotF8.setFillColor(Color.GRAY);
            lotF8.setStrokeColor(Color.GRAY);
            lotF8.setStrokeWidth(1);

            Polygon lotF9 = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.06070598373017,-117.8152674805543), new LatLng(34.06038798375073,-117.8147463986516), new LatLng(34.05959425945859,-117.8156789534857), new LatLng(34.0598372379358,-117.8164075610664), new LatLng(34.06070598373017,-117.8152674805543)));
            lotF9.setFillColor(Color.GRAY);
            lotF9.setStrokeColor(Color.GRAY);
            lotF9.setStrokeWidth(1);

            Polygon lotF10 = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.06180601805028,-117.814689329113), new LatLng(34.06081105874627,-117.8152314437511), new LatLng(34.06046094364343,-117.814695630697), new LatLng(34.06129837748436,-117.8140916991604), new LatLng(34.06180601805028,-117.814689329113)));
            lotF10.setFillColor(Color.GRAY);
            lotF10.setStrokeColor(Color.GRAY);
            lotF10.setStrokeWidth(1);

            Polygon lotF5 = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.06229064043627,-117.8156344304231), new LatLng(34.06187264700342,-117.8149462954054), new LatLng(34.06093901385849,-117.8154175556302), new LatLng(34.06131274006639,-117.8161323861757), new LatLng(34.06229064043627,-117.8156344304231)));
            lotF5.setFillColor(Color.GRAY);
            lotF5.setStrokeColor(Color.GRAY);
            lotF5.setStrokeWidth(1);

            Polygon lotF3 = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.0624480348591,-117.8158770381946), new LatLng(34.06262769840713,-117.8164553380324), new LatLng(34.06164675224817,-117.816830145093), new LatLng(34.06145147611465,-117.8163005210238), new LatLng(34.0624480348591,-117.8158770381946)));
            lotF3.setFillColor(Color.GRAY);
            lotF3.setStrokeColor(Color.GRAY);
            lotF3.setStrokeWidth(1);

            Polygon lotF1 = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.0628104443127,-117.8170689323858), new LatLng(34.06200597417382,-117.8174007286614), new LatLng(34.06165687788728,-117.8168819773329), new LatLng(34.06259748590119,-117.8164740891396), new LatLng(34.0628104443127,-117.8170689323858)));
            lotF1.setFillColor(Color.GRAY);
            lotF1.setStrokeColor(Color.GRAY);
            lotF1.setStrokeWidth(1);

            Polygon lotF2 = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.06195811738629,-117.8175584532644), new LatLng(34.06167536975498,-117.8169423164849), new LatLng(34.06136099125442,-117.8173488801101), new LatLng(34.06114488526155,-117.8179321973774), new LatLng(34.06110040023845,-117.818258842547), new LatLng(34.06162576101303,-117.8183590157227), new LatLng(34.06195811738629,-117.8175584532644)));
            lotF2.setFillColor(Color.GRAY);
            lotF2.setStrokeColor(Color.GRAY);
            lotF2.setStrokeWidth(1);

            Polygon lotF4 = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.06164191312995,-117.8169415460543), new LatLng(34.06135066025252,-117.8164444802666), new LatLng(34.06084994918663,-117.8170073079399), new LatLng(34.06069031492188,-117.8174472500828), new LatLng(34.06054574857354,-117.818206376312), new LatLng(34.06098760529007,-117.8182686299437), new LatLng(34.06111225443324,-117.8180911580626), new LatLng(34.06121982937562,-117.8175861845335), new LatLng(34.06164191312995,-117.8169415460543)));
            lotF4.setFillColor(Color.GRAY);
            lotF4.setStrokeColor(Color.GRAY);
            lotF4.setStrokeWidth(1);

            Polygon parkingStructure = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.06119924460931,-117.8162111310238), new LatLng(34.06078343393973,-117.8155745788827), new LatLng(34.06000300990652,-117.8165887758576), new LatLng(34.05964876789193,-117.8179997921154), new LatLng(34.06027968678693,-117.8181627408553), new LatLng(34.06038907375445,-117.8176711440814), new LatLng(34.06048659839711,-117.8172402357672), new LatLng(34.06066563351202,-117.8168629013882), new LatLng(34.06119924460931,-117.8162111310238)));
            parkingStructure.setFillColor(Color.GRAY);
            parkingStructure.setStrokeColor(Color.GRAY);
            parkingStructure.setStrokeWidth(1);

            Polygon lotH = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.06160141839267,-117.8184673337112), new LatLng(34.06111475278459,-117.8184248457564), new LatLng(34.0609183240078,-117.8186030783294), new LatLng(34.06070709583212,-117.8189956388533), new LatLng(34.06093901645773,-117.8190994950738), new LatLng(34.06113514403748,-117.8186236266159), new LatLng(34.06121160893622,-117.8184996200147), new LatLng(34.06155628809275,-117.8185534425669), new LatLng(34.06160141839267,-117.8184673337112)));
            lotH.setFillColor(Color.GRAY);
            lotH.setStrokeColor(Color.GRAY);
            lotH.setStrokeWidth(1);

            Polygon lotE2 = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.06085654905797,-117.8129627928817), new LatLng(34.06054404695362,-117.8132545508526), new LatLng(34.06022270917416,-117.812759166086), new LatLng(34.06107110379668,-117.8119922019722), new LatLng(34.06120078597977,-117.8123506482976), new LatLng(34.06107015658667,-117.8126589053179), new LatLng(34.06085654905797,-117.8129627928817)));
            lotE2.setFillColor(Color.GRAY);
            lotE2.setStrokeColor(Color.GRAY);
            lotE2.setStrokeWidth(1);

            Polygon lotE1 = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.06102230818576,-117.8116588519016), new LatLng(34.0617329125795,-117.8109771050162), new LatLng(34.06212735600475,-117.8115376681534), new LatLng(34.06158282432502,-117.8123373979399), new LatLng(34.06102230818576,-117.8116588519016)));
            lotE1.setFillColor(Color.GRAY);
            lotE1.setStrokeColor(Color.GRAY);
            lotE1.setStrokeWidth(1);
        }

        /*
        Polygon lotM = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.05620262508582,-117.8295228056154), new LatLng(34.05620707064467,-117.8307435793917), new LatLng(34.05536337566323,-117.8308117504884), new LatLng(34.05486872664848,-117.8305698299637), new LatLng(34.05482855964876,-117.8300675080738), new LatLng(34.05479478067391,-117.8299993460613), new LatLng(34.05477326315488,-117.8291418688103), new LatLng(34.05532640701347,-117.8291316332573), new LatLng(34.05533945389166,-117.8287698380034), new LatLng(34.05547156671925,-117.8287681731037), new LatLng(34.0555554043008,-117.8285267574207), new LatLng(34.05592515696901,-117.8274812733341), new LatLng(34.05612019631618,-117.827571837491), new LatLng(34.0560572035432,-117.8278558884045), new LatLng(34.05600736585699,-117.8280201814275), new LatLng(34.05594630552816,-117.8281623049589), new LatLng(34.05589605034486,-117.8283265142388), new LatLng(34.05584336684601,-117.828447686342), new LatLng(34.05579892850056,-117.8285685759171), new LatLng(34.05573205325216,-117.8286063772107), new LatLng(34.05570748430279,-117.8286572034474), new LatLng(34.05568345448888,-117.8286668773151), new LatLng(34.05562840636497,-117.8287860502731), new LatLng(34.05570268687433,-117.8288454134771), new LatLng(34.05578487782748,-117.8288844545202), new LatLng(34.05583805850957,-117.8288988388093), new LatLng(34.05587006763768,-117.8289439850078), new LatLng(34.05589885497549,-117.8290134347891), new LatLng(34.05590340560118,-117.8292024382296), new LatLng(34.05591511131352,-117.8292965959462), new LatLng(34.05590051926049,-117.8294351361715), new LatLng(34.0559080944575,-117.8295040677046)));
        lotM.setFillColor(Color.GRAY);

        Polygon lotJ = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.0589002001555,-117.8281437076521), new LatLng(34.05867443421134,-117.8289691936713), new LatLng(34.05830144817254,-117.8293767028923), new LatLng(34.05776380293005,-117.8294794927713), new LatLng(34.05731144245729,-117.8293885032575), new LatLng(34.05593232117811,-117.828661672969), new LatLng(34.05620918344528,-117.8277944857025), new LatLng(34.05768988371416,-117.8285124327289), new LatLng(34.05808897776775,-117.8283023859427), new LatLng(34.05802373322669,-117.8274051359044), new LatLng(34.05861746695594,-117.8273655340351), new LatLng(34.0589002001555,-117.8281437076521)));
        lotJ.setFillColor(Color.GRAY);

        Polygon lotU = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.04939301526104,-117.8171407036621), new LatLng(34.04931558901309,-117.8169484980819), new LatLng(34.04789372484903,-117.8181604513021), new LatLng(34.04798573799425,-117.8183202104472), new LatLng(34.04939301526104,-117.8171407036621)));
        lotU.setFillColor(Color.GRAY);

        Polygon parkingStructure2 = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.05267144802782,-117.8209680732823), new LatLng(34.05192914618127,-117.8206653252426), new LatLng(34.05056045628388,-117.8171698341826), new LatLng(34.05102100673412,-117.8168940837523), new LatLng(34.05267144802782,-117.8209680732823)));
        parkingStructure2.setFillColor(Color.GRAY);

        Polygon lotB = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.05420068834325,-117.8146737448492), new LatLng(34.05380665860395,-117.8140965089041), new LatLng(34.05060759655908,-117.816526986451), new LatLng(34.05072547030365,-117.8169434373183), new LatLng(34.0529275076813,-117.8157124108035), new LatLng(34.0528719375862,-117.8155640332699), new LatLng(34.05420068834325,-117.8146737448492)));
        lotB.setFillColor(Color.GRAY);

        Polygon unpavedOverflowLot = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.04947280443611,-117.8142583377738), new LatLng(34.04870496212538,-117.8124138547501), new LatLng(34.05208101673772,-117.8097428471187), new LatLng(34.05257166719087,-117.8105679647591), new LatLng(34.05275912516059,-117.8118149955344), new LatLng(34.04947280443611,-117.8142583377738)));
        unpavedOverflowLot.setFillColor(Color.GRAY);

        Polygon pavedOverflowLot = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.05433628451628,-117.8092053837446), new LatLng(34.05283950958133,-117.8103615126865), new LatLng(34.05241724340107,-117.8096114811795), new LatLng(34.05388484278387,-117.8083764342178), new LatLng(34.05433628451628,-117.8092053837446)));
        pavedOverflowLot.setFillColor(Color.GRAY);

        Polygon lotF8 = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.05971114738492,-117.8166800825357), new LatLng(34.05940626431246,-117.8180465825175), new LatLng(34.05832623234057,-117.8173725081641), new LatLng(34.05929281532124,-117.816171344917), new LatLng(34.05951992634744,-117.8161961536828), new LatLng(34.05971114738492,-117.8166800825357)));
        lotF8.setFillColor(Color.GRAY);

        Polygon lotF9 = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.06070598373017,-117.8152674805543), new LatLng(34.06038798375073,-117.8147463986516), new LatLng(34.05959425945859,-117.8156789534857), new LatLng(34.0598372379358,-117.8164075610664), new LatLng(34.06070598373017,-117.8152674805543)));
        lotF9.setFillColor(Color.GRAY);

        Polygon lotF10 = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.06180601805028,-117.814689329113), new LatLng(34.06081105874627,-117.8152314437511), new LatLng(34.06046094364343,-117.814695630697), new LatLng(34.06129837748436,-117.8140916991604), new LatLng(34.06180601805028,-117.814689329113)));
        lotF10.setFillColor(Color.GRAY);

        Polygon lotF5 = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.06229064043627,-117.8156344304231), new LatLng(34.06187264700342,-117.8149462954054), new LatLng(34.06093901385849,-117.8154175556302), new LatLng(34.06131274006639,-117.8161323861757), new LatLng(34.06229064043627,-117.8156344304231)));
        lotF5.setFillColor(Color.GRAY);

        Polygon lotF3 = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.0624480348591,-117.8158770381946), new LatLng(34.06262769840713,-117.8164553380324), new LatLng(34.06164675224817,-117.816830145093), new LatLng(34.06145147611465,-117.8163005210238), new LatLng(34.0624480348591,-117.8158770381946)));
        lotF3.setFillColor(Color.GRAY);

        Polygon lotF1 = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.0628104443127,-117.8170689323858), new LatLng(34.06200597417382,-117.8174007286614), new LatLng(34.06165687788728,-117.8168819773329), new LatLng(34.06259748590119,-117.8164740891396), new LatLng(34.0628104443127,-117.8170689323858)));
        lotF1.setFillColor(Color.GRAY);

        Polygon lotF2 = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.06195811738629,-117.8175584532644), new LatLng(34.06167536975498,-117.8169423164849), new LatLng(34.06136099125442,-117.8173488801101), new LatLng(34.06114488526155,-117.8179321973774), new LatLng(34.06110040023845,-117.818258842547), new LatLng(34.06162576101303,-117.8183590157227), new LatLng(34.06195811738629,-117.8175584532644)));
        lotF2.setFillColor(Color.GRAY);

        Polygon lotF4 = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.06164191312995,-117.8169415460543), new LatLng(34.06135066025252,-117.8164444802666), new LatLng(34.06084994918663,-117.8170073079399), new LatLng(34.06069031492188,-117.8174472500828), new LatLng(34.06054574857354,-117.818206376312), new LatLng(34.06098760529007,-117.8182686299437), new LatLng(34.06111225443324,-117.8180911580626), new LatLng(34.06121982937562,-117.8175861845335), new LatLng(34.06164191312995,-117.8169415460543)));
        lotF4.setFillColor(Color.GRAY);

        Polygon parkingStructure = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.06119924460931,-117.8162111310238), new LatLng(34.06078343393973,-117.8155745788827), new LatLng(34.06000300990652,-117.8165887758576), new LatLng(34.05964876789193,-117.8179997921154), new LatLng(34.06027968678693,-117.8181627408553), new LatLng(34.06038907375445,-117.8176711440814), new LatLng(34.06048659839711,-117.8172402357672), new LatLng(34.06066563351202,-117.8168629013882), new LatLng(34.06119924460931,-117.8162111310238)));
        parkingStructure.setFillColor(Color.GRAY);

        Polygon lotH = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.06160141839267,-117.8184673337112), new LatLng(34.06111475278459,-117.8184248457564), new LatLng(34.0609183240078,-117.8186030783294), new LatLng(34.06070709583212,-117.8189956388533), new LatLng(34.06093901645773,-117.8190994950738), new LatLng(34.06113514403748,-117.8186236266159), new LatLng(34.06121160893622,-117.8184996200147), new LatLng(34.06155628809275,-117.8185534425669), new LatLng(34.06160141839267,-117.8184673337112)));
        lotH.setFillColor(Color.GRAY);

        Polygon lotE2 = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.06085654905797,-117.8129627928817), new LatLng(34.06054404695362,-117.8132545508526), new LatLng(34.06022270917416,-117.812759166086), new LatLng(34.06107110379668,-117.8119922019722), new LatLng(34.06120078597977,-117.8123506482976), new LatLng(34.06107015658667,-117.8126589053179), new LatLng(34.06085654905797,-117.8129627928817)));
        lotE2.setFillColor(Color.GRAY);

        Polygon lotE1 = mMap.addPolygon(new PolygonOptions().add(new LatLng(34.06102230818576,-117.8116588519016), new LatLng(34.0617329125795,-117.8109771050162), new LatLng(34.06212735600475,-117.8115376681534), new LatLng(34.06158282432502,-117.8123373979399), new LatLng(34.06102230818576,-117.8116588519016)));
        lotE1.setFillColor(Color.GRAY);
        */
    }

    public void colorPolygons(Polygon drawLot, JSONObject lotName){
        try {
            switch (lotName.getString("capacityLevel")) {
                case "full":
                    drawLot.setFillColor(Color.RED);
                    drawLot.setStrokeColor(Color.RED);
                    drawLot.setStrokeWidth(1);
                    break;
                case "mostFull":
                    drawLot.setFillColor(Color.YELLOW);
                    drawLot.setStrokeColor(Color.YELLOW);
                    drawLot.setStrokeWidth(1);
                    break;
                case "mostlyEmpty":
                    drawLot.setFillColor(Color.GREEN);
                    drawLot.setStrokeColor(Color.GREEN);
                    drawLot.setStrokeWidth(1);
                    break;
                case "empty":
                    drawLot.setFillColor(Color.WHITE);
                    drawLot.setStrokeColor(Color.WHITE);
                    drawLot.setStrokeWidth(1);
                    break;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

class GetLotsByCapacity extends AsyncTask<Void, Void, JSONArray>{

    @Override
    protected JSONArray doInBackground(Void... voids) {
        JSONArray result = null;
        String url = "https://mysterious-atoll-40779.herokuapp.com/getLotsByCapacity";
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
