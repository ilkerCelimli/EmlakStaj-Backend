package com.emlak.backend.service;

import com.emlak.backend.entity.BaseEntity;
import com.emlak.backend.repository.BaseRepository;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public abstract class BaseService<T extends BaseEntity> {

    private final BaseRepository<T> baseRepository;

    protected BaseService(BaseRepository<T> baseRepository) {
        this.baseRepository = baseRepository;
    }

    public boolean save(T entity) {
      T e =   this.baseRepository.save(entity);

      return Objects.nonNull(e.getId()) && !e.getId().isEmpty() && !e.getId().isBlank() ;
      }

      public boolean update(T entity) {
        T e = this.baseRepository.save(entity);
        return true;
      }

      public boolean delete(String id) {
        T e = findById(id);
        if (Objects.nonNull(e)) {
            this.baseRepository.delete(e);
          }
        return true;
      }

      public T findById(String id) {
          Optional<T> o = this.baseRepository.findById(id);
          return o.isPresent() ? o.get():null;
      }

      public List<T> findAll() {
        return this.baseRepository.findAll(Sort.by(Sort.Order.desc("id")));
      }
}
