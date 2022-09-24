package universita.anagrafica.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import universita.anagrafica.client.extClient.LibrettoVuoto;

@Component
@Slf4j
public class Producer{

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    ObjectMapper objectMapper;

    public SendResult<String, String> sendMessaggio(Messaggio messaggio, String topic) {
        SendResult<String, String> sendResult = null;
        try{
            String key = messaggio.getCodice();
            String value = objectMapper.writeValueAsString(messaggio);
            sendResult = kafkaTemplate.send(topic, value).get();
            System.out.println("Messaggio: " + messaggio.toString() + " inviato a Kafka sul topic " + topic);
        }catch(Exception e){
            System.out.println("Eccezione lanciata nel send Kafka: " + e.getClass());
        }
        return sendResult;
    }
}
