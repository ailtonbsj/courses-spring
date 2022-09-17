package br.ailtonbsj.demooauthtwo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ailtonbsj.demooauthtwo.domain.Client;
import br.ailtonbsj.demooauthtwo.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientResource {
    @Autowired
    ClientService clientService;

    @GetMapping
    public List<Client> list() {
        return this.clientService.list();
    }
}
