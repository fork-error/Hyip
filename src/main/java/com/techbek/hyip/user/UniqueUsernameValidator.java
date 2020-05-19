package com.techbek.hyip.user;

import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {
   @Autowired
   UserRepository userRepository;

   public void initialize(UniqueUsername constraint) {
   }

   public boolean isValid(String username, ConstraintValidatorContext context) {
      return username!=null && !userRepository.findByUsername(username).isPresent();
   }
}
