package com.dongwoo.api.user.controller;

import com.dongwoo.api.user.domain.UserDto;
import com.dongwoo.api.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.mappers.ModelMapper;

@CrossOrigin(origins = "*", allowCredentials = "*")
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
        System.out.println("################## MMMMMMM ###########");
        return ResponseEntity.noContent().build();
    }
}
