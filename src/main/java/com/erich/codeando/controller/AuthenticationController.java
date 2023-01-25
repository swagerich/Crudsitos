package com.erich.codeando.controller;

import com.erich.codeando.controller.auth.AuthenticationRequest;
import com.erich.codeando.controller.auth.AuthenticationResponse;
import com.erich.codeando.controller.auth.AuthenticationService;
import com.erich.codeando.controller.auth.RegistroRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final AuthenticationService service;

    public AuthenticationController(AuthenticationService service) {
        this.service = service;
    }

    @PostMapping("/registro")
    public ResponseEntity<AuthenticationResponse> registro(@RequestBody RegistroRequest request){
        return ResponseEntity.ok(service.register(request));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }
}
