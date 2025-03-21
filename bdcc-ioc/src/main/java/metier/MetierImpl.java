package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component("metier")
@Service("metier")//pour la couche metier
public class MetierImpl implements IMetier {
    //couplage faible

    //@Autowired // n'est pas recommendé car il ne respect pas le principe de l'encapsulation car il peut acceder et modifier directemment les attr privés
    // au moment de la creation d'un objet de type MetierImpl, injecter ou affecter dans dao un objet de type IDao
    private IDao dao ;

    //quand on a un construsteur par parameter ,on est pas besoin de @Autowired
    public MetierImpl(@Qualifier("dao2") IDao dao) {
        this.dao = dao;
    }


//on doit utiliser un seule constructeur pour faire  injection des dep via constructeur avec spring
   /* public MetierImpl() {
    }*/

    @Override
    public double calcul() {
        double t= dao.getData();
        return t*23;
    }

    //Pour affecter dans la var dao un objet d'une classe qui implémente l'interface IDao
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
