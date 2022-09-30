package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Client;
import net.javaguides.springboot.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
@RestController
@RequestMapping("/api/v1/client")
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;


    @GetMapping
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    // build create  REST API
    @PostMapping
    public Client createClient(@RequestBody Client client)   {
        return clientRepository.save(client);
    }

    // build get  by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id)    {
        Client client = clientRepository.findById(id).orElseThrow(()-> new ResourceAccessException("Client not exist with id"+id));
        return ResponseEntity.ok(client);
    }

    // build update  REST API
    @PutMapping("{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id,@RequestBody Client clientDetails)    {
        Client updateClient = clientRepository.findById(id).orElseThrow(()-> new ResourceAccessException("Client not exist with id: "+ id));

        updateClient.setId(clientDetails.getId());
        updateClient.setClientName(clientDetails.getClientName());
        updateClient.setLocationTitle(clientDetails.getLocationTitle());
        updateClient.setCreateDate(clientDetails.getCreateDate());
        updateClient.setCreateUser(clientDetails.getCreateUser());



        clientRepository.save(updateClient);

        return  ResponseEntity.ok(updateClient);
    }

    // build delete  REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteClient(@PathVariable Long id)   {

        Client client = clientRepository.findById(id).orElseThrow(()-> new ResourceAccessException("Client not exist with id: "+ id));

        clientRepository.delete(client);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
