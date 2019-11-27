package com.lz.service.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ImageServlet")
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static int WIDTH = 140;
	private static int HEIGHT = 33;

	private String[] str = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
			"K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W",
			"X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };
	private Random r = new Random();
	public ImageServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletOutputStream sos = response.getOutputStream();
		StringBuffer sb = new StringBuffer();
		StringBuffer ss = new StringBuffer();
		for (int i = 0; i < 6; i++) {
			int index = r.nextInt(str.length);
			sb.append(str[index]);
			ss.append(str[index]+" ");
		}
		String content = sb.toString();
//		System.out.println(content);
		request.getSession().setAttribute("code", content);
		BufferedImage bi = new BufferedImage(WIDTH, HEIGHT,
				BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.getGraphics();
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.WHITE);
		g.setFont(new Font("ו", Font.BOLD, 20));
		g.drawString(ss.toString(), 10, 22);
		for (int i = 0; i < 400; i++) {
			int x = r.nextInt(WIDTH);
			int y = r.nextInt(HEIGHT);
			g.drawLine(x, y, x, y);
		}
		g.drawLine(10, 0, 130, 30);
		g.drawLine(10, 15, 130, 15);
		g.drawLine(10, 30, 130, 0);
		ImageIO.write(bi, "jpg", sos);
		sos.flush();
		sos.close();
	}

}
