package org.rangiffler.db.dao;

import org.rangiffler.db.entity.AuthUserEntity;

public interface RangifflerPhotosDAO {

    int removeAllUserPhotos(AuthUserEntity user);
}
