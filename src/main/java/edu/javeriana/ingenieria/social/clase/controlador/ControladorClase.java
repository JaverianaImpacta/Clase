package edu.javeriana.ingenieria.social.clase.controlador;

import edu.javeriana.ingenieria.social.clase.dominio.Clase;
import edu.javeriana.ingenieria.social.clase.seguridad.ServicioClase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clases")
@CrossOrigin(origins="http://localhost:4200")
public class ControladorClase {
    @Autowired
    private ServicioClase servicio;

    @GetMapping("listar")
    public List<Clase> obtenerClases(){
        return servicio.obtenerClases();
    }

    @GetMapping("obtenerPorAsignatura")
    public ResponseEntity<List<Clase>> obtenerClasesPorAsignatura(@RequestParam Integer asignatura){
        if(asignatura == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(servicio.obtenerClases(asignatura).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(servicio.obtenerClases(asignatura), HttpStatus.OK);
    }

    @GetMapping("obtener")
    public ResponseEntity<Clase> obtenerClase(@RequestParam Integer codigo){
        if(codigo == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(!servicio.claseExiste(codigo)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(servicio.obtenerClase(codigo), HttpStatus.OK);
    }
}
