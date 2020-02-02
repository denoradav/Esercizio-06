import java.io.*;
import beans.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class servlet_destinazione extends HttpServlet{
    public void doGet(HttpServletRequest request,HttpServletResponse response)
    throws IOException,ServletException{
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        Utente utente = (Utente)session.getAttribute("utente");

        response.setContentType("text/html");

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet di destinazione</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet di destinazione</h1>");

        out.println("Ciao " + utente.getNome() + " " + utente.getCognome()+"<br>");

        if(utente.getAnnoDiNascita()<2000){
            out.println("Alla tua età devi controllare la prostata");
        } else {
            out.println("Che bella la gioventu'");
        }


        out.println("</body>");
        out.println("</html>");
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response)
    throws IOException,ServletException{
        doGet(request, response);
    }

}