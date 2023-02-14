package View;


import Controller.ListaClientiMagazin;
import Controller.ListaProduseMagazin;
import Model.ClientMagazin;
import Model.CosCumparaturiMagazin;
import Model.ProdusMagazin;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CosMagazin", value = "/CosMagazin")
public class CosMagazin extends HttpServlet {
    private ListaProduseMagazin lp;

    public void init() {
        lp = new ListaProduseMagazin();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String np = request.getParameter("prod");
        
        ProdusMagazin produsSelectat = null;
        for (ProdusMagazin p: ListaProduseMagazin.ProdusMagazine){
            if (p.numeProdus.equals(np)){
                produsSelectat = p;
                CosCumparaturiMagazin.ProdusMagazine.add(produsSelectat);
            }
        }

        response.sendRedirect(request.getContextPath() + "/ProdusMagazine");
    }

    public void destroy() {
    }
}