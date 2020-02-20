package com.avps.angular;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.customer.drive.Driver;

/***
 * this
 * 
 * class hold all the necessary methods to manage the driver information* such
 * as CRUD operations on driver data**
 * 
 * @author Lenovo
 **/
public class DriverService {

	/**
	 * to get connection from DBUtil class
	 */
	static Connection conn = DBUtil.getConnection();

	/**
	 * Resultset to run the query
	 */

	static ResultSet resultSet = null;
		/**
	 * list driver type class object created here
	 */
	static List<Driver> rows = new ArrayList<Driver>();

	/**
	 * this method insert the driver record into USERS table
	 *
	 * @param driver
	 *            - passed driver information to be inserted
	 * @throws SQLException
	 *             - when error happens with DB operation or DB
	 */
	public static void createDriver(Driver driver) {

 QueryRunner queryRunner = new QueryRunner();

		String sql = "insert into driverdetails(Name, Age, State, City, Email, DrivingExperience, PreviousDate) values(?, ?, ?, ?, ?, ?, ?)";
 try {
			queryRunner.update(conn, sql, driver.getName(), driver.getAge(), driver.getState(), driver.getCity(),
					driver.getEmail(), driver.getDrivingExperience(), driver.getPreviousDate()
			);
			// driver.getLicenseCategory(), driver.isLicenseEligibility(),
			// driver.isDrivingTestEligibility(), driver.isDmvZoneEligibility()


 } catch (SQLException e) {
 // TODO Auto-generated catch block
 e.printStackTrace();
 }
 }

		/**
	 * this method used to fetch the driver list from database
	 *
	 * @param driver
	 *            - to get the registered driver information
	 * @return - list type variable rows
	 * @throws SQLException
	 *             - when error occurs with DB operations
	 */
	public static List<Driver> list(Driver driver) throws SQLException {
			try {

			Statement statement = conn.createStatement();
			String querySelect = "select * from driverdetails where email= '" + driver.getEmail() + "'";
			resultSet = statement.executeQuery(querySelect);
			while (resultSet.next()) {
				Driver rowdriver = new Driver();
				rowdriver.setName(resultSet.getString("name"));
				rowdriver.setPreviousDate(resultSet.getDate("PreviousDate"));
				rowdriver.setDrivingExperience(resultSet.getInt("DrivingExperience"));
				rowdriver.setAge(resultSet.getInt("age"));
				rowdriver.setCity(resultSet.getString("city"));
				rowdriver.setEmail(resultSet.getString("email"));
				rows.add(rowdriver);
			}

			} catch (Exception e) {
				e.printStackTrace();
			}

			return rows;
		}

	public static Driver getList(Driver driver) throws SQLException {
		try {

			Statement statement = conn.createStatement();
			String querySelect = "select * from driverdetails where email= '" + driver.getEmail() + "'";
			resultSet = statement.executeQuery(querySelect);
			while (resultSet.next()) {
				Driver rowdriver = new Driver();
				rowdriver.setName(resultSet.getString("name"));
				rowdriver.setPreviousDate(resultSet.getDate("PreviousDate"));
				rowdriver.setDrivingExperience(resultSet.getInt("DrivingExperience"));
				rowdriver.setAge(resultSet.getInt("age"));
				rowdriver.setCity(resultSet.getString("city"));
				rowdriver.setEmail(resultSet.getString("email"));
				rows.add(rowdriver);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return driver;
	}

	public static Driver login(Driver driver) {

 try {
String search = "Select * from driverdetails where email= '" + driver.getEmail() + "'";

 Statement statement = conn.createStatement();

 resultSet = statement.executeQuery(search);
 boolean more = resultSet.next();
 // if user exists set the isValid variable to true
			if (more) {
				// getString method is used to get the data from database, so need to put column
				// name according to db

				String email = resultSet.getString("email");
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String city = resultSet.getString("city");
				String state = resultSet.getString("state");
				Date previousDate = resultSet.getDate("previousdate");
				int experience = resultSet.getInt("drivingexperience");

				System.out.println("Welcome " + resultSet.getString("name"));
				// driver.setValid(true);
				driver.setEmail(email);
				driver.setName(name);
				driver.setAge(age);
				driver.setCity(city);
				driver.setPreviousDate(previousDate);
				driver.setDrivingExperience(experience);
				driver.setState(state);
				
			}
			else if (!more) {
				System.out.println("Sorry, you are not registered user !");
				// driver.setValid(false);
			}

 }
 catch(Exception e) {
 System.out.println("Log In failed: An Exception has occurred! " + e);
 }

 return driver;

 }

}
