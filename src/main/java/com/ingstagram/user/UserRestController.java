package com.ingstagram.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ingstagram.user.bo.UserBO;
import com.ingstagram.user.entity.UserEntity;

@RequestMapping("/user")
@RestController
public class UserRestController {
	@Autowired
	private UserBO userBO;
	
	/**
	 * 아이디 중복 확인 API
	 * @param loginId
	 * @return
	 */
	@RequestMapping("/is-duplicated-id")
	public Map<String, Object> isDuplicatedId(@RequestParam("loginId") String loginId){
		Map<String, Object> result = new HashMap<>();
		result.put("isDuplicatedId", false);
		
		//select
		UserEntity userEntity = userBO.getUserEntityByLoginId(loginId);
		result.put("code", 200);
		
		if(userEntity != null) {
			result.put("isDuplicatedId", true);
		}
		return result;
	}
	
	@PostMapping("/sign-up")
	public Map<String, Object> signUp(@RequestParam("loginId") String loginId,
			@RequestParam("password") String password, @RequestParam("name") String name,
			@RequestParam("email") String email){
		// 비밀번호 해싱
		String hashedPassword = EncryptUtils.md5(password);
		
		//db insert
		Integer userId = userBO.addUser(loginId, hashedPassword, name, email);
		
		Map<String, Object> result = new HashMap<>();
		if(userId != null) {
			//응답
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("errorMessage", "회원가입에 실패했습니다.");
		}
		return result;
	}
	

}
