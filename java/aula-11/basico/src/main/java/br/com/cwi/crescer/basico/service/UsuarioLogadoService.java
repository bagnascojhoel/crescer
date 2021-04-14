package br.com.cwi.crescer.basico.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.basico.security.UsuarioAutenticado;

@Service
public class UsuarioLogadoService {

    public UsuarioAutenticado get() {
        return (UsuarioAutenticado) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
