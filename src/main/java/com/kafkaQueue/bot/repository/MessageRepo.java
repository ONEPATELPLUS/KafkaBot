package com.kafkaQueue.bot.repository;

import com.kafkaQueue.bot.entity.Messages;
import com.kafkaQueue.bot.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepo extends JpaRepository<Messages, Long> {

    @Query("SELECT m FROM Messages m where m.messageId = :messageId AND m.user = :user ")
    Messages findByMessageIdAndUser(@Param("messageId") Long messageId,
                                           @Param("user") User user);

    @Query("SELECT m FROM Messages m where m.user = :user ")
    List<Messages> findTotalMessagesByUser(@Param("user") User user);
}
