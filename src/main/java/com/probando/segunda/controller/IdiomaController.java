
package com.probando.segunda.controller;

import com.probando.segunda.model.Idioma;
import com.probando.segunda.service.IdiomaService;
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
public class IdiomaController {
    
    @Autowired 
    private IdiomaService idiomaServ;
    
    @GetMapping ("/idiomas")
    @ResponseBody
    public List<Idioma> getIdiomas(){
        return idiomaServ.getIdiomas();
    }
    
    @PostMapping ("/idiomas")
    @ResponseBody
    public Idioma createIdioma(@RequestBody Idioma idioma){
       return idiomaServ.createIdioma(idioma);
    }
    
    @DeleteMapping ("/idiomas/{id}")
    @ResponseBody
    public List<Idioma> deleteIdioma (@PathVariable Long id){
        return idiomaServ.deleteIdioma(id);
    }
    
    @PutMapping ("idiomas/{id}")
    @ResponseBody
    public Idioma editIdioma (@PathVariable Long id, @RequestBody Idioma idioma) {
    Idioma idio = idiomaServ.findIdioma(id);
        idio.setTiempo(idioma.getTiempo());
        idio.setTitulo(idioma.getTitulo());
        idio.setDescripcion(idioma.getDescripcion());
        idio.setOtrasNotas(idioma.getOtrasNotas());
        idio.setImagen(idioma.getImagen());
        idio.setEditar(false);
    return idiomaServ.saveIdioma(idio);
    }
    
    @GetMapping("idiomas/{id}")
    @ResponseBody
    public Idioma findIdioma(@PathVariable Long id){
        return idiomaServ.findIdioma(id);
    }
    
    @PutMapping("/idiomas/order")
    @ResponseBody
    public List<Idioma> orderIdiomas(@RequestBody List<Idioma> idiomas){
        return idiomaServ.orderIdiomas(idiomas);
    }
}
    
