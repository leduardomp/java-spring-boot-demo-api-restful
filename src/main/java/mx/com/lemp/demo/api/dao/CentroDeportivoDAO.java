package mx.com.lemp.demo.api.dao;

import org.springframework.data.repository.CrudRepository;

import mx.com.lemp.demo.api.model.CentroDeportivo;

public interface CentroDeportivoDAO extends CrudRepository<CentroDeportivo, Long> {

}
