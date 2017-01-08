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
import org.springframework.stereotype.Component;

import fr.pizzeria.model.Performance;
import fr.pizzeria.model.Pizza;

@Aspect
@Component
public class MaClasseAspect {

	@Before("execution(* fr.pizzeria.dao.pizza.PizzaDao.saveNewPizza(..))")
	public void codeNewPizza(JoinPoint jp) {
		Pizza pizza = (Pizza) jp.getArgs()[0];
		String code = pizza.getNom().substring(0, 3).toUpperCase();
		pizza.setCode(code);
	}

	@Around("execution(* fr.pizzeria.dao..*.*(..))")
	public Object saveLog(ProceedingJoinPoint pjp) throws Throwable {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String today = dateFormat.format(date);
		String nomMethode = pjp.getSignature().getName();
		long before = System.currentTimeMillis();
		final Object[] args = pjp.getArgs();
		final StringBuffer sb = new StringBuffer();
		sb.append(pjp.getSignature().toString());
		sb.append(" avec les parametres : (");
		for (int i = 0; i < args.length; i++) {
			sb.append(args[i]);
			if (i < args.length - 1) {
				sb.append(", ");
			}
		}
		sb.append(")");
		Logger.getLogger(getClass().getName()).log(Level.INFO, "Debut methode : " + sb);
		Object obj = null;
		try {
			obj = pjp.proceed();
			if (obj == null) {
				obj = new Object();
			}
		} finally {
			Logger.getLogger(getClass().getName()).log(Level.INFO,
					"Fin methode :  " + nomMethode + " retour=" + obj.toString());
		}
		long after = System.currentTimeMillis();
		String temps = (after - before) + "ms";
		Performance perf = new Performance(nomMethode, today, temps);
		return obj;
	}

}
