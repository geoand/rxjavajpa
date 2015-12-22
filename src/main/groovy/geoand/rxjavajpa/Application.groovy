package geoand.rxjavajpa

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.core.task.TaskExecutor
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor

@SpringBootApplication
class Application {

    static void main(String[] args) {
        SpringApplication.run Application, args
    }

    @Bean
    TaskExecutor taskExecutor() {
        final ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setMaxPoolSize(5);
        taskExecutor.afterPropertiesSet();
        return taskExecutor;
    }
}
