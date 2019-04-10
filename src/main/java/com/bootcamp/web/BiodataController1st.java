package com.bootcamp.web;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bootcamp.model.Biodata;

@Controller

public class BiodataController1st {
	
	@RequestMapping("biodata")
//	public String biodata(Model model) {
//		model.addAttribute("modus", "input");
	public String biodata() {
		return "biodata/biodata";
	}
	
//	@RequestMapping(value="biodata-save.html",method=RequestMethod.POST)
//	public String biodataSave(Model model, @ModelAttribute("nama") String x, @ModelAttribute("nim") String y) {
//		model.addAttribute("modus", "output");
//		model.addAttribute("nama", x);
//		model.addAttribute("nim", y);
//		return "biodata/biodata";
	
	@RequestMapping("biodata-reset")
	public String resetBiodata(HttpServletRequest req) {
		Collection<Biodata> biodataList = null;
		HttpSession session = req.getSession(true);
		if(session.getAttribute("list")!=null) {
			biodataList = (Collection<Biodata>) session.getAttribute("list");
			biodataList.clear();
		}
		return "biodata/biodata";
	}
	
//	@RequestMapping(value="biodata-save.html",method=RequestMethod.POST)
//	public String biodataSave(Model model, @ModelAttribute Biodata biodata) {
//		model.addAttribute("modus", "output");
//		model.addAttribute("dt", biodata);
//		return "biodata/biodata";
//	}
	
	//tidak digunakan
	@RequestMapping(value="biodata-save",method=RequestMethod.POST)
	public String biodataSave(Model model, @ModelAttribute Biodata biodata, HttpServletRequest req) {
		Collection<Biodata> biodataList = null;
		HttpSession session = req.getSession(true);
		if(session.getAttribute("list")!=null) {
			biodataList = (Collection<Biodata>) session.getAttribute("list");
		}else {
			biodataList = new ArrayList<>();
			session.setAttribute("list", biodataList);
		}
		biodataList.add(biodata);
		model.addAttribute("list", biodataList);
		return "biodata/biodata";
	}
}