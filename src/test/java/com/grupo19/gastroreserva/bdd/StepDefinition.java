package com.grupo19.gastroreserva.bdd;

import com.grupo19.gastroreserva.domain.Endereco;
import com.grupo19.gastroreserva.domain.HorarioDeFuncionamento;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.domain.entities.reserva.Reserva;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import com.grupo19.gastroreserva.infra.persistence.reserva.ReservaEntity;
import com.grupo19.gastroreserva.utils.ReservaHelper;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;



import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class StepDefinition {


    private Response response;
    private ReservaEntity reservaResposta;

    private final String ENDPOINT_API_RESERVAS = "http://localhost:8080/reservas";

    @Quando("realizar uma reserva com os detalhes do restaurante escolhido")
    public void realizar_uma_reserva_com_os_detalhes_do_restaurante_escolhido() {
        Endereco endereco = new Endereco("11111-111","Rua", "10", "bairro", "cidade", "SP" );
        LocalTime horaAbertura = LocalTime.of(9,00);
        LocalTime horaFechamento = LocalTime.of(18,00);
        HorarioDeFuncionamento horarioDeFuncionamento = new HorarioDeFuncionamento(horaAbertura, horaFechamento);
        Restaurante restaurante = new Restaurante("Nome Restaurante", endereco, "Tipo de Cozinha", horarioDeFuncionamento, 50, 50);
        List<Restaurante> restaurantes = new ArrayList<>(List.of(restaurante));
        Cliente cliente = new Cliente("123.456.789-10", "Nome Cliente", "email@teste.com", restaurantes);
        LocalTime horario = LocalTime.of(17, 0);
        var reservaRequest = ReservaHelper.gerarReserva(cliente, restaurante, horario, LocalDate.now(), 5);

        response = given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(reservaRequest)
                .when()
                .post(ENDPOINT_API_RESERVAS);
    }

    @Entao("a reserva deve ser confirmada com sucesso")
    public void a_reserva_deve_ser_confirmada_com_sucesso() {
        response.then()
                .statusCode(HttpStatus.CREATED.value());

    }



}
