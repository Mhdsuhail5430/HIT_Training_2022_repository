package com;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestProcessor {
     public void process(HttpServletRequest request,HttpServletResponse response) {
    	 try{
    		  //First part
    		   ServletContext app=request.getServletContext();
    		   String configpath =app.getRealPath("/WEB-INF/config.properties");
    		   Properties prop=new Properties();
    		   prop.load(new FileInputStream(configpath));
    		   
    		   //Second part
    		   String formid= request.getParameter("formid");
    		   String actionclassname=prop.getProperty(formid);
    		   
    		   Action action=(Action)Class.forName(actionclassname).newInstance();
    		   
    		   String result=action.execute(request,response);
    		   
    		   String nextpage=prop.getProperty(result);
    		   
    		   RequestDispatcher rd=request.getRequestDispatcher(nextpage);
    		   rd.forward(request,response);
    		   
    		  }catch(Exception e ){
    		  
    		  }
     }
}
