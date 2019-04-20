package gt.edu.umg.ingenieria.sistemas.laboratorio1.controller;

import gt.edu.umg.ingenieria.sistemas.laboratorio1.model.Client;
import gt.edu.umg.ingenieria.sistemas.laboratorio1.service.ClientService;
import gt.edu.umg.ingenieria.sistemas.laboratorio1.service.ReportService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/clientes")
public class ClientController {

    @Autowired
    private ClientService clientService;
    
    @PostMapping("/create")
    public Client create(@RequestBody(required = true) Client newClient) {
        return this.clientService.createClient(newClient);
    }
    
    @GetMapping("/buscarTodos")
    public List<Client> getAll() {
        return this.clientService.getAllStudents();
    }
    
    @GetMapping("/buscarPorNit")
    public Client getByCarnetNumber(@RequestParam(name = "nit", required = true) String nit) {
        return this.clientService.buscarPorNit(nit);
    }
    
}
