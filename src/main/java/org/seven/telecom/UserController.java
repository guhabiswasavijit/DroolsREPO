package org.seven.telecom;
import java.util.List;

import org.seven.telecom.domain.CreateUserRequest;
import org.seven.telecom.domain.CreateUserResponse;
import org.seven.telecom.domain.FindAllUsersResponse;
import org.seven.telecom.domain.User;
import org.seven.telecom.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/user", produces = { MediaType.APPLICATION_JSON_VALUE })
public class UserController {

	private IUserService userService;

	@Autowired
	public UserController(IUserService userService) {
		this.userService = userService;
	}

	@GetMapping("/find/all")
	public FindAllUsersResponse findAll() {
		List<User> userList = userService.findAll();
		FindAllUsersResponse response = new FindAllUsersResponse();
		response.setUserList(userList);
		return response;
	}

	@PostMapping("/create")
	public CreateUserResponse createUser(@RequestBody CreateUserRequest request) {
		if (request.getUsername() == null || request.getUsername().equals("")) {
			throw new UserNotFoundException(Constants.MESSAGE_INVALIDUSERNAME);
		}
		if (request.getPassword() == null || request.getPassword().equals("")) {
			throw new UserNotFoundException(Constants.MESSAGE_INVALIDPASSWORD);
		}
		boolean isUsernameExist = userService.isUsernameExist(request.getUsername());
		if (isUsernameExist) {
			throw new UserNotFoundException(Constants.MESSAGE_SAMEUSERNAMEEXIST);
		}
		User user = userService.createNewUser(new User(request.getUsername(), request.getPassword()));
		CreateUserResponse response = new CreateUserResponse();
		response.setUsername(user.getUsername());
		return response;
	}

}
