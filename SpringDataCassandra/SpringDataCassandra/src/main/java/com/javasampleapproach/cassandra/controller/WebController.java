package com.javasampleapproach.cassandra.controller;

import java.util.HashSet;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.javasampleapproach.cassandra.jpamodel.RoleAccount;
import com.javasampleapproach.cassandra.jpamodel.UserAccount;
import com.javasampleapproach.cassandra.model.ProductCassandra;
import com.javasampleapproach.cassandra.secutiry.repository.RoleRepository;
import com.javasampleapproach.cassandra.secutiry.repository.UserRepository;
import com.javasampleapproach.cassandra.utils.DateTimeUtil;

@Controller
public class WebController {
	public static final Logger log = LoggerFactory.getLogger(WebController.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	/*@GetMapping("/login")
	public String getLogin() {
		return "login";
	}*/

	// test concurrent-session-control-max-session
	@RequestMapping("login")
	public String getLogin2(@RequestParam(required = false) String message, final Model model) {
		
		 if (message != null && !message.isEmpty()) {
		      if (message.equals("timeout")) {
		        model.addAttribute("message", "Time out");
		      }
		      if (message.equals("max_session")) {
		        model.addAttribute("message", "This accout has been login from another device!");
		      }
		      if (message.equals("logout")) {
		        model.addAttribute("message", "Logout!");
		      }
		      if (message.equals("error")) {
		        model.addAttribute("message", "Login Failed!");
		      }
		    }
		    return "login";

	}

	@GetMapping("/userInfo")
	public String index() {
		return "userInfo";
	}

	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}

	@GetMapping("/403")
	public String accessDenied() {
		return "403";
	}

	@RequestMapping("/init2")
	@ResponseBody
	public String initialAccount() {
		/*
		 * roleRepository.save(new RoleAccount(UUID.randomUUID(),"ROLE_ADMIN"));
		 * roleRepository.save(new
		 * RoleAccount(UUID.randomUUID(),"ROLE_MEMBER"));
		 */

		/*
		 * UserAccount admin = new UserAccount();
		 * admin.setId(UUID.randomUUID()); admin.setEmail("admin@gmail.com");
		 * admin.setPassword(passwordEncoder.encode("123456"));
		 * 
		 * HashSet<RoleAccount> roles = new HashSet<>();
		 * roles.add(roleRepository.findByName("ROLE_ADMIN"));
		 * roles.add(roleRepository.findByName("ROLE_MEMBER"));
		 * admin.setRoles(roles); userRepository.save(admin);
		 */
		/*
		 * 
		 * User user = new User(); user.setUser_id(UUID.randomUUID());
		 * user.setEmail("member@gmail.com");
		 * user.setPassword(passwordEncoder.encode("123456"));
		 */
		/*
		 * HashSet<Role> roles2 = new HashSet<>();
		 * roles2.add(roleRepository.findByName("ROLE_MEMBER"));
		 * user.setRoles(roles2);
		 */
		// userRepository.save(user);
		return "done";
	}
	@GetMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login";
	}
	
}
