package com.example.demosb_api_1_1.services;

import com.example.demosb_api_1_1.modele.Local;
import com.example.demosb_api_1_1.repositories.LocalRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackOn = Exception.class)
public class LocalServiceImpl implements InterfLocalService {

    @Autowired
    private LocalRepository localRepository;

    @Override
    public Local create(Local local) throws Exception {
        localRepository.save(local);
        return local;
    }

    @Override
    public Local read(Integer id) throws Exception {
        Optional<Local> lloc = localRepository.findById(id);
        return lloc.get();
    }

    @Override
    public Local update(Local local) throws Exception {
        read(local.getId_local());
        localRepository.save(local);
        return local;
    }

    @Override
    public void delete(Local local) throws Exception {
        localRepository.deleteById(local.getId_local());
    }

    @Override
    public List<Local> all() throws Exception {
        return localRepository.findAll();
    }
}
