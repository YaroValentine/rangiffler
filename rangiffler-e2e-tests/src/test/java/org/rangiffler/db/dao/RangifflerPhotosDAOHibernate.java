package org.rangiffler.db.dao;

import org.rangiffler.db.ServiceDB;
import org.rangiffler.db.entity.AuthUserEntity;
import org.rangiffler.db.jpa.EmfProvider;
import org.rangiffler.db.jpa.JpaTransactionManager;

public class RangifflerPhotosDAOHibernate extends JpaTransactionManager implements RangifflerPhotosDAO {

    public RangifflerPhotosDAOHibernate() {
        super(EmfProvider.INSTANCE.getEmf(ServiceDB.RANGIFFLER_AUTH).createEntityManager());
    }

    @Override
    public int removeAllUserPhotos(AuthUserEntity user) {
        return 0;
    }

}
