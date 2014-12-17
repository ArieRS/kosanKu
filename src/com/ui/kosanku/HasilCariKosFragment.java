package com.ui.kosanku;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.ui.common.DatabaseHelper;
import com.ui.common.SessionManager;

public class HasilCariKosFragment extends Fragment {
	Context mContext;
	Activity activity;
	ActionBar actioncBar;
	ListView listView;
	DatabaseHelper db;
	SessionManager sessionManager;
	
	public HasilCariKosFragment(Context context) {
		mContext = context;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		View rootView = inflater.inflate( R.layout.list_view_fragment_cari_kos, container, false);
		listView = (ListView) rootView.findViewById(R.id.ListFragmentHasilPencarian);
		logicControl();
		return rootView;
	}
	private void logicControl() {
		//HasilPencarianKosAdapter adapter = new HasilPencarianKosAdapter(context, resource, listOfDataKos)
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//				Fragment fragment = new DetailDataSapiFragment(mActivity, mContext, mData_SapiList.get(position));
//				if (fragment != null) {
//					General.replaceFragmentAddBackStack(fragment,getFragmentManager());
//				}
			}
		});
	}

//	public HasilCariKosFragment(Context context) {
//		mContext = context;
//		db = new DatabaseHelper(mContext);
//		sessionManager = new SessionManager(mContext);
//	}

//	@Override
//	public void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		activity = (Activity) mContext;
//		 actioncBar = activity.getActionBar();
//		// actioncBar.setHomeButtonEnabled(true);
//		 actioncBar.setDisplayHomeAsUpEnabled(true);
//		// setHasOptionsMenu(true);
//	}

//	private void setLayout(LayoutInflater inflater, View resultView) {
//		listView = (ListView) resultView
//				.findViewById(R.id.ListFragmentHasilPencarian);
//
//		HasilPencarianKosAdapter adapter = new HasilPencarianKosAdapter(
//				mContext, R.layout.item_list_data_kosan,
//				db.getLaporanLokasi(sessionManager.getIdKabupatenKota(),
//						sessionManager.getIdProvinsi(),
//						sessionManager.getIdLevelAdmin()));
//		adapter.notifyDataSetChanged();
//		listView.setAdapter(adapter);
//	}

//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//		switch (item.getItemId()) {
//		case android.R.id.home:
//			actioncBar.setDisplayHomeAsUpEnabled(false);
////			actioncBar.setHomeButtonEnabled(false);
//			Fragment fragment = new ReportDataFragment(mContext);
//			General.replaceFragment(fragment, getFragmentManager());
//			break;
//		default:
//			break;
//		}
//		return super.onOptionsItemSelected(item);
//	}
//	@Override
//	public void setInitialSavedState(SavedState state) {
//		super.setInitialSavedState(state);
//	}
//	
//	@Override
//	public void onActivityCreated(Bundle savedInstanceState) {
//		super.onActivityCreated(savedInstanceState);
//	}
//
//	@Override
//	public void onSaveInstanceState(Bundle outState) {
//		super.onSaveInstanceState(outState);
//	}
}
