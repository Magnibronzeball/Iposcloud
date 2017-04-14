//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.lefu.Iposcloud.ServiceDemo.service.mapper;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.lefu.Iposcloud.ServiceDemo.domain.User;
import com.lefu.Iposcloud.ServiceDemo.service.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {
    public UserMapperImpl() {
    }

    public UserDTO userToUserDTO(User user) {
        if(user == null) {
            return null;
        } else {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setUserName(user.getUserName());
            userDTO.setRemark(user.getRemark());
            return userDTO;
        }
    }

    public List<UserDTO> usersToUserDTOs(List<User> users) {
        if(users == null) {
            return null;
        } else {
            ArrayList list = new ArrayList();
            Iterator var3 = users.iterator();

            while(var3.hasNext()) {
                User user = (User)var3.next();
                list.add(this.userToUserDTO(user));
            }

            return list;
        }
    }

    public User userDTOToUser(UserDTO userDTO) {
        if(userDTO == null) {
            return null;
        } else {
            User user = new User();
            user.setId(userDTO.getId());
            user.setUserName(userDTO.getUserName());
            user.setRemark(userDTO.getRemark());
            return user;
        }
    }

    public List<User> userDTOsToUsers(List<UserDTO> userDTOs) {
        if(userDTOs == null) {
            return null;
        } else {
            ArrayList list = new ArrayList();
            Iterator var3 = userDTOs.iterator();

            while(var3.hasNext()) {
                UserDTO userDTO = (UserDTO)var3.next();
                list.add(this.userDTOToUser(userDTO));
            }

            return list;
        }
    }
}
