package com.example.salareservas.controller;

import com.example.salareservas.dto.request.SalaRequestDTO;
import com.example.salareservas.dto.response.SalaResponseDTO;
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
@RequestMapping("/api/salas")
@Tag(name = "Salas", description = "Gerenciamento de salas")
public class SalaController {

    private final SalaService salaService;

    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }

    @PostMapping
    @Operation(summary = "Criar nova sala", description = "Cria uma nova sala no sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Sala criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    public ResponseEntity<SalaResponseDTO> criar(@RequestBody SalaRequestDTO dto) {
        SalaResponseDTO response = salaService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar sala por ID", description = "Retorna uma sala específica pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sala encontrada"),
            @ApiResponse(responseCode = "404", description = "Sala não encontrada")
    })
    public ResponseEntity<SalaResponseDTO> buscarPorId(
            @Parameter(description = "ID da sala") @PathVariable Long id) {
        SalaResponseDTO response = salaService.buscarPorId(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    @Operation(summary = "Listar todas as salas", description = "Retorna uma lista de todas as salas")
    @ApiResponse(responseCode = "200", description = "Lista de salas retornada com sucesso")
    public ResponseEntity<List<SalaResponseDTO>> listarTodas() {
        List<SalaResponseDTO> salas = salaService.listarTodas();
        return ResponseEntity.ok(salas);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar sala", description = "Atualiza os dados de uma sala existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sala atualizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "404", description = "Sala não encontrada")
    })
    public ResponseEntity<SalaResponseDTO> atualizar(
            @Parameter(description = "ID da sala") @PathVariable Long id,
            @RequestBody SalaRequestDTO dto) {
        SalaResponseDTO response = salaService.atualizar(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar sala", description = "Remove uma sala do sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Sala removida com sucesso"),
            @ApiResponse(responseCode = "404", description = "Sala não encontrada")
    })
    public ResponseEntity<Void> deletar(@Parameter(description = "ID da sala") @PathVariable Long id) {
        salaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/bloco/{bloco}")
    @Operation(summary = "Buscar salas por bloco", description = "Retorna todas as salas de um bloco específico")
    @ApiResponse(responseCode = "200", description = "Lista de salas do bloco")
    public ResponseEntity<List<SalaResponseDTO>> buscarPorBloco(
            @Parameter(description = "Nome do bloco") @PathVariable String bloco) {
        List<SalaResponseDTO> salas = salaService.buscarPorBloco(bloco);
        return ResponseEntity.ok(salas);
    }

    @GetMapping("/capacidade-minima/{capacidade}")
    @Operation(summary = "Buscar salas por capacidade mínima",
            description = "Retorna salas com capacidade maior ou igual ao valor especificado")
    @ApiResponse(responseCode = "200", description = "Lista de salas com capacidade adequada")
    public ResponseEntity<List<SalaResponseDTO>> buscarPorCapacidadeMinima(
            @Parameter(description = "Capacidade mínima") @PathVariable Integer capacidade) {
        List<SalaResponseDTO> salas = salaService.buscarPorCapacidadeMinima(capacidade);
        return ResponseEntity.ok(salas);
    }
}