
package com.nocompany.webservicepersonas.entities.repositories;

import com.nocompany.webservicepersonas.entities.Personas;
import com.nocompany.webservicepersonas.entities.dto.PersonasDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class PersonasRepository {

    @PersistenceContext(unitName = "personasPU")
    private EntityManager manager;
    
    public List<Personas> findAll(){
        return manager.createNamedQuery("Personas.findAll", Personas.class).getResultList();
    }
    
    public Personas findById(Long idPersona){
        List<Personas> personas = manager
                .createNamedQuery("Personas.findByIdPersona")
                .setParameter("idPersona", idPersona).getResultList();    
        if(!personas.isEmpty()) return personas.get(0);
        else return null;
    }
    
    public Personas fromDTO2Entity(PersonasDTO dto) {
        Personas p = new Personas();
        p.setNombres(dto.getNombres());
        p.setApellidos(dto.getApellidos());
        p.setEmail(dto.getEmail());
        p.setSexo(dto.getSexo());
        p.setFechaNacimiento(dto.getFechaNacimiento());
        return p;
    }
    
    @Transactional
    public void save(PersonasDTO dto){
        Personas persona = fromDTO2Entity(dto);
        manager.persist(persona);
    }
    
    @Transactional(Transactional.TxType.REQUIRED)
    public void delete(Long idPersona) {
        manager.remove(findById(idPersona));
    }
    
    @Transactional(Transactional.TxType.REQUIRED)
    public void update(PersonasDTO dto, Long idPersona) {
        Personas p = fromDTO2Entity(dto);
        p.setIdPersona(idPersona);
        manager.merge(p);
    }
}
