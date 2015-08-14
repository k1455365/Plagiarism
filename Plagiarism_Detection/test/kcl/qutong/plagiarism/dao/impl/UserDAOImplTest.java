package kcl.qutong.plagiarism.dao.impl;

import static org.junit.Assert.*;
import kcl.qutong.plagiarism.dao.pojo.User;

import org.junit.Test;

public class UserDAOImplTest {

	@Test
	public void test() {
			User user=new User();
			user.setUsername("qt");
			user.setPassword("pass");

	}

}
