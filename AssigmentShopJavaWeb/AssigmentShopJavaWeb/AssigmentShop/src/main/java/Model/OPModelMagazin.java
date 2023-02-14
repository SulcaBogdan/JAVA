/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.ListaClientiMagazin;
import Controller.ListaProduseMagazin;


public class OPModelMagazin {

    // constructor - se creeaza cele 2 liste: 1 clienti si 2 ProdusMagazine
    public static void creeazaDate(){
        ClientMagazin client_a = new ClientMagazin();
        client_a.nume ="Alex";
        client_a.prenume = "Popescu";
        client_a.cosCumparaturi = new CosCumparaturiMagazin();

        ClientMagazin client_b = new ClientMagazin();
        client_b.nume ="Andrei";
        client_b.prenume = "Popescu";
        client_b.cosCumparaturi = new CosCumparaturiMagazin();

        ClientMagazin client_c = new ClientMagazin();
        client_b.nume ="Vlad";
        client_b.prenume = "Vlad";
        client_b.cosCumparaturi = new CosCumparaturiMagazin();


        ListaClientiMagazin.ClientiMagazin.add(client_a);
        ListaClientiMagazin.ClientiMagazin.add(client_b);

        ListaProduseMagazin.ProdusMagazine.clear();
        ProdusMagazin p1 = new ProdusMagazin();
        p1.numeProdus ="PC Desktop Asus i3";
        p1.price = 1500;
        ListaProduseMagazin.ProdusMagazine.add(p1);

        ProdusMagazin p2 = new ProdusMagazin();
        p2.numeProdus ="PC Desktop Asus i5";
        p2.price = 2000;
        ListaProduseMagazin.ProdusMagazine.add(p2);

        ProdusMagazin p3 = new ProdusMagazin();
        p3.numeProdus ="Laptop Asus i3";
        p3.price = 2200;
        ListaProduseMagazin.ProdusMagazine.add(p3);

        CosCumparaturiMagazin.numeClientMagazin = "Vlad";
    }
}
