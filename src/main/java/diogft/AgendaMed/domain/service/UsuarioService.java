package diogft.AgendaMed.domain.service;

import diogft.AgendaMed.domain.entity.Usuario;
import diogft.AgendaMed.domain.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional


public class UsuarioService implements UserDetailsService {

    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
        Optional<Usuario> optUsuario = repository.findByUsuario(usuario);

        if (optUsuario.isEmpty()) {
            throw new UsernameNotFoundException("Usuario não econtrado");
        }
        Usuario user = optUsuario.get();
        return new User(user.getUsuario(), user.getSenha(), new ArrayList<>());
    }

    public List<Usuario> getAll() {
        return repository.findAll();
    }

    public Usuario save(Usuario usuario) {
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return repository.save(usuario);
    }
}
