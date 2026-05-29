package com.taxiapp.backend.controller;
import com.taxiapp.backend.entity.Usuario;
import com.taxiapp.backend.repository.UsuarioRepository;
import com.taxiapp.backend.security.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuthController {

    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @PostMapping("/register")
    public Usuario register(@RequestBody Usuario usuario) {

        usuario.setPassword(encoder.encode(usuario.getPassword()));
        usuario.setRol("USER");
        usuario.setActivo(true);

        return usuarioRepository.save(usuario);
    }

    @GetMapping("/usuarios")
public List<Usuario> obtenerUsuarios() {
    return usuarioRepository.findAll();
}

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Usuario request) {

        Usuario usuario = usuarioRepository
                .findByEmail(request.getEmail())
                .orElseThrow();

        boolean valid = encoder.matches(
                request.getPassword(),
                usuario.getPassword()
        );

        if (!valid) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        String token = jwtService.generateToken(usuario.getEmail());

        return Map.of(
                "token", token,
                "nombre", usuario.getNombre(),
                "rol", usuario.getRol()
        );
    }
}