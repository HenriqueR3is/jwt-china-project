package br.com.faculdade.jwt_china_project.service;

import br.com.faculdade.jwt_china_project.dto.AuthResponseDto;
import br.com.faculdade.jwt_china_project.dto.LoginRequestDto;
import br.com.faculdade.jwt_china_project.dto.RegisterRequestDto;
import br.com.faculdade.jwt_china_project.model.User;
import br.com.faculdade.jwt_china_project.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    /**
     * Construtor explícito para a Injeção de Dependência do Spring.
     * Como removemos o @RequiredArgsConstructor do Lombok, precisamos
     * declarar este construtor manualmente para que o Spring saiba
     * como criar uma instância desta classe e injetar os componentes necessários.
     */
    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    /**
     * Lógica para registrar um novo usuário.
     * @param request Dados do usuário vindo do controller.
     * @return Uma resposta contendo o token JWT para o novo usuário.
     */
    public AuthResponseDto register(RegisterRequestDto request) {
        User newUser = new User(
                null,
                request.getName(),
                request.getEmail(),
                passwordEncoder.encode(request.getPassword()),
                request.getRole()
        );

        userRepository.save(newUser);

        var jwtToken = jwtService.generateToken(newUser);

        return new AuthResponseDto(jwtToken);
    }

    /**
     * Lógica para autenticar um usuário existente.
     * @param request Dados de login (email e senha) vindo do controller.
     * @return Uma resposta contendo o token JWT se a autenticação for bem-sucedida.
     */
    public AuthResponseDto login(LoginRequestDto request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalStateException("Usuário não encontrado após autenticação bem-sucedida."));

        var jwtToken = jwtService.generateToken(user);
        return new AuthResponseDto(jwtToken);
    }
}