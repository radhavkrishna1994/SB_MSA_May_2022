package UserController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.model.User;
import com.training.services.UserService;

import reactor.core.publisher.Flux;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	//web
	@GetMapping("/users")
	public List<User> getUsers()
	{
		return userService.getUsers();
		
	}
	
	//Reactive
	@GetMapping("/userstream")
	public Flux<User> getUsersStream()
	{
		return userService.getUsersStream();
		
		
	}
}
