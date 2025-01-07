package br.com.nataliaweise.gestaovagas.modules.company.useCases;

import br.com.nataliaweise.gestaovagas.modules.company.dto.AuthCompanyDTO;
import br.com.nataliaweise.gestaovagas.modules.company.repositories.CompanyRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthCompanyUseCase {

    @Value("${security.token.secret}")
    private String SECRET_KEY;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String execute(AuthCompanyDTO authCompanyDTO) throws AuthenticationException {
        var company = this.companyRepository.findByUsername(authCompanyDTO.getUsername()).orElseThrow(
                () -> {
                    throw new UsernameNotFoundException("Username/password incorrect");
                }
        );
        var passwordMatches = this.passwordEncoder.matches(authCompanyDTO.getPassword(), company.getPassword());

        if (!passwordMatches) throw new AuthenticationException();

        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
        var token = JWT.create().withIssuer("javagas")
                .withSubject(company.getId().toString())
                .sign(algorithm);
        return token;
    }
}
