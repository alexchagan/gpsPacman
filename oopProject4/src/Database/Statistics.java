package Database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * This classs is responsible for getting info from database
 * @author Alex Ilya Nour
 *
 */
public class Statistics {
/**
 * Takes your score and gets the average score of specific configuration from the database
 * prints both of them. 
 * source: Yael moodle
 * @param info - info that cotntains score
 * @param hash - hashcode of the configuration
 */
	public void getStats(String info,int hash)
	{
		double sum = 0;
		double avg = 0;
		int counter = 0;
		String[] comps = info.split(",");
		double score = Double.parseDouble(comps[2].substring(6));
		

		String jdbcUrl="jdbc:mysql://ariel-oop.xyz:3306/oop"; //?useUnicode=yes&characterEncoding=UTF-8&useSSL=false";
		String jdbcUser="student";
		String jdbcPassword="student";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = 
					(Connection) DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);


			Statement statement = (Statement) connection.createStatement();

			//select data
			String allCustomersQuery = "SELECT * FROM logs;";
			ResultSet resultSet = statement.executeQuery(allCustomersQuery);
		
			while(resultSet.next())
			{
				++counter;
					double result = resultSet.getDouble("SomeDouble");
						sum = sum + result;
			}
			
			avg = sum/counter;
			System.out.println("Your score is: "+score+", The average score is: "+avg);

			resultSet.close();		
			statement.close();		
			connection.close();		
		}

		catch (SQLException sqle) {
			System.out.println("SQLException: " + sqle.getMessage());
			System.out.println("Vendor Error: " + sqle.getErrorCode());
		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}


	}

}
