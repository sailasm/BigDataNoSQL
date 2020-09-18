package BigDataNoSQL.Aufgabe2;
import redis.clients.jedis.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;




public class Aufgabe2b 
{
    public static void main( String[] args ) throws IOException
    {
    	int heittomerkit = 0;
    	int commas = 0;
    	int citylength = 19;
    	int statelength = 0;
        Jedis connection = new Jedis("localhost");
        String key = connection.get("96096");
        //String key = "{ \"_id\" : \"01039\", \"city\" : \"HAYDENVILLE\", \"loc\" : [ -72.70317799999999, 42.381799 ], \"pop\" : 1387, \"state\" : \"MA\" }";
        String result = key.substring(19); // get the part of the string where the "city" begins
        String finalz = "";
        
        int y = 0;
    	int i = 0;
        while(heittomerkit <= 3) { //get the index of the last char that is in the city string by calculating: "'s

        	i++;
        	citylength++; 
        	if(result.charAt(i) == '"') {
        		heittomerkit++;
        	}
        	else {
        		continue;
        	}
        	
        		
        }
        while(commas <= 4) { //get the index of the part where "state" begins by calculating commas 

        	y++;
        	statelength++;
        	if(key.charAt(y) == ',') {
        		commas++;
        	}
        	else {
        		continue;
        	}
        	
        		
        }
        String result2 = key.substring(statelength, key.length() - 1);
        
        finalz =  key.substring(19, citylength -2)+ result2;
        System.out.println(finalz);        

    	

      connection.close();
    	//redisClient.shutdown();
    }

}
