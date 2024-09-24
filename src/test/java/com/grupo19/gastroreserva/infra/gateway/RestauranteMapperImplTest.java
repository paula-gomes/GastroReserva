package com.grupo19.gastroreserva.infra.gateway;

import com.grupo19.gastroreserva.domain.Endereco;
import com.grupo19.gastroreserva.domain.HorarioDeFuncionamento;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import com.grupo19.gastroreserva.infra.gateways.restaurante.RestauranteMapper;
import com.grupo19.gastroreserva.infra.persistence.restaurante.RestauranteEntity;
import com.grupo19.gastroreserva.infra.persistence.restaurante.RestauranteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RestauranteMapperImplTest {
    @Mock
    private RestauranteRepository restauranteRepository;

    @Mock
    private RestauranteMapper restauranteMapper;
    @Test
    void deveSalvarRestaurante() {
        // Arrange
        Endereco endereco = new Endereco("12345-678", "Rua teste", "30", "bairro", "Cidade", "SP");
        Restaurante restaurante = new Restaurante();
        restaurante.setNome("Restaurante Teste");
        restaurante.setEndereco(endereco);
        restaurante.setTipoDeCozinha("Brasileira");
        restaurante.setHorarioDeFuncionamento(new HorarioDeFuncionamento(LocalTime.of(8, 0), LocalTime.of(22, 0)));
        restaurante.setCapacidade(80);
        restaurante.setCadeirasDisponiveis(40);

        RestauranteEntity entity = new RestauranteEntity();
        entity.setId(1L);
        entity.setNome("Restaurante Teste");
        entity.setCapacidade(80);
        entity.setEndereco(endereco);

        when(restauranteMapper.toEntity(restaurante)).thenReturn(entity);
        when(restauranteRepository.save(entity)).thenReturn(entity);
        when(restauranteRepository.findById(entity.getId())).thenReturn(java.util.Optional.of(entity));

        // Act
        RestauranteEntity savedEntity = restauranteRepository.save(entity);

        // Assert
        assertNotNull(savedEntity.getId());
        assertEquals("Restaurante Teste", savedEntity.getNome());
        assertEquals(80, savedEntity.getCapacidade());

        RestauranteEntity foundEntity = restauranteRepository.findById(savedEntity.getId()).orElse(null);
        assertNotNull(foundEntity);

        // Verifique o conteúdo do foundEntity
        System.out.println("Found Entity: " + foundEntity);

        Restaurante foundRestaurante = restauranteMapper.toDomain(foundEntity);

        // Verifique se o método toDomain está sendo chamado e seus dados
        System.out.println("Found Restaurante (antes do assert): " + foundRestaurante);

        assertNotNull(foundRestaurante, "O objeto foundRestaurante não deve ser nulo");
        assertEquals("Restaurante Teste", foundRestaurante.getNome());
        assertEquals(80, foundRestaurante.getCapacidade());
    }
    @Test
    void deveConverterRestauranteParaRestauranteEntity() {
        // Arrange
        Endereco endereco = new Endereco("12345-678", "Rua teste", "30", "bairro", "Cidade", "SP");
        Restaurante restaurante = new Restaurante();
        restaurante.setNome("Restaurante Teste");
        restaurante.setEndereco(endereco);
        restaurante.setTipoDeCozinha("Brasileira");
        restaurante.setHorarioDeFuncionamento(new HorarioDeFuncionamento(LocalTime.of(8, 0), LocalTime.of(22, 0)));
        restaurante.setCapacidade(80);
        restaurante.setCadeirasDisponiveis(40);

        // Act
        RestauranteEntity entity = restauranteMapper.toEntity(restaurante);

        // Assert
        assertNotNull(entity);
        assertEquals("Restaurante Teste", entity.getNome());
        assertEquals(80, entity.getCapacidade());
    }
}