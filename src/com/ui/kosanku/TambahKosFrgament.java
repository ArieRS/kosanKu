package com.ui.kosanku;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.ui.common.GPSTracker;

/**
 * Created by arierachmadsyulistyo on 12/12/14.
 */

public class TambahKosFrgament extends Fragment {

	EditText edtLatitude, edtLongitude;
	Button btnShowLocation;
	// GPSTracker class
	GPSTracker gps;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_tambah_kos, container, false);
        btnShowLocation = (Button) rootView.findViewById(R.id.buttonGPS);
        edtLatitude = (EditText) rootView.findViewById(R.id.edtlatitude);
        edtLongitude = (EditText) rootView.findViewById(R.id.edtlongitude);
        logicControl();
        
        return rootView;
    }

	private void logicControl() {
		btnShowLocation.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// create class object
		        gps = new GPSTracker(getActivity());

				// check if GPS enabled		
		        if(gps.canGetLocation()){
		        	
		        	double latitude = gps.getLatitude();
		        	double longitude = gps.getLongitude();
		        	
		        	edtLatitude.setText(String.valueOf(latitude));
		        	edtLongitude.setText(String.valueOf(longitude));
		        		
		        }else{
		        	// can't get location
		        	// GPS or Network is not enabled
		        	// Ask user to enable GPS/network in settings
		        	gps.showSettingsAlert();
		        }
			}
		});
	}
}
