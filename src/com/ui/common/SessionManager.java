package com.ui.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SessionManager {

	SharedPreferences pref;
	Editor editor;
	Context mContext;
	int PRIVATE_MODE = 0;
	private static final String PREF_NAME = "kosankuPref";
	private static final String IS_LOGIN = "IsLoggedIn";
	public static final String KEY_USERNAME = "username";
	public static final String KEY_PASSWORD = "password";
	public static final String KEY_PERAN = "peran";
	
	// Constructor
	public SessionManager(Context context) {
		this.mContext = context;
		pref = mContext.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
	}

	public void createLoginSession(String name, String password) {
		editor = pref.edit();
		editor.putBoolean(IS_LOGIN, true);
		editor.putString(KEY_USERNAME, name);
		editor.putString(KEY_PASSWORD, password);
		editor.commit();
	}

	public void createLoginSession(String username, String password,
			String peran, int id_level_admin, int id_kabupaten_kota,
			int id_provinsi) {
		editor =  pref.edit();
		editor.putBoolean(IS_LOGIN, true);
		editor.putString(KEY_USERNAME, username);
		editor.putString(KEY_PASSWORD, password);
		editor.putString(KEY_PERAN, peran);
		editor.commit();
	}
	public void createEditPeran(String peran) {
		editor = pref.edit();
		editor.putString(KEY_PERAN, peran);
		editor.commit();
	}

	public void Logout() {
		editor = pref.edit();
		editor.clear();
		editor.commit();
	}

	public boolean isLogin() {
		return pref.getBoolean(IS_LOGIN, false);
	}

	public String getUserame() {
		String name = "";
		name = pref.getString(KEY_USERNAME, "admin");
		return name;
	}

	public String getPassword() {
		String password = "";
		password = pref.getString(KEY_PASSWORD, "admin");
		return password;
	}

	public String getPeran() {
		String peran = "";
		peran = pref.getString(KEY_PERAN, "admin");
		return peran;
	}
}
