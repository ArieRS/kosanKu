package com.ui.asynctask;

import android.os.AsyncTask;

public class tambahKosAsynctask extends AsyncTask<String, Void, String>{

	@Override
	protected String doInBackground(String... params) {
//		try {
//			JSONObject json = new JSONObject();
//			json.put("nit", mAddKematianModelSync.getNit());
//			json.put("tanggal_kematian", mAddKematianModelSync.getTanggal_kematian());
//			json.put("sebab_kematian", mAddKematianModelSync.getSebab_kematian());
//			json.put("idl_kematian", mAddKematianModelSync.getIdl_kematian());
//			json.put("id_petugas", mAddKematianModelSync.getId_petugas());
//			json.put("user", mAddKematianModelSync.getUser());
//			json.put("pass", mAddKematianModelSync.getPass());
//			json.put("guid", mAddKematianModelSync.getGuid());
//			json.put("transaksi",
//					mContext.getResources().getString(
//							R.string.add_data_kematian));
//
//			Log.d("json", json.toString());
//
//			return HttpRequestHelper.doPost(
//					mContext.getResources().getString(
//							R.string.url_insert_data_kematian), json);

//		} catch (JSONException e) {
//			e.printStackTrace();
//		}
		return null;
	}
	
}
