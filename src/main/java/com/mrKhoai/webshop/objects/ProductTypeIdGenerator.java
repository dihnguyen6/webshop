package com.mrKhoai.webshop.objects;

import com.mrKhoai.webshop.tools.WebshopConst;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;

public class ProductTypeIdGenerator implements IdentifierGenerator {

    private static final Logger LOGGER = LogManager.getLogger(ProductTypeIdGenerator.class);

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {

        ProductType pt = (ProductType) o;
        Connection connection = sharedSessionContractImplementor.connection();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select count(product_type_id) as Id from product_type");
            if (resultSet.next()) {
                try {
                    byte[] name = pt.getProductTypeNameEN().getBytes("UTF-8");
                    MessageDigest md = MessageDigest.getInstance("MD5");
                    String generatedId = Base64.getEncoder().encodeToString(md.digest(name));
                    LOGGER.info(generatedId);
                    return generatedId;
                } catch (NoSuchAlgorithmException e) {
                    LOGGER.info(e.getMessage());
                } catch (UnsupportedEncodingException e) {
                    LOGGER.info(e.getMessage());
                }
            }
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        } finally {
            AccountIdGenerator.closeStatement(statement, resultSet);
        }

        return WebshopConst.PREFIX;
    }
}
