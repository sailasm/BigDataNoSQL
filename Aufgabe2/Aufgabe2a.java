package BigDataNoSQL.Aufgabe2;
import redis.clients.jedis.*;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;




public class Aufgabe2a 
{
    public static void main( String[] args ) throws IOException
    {
    	
        List<String> lines = Files.readAllLines(
                Paths.get("/home/saku/Downloads/plz.data"), Charset.forName("UTF-8"));
        Jedis connection = new Jedis("localhost");
        Pipeline p = connection.pipelined();
        for(String line: lines){
        	
        	
        	String key = getKey(line.substring(11, 16));
        	String value = getValue(line);
        	p.set(key,value);
        }
        p.sync();

    	

    	connection.close();
    	//redisClient.shutdown();
    }

	private static String getValue(String line) {
		// TODO Auto-generated method stub
		return line;
	}

	private static String getKey(String line) {
		// TODO Auto-generated method stub
		return line;
	}
}
