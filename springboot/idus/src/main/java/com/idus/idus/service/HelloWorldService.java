package com.idus.idus.service;
import com.idus.idus.entity.SomaResultado;
import com.idus.idus.repository.SomaResultadoRepository;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

    private final SomaResultadoRepository somaResultadoRepository;

    // Injeta o repositório pelo construtor
    public HelloWorldService(SomaResultadoRepository somaResultadoRepository) {
        this.somaResultadoRepository = somaResultadoRepository;
    }

    public String hello() {
        return "Hello World";
    }
    public Integer soma(Integer number1, Integer number2) {
        Integer resultado = number1 + number2;

        // Salva o resultado no banco de dados usando a instância injetada
        SomaResultado somaResultado = new SomaResultado(resultado);
        somaResultadoRepository.save(somaResultado);

        return resultado;
    }
}
