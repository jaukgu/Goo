package controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;

@WebServlet("/main.do")
public class IdCheckAction extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter idchk = resp.getWriter();
		String id = req.getParameter("id");
		MemberDao meDao = MemberDao.getInstance();
		String result ="";
		if(meDao.selectMember(id)==1) {
			result = "중복되는 아이디입니다.";
		} else {
			result = "사용가능한 아이디입니다.";
		}
		idchk.print(result);
		idchk.flush();
	}

	
}
