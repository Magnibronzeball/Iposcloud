package com.lefu.Iposcloud.ServiceDemo.service.impl;


import com.lefu.Iposcloud.ServiceDemo.domain.User;
import com.lefu.Iposcloud.ServiceDemo.repository.UserRepository;
import com.lefu.Iposcloud.ServiceDemo.service.UserService;
import com.lefu.Iposcloud.ServiceDemo.service.dto.UserDTO;
import com.lefu.Iposcloud.ServiceDemo.service.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


/**
 * Service Implementation for managing User.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    private final UserMapper userMapper;


    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    /**
     * Save a user.
     *
     * @param userDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public UserDTO save(UserDTO userDTO) {
        log.debug("Request to save User : {}", userDTO);
        User user = userMapper.userDTOToUser(userDTO);
        user = userRepository.save(user);
        UserDTO result = userMapper.userToUserDTO(user);
        userRepository.save(user);
        return result;
    }

    /**
     *  Get all the users.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<UserDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Users");
        Page<User> result = userRepository.findAll(pageable);
        return result.map(user -> userMapper.userToUserDTO(user));
    }

    /**
     *  Get one user by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public UserDTO findOne(Long id) {
        log.debug("Request to get User : {}", id);
        User user = userRepository.findOne(id);
        UserDTO userDTO = userMapper.userToUserDTO(user);
        return userDTO;
    }

    /**
     *  Delete the  user by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete User : {}", id);
        userRepository.delete(id);
    }
}
