
package com.probando.segunda.controller;

import com.probando.segunda.model.Experiencia;
import com.probando.segunda.service.IExperienciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExperienciaController {
    
    @Autowired
    private IExperienciaService experienciaServ;
    
    @GetMapping ("/experiencias")
    @ResponseBody
    public List<Experiencia> getExperiencias(){
        return experienciaServ.getExperiencias();
    }
    
    @PostMapping ("/experiencias")
    @ResponseBody
    public Experiencia createExperiencia(@RequestBody Experiencia exp){
       return experienciaServ.createExperiencia(exp);
    }
    
     @DeleteMapping ("/experiencias/{id}")
    public List<Experiencia> deleteExperiencia (@PathVariable Long id){
        return experienciaServ.deleteExperiencia(id);
    }
 
    @PutMapping ("experiencias/{id}")
    @ResponseBody
    public Experiencia editExperiencia (@PathVariable Long id, @RequestBody Experiencia experiencia) {
    Experiencia exp = experienciaServ.findExperiencia(id);
        exp.setTiempo(experiencia.getTiempo());
        exp.setTitulo(experiencia.getTitulo());
        exp.setDescripcion(experiencia.getDescripcion());
        exp.setOtrasNotas(experiencia.getOtrasNotas());
        exp.setImagen(experiencia.getImagen());
        exp.setEditar(false);
    return experienciaServ.saveExperiencia(exp);
    }    
    
    @PutMapping("/experiencias/order")
    @ResponseBody
    public List<Experiencia> orderExperiencias(@RequestBody List<Experiencia> experiencias){
        return experienciaServ.orderExperiencias(experiencias);
    }
}
