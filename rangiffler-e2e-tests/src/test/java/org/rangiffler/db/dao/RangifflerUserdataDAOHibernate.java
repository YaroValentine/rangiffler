package org.rangiffler.db.dao;

import org.rangiffler.db.ServiceDB;
import org.rangiffler.db.jpa.EmfProvider;
import org.rangiffler.db.jpa.JpaTransactionManager;

public class RangifflerUserdataDAOHibernate extends JpaTransactionManager implements RangifflerUserdataDAO {

    public RangifflerUserdataDAOHibernate() {
        super(EmfProvider.INSTANCE.getEmf(ServiceDB.RANGIFFLER_AUTH).createEntityManager());
    }
}
