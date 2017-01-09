package fr.pizzeria.dao.other;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.pizzeria.dao.repo.PerformanceRepository;
import fr.pizzeria.model.Livreur;
import fr.pizzeria.model.Performance;
import fr.pizzeria.model.Pizza;

@Aspect
@Component
public class MaClasseAspect {
	@Autowired
	PerformanceRepository perfoRepo;

	@Before("execution(* fr.pizzeria.dao.service.pizza.PizzaDao.saveNewPizza(..))")
	public void codeNewPizza(JoinPoint jp) {
		Pizza pizza = (Pizza) jp.getArgs()[0];
		String code = pizza.getNom().substring(0, 3).toUpperCase();
		pizza.setCode(code);
	}

	@Around("execution(* fr.pizzeria.dao.service..*.*(..))")
	public Object saveLog(ProceedingJoinPoint pjp) throws Throwable {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String today = dateFormat.format(date);
		long before = System.currentTimeMillis();
		final Object[] args = pjp.getArgs();
		final StringBuilder sb = new StringBuilder();
		sb.append(pjp.getSignature().getName());
		if (args.length != 0) {
			sb.append(" avec les parametres : (");
			for (int i = 0; i < args.length; i++) {
				if (args[i].getClass().equals(Pizza.class)) {
					sb.append(" Pizza : ");
					Pizza p = (Pizza) args[i];
					sb.append(p.getCode() + " ");
					sb.append(p.getNom() + " ");
					sb.append(p.getPrix() + " ");
					sb.append(p.getCatP() + " ");
				} else if (args[i].getClass().equals(Livreur.class)) {
					sb.append(" Livreur : ");
					Livreur l = (Livreur) args[i];
					sb.append(l.getNom() + " ");
					sb.append(l.getPrenom() + " ");
				} else {
					sb.append(" " + args[i].toString());
				}
				if (i < args.length - 1) {
					sb.append(", ");
				}
			}
			sb.append(")");
		}
		Logger.getLogger(

				getClass().getName()).log(Level.INFO, "Debut methode : " + sb);
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
		Performance perf = new Performance(sb.toString(), today, temps);
		perfoRepo.save(perf);
		return obj;
	}

}
