package com.springbook.biz.User;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
public class UserController {
	@Autowired
	private UserRepository DAO;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String index() {
	return "index.jsp";
	}
	
	@PostMapping("/login.do") // 로그인
	  public String login(User user, HttpSession session) {
	      User login = DAO.findUser(user.getId(), user.getPw());
	      session.setAttribute("user", login);
	      if(login != null) {
	          return "index.jsp";
	      }
	      return "login.jsp";
	  }
	
	@PostMapping("createUser.do") // 계정생성
	  public String create(User user) {
		DAO.save(user);
	      return "index.jsp";
	  }
	
	@RequestMapping("logout.do") // 로그아웃
	  public String logout(HttpSession session) {
		session.invalidate();
	      return "index.jsp";
	  }
	@PostMapping("updateUser.do") // 정보수정
	  public String updateUser(User user, HttpSession session) {
		DAO.save(user); // save 메서드는 없으면 insert 해주고 바뀐부분은 update해줌
		session.setAttribute("user", user);
		return "index.jsp";
	  }
	@RequestMapping("deleteUser.do") // 계정삭제
	  public String deleteUser(User user) {
		DAO.deleteById(user.getUserCode());
	      return "index.jsp";
	  }
	
	@RequestMapping(value="/idChk.do") // 중복체크
	public String idchk(HttpServletRequest req) {
		String id = req.getParameter("id");
		Integer idchk = DAO.idChk(id);
		if(idchk >= 1) {
			req.setAttribute("msg", "사용 불가능합니다.");
			req.setAttribute("result", "1");
			return "idChk.jsp";
		}
			req.setAttribute("msg", "사용 가능합니다.");
			req.setAttribute("result", "0");
		return "idChk.jsp";
	}
	@RequestMapping("/getId.do")
	public String getId(HttpServletRequest req){
		String name = req.getParameter("name");
		req.setAttribute("userId", DAO.getId(name));
		if(DAO.getId(name) != null) {
			return "foundId.jsp";
		}else {
			return "getId.jsp";
		}
	}
	
	@RequestMapping("/getPw.do")
	public String getPw(HttpServletRequest req){
		String id = req.getParameter("id");
		req.setAttribute("userPw", DAO.getPw(id));
		if(DAO.getPw(id) != null) {
			return "foundPw.jsp";
		}else {
			return "getPw.jsp";
		}
	}
	
	 
	
	
}
