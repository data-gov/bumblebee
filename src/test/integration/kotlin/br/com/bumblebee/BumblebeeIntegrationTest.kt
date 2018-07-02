package br.com.bumblebee

import br.com.bumblebee.configuration.environment.INTEGRATION
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension

@SpringBootTest
@ActiveProfiles(INTEGRATION)
@ExtendWith(SpringExtension::class)
internal class BumblebeeIntegrationTest {

    @Test
    fun contextLoads() {
    }
}
