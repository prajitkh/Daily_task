package com;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController

public class UseraController {

//	@Autowired
//	private UserInterface userInterface;
////
//	@GetMapping
//	public ResponseEntity<?> getAlLUsers(@RequestParam(defaultValue = "") String search,
//			@RequestParam(defaultValue = "1") String PageNo, @RequestParam(defaultValue = "5") String PageSize) {
//
//		Page<IListUserDto> iListUserDto = this.userInterface.getAllUsers(search, PageNo, PageSize);
//		return new ResponseEntity<>(new SuccessResponseDto("All users", "success", iListUserDto.getContent()),
//				HttpStatus.OK);
//
//	}
}
