package br.com.cwi.crescer.basico.security;

import java.util.Collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import br.com.cwi.crescer.basico.security.bh.UserResponse;

@Component
public class AutenticadorProvider extends AbstractUserDetailsAuthenticationProvider {

    @Override
    protected void additionalAuthenticationChecks(final UserDetails userDetails,
        final UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

    }

    @Override
    protected UserDetails retrieveUser(
        String username,
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

        if (username == null) {
            new UsernameNotFoundException("Usuário não econtrado");
        }

        String token = username;

        String url = "http://52.191.131.0:3000/me";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        headers.set("Authorization", token);

        HttpEntity request = new HttpEntity(headers);

        try {

            ResponseEntity<UserResponse> response = new RestTemplate().exchange(
                url,
                HttpMethod.GET,
                request,
                UserResponse.class
            );

            UserResponse userAuth = response.getBody();

            return new UsuarioAutenticado(
                userAuth.getFirstName(),
                userAuth.getLastName(),
                userAuth.getEmail(),
                userAuth.getRoles());

        } catch (Exception exception) {

            // TODO ver como retornar o 401
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "");
        }

    }
}
