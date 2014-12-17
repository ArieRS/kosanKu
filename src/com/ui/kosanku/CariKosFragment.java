package com.ui.kosanku;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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
