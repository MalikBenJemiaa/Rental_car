package com.example.demo.Client;

import com.example.demo.cars.Cars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


}
