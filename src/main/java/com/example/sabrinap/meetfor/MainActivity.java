package com.example.sabrinap.meetfor;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final int ERROR_DIALOG_REQUEST = 9001;
    double meLat = 0;
    double meLng = 0;
    double youLat = 0;
    double youLng = 0;
    int meTransportation = 1;
    int youTransportation = 1;
    int meYou = 1;
    static final int getLocationRequestCode = 1348;
    ArrayList<String> meLocation;

    private TextView mTextMessage;

    private void init(){
        Button button_my_location = (Button) findViewById(R.id.button_my_location);
        button_my_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapActivity.class);
                startActivityForResult(intent, getLocationRequestCode);
            }
        });
    }

    private BottomNavigationView.OnNavigationItemSelectedListener transSelectorListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.trans_car:
                    if(meYou == 1){
                        meTransportation = 1;
                    }
                    else if (meYou ==2){
                        youTransportation = 1;
                    }
                    return true;
                case R.id.trans_walk:
                    if(meYou == 1){
                        meTransportation = 2;
                    }
                    else if (meYou ==2){
                        youTransportation = 2;
                    }
                    return true;
                case R.id.trans_bike:
                    if(meYou == 1){
                        meTransportation = 3;
                    }
                    else if (meYou ==2){
                        youTransportation = 3;
                    }
                    return true;
                case R.id.trans_transit:
                    if(meYou == 1){
                        meTransportation = 4;
                    }
                    else if (meYou ==2){
                        youTransportation = 4;
                    }
                    return true;
            }
            return false;
        }
    };




    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Button mButton = findViewById(R.id.button_my_location);
            TextView mText = findViewById(R.id.meetForTextView);
            EditText mEditText = findViewById(R.id.forSearchText);
            BottomNavigationView transportation = findViewById(R.id.transportation);
            ImageView arrow1 = findViewById(R.id.arrow1);
            ImageView arrow2 = findViewById(R.id.arrow2);
            Button searchButton = findViewById(R.id.sendSearchButton);
            TextView searchError = findViewById(R.id.searchErrorText);
            TextView searchBoxError = findViewById(R.id.searchBoxErrorText);
            switch (item.getItemId()) {
                case R.id.button_me_page:
                    mTextMessage.setText(R.string.me_page);
                    mButton.setVisibility(mButton.VISIBLE);
                    mText.setVisibility(mText.INVISIBLE);
                    mButton.setText("where am I?");
                    mEditText.setVisibility(mEditText.INVISIBLE);
                    transportation.setVisibility(transportation.VISIBLE);
                    arrow1.setVisibility(arrow1.VISIBLE);
                    arrow2.setVisibility(arrow2.INVISIBLE);
                    searchButton.setVisibility(searchButton.INVISIBLE);
                    searchError.setVisibility(searchError.INVISIBLE);
                    searchBoxError.setVisibility(searchBoxError.INVISIBLE);
                    if(meTransportation == 1){
                        transportation.setSelectedItemId(R.id.trans_car);
                    }
                    else if(meTransportation == 2){
                        transportation.setSelectedItemId(R.id.trans_walk);
                    }
                    else if(meTransportation == 3){
                        transportation.setSelectedItemId(R.id.trans_bike);
                    }
                    else if(meTransportation == 4){
                        transportation.setSelectedItemId(R.id.trans_transit);
                    }
                    meYou = 1;
                    return true;
                case R.id.button_you_page:
                    mTextMessage.setText(R.string.you_page);
                    mButton.setVisibility(mButton.VISIBLE);
                    mText.setVisibility(mText.INVISIBLE);
                    mEditText.setVisibility(mEditText.INVISIBLE);
                    transportation.setVisibility(transportation.VISIBLE);
                    mButton.setText("where are you?");
                    arrow1.setVisibility(arrow1.INVISIBLE);
                    arrow2.setVisibility(arrow2.VISIBLE);
                    searchButton.setVisibility(searchButton.INVISIBLE);
                    searchError.setVisibility(searchError.INVISIBLE);
                    searchBoxError.setVisibility(searchBoxError.INVISIBLE);
                    if(youTransportation == 1){
                        transportation.setSelectedItemId(R.id.trans_car);
                    }
                    else if(youTransportation == 2){
                        transportation.setSelectedItemId(R.id.trans_walk);
                    }
                    else if(youTransportation == 3){
                        transportation.setSelectedItemId(R.id.trans_bike);
                    }
                    else if(youTransportation == 4){
                        transportation.setSelectedItemId(R.id.trans_transit);
                    }
                    meYou = 2;
                    return true;
                case R.id.button_for_page:
                    mTextMessage.setText(R.string.for_page);
                    mButton.setVisibility(mButton.INVISIBLE);
                    mText.setVisibility(mText.VISIBLE);
                    mEditText.setVisibility(mEditText.VISIBLE);
                    transportation.setVisibility(transportation.INVISIBLE);
                    arrow1.setVisibility(arrow1.INVISIBLE);
                    arrow2.setVisibility(arrow2.INVISIBLE);
                    searchButton.setVisibility(searchButton.VISIBLE);
                    searchError.setVisibility(searchError.INVISIBLE);
                    //searchBoxError.setVisibility(searchBoxError.INVISIBLE);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (isServicesOK()) {
            init();
        }

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        BottomNavigationView transTabs = (BottomNavigationView) findViewById(R.id.transportation);
        transTabs.setOnNavigationItemSelectedListener(transSelectorListener);

        TextView mText = findViewById(R.id.meetForTextView);
        mText.setVisibility(mText.INVISIBLE);
        EditText mEditText = findViewById(R.id.forSearchText);
        mEditText.setVisibility(mEditText.INVISIBLE);
        ImageView arrow1 = findViewById(R.id.arrow1);
        arrow1.setVisibility(arrow1.VISIBLE);
        ImageView arrow2 = findViewById(R.id.arrow2);
        arrow2.setVisibility(arrow2.INVISIBLE);
        Button searchButton = findViewById(R.id.sendSearchButton);
        searchButton.setVisibility(searchButton.INVISIBLE);
        TextView searchError = findViewById(R.id.searchErrorText);
        searchError.setVisibility(searchError.INVISIBLE);
        TextView searchBoxError = findViewById(R.id.searchBoxErrorText);
        searchBoxError.setVisibility(searchBoxError.INVISIBLE);


        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, SearchActivity.class);
                intent2.putExtra("meLat", meLat);
                intent2.putExtra("meLng", meLng);
                intent2.putExtra("meTransport", meTransportation);
                intent2.putExtra("youLat", youLat);
                intent2.putExtra("youLng", youLng);
                intent2.putExtra("youTransport", youTransportation);
                EditText searchText = findViewById(R.id.forSearchText);
                String searchString = searchText.getText().toString();
                intent2.putExtra("search", searchString);
                TextView searchError = findViewById(R.id.searchErrorText);
                TextView searchBoxError = findViewById(R.id.searchBoxErrorText);
                String errorString;
                String emptyString = " ";

                if(meLat != 0 && meLng != 0 && youLat !=0 && youLng !=0 && !(searchString.isEmpty())) {
                    startActivity(intent2);
                }
                else if(meLat == 0 && youLat == 0){
                    errorString = "please enter location for 'me' and 'you'";
                    searchError.setVisibility(searchError.VISIBLE);
                    searchError.setText(errorString);
                    if(searchString.isEmpty()){
                        searchBoxError.setVisibility(searchBoxError.VISIBLE);
                    }
                    else{
                        searchBoxError.setVisibility(searchBoxError.INVISIBLE);
                    }
                }
                else if(meLat == 0 && youLat != 0){
                    errorString = "please enter location for 'me'";
                    searchError.setVisibility(searchError.VISIBLE);
                    searchError.setText(errorString);
                    if(searchString.isEmpty()){
                        searchBoxError.setVisibility(searchBoxError.VISIBLE);
                    }
                    else{
                        searchBoxError.setVisibility(searchBoxError.INVISIBLE);
                    }
                }
                else if(meLat != 0 && youLat == 0){
                    errorString = "please enter location for 'you'";
                    searchError.setVisibility(searchError.VISIBLE);
                    searchError.setText(errorString);
                    if(searchString.isEmpty()){
                        searchBoxError.setVisibility(searchBoxError.VISIBLE);
                    }
                    else{
                        searchBoxError.setVisibility(searchBoxError.INVISIBLE);
                    }
                }
                else if(meLat != 0 && youLat != 0 && searchString.isEmpty()){
                    searchBoxError.setVisibility(searchBoxError.VISIBLE);
                }
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // check that it is the SecondActivity with an OK result
        if (requestCode == getLocationRequestCode) {
            if (resultCode == RESULT_OK) { // Activity.RESULT_OK
                if (meYou == 1){
                    meLat = data.getDoubleExtra("lat",0);
                    meLng = data.getDoubleExtra("lng", 0);
                }
                else if (meYou == 2){
                    youLat = data.getDoubleExtra("lat",0);
                    youLng = data.getDoubleExtra("lng", 0);
                }

            }
        }
    }




    //checking map services
    public boolean isServicesOK(){
        Log.d(TAG, "isServicesOK: checking google services version");
        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MainActivity.this);
        if(available == ConnectionResult.SUCCESS){
            Log.d(TAG, "isServicesOK: Google Play Services is working");
            return true;
        }
        else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)){
            Log.d(TAG, "isServicesOK: An error occurred but we can fix it");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(MainActivity.this, available, ERROR_DIALOG_REQUEST);
            dialog.show();
        }
        else{
            Toast.makeText(this, "You can't make map requests", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

}
