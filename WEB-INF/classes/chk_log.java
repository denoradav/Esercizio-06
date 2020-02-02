import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import beans.*;

public class chk_log extends HttpServlet{
    Iterator it;
    Vector ve;
    User user;

    public void init(){
        ve = new Vector();
        ve.addElement(new User("admin","1234"));
        it = ve.iterator();
    }


    public void doPost(HttpServletRequest request,HttpServletResponse response)
    throws ServletException,IOException{
        String usr= request.getParameter("usr");
        String pwd= request.getParameter("pwd");
        HttpSession session = request.getSession();
        int step = Integer.parseInt(request.getParameter("step"));
        boolean logged = false;
        PrintWriter out=response.getWriter();

        response.setContentType("text.html");

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Titolo</title>");
        out.println("</head>");
        out.println("<body>");

        if (step==0){
            while(it.hasNext()){
                user = (User)it.next();
                if (user.canLog(usr,pwd)) logged = true;
            }

            if(logged){
                out.println("<form method=\"post\">");
                out.println("Nome:<br>");
                out.println("<input type=\"text\" name=\"nome\">");
                out.println("<input type=\"hidden\" name=\"step\" value=\"1\"><br>");
                out.println("<input type=\"submit\" value=\"invia\">");

            } else {

                //non si può entrare relog
            }
        }

        if (step==1){   
            String nome = request.getParameter("nome");
            session.setAttribute("nome",nome);
            out.println("<form method=\"post\">");
            out.println("Eta':<br>");
            out.println("<input type=\"text\" name=\"eta\">");
            out.println("<input type=\"hidden\" name=\"step\" value=\"2\"><br>");
            out.println("<input type=\"submit\" value=\"invia\">");
        }

        if (step==2){   
            String eta = request.getParameter("eta");
            session.setAttribute("eta",eta);
            out.println("<form method=\"post\">");
            out.println("Data di nascita:<br>");
            out.println("<input type=\"text\" name=\"data\">");
            out.println("<input type=\"hidden\" name=\"step\" value=\"3\"><br>");
            out.println("<input type=\"submit\" value=\"invia\">");
        }

        if (step==3){   
            String data = request.getParameter("data");
            String nome = (String)session.getAttribute("nome");
            String eta = (String)session.getAttribute("eta");

            out.println("Nome: " +nome+"<br>");
            out.println("Eta: " +eta+"<br>");
            out.println("Data: " +data+"<br>");
        }

        
        
        out.println("</body>");
        out.println("</html>");

        

        

    }
}