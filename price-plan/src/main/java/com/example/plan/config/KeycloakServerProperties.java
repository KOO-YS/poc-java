package com.example.plan.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@ConfigurationProperties(prefix = "keycloak.server")
public class KeycloakServerProperties {

    String contextPath = "/auth";
    String realmImportFile = "price-plan-realm.json";
    AdminUser adminUser = new AdminUser();

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public void setRealmImportFile(String realmImportFile) {
        this.realmImportFile = realmImportFile;
    }

    public void setAdminUser(AdminUser adminUser) {
        this.adminUser = adminUser;
    }

    public static class AdminUser {
        String username = "admin";
        String password = "1234";

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
