package com.example.accesskeybackend.template.controller;

import com.example.accesskeybackend.template.service.AccessKeyWebService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/web")
@RequiredArgsConstructor
public class AccessKeyWebController {
    private final AccessKeyWebService webService;

    @GetMapping("/checkIpv6Support")
    public HttpEntity<?> checkIpv6Support(@RequestParam("siteUrl") String siteUrl){
        return ResponseEntity.ok(webService.checkIpv6Support(siteUrl.trim()));
    }
}
