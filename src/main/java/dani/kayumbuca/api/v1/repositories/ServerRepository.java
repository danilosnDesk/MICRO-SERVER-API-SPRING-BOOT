package dani.kayumbuca.api.v1.repositories;

import dani.kayumbuca.api.v1.model.ServerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServerRepository extends JpaRepository<ServerModel, Integer> {

}
