package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Owner;
import com.db.grad.javaapi.repository.OwnersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnersService {


    @Autowired
    private OwnersRepository itsOwnerRepo;

    public OwnersService(OwnersRepository repo) {
        itsOwnerRepo = repo;
    }


    public Owner getOwnerById(long uniqueID) {
        return itsOwnerRepo.findById(uniqueID);
    }
}
