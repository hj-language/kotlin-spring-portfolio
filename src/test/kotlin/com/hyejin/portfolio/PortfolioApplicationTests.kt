package com.hyejin.portfolio

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@SpringBootTest
class PortfolioApplicationTests {

    @Test
    fun contextLoads() {
    }

    @Test
    fun encryptPassword() {
        val password = "ellie"
        println("encryptedPassword: ${BCryptPasswordEncoder().encode(password)}")
    }
}
