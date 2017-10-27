package com.jkxy.tang.test;

import java.sql.SQLException;

import org.junit.Test;

import com.jkxy.tang.util.DBUtil;

public class DBUtilTest {

	@Test
	public void test() {
		try {
			System.out.println(DBUtil.makeConnection().getAutoCommit());
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
