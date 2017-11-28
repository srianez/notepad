package br.com.silas.notepad.service;

import br.com.silas.notepad.model.Nota;
import br.com.silas.notepad.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaService {

    @Autowired
    NotaRepository notaRepository;

    public void salvar(Nota nota) {

        Nota notas = notaRepository.findByTitulo(nota.getTitulo());

        if (notas != null) {
            nota.setId(notas.getId());
        }

        notaRepository.save(nota);

    }

    public List<Nota> buscarTodas(){
        return notaRepository.findAll();
    }

    public Nota buscar(String titulo) {
        Nota notas = notaRepository.findByTitulo(titulo);

        if (notas == null) {
            return new Nota();
        } else {
            return notaRepository.findByTitulo(titulo);
        }
    }


}
