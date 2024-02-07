package com.example.es4;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class NameController {
    @Operation(summary = "Restituisce il nome ricevuto come parametro")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ok"),
            @ApiResponse(responseCode = "400", description = "bad request")
    })
    @GetMapping("/nome")
    public String getNome (@Parameter(description = "Nome da restituire") @RequestParam String nome) {
        return nome;
    }

    @Operation(summary = "Restituisce il nome ricevuto come parametro al contrario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ok"),
            @ApiResponse(responseCode = "400", description = "bad request")
    })
    @PostMapping("/nome")
    public String getNomeContrario (@Parameter(description = "Nome da invertire") @RequestParam String nome) {
        StringBuilder stringBuilder = new StringBuilder(nome);
        return stringBuilder.reverse().toString();
    }
}