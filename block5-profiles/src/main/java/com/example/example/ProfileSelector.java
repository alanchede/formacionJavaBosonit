package com.example.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class ProfileSelector implements CommandLineRunner {

    @Value("${spring.profiles.active}")
    private String profile;
    @Value("${bd.url}")
    private String url;

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Perfil: " + profile + " url: " + url);
    }
}
