package com.example.new_project.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GeoServerWMSService {

    private final RestTemplate restTemplate;

    public GeoServerWMSService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public byte[] getWMSImage() {
        String wmsUrl = "http://localhost:8080/geoserver/ne/wms?service=WMS&version=1.1.0&request=GetMap&layers=ne%3Atest&bbox=179191.375%2C536547.375%2C216242.265625%2C566863.5625&width=768&height=628&srs=EPSG%3A5186&styles=&format=application/openlayers";
        // WMS 요청을 보내고 응답으로 이미지를 바이트 배열로 받음
        ResponseEntity<byte[]> response = restTemplate.getForEntity(wmsUrl, byte[].class);
        return response.getBody();
    }
}
