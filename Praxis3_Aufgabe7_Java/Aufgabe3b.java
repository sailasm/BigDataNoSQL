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
public class Aufgabe3b {
	public static void main(String[] args) throws UnknownHostException {
		final long startTime = System.currentTimeMillis();
		int heittomerkit = 0;
		int commas = 0;
		int citylength = 19;
		int statelength = 0;

		MongoClient mongoClient = new MongoClient();
		DB database = mongoClient.getDB("NoSql");
		DBCollection collection = database.getCollection("Cities");
		String key = "";
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("_id", "99034");
		DBCursor cursor = collection.find(whereQuery);
		while (cursor.hasNext()) {
			key = cursor.next().toString();
		}
		String result = key.substring(19); // get the part of the string where the "city" begins
		String finalz = "";

		int y = 0;
		int i = 0;
		while (heittomerkit <= 3) { // get the index of the last char that is in the city string by calculating: "'s

			i++;
			citylength++;
			if (result.charAt(i) == '"') {
				heittomerkit++;
			} else {
				continue;
			}

		}
		while (commas <= 4) { // get the index of the part where "state" begins by calculating commas

			y++;
			statelength++;
			if (key.charAt(y) == ',') {
				commas++;
			} else {
				continue;
			}

		}
		String result2 = key.substring(statelength, key.length() - 1);

		finalz = key.substring(19, citylength) + result2;
		System.out.println(finalz);
		final long endTime = System.currentTimeMillis();

		System.out.println("Total execution time: " + (endTime - startTime));
	}

}
