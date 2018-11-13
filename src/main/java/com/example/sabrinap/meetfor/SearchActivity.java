package com.example.sabrinap.meetfor;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.support.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.net.*;

import javax.net.ssl.HttpsURLConnection;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    Intent intent2 = getIntent();
    double meLat = intent2.getDoubleExtra("meLat", 0);
    double meLng = intent2.getDoubleExtra("meLng", 0);
    int meTransport = intent2.getIntExtra("meTransport", 0);
    double youLat = intent2.getDoubleExtra("youLat", 0);
    double youLng = intent2.getDoubleExtra("youLng", 0);
    int youTransport = intent2.getIntExtra("youTransport", 0);
    String search = intent2.getStringExtra("search");

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

    TextView tv1 = findViewById(R.id.textView);
    TextView tv2 = findViewById(R.id.textView2);
    TextView tv3 = findViewById(R.id.textView3);
    TextView tv4 = findViewById(R.id.textView4);
    TextView tv5 = findViewById(R.id.textView5);

    int distMeYou = 0;
    int distYouMe = 0;
    int timeMeYou = 0;
    int timeYouMe = 0;
    String distance = "didnt update";

    String url = getUrl(meLat, meLng, youLat, youLng, meTransport);
        try {
            URL searchUrl = new URL(url);
            distance = "1";
            HttpURLConnection httpURLConnection = (HttpURLConnection)searchUrl.openConnection();
            httpURLConnection.connect();
            distance = "2";
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer sb = new StringBuffer();
            distance ="3";
            String line = "";
            while ((line = bufferedReader.readLine())!= null){
                sb.append(line);
            }
            distance = "4";
            String data = sb.toString();
            data = "{\n" +
                    "   \"geocoded_waypoints\" : [\n" +
                    "      {\n" +
                    "         \"geocoder_status\" : \"OK\",\n" +
                    "         \"place_id\" : \"ChIJb2R4euDHD4gR6hOUmLjk2lg\",\n" +
                    "         \"types\" : [ \"locality\", \"political\" ]\n" +
                    "      },\n" +
                    "      {\n" +
                    "         \"geocoder_status\" : \"OK\",\n" +
                    "         \"place_id\" : \"ChIJKdXizhPHD4gRZIIOuTarZ9A\",\n" +
                    "         \"types\" : [ \"route\" ]\n" +
                    "      }\n" +
                    "   ],\n" +
                    "   \"routes\" : [\n" +
                    "      {\n" +
                    "         \"bounds\" : {\n" +
                    "            \"northeast\" : {\n" +
                    "               \"lat\" : 42.1118874,\n" +
                    "               \"lng\" : -87.8292895\n" +
                    "            },\n" +
                    "            \"southwest\" : {\n" +
                    "               \"lat\" : 42.0875241,\n" +
                    "               \"lng\" : -87.85250429999999\n" +
                    "            }\n" +
                    "         },\n" +
                    "         \"copyrights\" : \"Map data ©2018 Google\",\n" +
                    "         \"legs\" : [\n" +
                    "            {\n" +
                    "               \"distance\" : {\n" +
                    "                  \"text\" : \"3.2 mi\",\n" +
                    "                  \"value\" : 5076\n" +
                    "               },\n" +
                    "               \"duration\" : {\n" +
                    "                  \"text\" : \"10 mins\",\n" +
                    "                  \"value\" : 623\n" +
                    "               },\n" +
                    "               \"end_address\" : \"Sherman Dr, Northbrook, IL 60062, USA\",\n" +
                    "               \"end_location\" : {\n" +
                    "                  \"lat\" : 42.1106883,\n" +
                    "                  \"lng\" : -87.8311492\n" +
                    "               },\n" +
                    "               \"start_address\" : \"Glenview, IL, USA\",\n" +
                    "               \"start_location\" : {\n" +
                    "                  \"lat\" : 42.0893131,\n" +
                    "                  \"lng\" : -87.85189079999999\n" +
                    "               },\n" +
                    "               \"steps\" : [\n" +
                    "                  {\n" +
                    "                     \"distance\" : {\n" +
                    "                        \"text\" : \"194 ft\",\n" +
                    "                        \"value\" : 59\n" +
                    "                     },\n" +
                    "                     \"duration\" : {\n" +
                    "                        \"text\" : \"1 min\",\n" +
                    "                        \"value\" : 26\n" +
                    "                     },\n" +
                    "                     \"end_location\" : {\n" +
                    "                        \"lat\" : 42.0890876,\n" +
                    "                        \"lng\" : -87.8525027\n" +
                    "                     },\n" +
                    "                     \"html_instructions\" : \"Head \\u003cb\\u003ewest\\u003c/b\\u003e toward \\u003cb\\u003ePfingsten Rd\\u003c/b\\u003e\",\n" +
                    "                     \"polyline\" : {\n" +
                    "                        \"points\" : \"eq{_GhqewOBv@@D@B`@p@@@?B\"\n" +
                    "                     },\n" +
                    "                     \"start_location\" : {\n" +
                    "                        \"lat\" : 42.0893131,\n" +
                    "                        \"lng\" : -87.85189079999999\n" +
                    "                     },\n" +
                    "                     \"travel_mode\" : \"DRIVING\"\n" +
                    "                  },\n" +
                    "                  {\n" +
                    "                     \"distance\" : {\n" +
                    "                        \"text\" : \"456 ft\",\n" +
                    "                        \"value\" : 139\n" +
                    "                     },\n" +
                    "                     \"duration\" : {\n" +
                    "                        \"text\" : \"1 min\",\n" +
                    "                        \"value\" : 52\n" +
                    "                     },\n" +
                    "                     \"end_location\" : {\n" +
                    "                        \"lat\" : 42.0878331,\n" +
                    "                        \"lng\" : -87.8525039\n" +
                    "                     },\n" +
                    "                     \"html_instructions\" : \"Turn \\u003cb\\u003eleft\\u003c/b\\u003e toward \\u003cb\\u003ePfingsten Rd\\u003c/b\\u003e\",\n" +
                    "                     \"maneuver\" : \"turn-left\",\n" +
                    "                     \"polyline\" : {\n" +
                    "                        \"points\" : \"yo{_GbuewOvA?~C?B?\"\n" +
                    "                     },\n" +
                    "                     \"start_location\" : {\n" +
                    "                        \"lat\" : 42.0890876,\n" +
                    "                        \"lng\" : -87.8525027\n" +
                    "                     },\n" +
                    "                     \"travel_mode\" : \"DRIVING\"\n" +
                    "                  },\n" +
                    "                  {\n" +
                    "                     \"distance\" : {\n" +
                    "                        \"text\" : \"0.2 mi\",\n" +
                    "                        \"value\" : 253\n" +
                    "                     },\n" +
                    "                     \"duration\" : {\n" +
                    "                        \"text\" : \"1 min\",\n" +
                    "                        \"value\" : 63\n" +
                    "                     },\n" +
                    "                     \"end_location\" : {\n" +
                    "                        \"lat\" : 42.0875418,\n" +
                    "                        \"lng\" : -87.8495155\n" +
                    "                     },\n" +
                    "                     \"html_instructions\" : \"Turn \\u003cb\\u003eleft\\u003c/b\\u003e toward \\u003cb\\u003ePfingsten Rd\\u003c/b\\u003e\",\n" +
                    "                     \"maneuver\" : \"turn-left\",\n" +
                    "                     \"polyline\" : {\n" +
                    "                        \"points\" : \"}g{_GbuewO?c@?aAFa@JYL]FWBW?W?kA@qABkADaB\"\n" +
                    "                     },\n" +
                    "                     \"start_location\" : {\n" +
                    "                        \"lat\" : 42.0878331,\n" +
                    "                        \"lng\" : -87.8525039\n" +
                    "                     },\n" +
                    "                     \"travel_mode\" : \"DRIVING\"\n" +
                    "                  },\n" +
                    "                  {\n" +
                    "                     \"distance\" : {\n" +
                    "                        \"text\" : \"1.3 mi\",\n" +
                    "                        \"value\" : 2040\n" +
                    "                     },\n" +
                    "                     \"duration\" : {\n" +
                    "                        \"text\" : \"3 mins\",\n" +
                    "                        \"value\" : 196\n" +
                    "                     },\n" +
                    "                     \"end_location\" : {\n" +
                    "                        \"lat\" : 42.1056629,\n" +
                    "                        \"lng\" : -87.8489622\n" +
                    "                     },\n" +
                    "                     \"html_instructions\" : \"Turn \\u003cb\\u003eleft\\u003c/b\\u003e onto \\u003cb\\u003ePfingsten Rd\\u003c/b\\u003e\",\n" +
                    "                     \"maneuver\" : \"turn-left\",\n" +
                    "                     \"polyline\" : {\n" +
                    "                        \"points\" : \"cf{_GnbewOBi@SGc@KOCUEYCUCYCg@AG?mA?WB[LiB?{A@U?Y?WOW?cCAuD?}BB}E?iA?uAAU?kA?g@?iAAYHeAA{EAe@?mCAeAAuHAuAA{CAQ?O?s@?mBASIe@?q@?yAA}ACgB?k@AwAAoBA\"\n" +
                    "                     },\n" +
                    "                     \"start_location\" : {\n" +
                    "                        \"lat\" : 42.0875418,\n" +
                    "                        \"lng\" : -87.8495155\n" +
                    "                     },\n" +
                    "                     \"travel_mode\" : \"DRIVING\"\n" +
                    "                  },\n" +
                    "                  {\n" +
                    "                     \"distance\" : {\n" +
                    "                        \"text\" : \"1.0 mi\",\n" +
                    "                        \"value\" : 1610\n" +
                    "                     },\n" +
                    "                     \"duration\" : {\n" +
                    "                        \"text\" : \"2 mins\",\n" +
                    "                        \"value\" : 122\n" +
                    "                     },\n" +
                    "                     \"end_location\" : {\n" +
                    "                        \"lat\" : 42.1055485,\n" +
                    "                        \"lng\" : -87.82944759999999\n" +
                    "                     },\n" +
                    "                     \"html_instructions\" : \"Turn \\u003cb\\u003eright\\u003c/b\\u003e onto \\u003cb\\u003eWillow Rd\\u003c/b\\u003e\",\n" +
                    "                     \"maneuver\" : \"turn-right\",\n" +
                    "                     \"polyline\" : {\n" +
                    "                        \"points\" : \"kw~_G~~dwO?aD?eA@cBAiABoF?o@?oC@eE@uJ?sB?uH@mBBmN?eB?uC@gB?oA?aE@qC?_@BmM?_E\"\n" +
                    "                     },\n" +
                    "                     \"start_location\" : {\n" +
                    "                        \"lat\" : 42.1056629,\n" +
                    "                        \"lng\" : -87.8489622\n" +
                    "                     },\n" +
                    "                     \"travel_mode\" : \"DRIVING\"\n" +
                    "                  },\n" +
                    "                  {\n" +
                    "                     \"distance\" : {\n" +
                    "                        \"text\" : \"0.4 mi\",\n" +
                    "                        \"value\" : 718\n" +
                    "                     },\n" +
                    "                     \"duration\" : {\n" +
                    "                        \"text\" : \"1 min\",\n" +
                    "                        \"value\" : 84\n" +
                    "                     },\n" +
                    "                     \"end_location\" : {\n" +
                    "                        \"lat\" : 42.11188689999999,\n" +
                    "                        \"lng\" : -87.8293089\n" +
                    "                     },\n" +
                    "                     \"html_instructions\" : \"Turn \\u003cb\\u003eleft\\u003c/b\\u003e onto \\u003cb\\u003eShermer Rd\\u003c/b\\u003e\",\n" +
                    "                     \"maneuver\" : \"turn-left\",\n" +
                    "                     \"polyline\" : {\n" +
                    "                        \"points\" : \"uv~_G`eawO?_@U@wA@]?i@?i@?cB?uB?aD?e@?a@@E?y@?E?mAAcB?}C?}A?{A?\"\n" +
                    "                     },\n" +
                    "                     \"start_location\" : {\n" +
                    "                        \"lat\" : 42.1055485,\n" +
                    "                        \"lng\" : -87.82944759999999\n" +
                    "                     },\n" +
                    "                     \"travel_mode\" : \"DRIVING\"\n" +
                    "                  },\n" +
                    "                  {\n" +
                    "                     \"distance\" : {\n" +
                    "                        \"text\" : \"0.2 mi\",\n" +
                    "                        \"value\" : 257\n" +
                    "                     },\n" +
                    "                     \"duration\" : {\n" +
                    "                        \"text\" : \"1 min\",\n" +
                    "                        \"value\" : 80\n" +
                    "                     },\n" +
                    "                     \"end_location\" : {\n" +
                    "                        \"lat\" : 42.1106883,\n" +
                    "                        \"lng\" : -87.8311492\n" +
                    "                     },\n" +
                    "                     \"html_instructions\" : \"Turn \\u003cb\\u003eleft\\u003c/b\\u003e at \\u003cb\\u003eRaymond Dr\\u003c/b\\u003e\",\n" +
                    "                     \"maneuver\" : \"turn-left\",\n" +
                    "                     \"polyline\" : {\n" +
                    "                        \"points\" : \"i~_`GddawO?Z?J@NDTNt@DJBDDDHDHBhC@J@F?B@BBDF?vC@L@HBF\"\n" +
                    "                     },\n" +
                    "                     \"start_location\" : {\n" +
                    "                        \"lat\" : 42.11188689999999,\n" +
                    "                        \"lng\" : -87.8293089\n" +
                    "                     },\n" +
                    "                     \"travel_mode\" : \"DRIVING\"\n" +
                    "                  }\n" +
                    "               ],\n" +
                    "               \"traffic_speed_entry\" : [],\n" +
                    "               \"via_waypoint\" : []\n" +
                    "            }\n" +
                    "         ],\n" +
                    "         \"overview_polyline\" : {\n" +
                    "            \"points\" : \"eq{_GhqewOD|@b@t@@DvF?B??c@?aAFa@Xw@Jo@DaGHkCw@SuAQaAEuA?WB[LeE@o@?WOW?yHA{IBaGAqBAYHeAAaGAsECyPEcA?mBASIwA?wDE{IEDk_@H_v@@cMBmS?_@U@uB@sA?aL?uO?{A??Z@ZTjAHPNJrCDZFDF?vCBVBF\"\n" +
                    "         },\n" +
                    "         \"summary\" : \"Pfingsten Rd and Willow Rd\",\n" +
                    "         \"warnings\" : [],\n" +
                    "         \"waypoint_order\" : []\n" +
                    "      }\n" +
                    "   ],\n" +
                    "   \"status\" : \"OK\"\n" +
                    "}";
            bufferedReader.close();
            JSONObject json = new JSONObject(data);
            distance = "6";
            distance = json.getJSONArray("routes").getJSONObject(0).getJSONArray("legs").getJSONObject(0).getJSONArray("duration").getJSONObject(1).getString("value");


            //HttpsURLConnection uc = (HttpsURLConnection) searchUrl.openConnection();
            //InputStreamReader in = new InputStreamReader(uc.getInputStream());
            //JSONObject json = (JSONObject) uc.getContent();
            //String read = readAll(in);
            //JSONObject json = new JSONObject(read);
            //JSONArray legs = json.getJSONArray("legs");
            //String time = legs.getJSONObject(1).getString("value");
            //timeMeYou = Integer.getInteger(time);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }




        tv1.setText("my location: (" + Double.toString(meLat)+ ", " + Double.toString(meLng) + ")");
    tv2.setText("your location: (" + Double.toString(youLat) + ", " + Double.toString(youLng) + ")");
    if(meTransport == 1){
        tv3.setText("I'm driving");
    }
    else if(meTransport == 2){
        tv3.setText("I'm walking");
    }
    else if(meTransport == 3){
        tv3.setText("I'm biking");
    }
    else if(meTransport == 4){
        tv3.setText("I'm taking transit");
    }
    if(youTransport == 1){
        tv4.setText("you're driving");
    }
    else if(youTransport == 2){
        tv4.setText("you're walking");
    }
    else if(youTransport == 3){
        tv4.setText("you're biking");
    }
    else if(youTransport == 4){
        tv4.setText("you're taking transit");
    }


   // tv3.setText(Integer.toString(meTransport));
   // tv4.setText(Integer.toString(youTransport));
    tv5.setText(distance);




    }

    private String getUrl(double lat1, double lng1, double lat2, double lng2, int mode){
        StringBuilder googleSearchString = new StringBuilder("https://maps.googleapis.com/maps/api/directions/json?");
        googleSearchString.append("origin=" + Double.toString(lat1) + "," + Double.toString(lng1));
        googleSearchString.append("&destination=" + Double.toString(lat2) + "," + Double.toString(lng2));
        if(mode == 1){
            googleSearchString.append("&mode=driving");
        }
        else if(mode == 2){
            googleSearchString.append("&mode=walking");
        }
        else if(mode == 3){
            googleSearchString.append("&mode=bicycling");
        }
        else if(mode == 4){
            googleSearchString.append("&mode=transit");
        }
        else{
            googleSearchString.append("&mode=driving");
        }

        googleSearchString.append("&key=AIzaSyC82w_trYreOcNEokO6Bvf7JmUukZo84Qs");

        return (googleSearchString.toString());
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

}

