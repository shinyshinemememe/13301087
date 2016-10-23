package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Request implements ServletRequest {

	private InputStream input;
	
	private String uri;
	
	public Request(InputStream input) {
		
		this.input = input;
		
	}
	
	public String getUri() {
		
		return uri;
		
	}
	
	private String parseUri(String requestString) {
		
		int index1, index2;
		
		index1 = requestString.indexOf(' ');
		
		if (index1 != -1) {
			
			index2 = requestString.indexOf(' ', index1 + 1);
			
			if (index2 > index1) {
				
				return requestString.substring(index1 + 1, index2);
				
			}
			
		}
		
		return null;
		
	}
	
	public void parse() {
		
		// Read a set of characters from the socket
		StringBuffer request = new StringBuffer(2048);
		
		int i; 
		byte[] buffer = new byte[2048];
		
		try {
			
			i = input.read(buffer);
			
		} catch (IOException e) {
			
			e.printStackTrace();
			i = -1;
			
		}
		
		for (int j = 0; j < i; j ++) {
			
			request.append((char) buffer[j]);
			
		}
		
		System.out.println("----------------");
		System.out.print(request.toString());
		System.out.println("----------------");
		
		uri = parseUri(request.toString());
	}
	
	@Override
	public Object getAttribute(String name) {
		
		return null;
	}

	@Override
	public Enumeration getAttributeNames() {
		
		return null;
	}

	@Override
	public String getCharacterEncoding() {
		
		return null;
	}

	@Override
	public int getContentLength() {
		
		return 0;
	}

	@Override
	public String getContentType() {
		
		return null;
	}

	@Override
	public ServletInputStream getInputStream() throws IOException {
		
		return null;
	}

	@Override
	public String getLocalAddr() {
		
		return null;
	}

	@Override
	public Locale getLocale() {
		
		return null;
	}

	@Override
	public Enumeration getLocales() {
		
		return null;
	}

	@Override
	public String getLocalName() {
		
		return null;
	}

	@Override
	public int getLocalPort() {
		
		return 0;
	}

	public String getParameter(String name) {
		String subname=name+"=";
		String[] sourceStrArray = uri.split("&");
		String ans=null;
		for (int i = 0; i < sourceStrArray.length; i++) {
			
			if (sourceStrArray[i].indexOf(subname)!=-1) {
				ans=sourceStrArray[i].substring(sourceStrArray[i].indexOf(subname)+subname.length());
				if (ans!=null) {
					return ans;
				}
			}
			
		}
		return null;
	}

	@Override
	public Map getParameterMap() {
		
		return null;
	}

	@Override
	public Enumeration getParameterNames() {
		
		return null;
	}

	@Override
	public String[] getParameterValues(String name) {
		
		return null;
	}

	@Override
	public String getProtocol() {
		
		return null;
	}

	@Override
	public BufferedReader getReader() throws IOException {
		
		return null;
	}

	@Override
	public String getRealPath(String path) {
		
		return null;
	}

	@Override
	public String getRemoteAddr() {
		
		return null;
	}

	@Override
	public String getRemoteHost() {
		
		return null;
	}

	@Override
	public int getRemotePort() {
		
		return 0;
	}

	@Override
	public RequestDispatcher getRequestDispatcher(String path) {
		
		return null;
	}

	@Override
	public String getScheme() {
		
		return null;
	}

	@Override
	public String getServerName() {
		
		return null;
	}

	@Override
	public int getServerPort() {
		
		return 0;
	}

	@Override
	public boolean isSecure() {
		
		return false;
	}

	@Override
	public void removeAttribute(String name) {
		
		
	}

	@Override
	public void setAttribute(String name, Object o) {
		
		
	}

	@Override
	public void setCharacterEncoding(String env)
			throws UnsupportedEncodingException {
		
		
	}

	@Override
	public AsyncContext getAsyncContext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DispatcherType getDispatcherType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServletContext getServletContext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAsyncStarted() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAsyncSupported() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public AsyncContext startAsync() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AsyncContext startAsync(ServletRequest arg0, ServletResponse arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
