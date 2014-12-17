package com.ui.model.database;

import com.google.gson.annotations.SerializedName;

public class mdFasilitasKos {
	@SerializedName("id")
	int id;
	
	@SerializedName("id_kos")
	int id_kos;
	
	@SerializedName("id_fasilitas")
	int id_fasilitas;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId_Kos() {
		return id_kos;
	}
	public void setId_Kos(int id_kos) {
		this.id_kos = id_kos;
	}
	
	public int getId_Fasilitas() {
		return id_fasilitas;
	}
	public void setId_Fasilitas(int id_fasilitas) {
		this.id_fasilitas = id_fasilitas;
	}

}
