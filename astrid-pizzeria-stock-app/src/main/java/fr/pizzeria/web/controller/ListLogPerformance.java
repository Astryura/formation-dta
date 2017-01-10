package fr.pizzeria.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import fr.pizzeria.dao.repo.PerformanceRepository;
import fr.pizzeria.model.Performance;

@RestController
@RequestMapping(value = "/performances")
public class ListLogPerformance {
	@Autowired
	PerformanceRepository perfoRepo;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listLogs() {
		ModelAndView mav = new ModelAndView();
		List<Performance> performances = perfoRepo.findAll();
		mav.addObject("performances", performances);
		mav.setViewName("listPerf");
		return mav;
	}
}
