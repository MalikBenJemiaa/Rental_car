package com.example.demo.Client;

import com.example.demo.cars.Cars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class ClientController {
private final ClientService clientService;
@Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    /////////////////////////////////////////////////////:
        @GetMapping("/secure/admin/GetAllClient")
    public List<Client> getAllClient() {
        return clientService.getAllClient();
    }
    @GetMapping("/secure/admin/getOneClient/{id}")
    public Optional<Client> getClientById(@PathVariable String id) {
        return clientService.getClientById(id);
    }

    @PostMapping("/secure/user/CreateClient")
    public Client createClient(@RequestBody Client client) {

        System.out.println("update client is made succefully");
        return clientService.createClient(client);
    }
/*to make a change that can hundle the update with the username*/
    @PutMapping("/common/UpdateClient/{id}")
    public Client updateClient(@PathVariable String id, @RequestBody Client updatedClient) {
        return clientService.updateClient(id, updatedClient);
    }

    @DeleteMapping("/secure/admin/DeleteClient/{id}")
    public void deleteClient(@PathVariable String id) {
        clientService.deleteClient(id);
    }
}
