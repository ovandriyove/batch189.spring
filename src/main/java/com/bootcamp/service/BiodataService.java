package com.bootcamp.service;

import java.util.Collection;

import com.bootcamp.model.Biodata;

public interface BiodataService {
	public Biodata findOne(String id);
	public Collection<Biodata> findAll();
	public Biodata update(Biodata biodata);
	public void delete(Biodata biodata);
	public void deleteById(String id);
	public void save(Biodata biodata);
}
