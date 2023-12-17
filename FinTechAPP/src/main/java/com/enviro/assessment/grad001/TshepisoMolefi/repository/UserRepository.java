package com.enviro.assessment.grad001.TshepisoMolefi.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.enviro.assessment.grad001.TshepisoMolefi.models.User;

@Repository
public interface UserRepository  extends CrudRepository<User, Integer> {

    @Query(value = "SELECT user1 FROM users WHERE user1 = :user1", nativeQuery = true)
    String getUserName(@Param("user1")String user1);

    @Query(value = "SELECT password FROM users WHERE user1 = :user1", nativeQuery = true)
    String getUserPassword(@Param("user1")String user1);

    @Query(value = "SELECT verified FROM users WHERE user1 = :user1", nativeQuery = true)
    int isVerified(@Param("user1")String user1);

    @Query(value = "SELECT * FROM users WHERE user1 = :user1", nativeQuery = true)
    User getUserDetails(@Param("user1")String user1);

    @Modifying
    @Query(value = "INSERT INTO users (first_name, last_name, user1, password,address,contact,age, token, code) VALUES" +
            "(:first_name, :last_name, :user1, :password, :address,:contact,:age, :token, :code)", nativeQuery = true )
    @Transactional
    void registerUser(@Param("first_name")String first_name,
                      @Param("last_name") String last_name,
                      @Param("user1")String user1,
                      @Param("password")String password,
                      @Param("address")String address,
                      @Param("contact") String contact,
                      @Param("age") String age,
                      @Param("token") String token,
                      @Param("code")int code);

    @Modifying
    @Query(value = "UPDATE users SET token=null, code=null, verified=1, verified_at=NOW(), updated_at=NOW() WHERE " +
            "token= :token AND code= :code", nativeQuery = true)
    @Transactional
    void verifyAccount(@Param("token")String token, @Param("code") String code);

    @Query(value = "SELECT token FROM users WHERE token = :token" , nativeQuery = true)
    String checkToken(@Param("token")String token);

}
