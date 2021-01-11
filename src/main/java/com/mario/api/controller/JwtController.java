package com.mario.api.controller;

import com.mario.api.errors.ErrorMessages;
import com.mario.api.exceptions.TokenServiceException;
import com.mario.api.jwt.JwtUtil;
import com.mario.api.request.JwtRequestToken;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class JwtController {

    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;


    public JwtController(JwtUtil jwtUtil, AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }


    @PostMapping(value = "/authenticate",consumes = MediaType.APPLICATION_JSON_VALUE)
    public String getToken(@RequestBody JwtRequestToken requestToken) throws TokenServiceException {

        if (requestToken.getUsername().isEmpty() && requestToken.getPassword().isEmpty()) throw new TokenServiceException(ErrorMessages.BAD_TOKEN_REQUEST.getErrorMessage());

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requestToken.getUsername(),requestToken.getPassword()));
        }catch (Exception e){

            throw new TokenServiceException(ErrorMessages.TOKEN_IS_NOT_VALID.getErrorMessage());
        }
        return jwtUtil.generateToken(requestToken.getUsername());
    }

}
