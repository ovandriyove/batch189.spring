package com.bootcamp.dao;

import java.util.Collection;

import com.bootcamp.model.Biodata;

public interface BiodataDao {
	public Biodata findOne(String id);
	public Collection<Biodata> findAll();
	public Biodata update(Biodata biodata);
	public void delete(Biodata biodata);
	public void deleteById(String id);
	public void save(Biodata biodata);
}
