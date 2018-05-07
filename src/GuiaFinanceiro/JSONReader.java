package GuiaFinanceiro;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JSONReader{
	
    JSONReader(){}
    /**
     * Metodo para ler o arquivo Json
     * @return jsonFile um JSONArray com todas as informações de clientes
     */
    public JSONArray readFile(String path)
    {
    	
    	JSONParser parser = new JSONParser();
    	JSONArray jsonFile = new JSONArray();
    	 try {

             Object obj = parser.parse(new FileReader(path));

             jsonFile = (JSONArray) obj;

         } catch (FileNotFoundException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         } catch (ParseException e) {
             e.printStackTrace();
         }
    	 return jsonFile;
    }
}
