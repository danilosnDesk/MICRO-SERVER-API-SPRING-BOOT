package dani.kayumbuca.api.v1.controllers;


import dani.kayumbuca.api.v1.dtos.ServerDTO;
import dani.kayumbuca.api.v1.model.ServerModel;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import dani.kayumbuca.api.v1.repositories.ServerRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class ServerController {

    @Autowired
    ServerRepository serverRepository;

    @GetMapping("/servers")
    public ResponseEntity<List<ServerModel>> getAllServers() {
        List<ServerModel>  servers = serverRepository.findAll();
        return  ResponseEntity.status(HttpStatus.OK).body(servers);
    }

    @PostMapping("/servers")
    public ResponseEntity<ServerModel> saveServer(@RequestBody @Valid ServerDTO serverDTO) {
        var serveModel = new ServerModel();
        BeanUtils.copyProperties(serverDTO, serveModel);
        return  ResponseEntity.status(HttpStatus.CREATED).body(serverRepository.save(serveModel));
    }

    @GetMapping("/servers/{id}")
    public ResponseEntity<ServerModel> getServerById(@PathVariable("id") int id) {
        Optional<ServerModel> serveModel = serverRepository.findById(id);
        return serveModel.map(server -> ResponseEntity.status(HttpStatus.OK).body(server))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @DeleteMapping("/servers/{id}")
    public ResponseEntity<ServerModel> deleteServerById(@PathVariable("id") int id) {
        Optional<ServerModel> server = serverRepository.findById(id);
        if(server.isPresent()) {
            serverRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(server.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }


    @PutMapping("/servers/{id}")
    public ResponseEntity<ServerModel> updateServer(@PathVariable("id") int id, @RequestBody @Valid ServerDTO serverDTO) {
        Optional<ServerModel> server =  this.serverRepository.findById(id);

        if(server.isPresent()) {
            BeanUtils.copyProperties(serverDTO, server.get(), "id");
            return  ResponseEntity.status(HttpStatus.OK).body(serverRepository.save(server.get()));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

}
