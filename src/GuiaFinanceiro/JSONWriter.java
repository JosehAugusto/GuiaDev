package GuiaFinanceiro;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class JSONWriter {
	
	private JSONArray ListaDeItems;
	
	JSONWriter(JSONArray Lista){
		ListaDeItems = Lista;
	}
    
	public void salvarDados(String path) { 
    	try (FileWriter file = new FileWriter(path)) {

            file.write(ListaDeItems.toJSONString());
            file.flush();
           
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	@SuppressWarnings("unchecked")
	public void adicionarItem(JSONObject item) {
    	ListaDeItems.add(item);
    }
	
	public JSONArray getListaItems() {
		return ListaDeItems;
	}
}
