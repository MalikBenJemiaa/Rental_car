package com.example.demo.Client;

import com.example.demo.cars.Cars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Client")
public class ClientController {
private final ClientService clientService;
@Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    /////////////////////////////////////////////////////:
    @GetMapping
    public List<Client> getAllClient() {
        return clientService.getAllClient();
    }
    @GetMapping("/{id}")
    public Optional<Client> getClientById(@PathVariable String id) {
        return clientService.getClientById(id);
    }

    @PostMapping
    public Client createClient(@RequestBody Client client) {

        System.out.println("update client is made succefully");
        return clientService.createClient(client);
    }

    @PutMapping("/{id}")
    public Client updateClient(@PathVariable String id, @RequestBody Client updatedClient) {
        return clientService.updateClient(id, updatedClient);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable String id) {
        clientService.deleteClient(id);
    }
}
