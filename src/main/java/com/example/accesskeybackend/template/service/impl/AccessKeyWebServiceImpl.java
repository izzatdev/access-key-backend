package com.example.accesskeybackend.template.service.impl;

import com.example.accesskeybackend.template.service.AccessKeyWebService;
import inet.ipaddr.HostName;
import inet.ipaddr.HostNameException;
import inet.ipaddr.IPAddress;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccessKeyWebServiceImpl implements AccessKeyWebService {

    @Override
    public Boolean checkIpv6Support(String siteUrl) {
        try {
            InetAddress inetAddress = null;
            if (siteUrl.startsWith("http")) { //check if url or domain name
                inetAddress = InetAddress.getByName(new URL(siteUrl).getHost());
            } else {
                inetAddress = InetAddress.getByName(siteUrl);
            }
            HostName host = new HostName(inetAddress.getHostAddress());
            host.validate();
            if (host.isAddress()) {
                IPAddress.IPVersion ipVersion = host.asAddress().getIPVersion();
                return ipVersion.isIPv6();
            }
        } catch (MalformedURLException | HostNameException | UnknownHostException e) {
            return false;
        }
        return false;
    }

}

