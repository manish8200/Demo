package com.demo.module;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

public class StudentModuleListner extends GuiceServletContextListener {

	@Override
	protected Injector getInjector() {
		// TODO Auto-generated method stub
		return Guice.createInjector(new StudentModule());
	}

}
