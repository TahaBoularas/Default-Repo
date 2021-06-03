package model;

import java.lang.reflect.Field;
import java.lang.reflect.TypeVariable;

import javax.servlet.http.HttpServletRequest;

public class test {
public static void main(String[] args) {
	Personne client = new Client();
	Field[] Ss= client.getClass().getSuperclass().getDeclaredFields();
	HttpServletRequest request;
	request.get
	for(int i=0;i<Ss.length;i++) {
		System.out.println(Ss[i].getName());
	}
	
}
}
