package com.lefu.Iposcloud.ServiceDemo.repository;

import com.lefu.Iposcloud.ServiceDemo.domain.User;
import org.springframework.data.jpa.repository.*;

/**
 * Spring Data JPA repository for the User entity.
 */
@SuppressWarnings("unused")
public interface UserRepository extends JpaRepository<User,Long> {

}
