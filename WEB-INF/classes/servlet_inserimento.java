import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import beans.Utente;

public class servlet_inserimento extends HttpServlet{
    public void doPost(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException{
        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        int annoDiNascita = Integer.parseInt(request.getParameter("anno"));
        Utente utente = new Utente(nome,cognome,annoDiNascita);

        HttpSession session = request.getSession();

        session.setAttribute("utente",utente);

        if (annoDiNascita<2000){
            response.sendRedirect("servlet_destinazione");
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/servlet_destinazione");
            rd.forward(request,response);
        }
    }
}