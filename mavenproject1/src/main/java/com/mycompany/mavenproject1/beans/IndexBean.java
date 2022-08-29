
package com.mycompany.mavenproject1.beans;

import com.mycompany.mavenproject1.PersonasDTO;
import com.mycompany.mavenproject1.PersonasWebService;
import com.mycompany.mavenproject1.PersonasWebService_Service;
import com.mycompany.mavenproject1.dtos.PersDTO;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;


@Named(value = "indexBean")
@ViewScoped
public class IndexBean implements Serializable {

    private PersDTO persona;
    private List<SelectItem> sexoOptions;
    
    private PersonasWebService_Service service;
    private PersonasWebService port;
    
    @PostConstruct
    public void init() {
        persona = new PersDTO();
        sexoOptions = Arrays.asList(new SelectItem("M", "Masculino"), new SelectItem("F", "Femenino"));
        
         try { // Call Web Service Operation
            port = service.getPersonasWebServicePort();

        } catch (Exception ex) {
            System.err.print(ex);
        }
    }
    
    public IndexBean() {
    }

    public PersDTO getPersona() {
        return persona;
    }

    public void setPersona(PersDTO persona) {
        this.persona = persona;
    }

    public List<SelectItem> getSexoOptions() {
        return sexoOptions;
    }

    public void setSexoOptions(List<SelectItem> sexoOptions) {
        this.sexoOptions = sexoOptions;
    }
    
    public void guardarPersona(){
        if(this.getPersona() != null){
           port.save(fromFormToDTO());
           FacesContext.getCurrentInstance().addMessage("Exito ", new FacesMessage("Se agrego una persona"));
        }
    }
    
    public PersonasDTO fromFormToDTO(){
        PersonasDTO p = new PersonasDTO();
        p.setNombres(this.persona.getNombres());
        p.setApellidos(this.persona.getApellidos());
        p.setEmail(this.persona.getEmail());
        p.setSexo(this.persona.getSexo());
//        p.setFechaNacimiento(fromDateToXML(this.persona.getFechaNacimiento()));
        return p;
    }
    
    public XMLGregorianCalendar fromDateToXML(Date d){
        
        XMLGregorianCalendar xmlDate = null;
        
        gc.setTime(d);
        try{
            xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return xmlDate;
    }
    
    private static GregorianCalendar gc = new GregorianCalendar();
}
