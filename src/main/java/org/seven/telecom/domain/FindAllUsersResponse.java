package org.seven.telecom.domain;


import java.util.List;
import lombok.Data;

@Data
public class FindAllUsersResponse {
	List<User> userList;
}
