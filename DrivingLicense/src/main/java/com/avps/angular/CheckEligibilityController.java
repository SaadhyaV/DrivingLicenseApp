package com.avps.angular;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.customer.drive.Driver;

//@WebServlet("/CheckEligibilityController")
public class CheckEligibilityController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		Driver driver = new Driver();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		driver.setName(request.getParameter("name").toString());
		driver.setAge(Integer.parseInt(request.getParameter("age").toString()));
		driver.setCity(request.getParameter("city").toString());
		driver.setEmail(request.getParameter("email").toString());
		driver.setState(request.getParameter("state").toString());
		driver.setDrivingExperience(Integer.parseInt(request.getParameter("experience").toString()));
		try {
			driver.setPreviousDate(sdf.parse(request.getParameter("previousDate").toString()));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		try {
			System.out.println("Registration begin");
			DriverService.createDriver(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
