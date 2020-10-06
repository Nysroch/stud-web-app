package hr.tvz.sekula.studapp.user;

import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<UserDTO> findByUsername(String username) {
        return userRepository.findUserByUsername(username).map(this::mapUserToDTO);
    }

    private UserDTO mapUserToDTO(User user) {
        return new UserDTO(user.getId(), user.getUsername(), user.getFirst_name(), user.getLast_name(),
                user.getAuthorities().stream().map(Authority::getName).collect(Collectors.toSet()));
    }
}
