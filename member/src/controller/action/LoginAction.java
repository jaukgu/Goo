package controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import dao.MemberDao;
import dto.MemberVO;

public class LoginAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = null;
		MemberVO meVo = new MemberVO();
		
		String id = request.getParameter("id");
		String me_pwd = request.getParameter("me_pwd");
		
		MemberDao meDao = MemberDao.getInstance();
		int result = meDao.userCheck(id, me_pwd);
		
		if(result==-1) {
			url = "/member/main.jsp";
			request.setAttribute("message", "로그인에 실패했습니다. 아이디와 비밀번호를 확인해주세요.");
		} else {
			url = "/member/main.jsp";
			request.setAttribute("message", "로그인에 성공했습니다.");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
}
