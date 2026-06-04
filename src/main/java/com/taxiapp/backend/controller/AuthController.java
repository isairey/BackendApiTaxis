package com.taxiapp.backend.controller;
import com.taxiapp.backend.entity.Usuario;
import com.taxiapp.backend.repository.UsuarioRepository;
import com.taxiapp.backend.security.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    // Obtener usuario por ID
@GetMapping("/usuarios/{id}")
public Usuario obtenerUsuarioPorId(@PathVariable Long id) {

    return usuarioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
}

// Actualizar usuario
@PutMapping("/usuarios/{id}")
public Usuario actualizarUsuario(
        @PathVariable Long id,
        @RequestBody Usuario datos) {

    Usuario usuario = usuarioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

    usuario.setNombre(datos.getNombre());
    usuario.setEmail(datos.getEmail());
    usuario.setTelefono(datos.getTelefono());

    if (datos.getPassword() != null &&
            !datos.getPassword().isEmpty()) {

        usuario.setPassword(
                encoder.encode(datos.getPassword())
        );
    }

    return usuarioRepository.save(usuario);
}

// Cambiar estado activo/inactivo
@PatchMapping("/usuarios/{id}/estado")
public Usuario cambiarEstado(
        @PathVariable Long id,
        @RequestParam Boolean activo) {

    Usuario usuario = usuarioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

    usuario.setActivo(activo);

    return usuarioRepository.save(usuario);
}

// Eliminar usuario
@DeleteMapping("/usuarios/{id}")
public Map<String, String> eliminarUsuario(
        @PathVariable Long id) {

    Usuario usuario = usuarioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

    usuarioRepository.delete(usuario);

    return Map.of(
            "mensaje",
            "Usuario eliminado correctamente"
    );
}

// Buscar usuario por email
@GetMapping("/usuarios/email/{email}")
public Usuario buscarPorEmail(
        @PathVariable String email) {

    return usuarioRepository.findByEmail(email)
            .orElseThrow(() ->
                    new RuntimeException("Usuario no encontrado"));
}
}