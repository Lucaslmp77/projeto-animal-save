package br.com.projetoanimalsave.Controller;

import br.com.projetoanimalsave.Service.CaregiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/caregiver")
public class CaregiverController {

    @Autowired
    private CaregiverService caregiverService;


}
