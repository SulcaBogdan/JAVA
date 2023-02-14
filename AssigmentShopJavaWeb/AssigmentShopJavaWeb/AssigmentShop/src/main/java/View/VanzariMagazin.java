package View;

import Controller.ListaClientiMagazin;
import Model.ClientMagazin;
import Model.CosCumparaturiMagazin;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "VanzariMagazin", value = "/VanzariMagazin")
public class VanzariMagazin extends HttpServlet {
    private String raspuns;

    public void init() {
            raspuns+="<h2> Nume Client </h2>";
            raspuns+="<h2>" + CosCumparaturiMagazin.numeClientMagazin + "</h2>";
            raspuns+="<p>Produse achizitionate: </p>";

            for (int i=0;i<CosCumparaturiMagazin.ProdusMagazine.size();i++){
                raspuns+="<div>("+CosCumparaturiMagazin.ProdusMagazine.get(i).numeProdus+")</div>";
            }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body><div>");
        out.println(raspuns);
        out.println("</div></body></html>");
    }

    public void destroy() {
    }
}