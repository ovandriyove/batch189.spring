package com.bootcamp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="tblBiodata")
public class Biodata implements Serializable {
	
	@Id
	@Column(name="nim", length=10, nullable=false)
	private String nim;
	
	@Column(name="nama", length=100, nullable=false)
	private String nama;
	
	@Column(name="alamat", length=100)
	private String alamat;
	
	@Column(name="jurusan", length=100)
	private String jurusan;
	
	@Column(name="universitas", length=100)
	private String universitas;
	
	@Column(name="tanggalLahir")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date tanggalLahir;
	
	@Column(name="telp", length=20)
	private String telp;
	
	@Column(name="email", length=100)
	private String email;
	
	public String getNim() {
		return nim;
	}
	public void setNim(String nim) {
		this.nim = nim;
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
	public String getJurusan() {
		return jurusan;
	}
	public void setJurusan(String jurusan) {
		this.jurusan = jurusan;
	}
	public Date getTanggalLahir() {
		return tanggalLahir;
	}
	public void setTanggalLahir(Date tanggalLahir) {
		this.tanggalLahir = tanggalLahir;
	}
	public String getTelp() {
		return telp;
	}
	public void setTelp(String telp) {
		this.telp = telp;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUniversitas() {
		return universitas;
	}
	public void setUniversitas(String universitas) {
		this.universitas = universitas;
	}

}
