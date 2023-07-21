package com.web.webproject.repository;

import com.web.webproject.model.dto.UserDto;
import com.web.webproject.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>  {

    Optional<User> findByEmail(String email);
    @Query(value = "SELECT NEW com.web.webproject.model.dto.UserDTO (U.email, U.password) FROM User U WHERE U.email = :email",nativeQuery = true)
    List<UserDto> getUsersRoleByEmail(@Param("email") String email);
}
