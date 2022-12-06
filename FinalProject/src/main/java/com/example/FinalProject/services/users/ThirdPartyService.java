package com.example.FinalProject.services.users;

import com.example.FinalProject.models.users.Role;
import com.example.FinalProject.models.users.ThirdParty;
import com.example.FinalProject.repositories.users.RoleRepository;
import com.example.FinalProject.repositories.users.ThirdPartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThirdPartyService {
    @Autowired
    ThirdPartyRepository thirdPartyRepository;

    @Autowired
    RoleRepository roleRepository;

    public ThirdParty addNewThirdParty(ThirdParty thirdParty) {
        ThirdParty thirdParty1 = thirdPartyRepository.save(thirdParty);
        roleRepository.save(new Role("THIRD_PARTY",thirdParty1));
        return  thirdParty1;
    }
}
