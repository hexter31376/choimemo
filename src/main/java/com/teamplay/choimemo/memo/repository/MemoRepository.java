package com.teamplay.choimemo.memo.repository;

import com.teamplay.choimemo.memo.domain.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public interface MemoRepository extends JpaRepository<Memo, Long> {
}
