package com.mrKhoai.webshop.objects;

import com.mrKhoai.webshop.tools.WebshopConst;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountIdGenerator implements IdentifierGenerator {

    private static final Logger LOGGER = LogManager.getLogger(AccountIdGenerator.class);

    public static void closeStatement(Statement statement, ResultSet resultSet) {
        try {
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
    }

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {

        Connection connection = sharedSessionContractImplementor.connection();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select count(account_id) as Id from account");
            if (resultSet.next()) {
                int id = resultSet.getInt(1) + 1;
                String generatedId = WebshopConst.PREFIX + new Integer(id).toString();
                return generatedId;
            }
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        } finally {
            closeStatement(statement, resultSet);
        }

        return WebshopConst.PREFIX;
    }
}
