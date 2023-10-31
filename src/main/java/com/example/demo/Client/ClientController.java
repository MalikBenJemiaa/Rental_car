package com.example.demo.Client;

import com.example.demo.cars.Cars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/secure/Client")
public class ClientController {
private final ClientService clientService;
@Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    /////////////////////////////////////////////////////:
        @GetMapping("/GetAllClient")
    public List<Client> getAllClient() {
        return clientService.getAllClient();
    }
    @GetMapping("/getOneClient/{id}")
    public Optional<Client> getClientById(@PathVariable String id) {
        return clientService.getClientById(id);
    }

    @PostMapping("/CreateClient")
    public Client createClient(@RequestBody Client client) {

        System.out.println("update client is made succefully");
        return clientService.createClient(client);
    }

    @PutMapping("/UpdateClient/{id}")
    public Client updateClient(@PathVariable String id, @RequestBody Client updatedClient) {
        return clientService.updateClient(id, updatedClient);
    }

    @DeleteMapping("/DeleteClient/{id}")
    public void deleteClient(@PathVariable String id) {
        clientService.deleteClient(id);
    }
}
