package metier;

import dao.IDao;

public class MetierImpl implements IMetier {
    //couplage faible
    private IDao dao ;

    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    public MetierImpl() {
    }

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
