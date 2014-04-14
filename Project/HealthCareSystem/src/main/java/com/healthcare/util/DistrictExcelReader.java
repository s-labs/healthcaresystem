package com.healthcare.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class DistrictExcelReader {

	public static void main(String[] args) {
		try {

			final String DB_DRIVER = "com.mysql.jdbc.Driver";
			final String DB_CONNECTION = "jdbc:mysql://127.0.0.1:3306/healthcare";
			final String DB_USER = "healthcare";
			final String DB_PASSWORD = "healthcarepwd";

			Class.forName(DB_DRIVER);
			Connection dbConnection = DriverManager.getConnection(
					DB_CONNECTION, DB_USER, DB_PASSWORD);

			String districts[] = { "Adilabad", "Anantapur", "Chittoor",
					"Cuddapah", "Guntur", "Khammam", "Krishna", "Kurnool",
					"Mahbubnagar" };
			for (String district : districts) {
				
				System.out.println("************"+district+"****************");

				FileInputStream file = new FileInputStream(
						new File(
								"D:\\from lappy\\slabs_git_hub\\healthcaresystem\\Documents\\phc_ap_map_I\\phc_ap_map_I\\ap_"
										+ district + ".xls"));

				// create district healthcenter

				String sql = "INSERT into healthcenter(name,level,next) VALUES(?,?,?)";
				PreparedStatement prest = dbConnection.prepareStatement(sql,
						Statement.RETURN_GENERATED_KEYS);
				prest.setString(1, district+" District Head Quaters");
				prest.setInt(2, 2);
				prest.setInt(2, 2);
				prest.setInt(3, 1);
				int count = prest.executeUpdate();
				System.out.println(count + "row(s) affected");
				int districtHealthcenterId = -1;

				ResultSet rs = prest.getGeneratedKeys();

				if (rs.next()) {
					districtHealthcenterId = rs.getInt(1);
				} else {

					// throw an exception from here
				}
				System.out.println("districtHealthcenterId:"
						+ districtHealthcenterId);
				
				int districtcode = 1;
				sql = "INSERT into district(name,statecode,healthcentercode) VALUES(?,?,?)";
				prest = dbConnection.prepareStatement(sql,
						Statement.RETURN_GENERATED_KEYS);
				prest.setString(1, district);
				prest.setLong(2, 10);
				prest.setLong(3, districtHealthcenterId);
				count = prest.executeUpdate();
				System.out.println(count + "row(s) affected");
				districtcode = -1;

				rs = prest.getGeneratedKeys();

				if (rs.next()) {
					districtcode = rs.getInt(1);
				} else {

					// throw an exception from here
				}
				System.out
						.println("Key returned from getGeneratedKeys():"
								+ districtcode);
				
				
				sql = "INSERT into users(USERNAME,PASSWORD,ENABLED,healthcentercode) VALUES(?,?,?,?)";
				prest = dbConnection.prepareStatement(sql,
						Statement.RETURN_GENERATED_KEYS);
				prest.setString(1, district.toLowerCase()+"_"+"admin");
				prest.setString(2, "pwd");
				prest.setInt(3, 1);
				prest.setLong(4, districtHealthcenterId);
				count = prest.executeUpdate();
				System.out.println(count + "row(s) affected");
				int userId = -1;

				rs = prest.getGeneratedKeys();

				if (rs.next()) {
					userId = rs.getInt(1);
				} else {

					// throw an exception from here
				}
				System.out
						.println("userId :"
								+ userId);

				sql = "INSERT into user_roles(usercode,AUTHORITY) VALUES(?,?)";
				prest = dbConnection.prepareStatement(sql,
						Statement.RETURN_GENERATED_KEYS);
				prest.setLong(1, userId);
				prest.setString(2, "ROLE_HC_ADMIN");
				count = prest.executeUpdate();
				prest.setLong(1, userId);
				prest.setString(2, "ROLE_HEALTHCENTER");
				count = prest.executeUpdate();
				

				// Get the workbook instance for XLS file
				HSSFWorkbook workbook = new HSSFWorkbook(file);

				// Get first sheet from the workbook
				HSSFSheet sheet = workbook.getSheetAt(0);

				// Iterate through each rows from first sheet
				Iterator<org.apache.poi.ss.usermodel.Row> rowIterator = sheet
						.iterator();
			
				int rowCount = 0;
				int mandalId = -1;
				int mandalHeathcenterid = -1;
				while (rowIterator.hasNext()) {

					Row row = rowIterator.next();
					rowCount++;
					if (rowCount < 7) {
						// skip first 7 rows
						continue;

					}

					// For each row, iterate through each columns

					Iterator<Cell> cellIterator = row.cellIterator();
					String mandalname;

					while (cellIterator.hasNext()) {

						System.out.println("current mandal Id:" + mandalId);

						Cell cell = cellIterator.next();
						// System.out.print(cell.getColumnIndex() + " ");
						if (cell.getColumnIndex() == 0) {					
							
							mandalname = cell.getStringCellValue();			
							
							sql = "INSERT into healthcenter(name,level,next) VALUES(?,?,?)";
							prest = dbConnection.prepareStatement(sql,
									Statement.RETURN_GENERATED_KEYS);
							prest.setString(1, mandalname+" Mandal Head Quaters");
							prest.setInt(2, 3);
							prest.setLong(3,districtHealthcenterId);
							//prest.setInt(3, 1);
							count = prest.executeUpdate();
							System.out.println(count + "row(s) affected");
							

							 rs = prest.getGeneratedKeys();

							if (rs.next()) {
								mandalHeathcenterid = rs.getInt(1);
							} else {

								// throw an exception from here
							}
							System.out.println("mandalHeathcenterid:"
									+ mandalHeathcenterid);
							
							
							sql = "INSERT into users(USERNAME,PASSWORD,ENABLED,healthcentercode) VALUES(?,?,?,?)";
							prest = dbConnection.prepareStatement(sql,
									Statement.RETURN_GENERATED_KEYS);
							prest.setString(1, mandalname.toLowerCase()+"_"+"admin");
							prest.setString(2, "pwd");
							prest.setInt(3, 1);
							prest.setLong(4, mandalHeathcenterid);
							count = prest.executeUpdate();
							System.out.println(count + "row(s) affected");
							 userId = -1;

							rs = prest.getGeneratedKeys();

							if (rs.next()) {
								userId = rs.getInt(1);
							} else {

								// throw an exception from here
							}
							
							sql = "INSERT into user_roles(usercode,AUTHORITY) VALUES(?,?)";
							prest = dbConnection.prepareStatement(sql,
									Statement.RETURN_GENERATED_KEYS);
							prest.setLong(1, userId);
							prest.setString(2, "ROLE_HC_ADMIN");
							count = prest.executeUpdate();
							prest.setLong(1, userId);
							prest.setString(2, "ROLE_HEALTHCENTER");
							count = prest.executeUpdate();
							

							sql = "INSERT into mandal(name,districtcode,healthcentercode) VALUES(?,?,?)";
							prest = dbConnection.prepareStatement(sql,
									Statement.RETURN_GENERATED_KEYS);
							prest.setString(1, mandalname);
							prest.setLong(2, districtcode);
							prest.setLong(3, mandalHeathcenterid);
							count = prest.executeUpdate();
							System.out.println(count + "row(s) affected");
							mandalId = -1;

							rs = prest.getGeneratedKeys();

							if (rs.next()) {
								mandalId = rs.getInt(1);
							} else {

								// throw an exception from here
							}
							System.out
									.println("Key returned from getGeneratedKeys():"
											+ mandalId);

							continue;
						}

						if (cell.getColumnIndex() == 1
								|| cell.getColumnIndex() == 4
								|| cell.getColumnIndex() == 7) {
							String subcentername = cell.getStringCellValue();
							
							

							sql = "INSERT into healthcenter(name,level,next) VALUES(?,?,?)";
							prest = dbConnection.prepareStatement(sql,
									Statement.RETURN_GENERATED_KEYS);
							prest.setString(1, subcentername+" Village HealthCenter");
							prest.setInt(2, 4);
							prest.setLong(3,mandalHeathcenterid);
							//prest.setInt(3, 1);
							count = prest.executeUpdate();
							System.out.println(count + "row(s) affected");
							int villageHealthCenterId = -1;

							 rs = prest.getGeneratedKeys();

							if (rs.next()) {
								villageHealthCenterId = rs.getInt(1);
							} else {

								// throw an exception from here
							}
							System.out.println("villageHealthCenterId:"
									+ villageHealthCenterId);
							
							
							sql = "INSERT into users(USERNAME,PASSWORD,ENABLED,healthcentercode) VALUES(?,?,?,?)";
							prest = dbConnection.prepareStatement(sql,
									Statement.RETURN_GENERATED_KEYS);
							prest.setString(1, subcentername.toLowerCase()+"_"+"admin");
							prest.setString(2, "pwd");
							prest.setInt(3, 1);
							prest.setLong(4, villageHealthCenterId);
							count = prest.executeUpdate();
							System.out.println(count + "row(s) affected");
							 userId = -1;

							rs = prest.getGeneratedKeys();

							if (rs.next()) {
								userId = rs.getInt(1);
							} else {

								// throw an exception from here
							}
							
							sql = "INSERT into user_roles(usercode,AUTHORITY) VALUES(?,?)";
							prest = dbConnection.prepareStatement(sql,
									Statement.RETURN_GENERATED_KEYS);
							prest.setLong(1, userId);
							prest.setString(2, "ROLE_HC_ADMIN");
							count = prest.executeUpdate();
							prest.setLong(1, userId);
							prest.setString(2, "ROLE_HEALTHCENTER");
							count = prest.executeUpdate();
							


							sql = "insert into village(name,mandalcode,Distance_0_5_KMS,Distance_5_10_KMS,Distance_More_Than10_KMS,healthcentercode)  VALUES(?,?,?,?,?,?)";
							prest = dbConnection.prepareStatement(sql);
							prest.setString(1, subcentername);
							prest.setLong(2, mandalId);
							prest.setInt(3, 0);
							prest.setInt(4, 0);
							prest.setInt(5, 0);
							prest.setInt(6, villageHealthCenterId);
							if (cell.getColumnIndex() == 1)
								prest.setInt(3, 1);
							if (cell.getColumnIndex() == 4)
								prest.setInt(4, 1);
							if (cell.getColumnIndex() == 7)
								prest.setInt(5, 1);
							count = prest.executeUpdate();
							System.out.println(count + "row(s) affected");

						}
					}

				}
				file.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" -----------done -----------");

	}

}
