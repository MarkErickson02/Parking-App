package com.example.gener_000.parkingproject;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;

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

        // Add a marker in Sydney and move the camera
        LatLng cppLibrary = new LatLng(34.05788, -117.82152);
        mMap.addMarker(new MarkerOptions().position(cppLibrary).title("CPP"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(cppLibrary));

        Polygon lotM = mMap.addPolygon(new PolygonOptions().add(new LatLng(-117.8295228056154,34.05620262508582), new LatLng(-117.8307435793917,34.05620707064467), new LatLng( -117.8308117504884,34.05536337566323), new LatLng(-117.8305698299637,34.05486872664848), new LatLng(-117.8300675080738,34.05482855964876), new LatLng(-117.8299993460613,34.05479478067391), new LatLng(-117.8291418688103,34.05477326315488), new LatLng(-117.8291316332573,34.05532640701347), new LatLng(-117.8287698380034,34.05533945389166), new LatLng( -117.8287681731037,34.05547156671925), new LatLng(-117.8285267574207,34.0555554043008), new LatLng(-117.8274812733341,34.05592515696901), new LatLng(-117.827571837491,34.05612019631618), new LatLng(-117.8278558884045,34.0560572035432), new LatLng(-117.8280201814275,34.05600736585699), new LatLng(-117.8281623049589,34.05594630552816), new LatLng(-117.8283265142388,34.05589605034486), new LatLng(-117.828447686342,34.05584336684601), new LatLng(-117.8285685759171,34.05579892850056), new LatLng(-117.8286063772107,34.05573205325216), new LatLng(-117.8286572034474,34.05570748430279),
        new LatLng(-117.8286668773151,34.05568345448888), new LatLng(-117.8287860502731,34.05562840636497), new LatLng(-117.8288454134771,34.05570268687433), new LatLng(-117.8288844545202,34.05578487782748), new LatLng(-117.8288988388093,34.05583805850957), new LatLng(-117.8289439850078,34.05587006763768), new LatLng(-117.8290134347891,34.05589885497549), new LatLng(-117.8292024382296,34.05590340560118), new LatLng(-117.8292965959462,34.05591511131352), new LatLng(-117.8294351361715,34.05590051926049), new LatLng(-117.8295040677046,34.0559080944575), new LatLng(-117.8295228056154,34.05620262508582)));
        lotM.setFillColor(Color.GRAY);

        Polygon lotJ = mMap.addPolygon(new PolygonOptions().add(new LatLng(-117.8281437076521,34.0589002001555), new LatLng(-117.8289691936713,34.05867443421134), new LatLng(-117.8293767028923,34.05830144817254), new LatLng(-117.8294794927713,34.05776380293005), new LatLng(-117.8293885032575,34.05731144245729), new LatLng(-117.828661672969,34.05593232117811), new LatLng(-117.8277944857025,34.05620918344528), new LatLng(-117.8285124327289,34.05768988371416), new LatLng(-117.8283023859427,34.05808897776775), new LatLng(-117.8274051359044,34.05802373322669), new LatLng(-117.8273655340351,34.05861746695594), new LatLng(-117.8281437076521,34.0589002001555)));
        lotJ.setFillColor(Color.GRAY);

        Polygon lotU = mMap.addPolygon(new PolygonOptions().add(new LatLng(-117.8171407036621,34.04939301526104), new LatLng(-117.8169484980819,34.04931558901309), new LatLng( -117.8181604513021,34.04789372484903), new LatLng(-117.8183202104472,34.04798573799425), new LatLng(-117.8171407036621,34.04939301526104)));
        lotU.setFillColor(Color.GRAY);

        Polygon parkingStructure2 = mMap.addPolygon(new PolygonOptions().add(new LatLng(-117.8209680732823,34.05267144802782), new LatLng(-117.8206653252426,34.05192914618127), new LatLng( -117.8171698341826,34.05056045628388), new LatLng( -117.8168940837523,34.05102100673412), new LatLng(-117.8209680732823,34.05267144802782)));
        parkingStructure2.setFillColor(Color.GRAY);

        Polygon lotB = mMap.addPolygon(new PolygonOptions().add(new LatLng(-117.8146737448492,34.05420068834325), new LatLng(-117.8140965089041,34.05380665860395), new LatLng(-117.816526986451,34.05060759655908), new LatLng(-117.8169434373183,34.05072547030365), new LatLng(-117.8157124108035,34.0529275076813), new LatLng(-117.8155640332699,34.05287193758625), new LatLng(-117.8146737448492,34.05420068834325)));
        lotB.setFillColor(Color.GRAY);

        Polygon unpavedOverflowLot = mMap.addPolygon(new PolygonOptions().add(new LatLng(-117.8142583377738,34.04947280443611), new LatLng(-117.8124138547501,34.04870496212538), new LatLng(-117.8097428471187,34.05208101673772), new LatLng(-117.8105679647591,34.05257166719087), new LatLng(-117.8118149955344,34.05275912516059), new LatLng(-117.8142583377738,34.04947280443611)));
        unpavedOverflowLot.setFillColor(Color.GRAY);

        Polygon pavedOverflowLot = mMap.addPolygon(new PolygonOptions().add(new LatLng(-117.8092053837446,34.05433628451628), new LatLng(-117.8103615126865,34.05283950958133), new LatLng(-117.8096114811795,34.05241724340107), new LatLng(-117.8083764342178,34.05388484278387), new LatLng(-117.8092053837446,34.05433628451628)));
        pavedOverflowLot.setFillColor(Color.GRAY);

        Polygon lotF8 = mMap.addPolygon(new PolygonOptions().add(new LatLng(-117.8166800825357,34.05971114738492), new LatLng(-117.8180465825175,34.05940626431246), new LatLng(-117.8173725081641,34.05832623234057), new LatLng(-117.816171344917,34.05929281532124), new LatLng(-117.8161961536828,34.05951992634744), new LatLng(-117.8166800825357,34.05971114738492)));
        lotF8.setFillColor(Color.GRAY);

        Polygon lotF9 = mMap.addPolygon(new PolygonOptions().add(new LatLng(-117.8152674805543,34.06070598373017), new LatLng(-117.8147463986516,34.06038798375073), new LatLng(-117.8156789534857,34.05959425945859), new LatLng(-117.8164075610664,34.0598372379358), new LatLng(-117.8152674805543,34.06070598373017)));
        lotF9.setFillColor(Color.GRAY);

        Polygon lotF10 = mMap.addPolygon(new PolygonOptions().add(new LatLng(-117.814689329113,34.06180601805028), new LatLng(-117.8152314437511,34.06081105874627), new LatLng(-117.814695630697,34.06046094364343), new LatLng(-117.8140916991604,34.06129837748436), new LatLng(-117.814689329113,34.06180601805028)));
        lotF10.setFillColor(Color.GRAY);

        Polygon lotF5 = mMap.addPolygon(new PolygonOptions().add(new LatLng(-117.8156344304231,34.06229064043627), new LatLng(-117.8149462954054,34.06187264700342), new LatLng(-117.8154175556302,34.06093901385849), new LatLng(-117.8161323861757,34.06131274006639), new LatLng(-117.8156344304231,34.06229064043627)));
        lotF5.setFillColor(Color.GRAY);

        Polygon lotF3 = mMap.addPolygon(new PolygonOptions().add(new LatLng(-117.8158770381946,34.0624480348591), new LatLng(-117.8164553380324,34.06262769840713), new LatLng(-117.816830145093,34.06164675224817), new LatLng(-117.8163005210238,34.06145147611465), new LatLng(-117.8158770381946,34.0624480348591)));
        lotF3.setFillColor(Color.GRAY);

        Polygon lotF1 = mMap.addPolygon(new PolygonOptions().add(new LatLng(-117.8170689323858,34.0628104443127), new LatLng(-117.8174007286614,34.06200597417382), new LatLng(-117.8168819773329,34.06165687788728), new LatLng(-117.8164740891396,34.06259748590119), new LatLng(-117.8170689323858,34.0628104443127)));
        lotF1.setFillColor(Color.GRAY);

        Polygon lotF2 = mMap.addPolygon(new PolygonOptions().add(new LatLng(-117.8175584532644,34.06195811738629), new LatLng(-117.8169423164849,34.06167536975498), new LatLng(-117.8173488801101,34.06136099125442), new LatLng(-117.8179321973774,34.06114488526155), new LatLng(-117.818258842547,34.06110040023845), new LatLng(-117.8183590157227,34.06162576101303), new LatLng(-117.8175584532644,34.06195811738629)));
        lotF2.setFillColor(Color.GRAY);

        Polygon lotF4 = mMap.addPolygon(new PolygonOptions().add(new LatLng(-117.8169415460543,34.06164191312995), new LatLng(-117.8164444802666,34.06135066025252), new LatLng(-117.8170073079399,34.06084994918663), new LatLng(-117.8174472500828,34.06069031492188), new LatLng(-117.818206376312,34.06054574857354), new LatLng(-117.8182686299437,34.06098760529007), new LatLng(-117.8180911580626,34.06111225443324), new LatLng(-117.8175861845335,34.06121982937562), new LatLng(-117.8169415460543,34.06164191312995)));
        lotF4.setFillColor(Color.GRAY);

        Polygon parkingStructure = mMap.addPolygon(new PolygonOptions().add(new LatLng(-117.8162111310238,34.06119924460931), new LatLng(-117.8155745788827,34.06078343393973), new LatLng(-117.8165887758576,34.06000300990652), new LatLng(-117.8179997921154,34.05964876789193), new LatLng(-117.8181627408553,34.06027968678693), new LatLng(-117.8176711440814,34.06038907375445), new LatLng(-117.8172402357672,34.06048659839711), new LatLng(-117.8168629013882,34.06066563351202), new LatLng(-117.8162111310238,34.06119924460931)));
        parkingStructure.setFillColor(Color.GRAY);

        Polygon lotH = mMap.addPolygon(new PolygonOptions().add(new LatLng(-117.8184673337112,34.06160141839267), new LatLng(-117.8184248457564,34.06111475278459), new LatLng(-117.8186030783294,34.0609183240078), new LatLng(-117.8189956388533,34.06070709583212), new LatLng(-117.8190994950738,34.06093901645773), new LatLng(-117.8186236266159,34.06113514403748), new LatLng(-117.8184996200147,34.06121160893622), new LatLng(-117.8185534425669,34.06155628809275), new LatLng(-117.8184673337112,34.06160141839267)));
        lotH.setFillColor(Color.GRAY);

        Polygon lotE2 = mMap.addPolygon(new PolygonOptions().add(new LatLng(-117.8129627928817,34.06085654905797), new LatLng(-117.8132545508526,34.06054404695362), new LatLng(-117.812759166086,34.06022270917416), new LatLng(-117.8119922019722,34.06107110379668), new LatLng(-117.8123506482976,34.06120078597977), new LatLng(-117.8126589053179,34.06107015658667), new LatLng(-117.8129627928817,34.06085654905797)));
        lotE2.setFillColor(Color.GRAY);

        Polygon lotE1 = mMap.addPolygon(new PolygonOptions().add(new LatLng(-117.8116588519016,34.06102230818576), new LatLng(-117.8109771050162,34.0617329125795), new LatLng(-117.8115376681534,34.06212735600475), new LatLng(-117.8123373979399,34.06158282432502), new LatLng(-117.8116588519016,34.06102230818576)));
        lotE1.setFillColor(Color.GRAY);

    }
}
