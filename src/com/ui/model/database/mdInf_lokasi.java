package com.ui.model.database;

import com.google.gson.annotations.SerializedName;

public class mdInf_lokasi {
	@SerializedName("lokasi_ID")
	int lokasi_ID;
	
	@SerializedName("lokasi_kode")
	String lokasi_kode;
	
	@SerializedName("lokasi_nama")
	String lokasi_nama;
	
	@SerializedName("lokasi_propinsi")
	String lokasi_propinsi;
	
	@SerializedName("lokasi_kabupatenkota")
	String lokasi_kabupatenkota;
	
	@SerializedName("lokasi_kecamatan")
	String lokasi_kecamatan;
	
	@SerializedName("lokasi_kelurahan")
	String lokasi_kelurahan;
	
	public int getLokasi_ID() {
		return lokasi_ID;
	}
	public void setLokasi_ID(int lokasi_ID) {
		this.lokasi_ID = lokasi_ID;
	}
	
	public String getLokasi_kode() {
		return lokasi_kode;
	}
	public void setLokasi_kode(String lokasi_kode) {
		this.lokasi_kode = lokasi_kode;
	}
	
	public String getLokasi_nama() {
		return lokasi_nama;
	}
	public void setLokasi_nama(String lokasi_nama) {
		this.lokasi_nama = lokasi_nama;
	}
	
	public String getLokasi_propinsi() {
		return lokasi_propinsi;
	}
	public void setLokasi_propinsi(String lokasi_propinsi) {
		this.lokasi_propinsi = lokasi_propinsi;
	}
	
	public String getLokasi_kabupatenkota() {
		return lokasi_kabupatenkota;
	}
	public void setLokasi_kabupatenkota(String lokasi_kabupatenkota) {
		this.lokasi_kabupatenkota = lokasi_kabupatenkota;
	}
	
	public String getLokasi_kecamatan() {
		return lokasi_kecamatan;
	}
	public void setLokasi_kecamatan(String lokasi_kecamatan) {
		this.lokasi_kecamatan = lokasi_kecamatan;
	}
	
	public String getLokasi_kelurahan() {
		return lokasi_kelurahan;
	}
	public void setLokasi_kelurahan(String lokasi_kelurahan) {
		this.lokasi_kelurahan = lokasi_kelurahan;
	}

}
