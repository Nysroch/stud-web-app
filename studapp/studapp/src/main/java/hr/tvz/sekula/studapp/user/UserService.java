package hr.tvz.sekula.studapp.user;

import java.util.Optional;

public interface UserService {


    Optional<UserDTO> findByUsername(String username);
}
