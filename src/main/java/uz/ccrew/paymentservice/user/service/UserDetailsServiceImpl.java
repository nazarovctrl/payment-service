package uz.ccrew.paymentservice.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import uz.ccrew.paymentservice.user.User;
import uz.ccrew.paymentservice.user.UserDetailsImpl;
import uz.ccrew.paymentservice.user.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<User> optional = userRepository.findByUsername(login.toLowerCase());
        if (optional.isEmpty()) {
            throw new UsernameNotFoundException("Username not found");
        }
        return new UserDetailsImpl(optional.get());
    }
}