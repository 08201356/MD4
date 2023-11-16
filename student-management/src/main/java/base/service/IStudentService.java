package base.service;

import java.util.List;

public interface IStudentService<E> {
    List<E> findAll();
    int findById(int id);
    List<E> findByName(String name);
    void add(E e);
    void update(int id, E e);
    void remove(int id);
}
