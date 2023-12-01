
package delivery.order.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.context.ApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.MimeTypeUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import delivery.order.service.config.kafka.KafkaProcessor;
import delivery.order.service.domain.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderPlacementPolicyTest {

   private static final Logger LOGGER = LoggerFactory.getLogger(EventTest.class);
   
   @Autowired
   private KafkaProcessor processor;
   @Autowired
   private MessageCollector messageCollector;
   @Autowired
   private ApplicationContext applicationContext;

   @Autowired
   public PaymentCompletedRepository repository;

   @Test
   @SuppressWarnings("unchecked")
   public void test0() {

      //given:  
      PaymentCompleted entity = new PaymentCompleted();

      entity.setOrderId("주문번호1");
      entity.setAmount([object Object]);
      entity.setIsCompleted(true);

      repository.save(entity);

      //when:  
      
      OrderPlaced event = new OrderPlaced();

      event.setOrderId("주문번호1");
      event.setOrderItems(new Object[]{[object Object], [object Object]});
      event.setDeliveryAddress([object Object]);
      event.setContactInfo("010-1234-5678");
      
      InventoryApplication.applicationContext = applicationContext;

      ObjectMapper objectMapper = new ObjectMapper();
      try {
         String msg = objectMapper.writeValueAsString(event);

         processor.inboundTopic().send(
            MessageBuilder
            .withPayload(msg)
            .setHeader(
               MessageHeaders.CONTENT_TYPE,
               MimeTypeUtils.APPLICATION_JSON
            )
            .setHeader("type", event.getEventType())
            .build()
         );

         //then:

         Message<String> received = (Message<String>) messageCollector.forChannel(processor.outboundTopic()).poll();

         assertNotNull("Resulted event must be published", received);



         LOGGER.info("Response received: {}", received.getPayload());

         assertEquals(outputEvent.getOrderId(), "주문번호1");
         assertEquals(outputEvent.getAmount(), [object Object]);


      } catch (JsonProcessingException e) {
         // TODO Auto-generated catch block
         assertTrue("exception", false);
      }

     
   }
   @Test
   @SuppressWarnings("unchecked")
   public void test1() {

      //given:  
      PaymentCompleted entity = new PaymentCompleted();

      entity.setOrderId("주문번호2");
      entity.setAmount([object Object]);
      entity.setIsCompleted(false);

      repository.save(entity);

      //when:  
      
      OrderPlaced event = new OrderPlaced();

      event.setOrderId("주문번호2");
      event.setOrderItems(new Object[]{[object Object], [object Object]});
      event.setDeliveryAddress([object Object]);
      event.setContactInfo("010-9876-5432");
      
      InventoryApplication.applicationContext = applicationContext;

      ObjectMapper objectMapper = new ObjectMapper();
      try {
         String msg = objectMapper.writeValueAsString(event);

         processor.inboundTopic().send(
            MessageBuilder
            .withPayload(msg)
            .setHeader(
               MessageHeaders.CONTENT_TYPE,
               MimeTypeUtils.APPLICATION_JSON
            )
            .setHeader("type", event.getEventType())
            .build()
         );

         //then:

         Message<String> received = (Message<String>) messageCollector.forChannel(processor.outboundTopic()).poll();

         assertNotNull("Resulted event must be published", received);



         LOGGER.info("Response received: {}", received.getPayload());

         assertEquals(outputEvent.getOrderId(), "주문번호2");
         assertEquals(outputEvent.getAmount(), [object Object]);


      } catch (JsonProcessingException e) {
         // TODO Auto-generated catch block
         assertTrue("exception", false);
      }

     
   }
   @Test
   @SuppressWarnings("unchecked")
   public void test2() {

      //given:  
      PaymentCompleted entity = new PaymentCompleted();

      entity.setOrderId("주문번호3");
      entity.setAmount([object Object]);
      entity.setIsCompleted(true);

      repository.save(entity);

      //when:  
      
      OrderPlaced event = new OrderPlaced();

      event.setOrderId("주문번호3");
      event.setOrderItems(new Object[]{});
      event.setDeliveryAddress([object Object]);
      event.setContactInfo("010-5555-6666");
      
      InventoryApplication.applicationContext = applicationContext;

      ObjectMapper objectMapper = new ObjectMapper();
      try {
         String msg = objectMapper.writeValueAsString(event);

         processor.inboundTopic().send(
            MessageBuilder
            .withPayload(msg)
            .setHeader(
               MessageHeaders.CONTENT_TYPE,
               MimeTypeUtils.APPLICATION_JSON
            )
            .setHeader("type", event.getEventType())
            .build()
         );

         //then:

         Message<String> received = (Message<String>) messageCollector.forChannel(processor.outboundTopic()).poll();

         assertNotNull("Resulted event must be published", received);



         LOGGER.info("Response received: {}", received.getPayload());

         assertEquals(outputEvent.getOrderId(), "주문번호3");
         assertEquals(outputEvent.getAmount(), [object Object]);


      } catch (JsonProcessingException e) {
         // TODO Auto-generated catch block
         assertTrue("exception", false);
      }

     
   }

}
