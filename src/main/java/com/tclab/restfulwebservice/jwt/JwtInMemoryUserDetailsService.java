package com.tclab.restfulwebservice.jwt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

  static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

  static {
    inMemoryUserList.add(new JwtUserDetails(1L, "juan",
        "$2a$10$xzEzMHYzllb0Gn2ZJerWNeWMkkJJn6dZHD/NKF.QSRKKMMWh66ZkO", "ROLE_USER_2"));
    inMemoryUserList.add(new JwtUserDetails(1L, "test",
        "$2a$10$w.Td.s.MQA6Qoc4zS10SmOg6UwKHK5aX45Jz.u2ElsTJm2/S/DEiW", "ROLE_USER_2"));
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
        .filter(user -> user.getUsername().equals(username)).findFirst();

    if (!findFirst.isPresent()) {
      throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
    }

    return findFirst.get();
  }

}


