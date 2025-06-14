package br.com.faculdade.jwt_china_project.service;

import br.com.faculdade.jwt_china_project.dto.AuthResponseDto;
import br.com.faculdade.jwt_china_project.dto.LoginRequestDto;
import br.com.faculdade.jwt_china_project.dto.RegisterRequestDto;
import br.com.faculdade.jwt_china_project.model.User;
import br.com.faculdade.jwt_china_project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponseDto register(RegisterRequestDto request) {
        var user = User.builder()
                .nome(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword())) // Codifica a senha
                .role(request.getRole())
                .build();

        userRepository.save(user);

        var jwtToken = jwtService.generateToken(user);

        return AuthResponseDto.builder().token(jwtToken).build();
    }

    public AuthResponseDto login(LoginRequestDto request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();

        var jwtToken = jwtService.generateToken(user);

        return AuthResponseDto.builder().token(jwtToken).build();
    }
}