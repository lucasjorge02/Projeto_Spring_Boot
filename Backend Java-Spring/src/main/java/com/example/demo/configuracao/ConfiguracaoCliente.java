//package com.example.demo.config;
//
//import com.example.demo.model.entities.Cliente;
//import com.example.demo.model.entities.Conta;
//import com.example.demo.model.entities.Operador;
//import com.example.demo.repository.ClienteRepository;
//import com.example.demo.repository.ContaRepository;
//import com.example.demo.repository.OperadorRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class ClienteConfig implements CommandLineRunner {
//
//    private final ClienteRepository clienteRepository;
//    private final ContaRepository contaRepository;
//    private final OperadorRepository operadorRepository;
//
//    public ClienteConfig(ClienteRepository clienteRepository, ContaRepository contaRepository, OperadorRepository operadorRepository) {
//        this.clienteRepository = clienteRepository;
//        this.contaRepository = contaRepository;
//        this.operadorRepository = operadorRepository;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        Cliente cliente = new Cliente(
//                null,
//                "Lucas",
//                "11",
//                "966425429",
//                "CPF",
//                "41363954857");
//
//        clienteRepository.save(cliente);
//
//        Conta conta = new Conta(cliente);
//
//        contaRepository.save(conta);
//
//        Operador operador = new Operador(
//                "Financeira ADM",
//                "Financeira@gmail.com",
//                cliente
//        );
//
//        operadorRepository.save(operador);
//
//    }
//}
