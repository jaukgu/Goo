package controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import dao.MemberDao;
import dto.MemberVO;

public class MemberUpdateAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = null;
		MemberVO meVo = new MemberVO();
		MemberDao meDao = MemberDao.getInstance();
		
		int me_code = Integer.parseInt(request.getParameter("me_code"));
		int result = meDao.updateMember(me_code);
		
		if(result==1) {
			url = "/member/main.jsp";
			request.setAttribute("message", "회원 정보가 수정되었습니다.");
		} else {
			url = "/member/main.jsp";
			request.setAttribute("message", "회원 정보 수정에 실패하였습니다.");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
}
