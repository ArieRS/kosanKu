package com.ui.model.database;

import com.google.gson.annotations.SerializedName;

public class mdKosan {
	@SerializedName("id")
	int id;
	
	@SerializedName("nama")
	String nama;
	
	@SerializedName("alamat")
	String alamat;
	
	@SerializedName("harga_min")
	int harga_min;
	
	@SerializedName("harga_max")
	int harga_max;
	
	@SerializedName("foto")
	String foto;
	
	@SerializedName("jumlah_kamar")
	int jumlah_kamar;
	
	@SerializedName("fasilitas")
	String fasilitas;
	
	@SerializedName("longitude")
	double longitude;
	
	@SerializedName("latitude")
	double latitude;
	
	@SerializedName("nama_cp")
	String nama_cp;
	
	@SerializedName("telp_cp")
	String telp_cp;
	
	@SerializedName("id_lokasi")
	int id_lokasi;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	
	public int getHarga_min() {
		return harga_min;
	}
	public void setHarga_min(int harga_min) {
		this.harga_min = harga_min;
	}
	
	public int getHarga_max() {
		return harga_max;
	}
	public void setHarga_max(int harga_max) {
		this.harga_max = harga_max;
	}
	
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	public int getJumlahKamar() {
		return jumlah_kamar;
	}
	public void setJumlahKamar(int jumlah_kamar) {
		this.jumlah_kamar = jumlah_kamar;
	}
	
	public String getFasilitas() {
		return fasilitas;
	}
	public void setFasilitas(String fasilitas) {
		this.fasilitas = fasilitas;
	}
	
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public String getNamaCp() {
		return nama_cp;
	}
	public void setNamaCp(String nama_cp) {
		this.nama_cp = nama_cp;
	}
	
	public String getTelpCp() {
		return telp_cp;
	}
	public void setTelpCp(String telp_cp) {
		this.telp_cp = telp_cp;
	}
	
	public int getId_lokasi() {
		return id_lokasi;
	}
	public void setId_lokasi(int id_lokasi) {
		this.id_lokasi = id_lokasi;
	}
	

}
