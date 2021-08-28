package com.dongwoo.api.user.service;

import com.dongwoo.api.security.domain.SecurityProvider;
import com.dongwoo.api.security.exception.SecurityRuntimeException;
import com.dongwoo.api.user.domain.Role;
import com.dongwoo.api.user.domain.User;
import com.dongwoo.api.user.domain.UserDto;
import com.dongwoo.api.user.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final SecurityProvider provider;
    private final ModelMapper modelMapper;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public boolean existsById(long id) {
        return userRepository.existsById(id);
    }

    @Override
    public long count() {
        return userRepository.count();
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public String signup(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new SecurityRuntimeException("중복된 ID입니다.", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        List<Role> list = new ArrayList<>();
        list.add(Role.USER);
        user.setRoles(list);
        userRepository.save(user);

        log.info("Sign up user: " + user);
        return provider.createToken(user.getUsername(), user.getRoles());
    }

    @Override
    public UserDto signin(User user) {
        try {
            UserDto dto = modelMapper.map(user, UserDto.class);
            String token =
                (passwordEncoder.matches(user.getPassword(), userRepository.findByUsername(
                    user.getUsername()).get().getPassword())) ? provider.createToken(
                    user.getUsername(),
                    userRepository.findByUsername(user.getUsername()).get().getRoles())
                    : "Wrong Password";
            dto.setToken(token);
            return dto;
        } catch (Exception e) {
            throw new SecurityRuntimeException("유효하지 않은 아이디/비밀번호", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
