package praxis4.aufgabe10;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;

public class Aufgabe10 {

	public static void main(String args[]) throws Exception {
		final long startTime = System.currentTimeMillis();
		// AUFGABE 10C
		 //String searchValue = "'56578'"; 
		 //String searchResult1 = "city";
		 //String searchResult2 = "state";
		 //String query = "SELECT " + searchResult1 + ", " + searchResult2 + " FROM cities WHERE id=" + searchValue + ";";
		
		//AUFGABE10D
		 String searchValue = "'HAMBURG'";
		 String searchResult = "id";
		 String query = "SELECT " + searchResult + " FROM cities WHERE city=" + searchValue + " ALLOW FILTERING;";
		System.out.print(query);
		// Creating Cluster object
		Cluster cluster = Cluster.builder().addContactPoint("localhost").build();

		// Creating Session object
		Session session = cluster.connect("plz");

		// Getting the ResultSet
		ResultSet result = session.execute(query);

		System.out.println(result.all());
		final long endTime = System.currentTimeMillis();

		System.out.println("Total execution time: " + (endTime - startTime));
	}
}
