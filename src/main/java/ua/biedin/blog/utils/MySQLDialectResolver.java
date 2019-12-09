package ua.biedin.blog.utils;

import org.hibernate.dialect.MySQL8Dialect;
import org.springframework.stereotype.Component;

import java.sql.Types;

@Component
public class MySQLDialectResolver extends MySQL8Dialect {
    protected void registerVarcharTypes() {
        registerColumnType(Types.BIGINT, "INT(11)");
        registerColumnType(Types.VARCHAR, "VARCHAR(255)");
    }
}
