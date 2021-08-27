package com.dongwoo.api.user.domain;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;

@Data
public class UserDto {

    private long userId;

    @ApiModelProperty(position = 1)
    private String username;

    @ApiModelProperty(position = 2)
    private String password;

    @ApiModelProperty(position = 3)
    private String name;

    @ApiModelProperty(position = 4)
    private String email;

    @ApiModelProperty(position = 5)
    private String regDate;

    @ApiModelProperty(position = 6)
    private String token;

    @ApiModelProperty(position = 7)
    private List<Role> roles;
}
