package com.avps.angular;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import org.apache.http.client.ClientProtocolException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.customer.drive.Driver;


@RestController
public class DriveController {

	private Driver d;

	@RequestMapping(value = "/setEmail", method = RequestMethod.POST, headers = "Accept=application/json")
	public Driver search(@RequestBody Driver driver) {
		try {
			d = driver;
			Connection conn = DBUtil.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = null;

			System.out.println("hello connection");

			System.out.println(d.getEmail());
			System.out.println(d.getFamilyMembersCount());
			System.out.println("revoked=" + d.getLicenseRevokedDate());

			Date lrd = d.getLicenseRevokedDate();
			lrd = new java.sql.Date(d.getLicenseRevokedDate().getTime());
			System.out.println("sql date convertor===" + lrd);

			String query = "Select * from driverdetails where email= '" + d.getEmail() + "'";
			System.out.println("email mapping process starts");
			rs = st.executeQuery(query);
			while (rs.next()) {
				String driverEmail = rs.getString("email");
				String driverName = rs.getString("name");
				int driverAge = rs.getInt("age");
				String driverState = rs.getString("state");
				String driverCity = rs.getString("city");
				Date pd = rs.getDate("previousDate");
				int experience = rs.getInt("drivingexperience");

				System.out.println(pd);

				if (d.getEmail().equals(driverEmail)) {
					System.out.println("Success==" + driverEmail);

				d.setAge(driverAge);
				d.setPreviousDate(pd);
				d.setCity(driverCity);
				d.setState(driverState);
					d.setFamilyMembersCount(driver.getFamilyMembersCount());
					d.setLicenseRevokedDate(lrd);
				d.setDrivingExperience(experience);
				d.setEmail(driverEmail);
				d.setName(driverName);


					DriverRest dr = new DriverRest();
					d = dr.restServiceMethod(d);
				}
			}

		} catch (ClientProtocolException ce) {
			ce.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return d;
	}

	@ResponseBody
	@RequestMapping(value = "/getEmail", method = RequestMethod.GET, headers = "Accept=application/json")
	public Driver driverName() {
		return d;
	}

}
