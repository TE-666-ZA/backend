package de.aittr.g_27_rest_demo.services;

import java.util.List;

public interface IService<T> {

  T save(T obj);

  T getByID(int id);

  List<T> getAll();

  void deleteById(int id);

}
