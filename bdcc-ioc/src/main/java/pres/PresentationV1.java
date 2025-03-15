package pres;

import dao.DaoImpl;
import ext.DaoImplV2;
import metier.MetierImpl;

public class PresentationV1 {
    public static void main(String[] args) {
        //Injection des dépendance par instanciation statique => new
        //DaoImpl d= new DaoImpl();
        DaoImplV2 d= new DaoImplV2();
        MetierImpl metier = new MetierImpl(d); // Injection via le constructeur
      //  metier.setDao(d);// Injection via le setter
        System.out.println("res = "+metier.calcul());
    }
}
