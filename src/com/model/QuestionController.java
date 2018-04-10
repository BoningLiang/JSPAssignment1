package com.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;

public class QuestionController {

	public ArrayList <String> answerArrayList = new ArrayList <String> ();
	
	public String readQuestionFile(String path)
	{	
		InputStream inputStream;
		String resultString = "";
		try {
			inputStream = new FileInputStream(path);
			BufferedReader bufferedReader = new BufferedReader( (new InputStreamReader(inputStream) ));
			StringBuilder stringBuilder = new StringBuilder();
			String line;
			int count = 0;
			while((line = bufferedReader.readLine()) != null) {
				
				String array[]= line.split("#");
				answerArrayList.add(array[1]);
				String questionString = array[0];
				
				
				String htmlString = 
						"					<tr><td>"+questionString+"</td><td>\n" + 
						"						<input type=\"radio\" name=\"answer"+ count +"\" value=\"true\"/> True  \n" + 
						"						<input type=\"radio\" name=\"answer"+ count +"\" value=\"false\"/> False\n" + 
						"					</td></tr>\n";
				count++;
				stringBuilder.append(htmlString);
			}
			resultString = stringBuilder.toString();
			System.out.println("\n Done!");
			
			bufferedReader.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("\n Not Done!");
			e.printStackTrace();
		}
		
		return resultString;
	}
	
	public String handleAnswer(HttpServletRequest request, JspWriter out) {
		
		int i=0;
		int marksCount = 0;
		int nullCount=0;
		try{
			for(String answer: this.answerArrayList){
				String answerParameter = request.getParameter("answer"+i);
				if(answer.equals(answerParameter)){
					marksCount++;
				}
				if(answerParameter==null){
					nullCount++;
				}
				i++;
			}
		}catch (Exception e){
			
		}
		String markHtmlString = "";
		if(nullCount == i){
			
		}else{
			markHtmlString = "<tr><td>Total Marks: "+marksCount+"</td><td></td></tr>";
		}
		return markHtmlString;
	}
	
}
