package com.kael.login.qzone;

import java.io.BufferedReader;
import java.io.InputStreamReader;



public class AppStrTest {

	public static void main(String[] args) {

		StringBuilder builder = new StringBuilder();
//		try(BufferedReader br = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("rsa.js")))){
//			String line;
//			builder.append("StringBuilder builder = new StringBuilder();\n builder \n");
//			while((line = br.readLine()) != null){
//				builder.append(".append(\""+line+"\")\n");
//			}
////			builder.append(";");
////			System.out.println(builder.toString());
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
		try(BufferedReader br = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("login.js")))){
			String line;
			//builder.append("StringBuilder builder = new StringBuilder();\n builder \n");
			builder.append("scriptEngine.eval(\"");
			while((line = br.readLine()) != null){
				line = line.replace("\"", "\\\"");
				//builder.append("scriptEngine.eval(\""+line+"\");\n");
				builder.append(line);
			}
			builder.append("\");\n");
			System.out.println(builder.toString());
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
