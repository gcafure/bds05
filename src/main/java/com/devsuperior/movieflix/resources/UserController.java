package com.devsuperior.movieflix.resources;

import com.devsuperior.movieflix.resources.dtos.UserDTO;
import com.devsuperior.movieflix.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    private final ModelMapper mapper;


    @Autowired
    public UserController(UserService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/profile")
    public ResponseEntity<UserDTO> findLoggedUser(Authentication authentication) {
        var user = service.loadUserByUsername(authentication.getName());

        var response = mapper.map(user, UserDTO.class);

        return ResponseEntity.ok().body(response);
    }

}
