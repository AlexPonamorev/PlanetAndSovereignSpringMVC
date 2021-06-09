package com.example.TaskSpringBoot1.services;

import com.example.TaskSpringBoot1.entity.Sovereign;
import com.example.TaskSpringBoot1.repository.SovereignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SovereignService {
    SovereignRepository sovereignRepository;

    @Autowired
    public SovereignService(SovereignRepository sovereignRepository) {
        this.sovereignRepository = sovereignRepository;
    }

    public List<String> rankingByAge() {
        List<Sovereign> sovereignList = sovereignRepository.rankingByAge();
        List<String> nameList = sovereignList.stream().map(sovereign -> sovereign.getName()).limit(10).collect(Collectors.toList());
        return nameList;
    }

    public void delete(long id) {
        sovereignRepository.deleteById(id);
    }

    public List<Sovereign> getListSovereign() {
        return sovereignRepository.getListSovereign();
    }

    public Sovereign getSovereignById(long id) {
        Optional<Sovereign> sovereignOptional = sovereignRepository.findById(id);
        Sovereign sovereign = sovereignOptional.get();
        return sovereign;
    }

    public void saveSovereign(Sovereign sovereign) {
        sovereignRepository.save(sovereign);
    }
}
