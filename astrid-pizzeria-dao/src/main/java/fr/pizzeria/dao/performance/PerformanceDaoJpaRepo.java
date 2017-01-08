package fr.pizzeria.dao.performance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.pizzeria.dao.repo.PerformanceRepository;
import fr.pizzeria.model.Performance;

@Component
public class PerformanceDaoJpaRepo {
	@Autowired
	PerformanceRepository perfRepo;

	public List<Performance> listLog() {
		return perfRepo.findAll();
	}

	public void saveLog(Performance perf) {
		perfRepo.save(perf);
	}
}
