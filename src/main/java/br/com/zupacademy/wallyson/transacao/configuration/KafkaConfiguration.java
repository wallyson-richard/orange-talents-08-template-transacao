package br.com.zupacademy.wallyson.transacao.configuration;

import static org.apache.kafka.clients.consumer.ConsumerConfig.*;

import br.com.zupacademy.wallyson.transacao.transacoes.novatransacao.TransacaoMessageRequest;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.Properties;

@Configuration
public class KafkaConfiguration {

    @Autowired
    private KafkaProperties kafkaProperties;

    public Properties consumerConfigurations() {
        var properties = new Properties();
        properties.put(BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        properties.put(GROUP_ID_CONFIG, kafkaProperties.getConsumer().getGroupId());
        properties.put(AUTO_OFFSET_RESET_CONFIG, kafkaProperties.getConsumer().getAutoOffsetReset());
        properties.put(KEY_DESERIALIZER_CLASS_CONFIG, kafkaProperties.getConsumer().getKeyDeserializer());
        properties.put(VALUE_DESERIALIZER_CLASS_CONFIG, kafkaProperties.getConsumer().getValueDeserializer());
        return properties;
    }

    @Bean
    public ConsumerFactory<String, TransacaoMessageRequest> transacaoConsumerFactory() {
        var keyDeserializer = new StringDeserializer();
        var valueDeserializer = new JsonDeserializer<>(TransacaoMessageRequest.class, false);
        return new DefaultKafkaConsumerFactory(consumerConfigurations(), keyDeserializer, valueDeserializer);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, TransacaoMessageRequest> kafkaListenerContainerFactory() {
        var factory = new ConcurrentKafkaListenerContainerFactory<String, TransacaoMessageRequest>();
        factory.setConsumerFactory(transacaoConsumerFactory());
        return factory;
    }
}
