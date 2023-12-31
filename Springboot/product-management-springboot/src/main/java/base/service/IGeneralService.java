package base.service;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();
    Optional<T> findById(int id);
    T save(T t);
    void delete(int id);
}
