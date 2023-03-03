package com.luv2code.springbootlibrary.technical.infrastructure.secondary.postgresql;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "com.luv2code.springbootlibrary" }, enableDefaultTransactions = false)
public class DatabaseConfiguration {}
