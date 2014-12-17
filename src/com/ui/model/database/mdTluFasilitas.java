package com.ui.model.database;

import com.google.gson.annotations.SerializedName;

public class mdTluFasilitas {
	@SerializedName("id")
	int id;
	
	@SerializedName("nama")
	String nama;
	
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

}
