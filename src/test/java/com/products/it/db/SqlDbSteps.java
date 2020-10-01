package com.products.it.db;
/*-
 *#%L
 * product-service
 *#%L
 */

import cucumber.api.java.en.Given;
import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.SQLException;

public class SqlDbSteps extends SqlDbTestDataSupport {

    @Autowired
    private DataSource dataSource;

    @Before
    public void cleanUp() throws SQLException {
        importSqlResource(dataSource, "/db/cleanup.sql");
    }

    @Given("^the database contains the data prepared for (.*)")
    public void importSqlData(final String dataFileDescription) throws SQLException {
        final String scriptFileName = fileDescriptionToFileName(dataFileDescription, ".sql");
        importSqlResource(dataSource, "/db/" + scriptFileName);
    }

    @After
    public void clean() throws SQLException {
        importSqlResource(dataSource, "/db/cleanup.sql");
    }
}