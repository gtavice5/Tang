package com.jkxy.tang.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.jkxy.tang.dao.PoetryDao;
import com.jkxy.tang.entity.Poetry;

public class PoetryDaoTest {

	@Test
	public void test() {
		PoetryDao poetryDao=new PoetryDao();
		
		
//		List<Poetry> pList=poetryDao.getAllByName("���");
//		int i=0;
//		for(Poetry poetry:pList){
//			i++;
//			System.out.println(i+"."+poetry.getTitle());
//		}
		
//		Poetry poetry=poetryDao.getByTitle("�۾�ƪʮ��");
//		System.out.println(poetry.getContent());
		
		Poetry poetry1=poetryDao.getByContent("�ش��۵�լ");
		System.out.println(poetry1.getName());
		
		
	}

}
