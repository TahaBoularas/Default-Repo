package model;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class TraitementFormulaire {
	
	public TraitementFormulaire() {
		
	}
	
	public Map<String,String> extraireInfoFormulaire(HttpServletRequest request , Client client){
		HashMap<String, String> infos = new HashMap<String, String>();
		List infoClient=Arrays.asList(client.getClass().getSuperclass().getDeclaredFields());
		for (Object info:infoClient) {
			if (request.getParameter(((Field) info).getName()) != null) {
				String propriete=((Field) info).getName();
				infos.put(propriete,request.getParameter(propriete));
			}
			
		}
		return infos;
		
	}

}
