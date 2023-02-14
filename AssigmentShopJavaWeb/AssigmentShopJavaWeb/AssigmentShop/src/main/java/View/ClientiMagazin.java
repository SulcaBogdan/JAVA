package View;

import Controller.ListaClientiMagazin;
import Model.ClientMagazin;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ClientiMagazin", value = "/ClientiMagazin")
public class ClientiMagazin extends HttpServlet {
    private String mesaj;
    private String raspuns;

    public void init() {
        raspuns = "<h4> Nume Client </h4>";

        for (ClientMagazin c: ListaClientiMagazin.ClientiMagazin){
            raspuns += "<div>" + c.nume +"</div>";
        }
        mesaj = raspuns;
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + mesaj + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}