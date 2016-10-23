package org.apache.jsp.ch04;      
     
import javax.servlet.*;  
import javax.servlet.http.*;      
import javax.servlet.jsp.*;      

import java.text.*;      
import java.util.*;

import jsp.*;

import org.apache.*;
     
public final class show_jsp extends org.apache.jasper.runtime.HttpJspBase      
    implements org.apache.jasper.runtime.JspSourceDependent {      
     
  private static java.util.List _jspx_dependants;      
     
  /************************************************************/
  public Object getDependants() {      
    return _jspx_dependants;      
  }      
  /***********************************************************/
     
  public void _jspService(HttpServletRequest request, HttpServletResponse response)      
        throws java.io.IOException, ServletException {      
     
    JspFactory _jspxFactory = null;      
    PageContext pageContext = null;      
    HttpSession session = null;      
    ServletContext application = null;      
    ServletConfig config = null;      
    JspWriter out = null;      
    Object page = this;      
    JspWriter _jspx_out = null;      
    PageContext _jspx_page_context = null;      
     
    try {      
      _jspxFactory = JspFactory.getDefaultFactory();      
      response.setContentType("text/html;charset=gb2312");      
      pageContext = _jspxFactory.getPageContext(this, request, response,      
                   null, true, 8080, true);      
      _jspx_page_context = pageContext;      
      application = pageContext.getServletContext();      
      config = pageContext.getServletConfig();      
      session = pageContext.getSession();      
      out = pageContext.getOut();      
      _jspx_out = out;      
     
      out.write("\r\n");      
      out.write("<html>\r\n");      
      out.write("<head>\r\n");      
      out.write("<title>Show time</title>\r\n");      
      out.write("</head>\r\n");      
      out.write("<body> \r\n");      
      out.write("\tHello : \r\n");      
      out.write("\t");      
     
         SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");      
         String str = format.format(new Date());      
     
      out.write("\r\n");      
      out.write("\t ");      
      out.print(str );      
      out.write("\r\n");      
      out.write("</body>\r\n");      
      out.write("</html>");      
    } catch (Throwable t) {      
     
      if (!(t instanceof SkipPageException)){      
        out = _jspx_out;      
        if (out != null && out.getBufferSize() != 0)      
          out.clearBuffer();      
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);      
      }      
     
    } finally {      
     
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);      
    }      
  }

@Override
public List getIncludes() {
	// TODO Auto-generated method stub
	return null;
}      
} 