package org.zerock.wcup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.wcup.domain.Reply;

public interface ReplyRepository extends JpaRepository<Reply,Long> {
}
