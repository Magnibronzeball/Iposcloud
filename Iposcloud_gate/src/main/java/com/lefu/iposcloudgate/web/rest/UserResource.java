package com.lefu.iposcloudgate.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * REST controller for managing User.
 */
@RestController
@RequestMapping("/api")
public class UserResource {

    private final Logger log = LoggerFactory.getLogger(UserResource.class);

    @GetMapping("/test/{id}")
    public ResponseEntity<String> test(@PathVariable Long id) {
        log.info("11111111111111:{}",id);
        return ResponseEntity.ok().body(id.toString());
    }

}
