package com.dongwoo.api.item.controller;

import com.dongwoo.api.item.domain.Item;
import com.dongwoo.api.item.service.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "items")
@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    public ResponseEntity<List<Item>> findAll() {
        return ResponseEntity.ok(itemService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Item>> findById(@PathVariable long id) {
        return ResponseEntity.ok(itemService.findById(id));
    }

    @PostMapping
    public void save(@RequestBody Item item) {
        itemService.save(item);
    }

    @PutMapping
    public void update(@RequestBody Item item) {
        itemService.save(item);
    }

    @GetMapping("/exists")
    public ResponseEntity<Boolean> existsById(long id) {
        return ResponseEntity.ok(itemService.existsById(id));
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(itemService.count());
    }

    @DeleteMapping
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Something went wrong"),
        @ApiResponse(code = 403, message = "Access Denied"),
        @ApiResponse(code = 422, message = "Item is alredy in use")})
    public void deleteAll() {
        itemService.deleteAll();
    }
}
