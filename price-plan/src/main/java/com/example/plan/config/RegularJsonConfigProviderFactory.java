package com.example.plan.config;

import org.keycloak.common.util.SystemEnvProperties;
import org.keycloak.services.util.JsonConfigProviderFactory;

import java.util.Properties;

public class RegularJsonConfigProviderFactory extends JsonConfigProviderFactory {
    @Override
    protected Properties getProperties() {
        return new SystemEnvProperties(System.getenv());
    }
}
