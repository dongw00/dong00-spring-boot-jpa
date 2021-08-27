package com.dongwoo.api.user.service;

import com.dongwoo.api.user.domain.User;
import com.dongwoo.api.user.domain.UserDto;
import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    Optional<User> findById(long id);

    void save(User user);

    boolean existsById(long id);

    long count();

    void deleteById(long id);

    String signup(User user);

    UserDto signin(User user);
}
