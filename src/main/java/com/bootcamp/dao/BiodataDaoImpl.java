package com.bootcamp.dao;

import org.springframework.stereotype.Repository;

import com.bootcamp.model.Biodata;
@Repository
public class BiodataDaoImpl extends AbstractHibernateDao<Biodata> implements BiodataDao {
	
	public BiodataDaoImpl() {
		setClazz(Biodata.class);
	}
}
