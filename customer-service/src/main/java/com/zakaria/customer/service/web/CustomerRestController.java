package com.zakaria.customer.service.web;


import com.zakaria.customer.service.dtos.CustomerRequestDto;
import com.zakaria.customer.service.dtos.CustomerResponseDto;
import com.zakaria.customer.service.exceptions.CustomerNotFoundException;
import com.zakaria.customer.service.services.CustomerService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/api/customers")
public class CustomerRestController {

    private CustomerService customerService;
    @GetMapping()
    public ResponseEntity<List<CustomerResponseDto>> listCustomers(){
        return ResponseEntity.ok(customerService.listCustomers());
    }

    @PostMapping()
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = Void.class))),
            @ApiResponse(responseCode = "500", content = @Content(schema = @Schema(implementation = ErrorMessage.class)))
    })
    public ResponseEntity<CustomerResponseDto> save(@Valid @RequestBody CustomerRequestDto CustomerRequestDto){
        return new ResponseEntity<>(customerService.save(CustomerRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long id){
        try {
            CustomerResponseDto Customer = customerService.getCustomerById(id);
            return ResponseEntity.ok(Customer);
        } catch (CustomerNotFoundException e) {
            return ResponseEntity.internalServerError().body(new ErrorMessage(e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = Void.class))),
            @ApiResponse(responseCode = "500", content = @Content(schema = @Schema(implementation = ErrorMessage.class)))
    })
    public ResponseEntity<?> updateCustomer(@Valid @RequestBody CustomerRequestDto request, @PathVariable Long id){
        try {
            CustomerResponseDto CustomerResponseDto = customerService.update(request, id);
            return ResponseEntity.ok(CustomerResponseDto);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ErrorMessage(e.getMessage()));
        }
    }
    @DeleteMapping("/{id}")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = Void.class))),
            @ApiResponse(responseCode = "500", content = @Content(schema = @Schema(implementation = ErrorMessage.class)))
    })
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id){
        try {
            customerService.deleteCustomer(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ErrorMessage(e.getMessage()));
        }
    }
}
