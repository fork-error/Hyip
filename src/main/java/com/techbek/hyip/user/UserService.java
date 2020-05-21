package com.techbek.hyip.user;

import com.techbek.hyip.dto.RegistrationDto;
import com.techbek.hyip.util.EmailSenderUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {
    final EmailSenderUtil emailSenderUtil;
    final UserRepository userRepository;
    final PersonalDetailsRepository detailsRepository;


    @Override
    public UserDetails loadUserByUsername(String s) {
        User user = userRepository.findByEmail(s)
                .orElseThrow(() -> new UsernameNotFoundException("Username or Password Incorrect"));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.isVerified(), true, true, true, emptyList());
    }

    @Transactional
    public void registerUser(RegistrationDto registrationDto) {
        PersonalDetails details = new PersonalDetails();
        details.setCountry(registrationDto.getCountry());
        details.setFirstName(registrationDto.getFirstName());
        details.setLastName(registrationDto.getLastName());
        log.info("trying to save userdetails");
        detailsRepository.save(details);
        log.info("Saved details");

        Optional<User> userReferral = userRepository.findByUsername(registrationDto.getReferral());

        User user = new User();
        user.setEmail(registrationDto.getEmail());
        user.setUsername(registrationDto.getUsername());
        user.setPassword(registrationDto.getPassword());
        if(userReferral.isPresent()){
            user.setReferral(registrationDto.getReferral());
        }
        user.setVerified(true);
        user.setPin(registrationDto.getPin());
        user.setPersonalDetails(details);
        log.info("trying to save user");

        userRepository.save(user);
        log.info(" saved user");

//        emailSenderUtil.sendWelcomeEmail(user);

    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
