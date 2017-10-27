package com.jkxy.tang.action;

import java.util.List;

import javax.servlet.ServletRequest;

import org.apache.struts2.ServletActionContext;

import com.jkxy.tang.dao.PoetryDao;
import com.jkxy.tang.entity.Poetry;
import com.opensymphony.xwork2.ActionSupport;

public class ListAction extends ActionSupport {
	private String action;
	private String content;
	
	@Override
	public String execute() throws Exception {
		PoetryDao poetryDao=new PoetryDao();
		ServletRequest request=ServletActionContext.getRequest();
		if(action.equals("getAllByName")){
			List<Poetry> pList=poetryDao.getAllByName(content);
			request.setAttribute("pList", pList);
			return SUCCESS;
		}else if(action.equals("getByTitle")){
			Poetry poetry1=poetryDao.getByTitle(content);
			request.setAttribute("poetry1", poetry1);
			return SUCCESS;
		}else if(action.equals("getByContent")){
			Poetry poetry2=poetryDao.getByContent(content);
			request.setAttribute("poetry2", poetry2);
			return SUCCESS;
		}
		return SUCCESS;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
