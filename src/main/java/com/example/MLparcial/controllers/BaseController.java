package com.example.MLparcial.controllers;


import com.example.MLparcial.entities.Base;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;

public interface BaseController<E extends Base,ID extends Serializable> {
    ResponseEntity<?> save(@RequestBody E entity);


}