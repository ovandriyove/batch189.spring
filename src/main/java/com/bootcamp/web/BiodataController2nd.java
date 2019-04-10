package com.bootcamp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BiodataController2nd {
	@RequestMapping("biodata.html")
	public String biodata(Model model) {
		model.addAttribute("modus", "input");
		return "biodata/biodata";
	}
	
	@RequestMapping("calculator.html")
	public String calculator() {
		return "calculator/calculator";
	}	
}
