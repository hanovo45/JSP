package co.edu.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.jdbc.EmpDAO;

@WebServlet("/getUserInfo")
public class JdbcServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf-8");
		EmpDAO dao = new EmpDAO();
		
		// get or post 요청을 구분해서 처리
		// get이면 조회 . post이면 입력
		Map<String, Object> result = dao.getEmpInfo(101);
		Set<String> set = result.keySet(); // 키부분만 set 컬렉션
		for(String key : set) {
			System.out.println("key : " + key + ", val : " + result.get(key));
		}
		
		// 페이지 출력, 사번/이름(이름+성씨) / 급여 / 부서
		PrintWriter out = resp.getWriter();
		
		// 페이지 작성
		// {키:값},{키:값},{키:값},{키:값} => result.get('키값')넣으면 값을 반환
		
		out.print("<a href='temp.html'>조회-등록으로 이동</a>");
		
		out.println(result.get("id"));
		out.println(result.get("firstName"));
		out.println(result.get("lastName"));
		out.println(result.get("salary"));
		out.println(result.get("departmentId"));
		
	}
}
