package com.insomnia.java.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.insomnia.java.service.MessageService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author insomnia
 * @date 2021/4/3 下午4:31
 * @effect
 */
@WebServlet(name = "InServlet" , value = "/")
public class InsomniaServlet extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6611180599581120260L;

	private static final String COUNT = "count";
	private static Logger logger = LogManager.getLogger(InsomniaServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		System.out.println("doGet");
		Map<String, Integer> currentMap = MessageService.getCurrentMap();
		Integer count = currentMap.get(COUNT);
		System.out.println("发送短信之前" + count);
		System.out.println("发送一条短信 " );
		currentMap.replace(COUNT,--count);
		System.out.println("发送短信之后的次数" + currentMap.get(COUNT));
		//req.getRequestDispatcher("/index.html").forward(req,resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{

		super.doPost(req, resp);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		super.doPut(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		super.doDelete(req, resp);
	}

}
