package BigDataNoSQL.Aufgabe2;
import redis.clients.jedis.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;




public class Aufgabe2c 
{
    public static void main( String[] args ) throws IOException
    {
    	Jedis jedis = new Jedis("localhost");
        Set<String> names=jedis.keys("*"); // Finding all the keys in the database
        List<String> keysList = new ArrayList<String>();
        List<String> wantedList = new ArrayList<String>();
        Iterator<String> it = names.iterator();

        while (it.hasNext()) { //Populating a list with all the keys 
        	
            String s = it.next();
            keysList.add(s);
        }	
        for(int i = 0; i< keysList.size(); i++) {
        	String keyValue =jedis.get(keysList.get(i)); //getting the keys to string form
        	int heittomerkit = 0;
        	int citylength = 19;
        	int y = 0;
        	String result = keyValue.substring(19);
        	String finalz = "";
            while(heittomerkit <= 3) { //get the index of the last char that is in the city string by calculating: "'s

            	y++;
            	citylength++; 
            	if(result.charAt(y) == '"') {
            		heittomerkit++;
            	}
            	else {
            		continue;
            	}

        }
            finalz =keyValue.substring(29, citylength - 3 ); //getting the city part of the string
            if(finalz.equals("HAMBURG"))
            {
            wantedList.add(keysList.get(i)); //if value is found add it to the list of wanted ZIP codes
            }

       //System.out.println(Arrays.toString(keysList.toArray()));
     
    	//redisClient.shutdown();
    //}
        }
        System.out.println(Arrays.toString(wantedList.toArray()));
        System.out.println(wantedList.size());
        jedis.close();
    }
}


