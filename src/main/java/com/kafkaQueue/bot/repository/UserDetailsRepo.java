package com.kafkaQueue.bot.repository;

import com.kafkaQueue.bot.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDetailsRepo extends JpaRepository<User, Long> {

	@Query("select u from User u where u.userNumber = :userNumber")
	User findUserNumber(@Param("userNumber") Long messageId);


}
