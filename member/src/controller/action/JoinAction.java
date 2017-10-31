package controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import dao.MemberDao;
import dto.MemberVO;

public class JoinAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String url = null;
		MemberVO meVo = new MemberVO();
		
		meVo.setMe_code(Integer.parseInt(request.getParameter("me_code")));
		meVo.setId(request.getParameter("id"));
		meVo.setMe_pwd(request.getParameter("pwd"));
		meVo.setSns(request.getParameter("sns"));
		meVo.setMe_genre(request.getParameter("me_genre"));
		meVo.setEmail(request.getParameter("email"));
		
		MemberDao meDao = MemberDao.getInstance();
		int result = meDao.insertMember(meVo);
		if(result==1) {
			url = "/member/main.jsp";
			request.setAttribute("message", "회원 가입에 성공했습니다. 로그인 해주세요.");
		} else {
			url = "/member/join.jsp";
			request.setAttribute("message", "회원 가입에 실패했습니다. 다시 가입해주세요.");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
}
