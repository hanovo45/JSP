package co.yedam.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.service.BookService;
import co.yedam.service.BookServiceMybatis;
import co.yedam.vo.BookVO;

public class BoodAddControl implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String code = request.getParameter("code");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String press = request.getParameter("press");
		String desc = request.getParameter("desc");
		String price = request.getParameter("price");
		
		BookVO vo = new BookVO();
		vo.setBookCode(code);
		vo.setBookTitle(title);
		vo.setBookAuthor(author);
		vo.setBookPress(press);
		vo.setBookDesc(desc);
		vo.setBookPrice(price);
		System.out.println("입력 : " + vo);
		
		BookService service = new BookServiceMybatis();
		
		if(service.addBook(vo)) {
			System.out.println("성공");
			response.sendRedirect("bookList.do");
			request.getRequestDispatcher("WEB-INF/book/bookAddForm.jsp").forward(request, response);
//		}else {
//			System.out.println("예외");
////			request.setAttribute("message", "예외임");
//			request.getRequestDispatcher("WEB-INF/book/bookAddForm.jsp").forward(request, response);
		}
		
//		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/book/bookList.jsp");
//		rd.forward(request, response);
		
//		private String bookCode;
//		private String bookTitle;
//		private String bookAuthor;
//		private String bookPress;
//		private String bookDesc;
//		private String bookPrice;

	}

}
