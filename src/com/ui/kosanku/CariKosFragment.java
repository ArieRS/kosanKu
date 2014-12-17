package com.ui.kosanku;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;

public class CariKosFragment extends Fragment {
	
	Button buttonCari;
	Context mContext;
	public CariKosFragment(Context context){
		mContext  = context;
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_cari_kos, container, false);
        buttonCari = (Button) rootView.findViewById(R.id.buttonCari);
		logicControl();
		
		AsyncHttpClient client = new AsyncHttpClient();
		client.setTimeout(6000);
	
		client.get(getResources().getString(R.string.url_select_all), new JsonHttpResponseHandler(){

			@Override
			public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
				super.onSuccess(statusCode, headers, response);
				
				
				for (int ii= 0 ; ii < response.length(); ii++){
					try {
//						String jsonString = json
						JSONObject newJsonObject = response.getJSONObject(ii);
//						newJsonObject.getJSONObject(get)
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
				
				Toast.makeText(mContext, response.toString(), Toast.LENGTH_LONG).show();
			}
		});
		
		
        return rootView;
    }
	private void logicControl() {
		buttonCari.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Fragment fragment  = new HasilCariKosFragment(mContext);
				FragmentManager fragmentManager = getActivity().getFragmentManager();
				fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();
			}
		});
	}
	
}
