package com.jluzh.utils;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

public class JDBCUtilsTest {
    @Test
    public void testGetConnection() throws Exception {
        Connection connection = JDBCUtils.getConnection();
        Assert.assertNotNull(connection);
    }
}
