package co.prod.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.prod.controller.MemberListControl;
import co.prod.controller.MembersControl;
import co.prod.controller.ProductInfoControl;
import co.prod.controller.ProductListControl;

public class FrontController extends HttpServlet{
	
	private Map<String, Control> map;
	
	public FrontController() {
		map = new HashMap<>();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
			
		// url <-> control
		map.put("/memberList.do", new MemberListControl());
		map.put("/members.do", new MembersControl());
		
		// 상품목록
		map.put("/productList.do", new ProductListControl());
		// 상품 한건 정보
		map.put("/productInfo.do", new ProductInfoControl());
	}
	

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uri = req.getRequestURI();	// 
		String context = req.getContextPath();	
		String page = uri.substring(context.length());
		System.out.println("do page: " + page);
		
		Control command = map.get(page);
		String viewPage = command.exec(req, resp);	//  
		
		if(viewPage.endsWith(".jsp")) {		// memberList.do
			viewPage = "/WEB-INF/views/" + viewPage;
//		}else if(viewPage.endsWith(".tiles")){	// members.do
			
		}
		
		
		RequestDispatcher rd = req.getRequestDispatcher(viewPage);
		rd.forward(req, resp);
		
//       -  준호 교수님 말씀 - 
//		http://localhost:8081/HelloApp/members.do
//			-->
//			uri = /HelloApp/members.do
//			context<<<-어플리케이션부분을 말해요
//			req.getContextpath()라는건
//			메소드인데
//			uri입력한 어플리케이션 경로
//			->즉  /HelloApp
//			context = /helloapp
//			substring<<우리 이미 배운건데 
//			subString(?)만큼을 제외한 String
//			uri에서 제외를 해달라
//			얼만큼? context의 길이만큼
//			/HelloApp의 길이만큼을 제외한 uri
//			uri = /HelloApp/members.do
//			page = /members.do
//			map.get("/members.do")
//			Control command = map.get("/members.do")Map<String, Control>
//			Map< String : Control>
//			Control command = <"/members.do : new MemberListControl()>
//			command = new MemberListControl()
//			command = MemberListControl 이라는 클래스에요
//			command.exec
//			MemberListControl().exec();
//			exec<<오버라이딩 한거에
//			return "member/member.tiles
//			String viewPage = member/member.tiles
//
//			dispatcher("member/member.tiles")<<
//			경로 재지정을 위해서 사용;
//
//			rd.forward(req,resp);
//			경로 재지정된 곳에 req와 resp 설정한 걸 가지고 넘어가주세요
//
//			req.setAttritude("message","오류입니다")
//
//			member/member.tiles
//			request.getAttritude("message")
//			"오류입니다"
	}
}
