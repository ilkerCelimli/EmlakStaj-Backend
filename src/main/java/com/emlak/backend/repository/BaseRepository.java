package com.emlak.backend.repository;

import com.emlak.backend.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T,String> {
}
