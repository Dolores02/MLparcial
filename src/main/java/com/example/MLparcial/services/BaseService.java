package com.example.MLparcial.services;

import com.example.MLparcial.entities.Base;
import java.io.Serializable;
import java.util.List;

public interface BaseService<E extends Base, ID extends Serializable> {
    public List<E> findAll() throws Exception; //lista de todas las E  en base de datos
    public E findById(ID id) throws Exception; //buscar por ID
    public E save(E entity) throws Exception; //crear nueva entidad
    public E update(ID id, E entity) throws Exception; //actualizar entidad
    public boolean delete(ID id) throws Exception; //eliminar registro de la base de datos
}
