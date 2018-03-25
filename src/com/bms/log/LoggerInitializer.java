package com.bms.log;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;





/**
 * Servlet implementation class LoggerInitializer
 */
public class LoggerInitializer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/** The Constant LOG. */
	private static final Logger LOG = Logger
			.getLogger(LoggerInitializer.class);
	
	/**
	 * ServletConfig - servlet config object.
	 *
	 * @param config the config
	 * @throws ServletException the servlet exception
	 */
	public void init(final ServletConfig config)
			throws ServletException {
		final String realPath = config.getServletContext()
				.getRealPath("/");
		final String log4jFile = realPath+"/WEB-INF/log4j.properties";
		PropertyConfigurator.configure(log4jFile);
		LOG.info("Application Initialized");

	}
}
