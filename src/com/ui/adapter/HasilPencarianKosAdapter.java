package com.ui.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ui.kosanku.R;
import com.ui.model.sync.CariKosModelSync;

public class HasilPencarianKosAdapter extends ArrayAdapter<CariKosModelSync>{
	
	int resource;
	String response;
	Context mContext;

	public HasilPencarianKosAdapter(Context context, int resource,
			ArrayList<CariKosModelSync> listOfDataKos) {
		super(context, resource, listOfDataKos);
		this.resource = resource;
		this.mContext = context;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) mContext
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(resource, parent, false);
			holder = new ViewHolder();
			holder.textHeader = (TextView) convertView
					.findViewById(R.id.tvNamaKosan);
			holder.textDetail1 = (TextView) convertView
					.findViewById(R.id.tvAlamatKosan);
			holder.textDetail2 = (TextView) convertView
					.findViewById(R.id.tvNoTelpon);			
			
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		CariKosModelSync itemDataKos = (CariKosModelSync) getItem(position);
		holder.textHeader.setText("Nama Kos : " + itemDataKos.getNamaKos());
		// Relation
		holder.textDetail1.setText("Alamat : " + itemDataKos.getAlamat());
		holder.textDetail2.setText("No. Telpon : " + itemDataKos.getNoTelpon());		
		
		holder.imageView.setImageDrawable(mContext.getResources().getDrawable(R.drawable.home));
		
		return convertView;
	}
	@Override
	public boolean isEnabled(int position) {
		return false;
	}
	static class ViewHolder {
		TextView textHeader;
		TextView textDetail1;
		TextView textDetail2;		
		ImageView imageView;
	}


}
