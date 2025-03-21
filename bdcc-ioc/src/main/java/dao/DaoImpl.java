package dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component("dao")//demander à Spri,g de creer un objet de cette class nommé dao/Compenent est comme " bean id class" dans la version XMl
@Repository("dao") // pour les class de la couche DAO
public class DaoImpl implements IDao {


    @Override
    public double getData() {
        System.out.println("Version base de données ");
        double temp=23;
        return temp;
    }
}
