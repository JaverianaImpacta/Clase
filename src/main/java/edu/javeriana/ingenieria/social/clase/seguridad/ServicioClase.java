package edu.javeriana.ingenieria.social.clase.seguridad;

import edu.javeriana.ingenieria.social.clase.dominio.Clase;
import edu.javeriana.ingenieria.social.clase.repositorio.RepositorioClase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioClase {
    @Autowired
    private RepositorioClase repositorio;

    public List<Clase> obtenerClases(){
        return repositorio.findAll();
    }

    public List<Clase> obtenerClases(Integer asignatura){
        return repositorio.findAllByAsignatura(asignatura);
    }

    public Clase obtenerClase(Integer codigo){
        return repositorio.findOneByCodigo(codigo);
    }

    public boolean claseExiste(Integer codigo){
        return repositorio.existsByCodigo(codigo);
    }

}
