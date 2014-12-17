package com.ui.common;

import java.util.ArrayList;
import com.ui.model.database.mdKosan;
import com.ui.model.sync.CariKosModelSync;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);		
	}
	// Database Name
	private static final String DATABASE_NAME = "db_sig";
	public static final String DB_PATH = "/data/data/com.ui.kosanku/databases/";
	// Database Version
	private static final int DATABASE_VERSION = 1;

	// Table Names
	// MASTER
	private static final String TABLE_KOSAN = "kosan";
	private static final String TABLE_INF_LOKASI = "inf_lokasi";
	private static final String TABLE_TLU_FASILITAS = "tlu_fasilitas";
	private static final String TABLE_FASILITAS_KOS = "fasilitas_kos";
	private static final String TABLE_WP_USER = "wp_users";
	
	
	// TABLE_KOSAN Table - column names
	private static final String KEY_ID = "id";
	private static final String KEY_NAMA = "nama";
	private static final String KEY_ALAMAT = "alamat";
	private static final String KEY_HARGA_MIN = "harga_min";
	private static final String KEY_HARGA_MAX = "harga_max";
	private static final String KEY_FOTO = "foto";
	private static final String KEY_JUMLAH_KAMAR = "jumlah_kamar";
	private static final String KEY_FASILITAS = "fasilitas";
	private static final String KEY_LONGITUDE = "longitude";
	private static final String KEY_LATITUDE = "latitude";
	private static final String KEY_NAMA_CP = "nama_cp";
	private static final String KEY_TELP_CP = "telp_cp";
	private static final String KEY_ID_LOKASI = "id_lokasi";
	
	
	// inf_lokasi Table - column names
	private static final String KEY_LOKASI_ID = "lokasi_ID";
	private static final String KEY_KODE = "lokasi_kode";
	private static final String KEY_LOKASI_NAMA = "lokasi_nama";
	private static final String KEY_LOKASI_PROPINSI = "lokasi_propinsi";
	private static final String KEY_LOKASI_KABUPATENKOTA = "lokasi_kabupatenkota";
	private static final String KEY_LOKASIKECAMATAN = "lokasi_kecamatan";
	private static final String KEY_KELURAHAN = "lokasi_kelurahan";
	
	// TABLE_TLU_FASILITAS Table - column names
	private static final String KEY_TLU_ID = "id";
	private static final String KEY_TLU_NAMA = "nama";
	
	// TABLE_FASILITAS_KOS - column names
	private static final String KEY_FASILITAS_ID = "id";
	private static final String KEY_FASILITAS_ID_KOS = "id_kos";
	private static final String KEY_FASILITAS_ID_FASILITAS = "id_fasilitas";
	
	// TABLE_WP_USER Table - column names
	private static final String KEY_User_ID = "ID";
	private static final String KEY_User_LOGIN = "user_login";
	private static final String KEY_User_PASS = "user_pass";
	private static final String KEY_User_NICENAME = "user_nicename";
	private static final String KEY_User_EMAIL = "user_email";
	private static final String KEY_User_URL= "user_url";
	private static final String KEY_User_REGISTERED = "user_registered";
	private static final String KEY_User_ACTIVATION = "user_activation_key";
	private static final String KEY_User_STATUS = "user_status";
	private static final String KEY_User_DISPLAY_NAME = "display_name";
	
	
	private static final String CREATE_TABLE_KOSAN = "CREATE TABLE "
			+ TABLE_KOSAN
			+ " ( "
			+ KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ KEY_NAMA + " TEXT, "
			+ KEY_ALAMAT + " TEXT, "
			+ KEY_HARGA_MIN + " INT, "
			+ KEY_HARGA_MAX + " INT, "
			+ KEY_FOTO + " TEXT, "
			+ KEY_JUMLAH_KAMAR + " INT, "
			+ KEY_FASILITAS + " TEXT, "
			+ KEY_LONGITUDE + " DOUBLE, "
			+ KEY_LATITUDE + " DOUBLE, "
			+ KEY_NAMA_CP + " TEXT, "
			+ KEY_TELP_CP + " TEXT, "
			+ KEY_ID_LOKASI + " TEXT"
			+ " ) ";
	
	private static final String CREATE_TABLE_TLU_FASILITAS = " CREATE TABLE "
			+ TABLE_TLU_FASILITAS
			+ " ( "
			+ KEY_TLU_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ KEY_TLU_NAMA + " TEXT"			
			+ " ) ";

	private static final String CREATE_TABLE_INF_LOKASI = " CREATE TABLE "
			+ TABLE_TLU_FASILITAS
			+ " ( "
			+ KEY_LOKASI_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ KEY_KODE + " TEXT, "
			+ KEY_LOKASI_NAMA + " TEXT, "
			+ KEY_LOKASI_PROPINSI + " INT, "
			+ KEY_LOKASI_KABUPATENKOTA + " INT, "
			+ KEY_LOKASIKECAMATAN + " INT, "
			+ KEY_KELURAHAN + " INT"
			+ " ) ";	
	
	private static final String CREATE_TABLE_FASILITAS_KOS = " CREATE TABLE "
			+ TABLE_FASILITAS_KOS
			+ " ( "
			+ KEY_FASILITAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ KEY_FASILITAS_ID_KOS + " INT, "
			+ KEY_FASILITAS_ID_FASILITAS + " INT"
			+ " ) ";

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_TABLE_KOSAN);
		db.execSQL(CREATE_TABLE_TLU_FASILITAS);
		db.execSQL(CREATE_TABLE_INF_LOKASI);
		db.execSQL(CREATE_TABLE_FASILITAS_KOS);
		try {
			Log.d("create", "sukses");
		} catch (Exception e) {
			Log.d("creat", e.getMessage());
		}
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		if (newVersion > oldVersion){
			db.execSQL("DROP TABLE IF EXISTS " + TABLE_KOSAN);
			db.execSQL("DROP TABLE IF EXISTS " + TABLE_TLU_FASILITAS);
			db.execSQL("DROP TABLE IF EXISTS " + TABLE_INF_LOKASI);
			db.execSQL("DROP TABLE IF EXISTS " + TABLE_FASILITAS_KOS);
			onCreate(db);
		}
	}
	public void deleteAllTable(Context context){
		SQLiteDatabase db = this.getWritableDatabase();
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_KOSAN);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_TLU_FASILITAS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_INF_LOKASI);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_FASILITAS_KOS);
		
		context.deleteDatabase(DB_PATH + DATABASE_NAME);
	}
	// closing database
	public void closeDB() {
		SQLiteDatabase db = this.getReadableDatabase();
		if (db != null && db.isOpen())
			db.close();
	}

	@Override
	public synchronized void close() {
		closeDB();
	}
	
	//////////////////////query/////////////
	//////////////////////query/////////////
	// 1 controller mdKosan
		public long createMdKosan(mdKosan kosanModel) {
			SQLiteDatabase db = this.getWritableDatabase();

			ContentValues values = new ContentValues();
			values.put(KEY_ID, kosanModel.getId());
			values.put(KEY_NAMA, kosanModel.getNama());
			values.put(KEY_ALAMAT, kosanModel.getAlamat());
			values.put(KEY_HARGA_MIN, kosanModel.getHarga_min());
			values.put(KEY_HARGA_MAX, kosanModel.getHarga_max());
			values.put(KEY_FOTO, kosanModel.getFoto());
			values.put(KEY_JUMLAH_KAMAR, kosanModel.getJumlahKamar());
			values.put(KEY_FASILITAS, kosanModel.getFasilitas());
			values.put(KEY_LONGITUDE, kosanModel.getLongitude());
			values.put(KEY_LATITUDE, kosanModel.getLatitude());
			values.put(KEY_NAMA_CP, kosanModel.getNamaCp());
			values.put(KEY_TELP_CP, kosanModel.getTelpCp());
			values.put(KEY_ID_LOKASI, kosanModel.getId_lokasi());
			// insert row
			long todo_id = db.insertOrThrow(TABLE_KOSAN, null, values);

			return todo_id;
		}
		
		public long updateMdKosan(mdKosan kosanModel) {
			SQLiteDatabase db = this.getWritableDatabase();

			ContentValues values = new ContentValues();
			values.put(KEY_NAMA, kosanModel.getNama());
			// insert row
			long todo_id = db.update(TABLE_KOSAN, values, KEY_ID
					+ " = " +  kosanModel.getId(), null);
			return todo_id;
		}
		
		public long deleteMdKosan(int id) {
			SQLiteDatabase db = this.getWritableDatabase();
	 
			long todo_id = db.delete(TABLE_KOSAN, KEY_ID
					+ " = " + id, null);
			return todo_id;
		}
		
		public ArrayList<String> getAllNamaKosan() {
			ArrayList<String> listString = new ArrayList<String>();
			String query = "SELECT " + KEY_NAMA + " FROM "
					+ TABLE_KOSAN;

			SQLiteDatabase db = this.getReadableDatabase();
			Cursor c = db.rawQuery(query, null);

			if (c.moveToFirst()) {
				do {
					String namaKos = "";
					namaKos = c.getString(c.getColumnIndex(KEY_NAMA));

					// adding to todo list
					listString.add(namaKos);
				} while (c.moveToNext());
			}
			return listString;
		}
		
		public mdKosan getKosanById(int id) {
			String selectQuery = "SELECT  * FROM " + TABLE_KOSAN + " WHERE "
					+ KEY_ID + " = " + id + ";";
			mdKosan value = new mdKosan();

			SQLiteDatabase db = this.getReadableDatabase();
			Cursor c = db.rawQuery(selectQuery, null);
			if (c.moveToFirst()) {
				value.setId(c.getInt(c.getColumnIndex(KEY_ID)));
				value.setNama(c.getString(c.getColumnIndex(KEY_NAMA)));
				value.setAlamat(c.getString(c.getColumnIndex(KEY_ALAMAT)));
				value.setHarga_min(c.getInt(c.getColumnIndex(KEY_HARGA_MIN)));
				value.setHarga_max(c.getInt(c.getColumnIndex(KEY_HARGA_MAX)));
				value.setFoto(c.getString(c.getColumnIndex(KEY_FOTO)));
				value.setJumlahKamar(c.getInt(c.getColumnIndex(KEY_JUMLAH_KAMAR)));
				value.setFasilitas(c.getString(c.getColumnIndex(KEY_FASILITAS)));
				value.setLongitude(c.getDouble(c.getColumnIndex(KEY_LONGITUDE)));
				value.setLatitude(c.getDouble(c.getColumnIndex(KEY_LATITUDE)));
				value.setNamaCp(c.getString(c.getColumnIndex(KEY_NAMA_CP)));
				value.setTelpCp(c.getString(c.getColumnIndex(KEY_TELP_CP)));
				value.setId_lokasi(c.getInt(c.getColumnIndex(KEY_ID_LOKASI)));				
			}
			return value;
		}
		
		public void deleteKosanById(int id) {
			SQLiteDatabase db = this.getWritableDatabase();
			db.delete(TABLE_KOSAN, KEY_ID + " = ?",
					new String[] { String.valueOf(id) });
		}
		
		public int updateToDo(mdKosan kosanModel) {
			SQLiteDatabase db = this.getWritableDatabase();

			ContentValues values = new ContentValues();
			values.put(KEY_ID, kosanModel.getId());
			values.put(KEY_NAMA, kosanModel.getNama());
			values.put(KEY_ALAMAT, kosanModel.getAlamat());
			values.put(KEY_HARGA_MIN, kosanModel.getHarga_min());
			values.put(KEY_HARGA_MAX, kosanModel.getHarga_max());
			values.put(KEY_FOTO, kosanModel.getFoto());
			values.put(KEY_JUMLAH_KAMAR, kosanModel.getJumlahKamar());
			values.put(KEY_FASILITAS, kosanModel.getFasilitas());
			values.put(KEY_LONGITUDE, kosanModel.getLongitude());
			values.put(KEY_LATITUDE, kosanModel.getLatitude());
			values.put(KEY_NAMA_CP, kosanModel.getNamaCp());
			values.put(KEY_TELP_CP, kosanModel.getTelpCp());
			values.put(KEY_ID_LOKASI, kosanModel.getId_lokasi());

			// updating row
			return db
					.update(TABLE_KOSAN, values, KEY_ID + " = ?",
							new String[] { String.valueOf(kosanModel.getId()) });
		}
		
		public ArrayList<mdKosan> getAllKosan() {
			ArrayList<mdKosan> kosList = new ArrayList<mdKosan>();
			String selectQuery = "SELECT  * FROM " + TABLE_KOSAN;

			SQLiteDatabase db = this.getReadableDatabase();
			Cursor c = db.rawQuery(selectQuery, null);

			// looping through all rows and adding to list
			if (c.moveToFirst()) {
				do {
					mdKosan value = new mdKosan();
					value.setId(c.getInt(c.getColumnIndex(KEY_ID)));
					value.setNama(c.getString(c.getColumnIndex(KEY_NAMA)));
					value.setAlamat(c.getString(c.getColumnIndex(KEY_ALAMAT)));
					value.setHarga_min(c.getInt(c.getColumnIndex(KEY_HARGA_MIN)));
					value.setHarga_max(c.getInt(c.getColumnIndex(KEY_HARGA_MAX)));
					value.setFoto(c.getString(c.getColumnIndex(KEY_FOTO)));
					value.setJumlahKamar(c.getInt(c.getColumnIndex(KEY_JUMLAH_KAMAR)));
					value.setFasilitas(c.getString(c.getColumnIndex(KEY_FASILITAS)));
					value.setLongitude(c.getDouble(c.getColumnIndex(KEY_LONGITUDE)));
					value.setLatitude(c.getDouble(c.getColumnIndex(KEY_LATITUDE)));
					value.setNamaCp(c.getString(c.getColumnIndex(KEY_NAMA_CP)));
					value.setTelpCp(c.getString(c.getColumnIndex(KEY_TELP_CP)));
					value.setId_lokasi(c.getInt(c.getColumnIndex(KEY_ID_LOKASI)));

					// adding to todo list
					kosList.add(value);
				} while (c.moveToNext());
			}
			return kosList;
		}
		
		public int getIdKosan(String namaKos) {
			ArrayList<mdKosan> kosanList = new ArrayList<mdKosan>();
			String selectQuery = "SELECT " + KEY_ID + " FROM "
					+ TABLE_KOSAN + " WHERE " + KEY_NAMA + " = '"
					+ namaKos + "' ;";

			SQLiteDatabase db = this.getReadableDatabase();
			Cursor c = db.rawQuery(selectQuery, null);

			// looping through all rows and adding to list
			int value = 0;
			if (c.moveToFirst()) {
				value = (c.getInt(c.getColumnIndex(KEY_ID)));
			}
			return value;
		}
		
	
	
	
	///////////////////end query/////////////
	//////////////////end query/////////////

}

