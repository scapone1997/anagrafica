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

    public SendResult<String, String> sendMessaggio(Messaggio messaggio) {
        SendResult<String, String> sendResult = null;
        try{
            String key = messaggio.getCodice();
            String value = objectMapper.writeValueAsString(messaggio);
            sendResult = kafkaTemplate.sendDefault(key, value).get();
            System.out.println("Messaggio: " + messaggio.toString() + " invviato a Kafka.");
        }catch(Exception e){
            System.out.println("Eccezione lanciata nel send Kafka: " + e.getClass());
        }
        return sendResult;
    }
}
