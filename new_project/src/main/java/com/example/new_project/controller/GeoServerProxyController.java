package com.example.new_project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "http://localhost:9999")  // CORS 허용
public class GeoServerProxyController {

    private final RestTemplate restTemplate;

    public GeoServerProxyController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/proxy/geoserver")
    public ResponseEntity<String> proxyGeoServerRequest(
            @RequestParam("service") String service,
            @RequestParam("version") String version,
            @RequestParam("request") String request,
            @RequestParam("layers") String layers,
            @RequestParam("bbox") String bbox,
            @RequestParam("width") int width,
            @RequestParam("height") int height,
            @RequestParam("srs") String srs,
            @RequestParam("x") int x,
            @RequestParam("y") int y,
            @RequestParam("info_format") String infoFormat) {

        // GeoServer WMS URL
        String geoserverUrl = "http://localhost:8080/geoserver/ne/wms?service=" + service
                + "&version=" + version
                + "&request=" + request
                + "&layers=" + layers
                + "&bbox=" + bbox
                + "&width=" + width
                + "&height=" + height
                + "&srs=" + srs
                + "&x=" + x
                + "&y=" + y
                + "&info_format=" + infoFormat;

        // GeoServer로 요청 전송
        ResponseEntity<String> response = restTemplate.getForEntity(geoserverUrl, String.class);

        return ResponseEntity.ok(response.getBody());
    }
}
