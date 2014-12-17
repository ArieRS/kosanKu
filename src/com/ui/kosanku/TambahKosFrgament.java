package com.ui.kosanku;

import java.util.ArrayList;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.ui.common.GPSTracker;

/**
 * Created by arierachmadsyulistyo on 12/12/14.
 */

public class TambahKosFrgament extends Fragment {

	EditText edtLatitude, edtLongitude;
	Button btnShowLocation, btnSimpan, btnCancel;
	// GPSTracker class
	GPSTracker gps;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_tambah_kos, container, false);
        btnShowLocation = (Button) rootView.findViewById(R.id.buttonGPS);
        btnSimpan = (Button) rootView.findViewById(R.id.buttonSimpanTambahKos);
        btnCancel = (Button) rootView.findViewById(R.id.buttonBatalTambahKos);
        
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
		
		btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 100);
            }
        });
		
		btnSimpan.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				postServer();
			}
			
		});
	}
	private void postServer() {
//		 	RequestParams requestParams = new RequestParams();
//	        requestParams.put("nama","nama");
//	        requestParams.put("alamat","alamat");
//	        requestParams.put("jumlah_kamar","jumlah_kamar");
//	        requestParams.put("harga_min","harga_min");
//	        requestParams.put("harga_max","harga_max");
//	        requestParams.put("koodinat",edtLatitude.getText().toString()+","+edtLongitude.getText().toString());
//	        
//	        ArrayList<String> tlu_fasilitas;
//	        tlu_fasilitas.add("1");
//	        tlu_fasilitas.add("2");
//	        tlu_fasilitas.add("3");
//	        
//	        requestParams.put("fasilitas",tlu_fasilitas);
//	        requestParams.put("nama_cp","nama_cp");
//	        requestParams.put("telpn_p","telpn_cp");
//	        requestParams.put("prop","34");
//	        requestParams.put("kota","34");
//	        requestParams.put("kecamatan","35");
//	        requestParams.put("kel","35");
//
//	        try {
//	            requestParams.put("foto",filePath);
//
//	        } catch (Exception e) {
//
//	        }
//	        AsyncHttpClient client = new AsyncHttpClient();
//	        client.setTimeout(6000);
//	        client.post(url,requestParams,new AsyncHttpResponseHandler() {
//	            @Override
//	            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
//	                dialog.dismiss();
//	                fetchResponse(new String(responseBody));
//	            }
//
//
//	            @Override
//	            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
//	                   dialog.dismiss();
//	                Toast.makeText(AddEmployeeActivity.this, "gagal", Toast.LENGTH_LONG).show();
//	            }
//	        });
	}
	
//	@Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if(resultCode==RESULT_OK){
//            Uri selectedImageUri= data.getData();
//
//            SelectedImagePath= Utils.getRealPathFromURI(AddEmployeeActivity.this,selectedImageUri);
//            imgPhoto.setImageURI(selectedImageUri);
//        }
//    }
}
