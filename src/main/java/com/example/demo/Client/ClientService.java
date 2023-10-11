package com.example.demo.Client;

import com.example.demo.cars.Cars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private ClientRepo clientRepo;
    public ClientService(){

    }
@Autowired
    public ClientService(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }
    ///////////////////////////////////

    public List<Client> getAllClient() {
        return clientRepo.findAll();
    }
    public Optional<Client> getClientById(String id) {
        return clientRepo.findById(id);
    }
    public Client createClient(Client client) {
        return clientRepo.save(client);
    }

    public Client updateClient(String id, Client updatedClient) {
        Optional<Client> existingClient = clientRepo.findById(id);
        if (existingClient.isPresent()) {
            Client clientToUpdate = existingClient.get();
            clientToUpdate.setCin(updatedClient.getCin());
            clientToUpdate.setAddress(updatedClient.getAddress());
            clientToUpdate.setContact(updatedClient.getContact());
            clientToUpdate.setUsername(updatedClient.getUsername());
            clientToUpdate.setFidalityPoint(updatedClient.getFidalityPoint());

            // You can update other properties as needed
            return clientRepo.save(clientToUpdate);
        } else {
            throw new RuntimeException("Client not found with id: " + id);
        }
    }
    public void deleteClient(String id) {
        clientRepo.deleteById(id);
    }


}
