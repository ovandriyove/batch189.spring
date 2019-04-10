package com.bootcamp.web;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.model.Biodata;
import com.bootcamp.service.BiodataService;


@RestController
@RequestMapping("/biodata-rest")
public class BiodataRestController {
	
	@Autowired
	private BiodataService biodataService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<Collection<Biodata>> listBiodata(HttpServletRequest req) {
		Collection<Biodata> list = biodataService.findAll();
		ResponseEntity<Collection<Biodata>> result = new ResponseEntity<>(list, HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value="/{nim}", method=RequestMethod.GET)
	public ResponseEntity<Biodata> listBiodata(@PathVariable("nim") String nim) {
	    Biodata biodata = biodataService.findOne(nim);
		ResponseEntity<Biodata> result = new ResponseEntity<>(biodata, HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ResponseEntity<Biodata> simpanBiodata(@RequestBody Biodata biodata, HttpServletRequest req) {
		biodataService.save(biodata);	
		ResponseEntity<Biodata> result = new ResponseEntity<>(HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value="/{nim}", method=RequestMethod.DELETE)
	public ResponseEntity<Collection<Biodata>> deleteBiodata(@PathVariable("nim") String nim) {
        biodataService.deleteById(nim);
		ResponseEntity<Collection<Biodata>> result = new ResponseEntity<>(HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value="/", method=RequestMethod.PUT)
	public ResponseEntity<Biodata> updateBiodata(@RequestBody Biodata biodata) {
		Biodata biodataBaru = biodataService.update(biodata);
		ResponseEntity<Biodata> result = new ResponseEntity<>(biodataBaru, HttpStatus.OK);
		return result;
	}
}


//		HttpSession session = req.getSession();
//		Collection<Biodata> list = null;
//		if (session.getAttribute("list") != null) {
//			list = (Collection<Biodata>) session.getAttribute("list");
//		}else {
//			list = new ArrayList<>();
//			session.setAttribute("list", list);
//		}

//		HttpSession session =req.getSession();
//		Collection<Biodata> list = null;
//		if (session.getAttribute("list") != null) {
//			list = (Collection<Biodata>) session.getAttribute("list");
//		}else {
//			list = new ArrayList<>();
//			session.setAttribute("list", list);
//		}
//		list.add(biodata);