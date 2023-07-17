package com.web.webproject.repository;

import com.web.webproject.model.dto.UserRoleDTO;
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
    @Query(value = "SELECT UR.id,UT.email,RT.role_name,RT.id AS role_id,UT.id AS user_id FROM user_role AS UR INNER JOIN user_table as UT ON UR.user_id = UT.id INNER JOIN role_table AS RT ON RT.id = UR.role_id WHERE UT.email=email",nativeQuery = true)
     List<UserRoleDTO> getUsersRoleByEmail(@Param("email") String email);

}
