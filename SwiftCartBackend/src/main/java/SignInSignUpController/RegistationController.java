package SignInSignUpController;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import com.swiftcart.regestation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class RegistationController {

	@Autowired
    private final UserService userService;
	@Autowired
    private final UserRepository userRepository;

    
    public RegistationController(UserService userService) {
        this.userService = userService;
		this.userRepository = null;
        }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody @Valid UserRegistrationDTO dto) {
        User user = userService.registerUser(dto);
        return ResponseEntity.ok("User registered successfully: " + user.getEmail());
    }

    
}
