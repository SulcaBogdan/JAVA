package View;


import Controller.ListaProduseMagazin;
import Model.OPModelMagazin;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.ServletException;

@WebServlet(name = "AutentificaMagazin", value = "/AutentificaMagazin")
public class AutentificaMagazin extends HttpServlet {
    public static String raspuns;
    public static String utilizatorActiv;
    private ListaProduseMagazin lp;

    public void init() {
        lp = new ListaProduseMagazin();
        OPModelMagazin.creeazaDate();
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String utilizator = request.getParameter("utilizator");
        String parola = request.getParameter("parola");
        if (parola.equals("Vlad")){
            utilizatorActiv = utilizator;
            response.sendRedirect("meniuMagazin.jsp");
        }
        else{
            raspuns = "<div style='color:red'>User sau parola incorecte !</div>";
            response.sendRedirect("index.jsp");
        }
    }
    public void destroy() {
    }
}