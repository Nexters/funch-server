package kr.co.funch.api.supports.config.dispatcher

import kotlinx.coroutines.Dispatchers
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DispatchersConfig {
    @Bean
    fun ioDispatcher() = Dispatchers.IO
}
