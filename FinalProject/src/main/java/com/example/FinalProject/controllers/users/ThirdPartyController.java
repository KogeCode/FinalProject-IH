package com.example.FinalProject.controllers.users;

import com.example.FinalProject.models.users.ThirdParty;
import com.example.FinalProject.services.users.ThirdPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/thirdparty-account")
public class ThirdPartyController {
    @Autowired
    ThirdPartyService thirdPartyService;

    @PostMapping("/add-thirdparty-account")
    @ResponseStatus(HttpStatus.CREATED)
    public ThirdParty addNewThirdParty (@RequestBody ThirdParty thirdParty){
        return thirdPartyService.addNewThirdParty(thirdParty);
    }
}
