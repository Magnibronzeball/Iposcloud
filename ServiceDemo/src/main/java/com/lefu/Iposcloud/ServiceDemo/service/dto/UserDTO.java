package com.lefu.Iposcloud.ServiceDemo.service.dto;


import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the User entity.
 */
public class UserDTO implements Serializable {

    private Long id;

    private String userName;

    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UserDTO userDTO = (UserDTO) o;

        if ( ! Objects.equals(id, userDTO.id)) { return false; }

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "UserDTO{" +
            "id=" + id +
            ", userName='" + userName + "'" +
            ", remark='" + remark + "'" +
            '}';
    }
}
