package controller.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;

@WebServlet("/login.do")
public class PassCheckAction extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter passChk = resp.getWriter();
		String me_pwd = req.getParameter("me_pwd");
		MemberDao meDao = MemberDao.getInstance();
		String result ="";
		Pattern p = Pattern.compile("([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~])|([!,@,#,$,%,^,&,*,?,_,~].*[a-zA-Z0-9])");
		Matcher m = p.matcher(me_pwd);
		if(me_pwd.length()<8 || me_pwd.length()>16) {
			result = "8~16 글자로 입력해주세요.";
		} else if(!m.find()){
			result = "숫자, 문자, 특수문자(!,@,#,$,%,^,&,*,?,_,~)를 혼합하여 입력해주세요.";
		}
		passChk.print(result);
		passChk.flush();
	}
	
}
