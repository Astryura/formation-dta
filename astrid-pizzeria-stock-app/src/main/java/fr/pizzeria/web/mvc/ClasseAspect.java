package fr.pizzeria.web.mvc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.pizzeria.dao.repo.PerformanceRepository;
import fr.pizzeria.model.Ingredient;
import fr.pizzeria.model.Performance;

@Aspect
@Component
public class ClasseAspect {
	@Autowired
	PerformanceRepository perfoRepo;

	@Around("execution(* fr.pizzeria.web.controller.*.*(..))")
	public Object saveLog(ProceedingJoinPoint pjp) throws Throwable {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String today = dateFormat.format(date);
		long before = System.currentTimeMillis();
		String nomMethode = pjp.getSignature().getName();
		final Object[] args = pjp.getArgs();
		final StringBuilder sb = new StringBuilder();
		sb.append(nomMethode);
		if (args.length != 0) {
			for (int i = 0; i < args.length; i++) {
				if (args[i].getClass().equals(Ingredient.class)) {
					Ingredient ing = (Ingredient) args[i];
					sb.append(" Ingredient : ");
					sb.append(" " + ing.getNom() + " " + ing.getPrix() + " " + ing.getQuantite());
				}
			}

		}
		Logger.getLogger(getClass().getName()).log(Level.INFO, "Debut methode : " + sb);
		Object obj = null;
		try {
			obj = pjp.proceed();
		} catch (Exception e) {
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "", e);
		} finally {
			Logger.getLogger(getClass().getName()).log(Level.INFO,
					"Fin methode :  " + sb + " retour=" + ((obj == null) ? "pas de retour" : obj.toString()));
		}
		long after = System.currentTimeMillis();
		String temps = (after - before) + "ms";
		if (!nomMethode.contains("form")) {
			Performance perf = new Performance(sb.toString(), today, temps);
			perfoRepo.save(perf);
		}
		return obj;
	}
}
