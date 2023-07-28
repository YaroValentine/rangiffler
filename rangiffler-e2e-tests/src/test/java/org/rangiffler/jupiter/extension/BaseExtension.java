package org.rangiffler.jupiter.extension;

import io.qameta.allure.AllureId;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.rangiffler.db.dao.RangifflerAuthDAOHibernate;
import org.rangiffler.db.dao.RangifflerPhotosDAOHibernate;
import org.rangiffler.db.dao.RangifflerUserdataDAOHibernate;
import org.rangiffler.pages.FriendsTravelsPage;

import java.util.Objects;

public abstract class BaseExtension {

    RangifflerAuthDAOHibernate rangifflerAuthDAOHibernate;
    RangifflerUserdataDAOHibernate rangifflerUserdataDAOHibernate;
    RangifflerPhotosDAOHibernate rangifflerPhotosDAOHibernate;

    protected String getTestId(ExtensionContext context) {
        return Objects
                .requireNonNull(context.getRequiredTestMethod().getAnnotation(AllureId.class))
                .value();
    }

    public RangifflerAuthDAOHibernate rangifflerAuthDAOHibernate() {
        return rangifflerAuthDAOHibernate == null ? new RangifflerAuthDAOHibernate() : rangifflerAuthDAOHibernate;
    }
    public RangifflerUserdataDAOHibernate rangifflerUserdataDAOHibernate() {
        return rangifflerUserdataDAOHibernate == null ? new RangifflerUserdataDAOHibernate() : rangifflerUserdataDAOHibernate;
    }
    public RangifflerPhotosDAOHibernate rangifflerPhotosDAOHibernate() {
        return rangifflerAuthDAOHibernate == null ? new RangifflerPhotosDAOHibernate() : rangifflerPhotosDAOHibernate;
    }
}
