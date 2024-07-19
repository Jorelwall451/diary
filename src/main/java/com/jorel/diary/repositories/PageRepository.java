package com.jorel.diary.repositories;

import com.jorel.diary.entities.PageEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PageRepository extends JpaRepository<PageEntity, Long> {
    List<PageEntity> findAllByUserId(UUID userId, Pageable pageable);
    Optional<PageEntity> findByIdAndUserId(Long pageId, UUID userId);
    void deleteByIdAndUserId(Long pageId, UUID userId);
}
