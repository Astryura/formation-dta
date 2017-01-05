package fr.pizzeria.ihm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.console.PizzeriaAppSpringConfigTest;
import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PizzeriaAppSpringConfigTest.class)
public class ListPizzaTest {

	@Autowired
	ListPizza list;

	@Test
	public void test() {
		Assert.assertEquals("1. Lister les pizzas", list.getDescribe());
	}

}
