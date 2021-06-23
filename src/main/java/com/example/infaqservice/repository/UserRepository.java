package com.example.infaqservice.repository;

import com.example.infaqservice.exception.ResourceNotFoundExceotion;
import com.example.infaqservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query(value = "select a.* from user a where a.email = :email", nativeQuery = true)
    User findByEmail(String email) throws ResourceNotFoundExceotion;

    @Query(value = "select b.* from user b where b.username = :username", nativeQuery = true)
    User findByUsername(String username) throws ResourceNotFoundExceotion;

    @Query(value = "select c.* from user c where c.mobile_phone_number = :mobile_phone_number", nativeQuery = true)
    User findByMobilePhoneNumber(String mobilePhoneNumber) throws ResourceNotFoundExceotion;

    @Query(value = "select d.* from user d where d.username = :username and d.password = :password and d.email = :email and d.mobile_phone_number = :mobile_phone_number", nativeQuery = true)
    User login(String username, String password, String email, String mobilePhoneNumber);
}
