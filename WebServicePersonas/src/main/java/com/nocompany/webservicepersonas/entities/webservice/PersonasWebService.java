
package com.nocompany.webservicepersonas.entities.webservice;

import com.nocompany.webservicepersonas.entities.Personas;
import com.nocompany.webservicepersonas.entities.dto.PersonasDTO;
import com.nocompany.webservicepersonas.entities.repositories.PersonasRepository;
import jakarta.inject.Inject;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import java.util.List;

@WebService(serviceName = "PersonasWebService")
public class PersonasWebService {

    @Inject
    private PersonasRepository personasRepository;
    
    @WebMethod(operationName = "findAll")
    public List<Personas> findAll() {
        return personasRepository.findAll();
    }
    
    @WebMethod(operationName = "findById")
    public Personas findById(@WebParam(name = "idPersona") Long idPersona) {
        return personasRepository.findById(idPersona);
    }
    
    @WebMethod(operationName = "save")
    public @WebResult(name = "success") void save(@WebParam(name = "persona") PersonasDTO persona) {
        personasRepository.save(persona);
    }
    
    @WebMethod(operationName = "delete")
    public void delete(@WebParam(name = "idPersona") Long idPersona) {
        personasRepository.delete(idPersona);
    }

    @WebMethod(operationName = "update")
    public @WebResult(name = "success") void update(@WebParam(name = "persona") PersonasDTO persona, @WebParam(name = "idPersona") Long idPersona) {
        personasRepository.update(persona, idPersona);
    }
}
