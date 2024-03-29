
package com.probando.segunda.controller;

import com.probando.segunda.model.Proyecto;
import com.probando.segunda.service.IProyectoService;
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
public class ProyectoController {
    
    @Autowired
    private IProyectoService proyectoServ;
    
    @GetMapping ("/proyectos")
    @ResponseBody
    public List<Proyecto> getProyectos(){
        return proyectoServ.getProyectos();
    }
    
    @PostMapping ("/proyectos")
    @ResponseBody
    public Proyecto createProyecto(@RequestBody Proyecto proy){
        return proyectoServ.createProyecto(proy);
    }
    
    @DeleteMapping ("/proyectos/{id}")
    public List<Proyecto> deleteProyecto (@PathVariable Long id){
        return proyectoServ.deleteProyecto(id);
    }
    
    @PutMapping ("proyectos/{id}")
    public Proyecto editProyecto (@PathVariable Long id,
                               @RequestBody Proyecto proyecto){
        Proyecto proy = proyectoServ.findProyecto(id);
        proy.setTiempo(proyecto.getTiempo());
        proy.setTitulo(proyecto.getTitulo());
        proy.setDescripcion(proyecto.getDescripcion());
        proy.setOtrasNotas(proyecto.getOtrasNotas());
        proy.setImagen(proyecto.getImagen());
        proy.setLinkGithub(proyecto.getLinkGithub());
        proy.setLink(proyecto.getLink());
        proy.setEditar(false);
        return proyectoServ.saveProyecto(proy);
    }
    
    @PutMapping("/proyectos/order")
    @ResponseBody
    public List<Proyecto> orderProyectos(@RequestBody List<Proyecto> proyectos){
        return proyectoServ.orderProyectos(proyectos);
    }
}
