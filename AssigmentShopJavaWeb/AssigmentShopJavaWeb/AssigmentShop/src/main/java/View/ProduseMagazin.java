package View;

import Controller.ListaProduseMagazin;
import Model.ProdusMagazin;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ProdusMagazine", value = "/ProdusMagazine")
public class ProduseMagazin extends HttpServlet {
    private String raspuns;

      public void init(){

          raspuns = "Utilizator: " + AutentificaMagazin.utilizatorActiv;

        for (ProdusMagazin p: ListaProduseMagazin.ProdusMagazine){
            
            
            raspuns +=
                    "<form method=\"post\" action=\"CosMagazin\">"+
                    "ProdusMagazin: " + p.numeProdus + " Pret: "+ p.price +
                    "<input type=\"hidden\" name=\"prod\" value=\""+
                            p.numeProdus+
                            "\">"+
                    "<input type=\"submit\" name=\"\" value=\"Adauga in cos\">" +
                    "</form>";

        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println(raspuns);
        out.println("</body></html>");

    }
}