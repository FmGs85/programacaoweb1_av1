package com.example.salareservas.controller;

import com.example.salareservas.dto.request.ReservaRequestDTO;
import com.example.salareservas.dto.response.ReservaResponseDTO;
import com.example.salareservas.service.ReservaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reservas")
@Tag(name = "Reservas", description = "Gerenciamento de reservas de salas")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping
    @Operation(summary = "Criar nova reserva", description = "Cria uma nova reserva de sala")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Reserva criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos ou sala não disponível"),
            @ApiResponse(responseCode = "404", description = "Sala ou usuário não encontrado")
    })
    public ResponseEntity<ReservaResponseDTO> criar(@RequestBody ReservaRequestDTO dto) {
        ReservaResponseDTO response = reservaService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar reserva por ID", description = "Retorna uma reserva específica pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reserva encontrada"),
            @ApiResponse(responseCode = "404", description = "Reserva não encontrada")
    })
    public ResponseEntity<ReservaResponseDTO> buscarPorId(
            @Parameter(description = "ID da reserva") @PathVariable Long id) {
        ReservaResponseDTO response = reservaService.buscarPorId(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    @Operation(summary = "Listar todas as reservas", description = "Retorna uma lista de todas as reservas")
    @ApiResponse(responseCode = "200", description = "Lista de reservas retornada com sucesso")
    public ResponseEntity<List<ReservaResponseDTO>> listarTodas() {
        List<ReservaResponseDTO> reservas = reservaService.listarTodas();
        return ResponseEntity.ok(reservas);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar reserva", description = "Atualiza os dados de uma reserva existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reserva atualizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos ou conflito de horário"),
            @ApiResponse(responseCode = "404", description = "Reserva, sala ou usuário não encontrado")
    })
    public ResponseEntity<ReservaResponseDTO> atualizar(
            @Parameter(description = "ID da reserva") @PathVariable Long id,
            @RequestBody ReservaRequestDTO dto) {
        ReservaResponseDTO response = reservaService.atualizar(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Cancelar reserva", description = "Cancela uma reserva existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Reserva cancelada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Reserva não encontrada")
    })
    public ResponseEntity<Void> deletar(@Parameter(description = "ID da reserva") @PathVariable Long id) {
        reservaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/sala/{salaId}")
    @Operation(summary = "Buscar reservas por sala", description = "Retorna todas as reservas de uma sala específica")
    @ApiResponse(responseCode = "200", description = "Lista de reservas da sala")
    public ResponseEntity<List<ReservaResponseDTO>> buscarPorSala(
            @Parameter(description = "ID da sala") @PathVariable Long salaId) {
        List<ReservaResponseDTO> reservas = reservaService.buscarPorSala(salaId);
        return ResponseEntity.ok(reservas);
    }

    @GetMapping("/usuario/{usuarioId}")
    @Operation(summary = "Buscar reservas por usuário", description = "Retorna todas as reservas de um usuário")
    @ApiResponse(responseCode = "200", description = "Lista de reservas do usuário")
    public ResponseEntity<List<ReservaResponseDTO>> buscarPorUsuario(
            @Parameter(description = "ID do usuário") @PathVariable Long usuarioId) {
        List<ReservaResponseDTO> reservas = reservaService.buscarPorUsuario(usuarioId);
        return ResponseEntity.ok(reservas);
    }

    @PostMapping("/verificar-disponibilidade/{salaId}")
    @Operation(summary = "Verificar disponibilidade",
            description = "Verifica se uma sala está disponível no período especificado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Disponibilidade verificada"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    public ResponseEntity<Boolean> verificarDisponibilidade(
            @Parameter(description = "ID da sala") @PathVariable Long salaId,
            @RequestBody ReservaRequestDTO dto) {
        boolean disponivel = reservaService.verificarDisponibilidade(salaId, dto);
        return ResponseEntity.ok(disponivel);
    }
}