package gov.api_confea.config;

import gov.api_confea.model.*;
import gov.api_confea.repository.CreaRepository;
import gov.api_confea.repository.ProfissionalRepository;
import gov.api_confea.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

// @Component
public class DataLoader implements CommandLineRunner {
    private final ProfissionalRepository profissionalRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UsuarioRepository usuarioRepository;
    private final CreaRepository creaRepository;

    public DataLoader(UsuarioRepository usuarioRepository, CreaRepository creaRepository, ProfissionalRepository profissionalRepository, BCryptPasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.creaRepository = creaRepository;
        this.profissionalRepository = profissionalRepository;

        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        // Load initial data into the database

        Rg rg = new Rg();

        rg.setDataExpedicao(LocalDate.now());
        rg.setNumero("1232312312");
        rg.setOrgaoExpedidor("SSP");

        Crea crea = this.createCreas();
        crea = creaRepository.save(crea);

        Profissional profissional1 = new Profissional();
        profissional1.setNome("Ruan");
        profissional1.setRnp("123123123123");
        profissional1.setNumRegistroCrea("123123123123");
        profissional1.setTipoNumeroCarteiraConfea();
        profissional1.setEstadoCivilCasado();
        profissional1.setNomeMae("Mãe");
        profissional1.setNomePai("Pai");
        profissional1.setEmail("ruan@mail.com");
        profissional1.setCpf("123456789-0");
        profissional1.setSexoMasculino();
        profissional1.setSenha(passwordEncoder.encode("123"));
        profissional1.setDataNascimento(LocalDate.now());
        profissional1.setPNE();
        profissional1.setNacionalidade("BRASILEIRO");
        profissional1.setCidadeNaturalidade("Maceió");
        profissional1.setUfNaturalidade("AL");
        profissional1.setPaisNascimento("BRASIL");
        profissional1.setRg(rg);
        profissional1.setCrea(crea);

        EnderecoUsuario endereco = new EnderecoUsuario();

        endereco.setNome("Escritório");
        endereco.setUf("AL");
        endereco.setBairro("Antares");
        endereco.setCep("57025-570");
        endereco.setCidade("Maceió");
        endereco.setNumeroLogradouro("150");
        endereco.setLogradouro("Avenida tal");
        endereco.setTipoLogradouro("AVENIDA");

        profissional1.setEnderecos(Set.of(endereco));


        profissionalRepository.save(profissional1);
    }

    public Crea createCreas(){

        EnderecoCrea enderecoCrea = new EnderecoCrea("SEDE", "57025-570", "AL", "Maceió", "Antares", "Teste", "150", "Avenida", LocalDateTime.now(), LocalDateTime.now());
        Crea crea = new Crea();

        crea.setCodigoCrea("1");
        crea.setNome("CREA-AL");
        crea.setCnpj("1231231231");
        crea.setEmail("crea-al@mail.com");
        crea.setPageUrl("https://www.crea-al.org.br/");
        crea.setAssinaturaPresidente("teste");


        crea.setEnderecos(Set.of(enderecoCrea));

        return crea;
    }
}
