package com.server.jourina.repository;

import com.server.jourina.entity.UserJournal;
import com.server.jourina.entity.UserJournalId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserJournalRepository extends JpaRepository<UserJournal, UserJournalId> {
    @Modifying
    @Query(value = "insert into user_journal values(:id_user, :id_journal)", nativeQuery = true)
    @Transactional
    void setUserJournal(@Param("id_user") Integer id_user, @Param("id_journal") Integer id_jrnl);
}