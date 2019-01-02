package com.mrKhoai.webshop.tools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class IdGenerator extends SequenceStyleGenerator {
    private static final Logger LOGGER = LogManager.getLogger(IdGenerator.class);

    public static final String INFIX_PARAMETER = "INFIXXX";
    public static final String INFIX_DEFAULT = "-";
    private String infix;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static final String NUMBER_FORMAT_PARAMETER = "numberFormat";
    public static final String NUMBER_FORMAT_DEFAULT = "%03d";
    private String numberFormat;

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj) throws HibernateException {
        Serializable result = WebshopConst.ID_PREFIX
                + "-" + simpleDateFormat.format(new Date())
                + "-" + infix
                + "-" + String.format(numberFormat, super.generate(session, obj));
        LOGGER.info("ID: [{}] successful created.", result);
        return result;
    }

    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
        super.configure(LongType.INSTANCE, params, serviceRegistry);
        infix = ConfigurationHelper.getString(INFIX_PARAMETER, params, INFIX_DEFAULT);
        numberFormat = ConfigurationHelper.getString(NUMBER_FORMAT_PARAMETER, params, NUMBER_FORMAT_DEFAULT);
    }
}
