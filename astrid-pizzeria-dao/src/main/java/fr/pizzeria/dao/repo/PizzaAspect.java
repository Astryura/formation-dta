package fr.pizzeria.dao.repo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import fr.pizzeria.model.Pizza;

@Aspect
@Component
public class PizzaAspect {

	@Before("execution(* fr.pizzeria.dao.pizza.PizzaDao.*(..))")
	public void codeNewPizza(JoinPoint jp) {
		Pizza pizza = (Pizza) jp.getArgs()[0];
		String code = pizza.getNom().substring(0, 2).toUpperCase();
		pizza.setCode(code);
	}
}
