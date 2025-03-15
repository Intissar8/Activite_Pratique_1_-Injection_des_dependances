package pres;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class PresentationV2 {
    public static void main(String[] args) {
        //Injection des dépendance par instanciation dynamique
        try {
            Scanner scanner = new Scanner(new File("config.txt"));

            //DaoImpl d= new DaoImpl(); // creer objet de 1ere ligne dans config.txt
            String daoClassname = scanner.nextLine();//lire le 1ere ligne dans config.txt
            //System.out.println(daoClassname);
            Class cDao = Class.forName(daoClassname); //charge it in memory if it exists in daoClassname
            IDao dao = (IDao) cDao.getConstructor().newInstance();//create an instance of the class of type object  but we cast it to Interface IDao
           // System.out.println(dao.getData());

            //MetierImpl metier = new MetierImpl(d);// creer objet de 2eme ligne dans config.txt
            String metierClassname = scanner.nextLine();//lire le next  line  dans config.txt
            Class cMetier = Class.forName(metierClassname); //charger dans memoire
           // IMetier metier = (IMetier) cMetier.getConstructor(IDao.class).newInstance(dao); //constr avec parametre pour creer objet

            //  metier.setDao(d);//methode dynamique pour utilisé setters
            IMetier metier = (IMetier) cMetier.getConstructor().newInstance();
            Method setDao = cMetier.getDeclaredMethod("setDao",IDao.class);
            setDao.invoke(metier,dao);
            System.out.println("RES="+metier.calcul());



        } catch (Exception e) {
            System.out.println(e.getMessage());
       /* } catch (ClassNotFoundException e) { // pour si la class dans daoClassname n'existe pas
            System.out.println(e.getMessage());
        }*/
        }
    }
}
