package se.alex.lexicon.g51todoapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.alex.lexicon.g51todoapi.converter.UserConverter;
import se.alex.lexicon.g51todoapi.domain.dto.UserDTOForm;
import se.alex.lexicon.g51todoapi.domain.dto.UserDTOView;
import se.alex.lexicon.g51todoapi.entity.User;
import se.alex.lexicon.g51todoapi.exception.DataNotFoundException;
import se.alex.lexicon.g51todoapi.repository.UserRepository;
import se.alex.lexicon.g51todoapi.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    @Override
    @Transactional
    public UserDTOView register(UserDTOForm userDTOForm) {
        User user = userConverter.toUserEntity(userDTOForm);
        user.setEnabled(true);
        User savedUser = userRepository.save(user);
        return userConverter.toUserDTOView(savedUser);
    }

    @Override
    public UserDTOView getByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new DataNotFoundException("User with email " + email + " not found"));
        return userConverter.toUserDTOView(user);
    }

    @Override
    public List<UserDTOView> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userConverter::toUserDTOView)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void disableUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new DataNotFoundException("User with email " + email + " not found"));
        user.setEnabled(false);
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void enableUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new DataNotFoundException("User with email " + email + " not found"));
        user.setEnabled(true);
        userRepository.save(user);
    }

    /**
     * @param email
     */
    @Override
    public void disableByEmail ( String email ) {

    }

    /**
     * @param email
     */
    @Override
    public void enableByEmail ( String email ) {

    }
}