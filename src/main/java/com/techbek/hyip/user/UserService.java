package com.techbek.hyip.user;

import com.techbek.hyip.dto.RegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(s)
                .orElseThrow(() -> new UsernameNotFoundException("Username or Password Incorrect"));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.isVerified(), true, true, true, emptyList());
    }


    public void registerUser(RegistrationDto registrationDto) {
        PersonalDetails details = new PersonalDetails();
        details.setCountry(registrationDto.getCountry());
        details.setFirstName(registrationDto.getFirstName());
        details.setLastName(registrationDto.getLastName());

        User user = new User();
        user.setEmail(registrationDto.getEmail());
        user.setUsername(registrationDto.getUsername());
        user.setPassword(registrationDto.getPassword());
        user.setVerified(false);
        user.setPin(registrationDto.getPin());
        user.setPersonalDetails(details);
        userRepository.save(user);


    }
}
