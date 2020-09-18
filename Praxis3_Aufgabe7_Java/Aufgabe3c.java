package BigDataNoSQL.Aufgabe3;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

/**
 * Hello world!
 *
 */
public class Aufgabe3c {
	public static void main(String[] args) throws UnknownHostException {
		final long startTime = System.currentTimeMillis();
		int heittomerkit = 0;
		int commas = 0;
		int idlength = 0;

		MongoClient mongoClient = new MongoClient();
		DB database = mongoClient.getDB("NoSql");
		DBCollection collection = database.getCollection("Cities");
		String key = "";
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("city", "HAMBURG");
		DBCursor cursor = collection.find(whereQuery);
		while (cursor.hasNext()) {
			key = cursor.next().toString();
			String finalz = "";
			int i = 0;
			while (heittomerkit <= 4) { // get the index of the last char that is in the city string by calculating: "'s

				i++;
				idlength++;
				if (key.charAt(i) == '"') {
					heittomerkit++;
				} else {
					continue;
				}

			}
			String result = key.substring(1, idlength - 2);

			System.out.println(result);
		}
		final long endTime = System.currentTimeMillis();

		System.out.println("Total execution time: " + (endTime - startTime));
	}

}
