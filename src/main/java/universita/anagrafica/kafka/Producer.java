package universita.anagrafica.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import universita.anagrafica.mapper.domain.Studente;

@Component
@Slf4j
public class Producer {

    @Autowired
    KafkaTemplate<Integer, String> kafkaTemplate;

    @Autowired
    ObjectMapper objectMapper;

    public SendResult<Integer, String> sendStudente(Studente studente) {
        SendResult<Integer, String> sendResult = null;
        try{
            Integer key = studente.getMatricola();
            String value = objectMapper.writeValueAsString(studente);
            sendResult = kafkaTemplate.sendDefault(key, value).get();
        }catch(Exception e){
            System.out.println("Eccezione lanciata: " + e.getClass());
        }
        return sendResult;
    }
}
