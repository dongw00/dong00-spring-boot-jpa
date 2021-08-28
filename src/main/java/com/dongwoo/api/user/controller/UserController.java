package com.dongwoo.api.user.controller;

import com.dongwoo.api.user.domain.User;
import com.dongwoo.api.user.domain.UserDto;
import com.dongwoo.api.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowCredentials = "false")
@Api(tags = "users")
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @PostMapping("/signup")
    @ApiOperation(value = "${UserController.signup}")
    @ApiResponses(value = {
        @ApiResponse(code = 400, message = "something wrong"),
        @ApiResponse(code = 403, message = "승인거절"),
        @ApiResponse(code = 422, message = "중복된 username")})
    public ResponseEntity<String> signup(@ApiParam("signup User") @RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.signup(modelMapper.map(userDto, User.class)));
    }

    @PostMapping("/signin")
    @ApiOperation(value = "${UserController.signin}")
    @ApiResponses(value = {
        @ApiResponse(code = 400, message = "something wrong"),
        @ApiResponse(code = 422, message = "유효하지 않은 아이디/비밀번호")})
    public ResponseEntity<UserDto> signin(@ApiParam("Signin User") @RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.signin(modelMapper.map(userDto, User.class)));
    }
}
