package com.bootcamp.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.dao.BiodataDao;
import com.bootcamp.model.Biodata;

@Service
@Transactional
public class BiodataServiceImpl implements BiodataService {
	
	@Autowired
	private BiodataDao biodataDao;
	
	@Override
	public Biodata findOne(String id) {
		return biodataDao.findOne(id);
	}
	
	@Override
	public void save(Biodata biodata) {
		biodataDao.save(biodata);
	}
	
	@Override
	public Collection<Biodata> findAll(){
		return biodataDao.findAll();
	}
	
	@Override
	public Biodata update(Biodata biodata) {
		return biodataDao.update(biodata);
	}
	
	@Override
	public void delete(Biodata biodata) {
		biodataDao.delete(biodata);
	}
	
	@Override
	public void deleteById(String id) {
		biodataDao.deleteById(id);
	}
}
