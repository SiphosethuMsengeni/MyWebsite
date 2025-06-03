
package za.ac.cput.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.HomeAddress;
import za.ac.cput.service.IHomeAddressService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/addresses")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class HomeAddressController {

    private final IHomeAddressService homeAddressService;

    @PostMapping
    public ResponseEntity<HomeAddress> createAddress(@Valid @RequestBody HomeAddress address) {
        HomeAddress savedAddress = homeAddressService.createAddress(address);
        return ResponseEntity.ok(savedAddress);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HomeAddress> getAddress(@PathVariable Long id) {
        return homeAddressService.getAddressById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<HomeAddress>> getAllAddresses() {
        List<HomeAddress> addresses = homeAddressService.getAllAddresses();
        return ResponseEntity.ok(addresses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HomeAddress> updateAddress(
            @PathVariable Long id,
            @Valid @RequestBody HomeAddress address) {
        return homeAddressService.updateAddress(id, address)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        if (homeAddressService.deleteAddress(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}