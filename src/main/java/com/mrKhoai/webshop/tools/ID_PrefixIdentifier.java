package com.mrKhoai.webshop.tools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class ID_PrefixIdentifier implements IdentifierGenerator, Configurable {

    private static final Logger LOGGER = LogManager.getLogger(ID_PrefixIdentifier.class);

    private String infix;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private String result;
    @Override
    public void configure(Type type, Properties properties, ServiceRegistry serviceRegistry) throws MappingException {
        infix = properties.getProperty("infix");

    }

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj) throws HibernateException {

        Connection connection = session.connection();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String query = String.format("select count %s from %s", session.getEntityPersister(obj.getClass().getName(), obj).getIdentifierPropertyName(), obj.getClass().getSimpleName());
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                int max = resultSet.getInt(1);
                result = WebshopConst.ID_PREFIX + "-" + infix + "-" + simpleDateFormat.format(new Date()) + "-" + (max + 1);
                return result;
            }
            LOGGER.info("Successful created ID: " , result);
            statement.close();
            resultSet.close();
        } catch (Exception e) {
            LOGGER.debug(e);
        }
        return null;
    }
}
