package com.test;

import java.io.BufferedReader;
import java.io.IOException;
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

public class RequestFacade implements ServletRequest {

	private ServletRequest request = null;
	
	public RequestFacade(Request request) {
		
		this.request = request;
		
	}
	
	@Override
	public Object getAttribute(String name) {
		
		return request.getAttribute(name);
	}

	@Override
	public Enumeration getAttributeNames() {
		
		return request.getAttributeNames();
	}

	@Override
	public String getCharacterEncoding() {
		
		return request.getCharacterEncoding();
	}

	@Override
	public int getContentLength() {
		
		return request.getContentLength();
	}

	@Override
	public String getContentType() {
		
		return request.getCharacterEncoding();
	}

	@Override
	public ServletInputStream getInputStream() throws IOException {
		
		return request.getInputStream();
	}

	@Override
	public String getLocalAddr() {
		
		return request.getLocalAddr();
	}

	@Override
	public Locale getLocale() {
		
		return request.getLocale();
	}

	@Override
	public Enumeration getLocales() {
		
		return request.getLocales();
	}

	@Override
	public String getLocalName() {
		
		return request.getLocalName();
	}

	@Override
	public int getLocalPort() {
		
		return request.getLocalPort();
	}

	@Override
	public String getParameter(String name) {
		
		return request.getParameter(name);
	}

	@Override
	public Map getParameterMap() {
		
		return request.getParameterMap();
	}

	@Override
	public Enumeration getParameterNames() {
		
		return request.getAttributeNames();
	}

	@Override
	public String[] getParameterValues(String name) {
		
		return request.getParameterValues(name);
	}

	@Override
	public String getProtocol() {
		
		return request.getProtocol();
	}

	@Override
	public BufferedReader getReader() throws IOException {
		
		return request.getReader();
	}

	@Override
	public String getRealPath(String path) {
		
		return request.getRealPath(path);
	}

	@Override
	public String getRemoteAddr() {
		
		return request.getRemoteAddr();
	}

	@Override
	public String getRemoteHost() {
		
		return request.getRemoteHost();
	}

	@Override
	public int getRemotePort() {
		
		return request.getRemotePort();
	}

	@Override
	public RequestDispatcher getRequestDispatcher(String path) {
		
		return request.getRequestDispatcher(path);
	}

	@Override
	public String getScheme() {
		
		return request.getScheme();
	}

	@Override
	public String getServerName() {
		
		return request.getServerName();
	}

	@Override
	public int getServerPort() {
		
		return request.getServerPort();
	}

	@Override
	public boolean isSecure() {
		
		return request.isSecure();
	}

	@Override
	public void removeAttribute(String name) {
		
		request.removeAttribute(name);
		
	}

	@Override
	public void setAttribute(String name, Object o) {
		
		request.setAttribute(name, o);
		
	}

	@Override
	public void setCharacterEncoding(String env)
			throws UnsupportedEncodingException {
		
		request.setCharacterEncoding(env);
		
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
