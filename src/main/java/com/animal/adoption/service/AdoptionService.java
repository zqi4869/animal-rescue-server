package com.animal.adoption.service;

import com.animal.adoption.domain.Adoption;
import com.animal.adoption.repository.AdoptionRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class AdoptionService {
	@Autowired
    private AdoptionRepository adoptionRepository;

    public Adoption save(Adoption adoption) {
        return adoptionRepository.save(adoption);
    }

    public List<Adoption> findMyAdoptions(String userId) {
        if(StringUtils.hasText(userId)) {
            return adoptionRepository.findMyAdoptions(new ObjectId(userId));
        } else {
            return adoptionRepository.findAllAdoptions();
        }
    }
}
