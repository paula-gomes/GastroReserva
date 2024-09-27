package com.grupo19.gastroreserva.application.usecases.cliente;

import com.grupo19.gastroreserva.application.gateways.cliente.AlterarEmailClienteInterface;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class AlterarEmailClienteTest {

 @Mock
 private AlterarEmailClienteInterface alterarEmailClienteInterface;

 @InjectMocks
 private AlterarEmailCliente alterarEmailCliente;

 private Cliente cliente;

 @BeforeEach
 void setUp() {
  MockitoAnnotations.openMocks(this);
  cliente = new Cliente();
  cliente.setEmail("novoemail@example.com");
 }

 @Test
 void deveAlterarEmailDoCliente() {

  when(alterarEmailClienteInterface.alterarEmailCliente(cliente)).thenReturn(cliente);

  Cliente clienteAtualizado = alterarEmailCliente.alterarEmailCliente(cliente);

  assertEquals("novoemail@example.com", clienteAtualizado.getEmail());
 }
}
