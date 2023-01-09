package com.kafkaQueue.bot.controller;

import com.kafkaQueue.bot.kafkaService.KafkaProducer;
import com.kafkaQueue.bot.pdfExport.PDFGenerator;
import com.kafkaQueue.bot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/kafka")
public class MessageController {

    @Autowired
    KafkaProducer producer;

    @Autowired
    PDFGenerator pdfGenerator;


    @Autowired
    UserService userService;

    @PostMapping("/{userNumber}/{messageId}/publish")
    public ResponseEntity<String> publish( @PathVariable(value = "userNumber") long userId,@PathVariable(value = "messageId") long messageId, @RequestParam("message") String message) {
        producer.publishToTopic(message);
        userService.saveUserDetails(userId,messageId,message);
        return ResponseEntity.ok("Message sent to the topic");
    }
    
    @PostMapping("/{userNumber}/{messageId}/updateMessage")
    public ResponseEntity<String> updateMessage(@PathVariable(value = "userNumber") long userNumber ,@PathVariable(value = "messageId") long messageId, @RequestParam("message") String message) {
        userService.updateUserDetails(userNumber,messageId, message);
        return ResponseEntity.ok("Message sent to the topic");
    }
    @GetMapping("/export/pdf")
    public ResponseEntity<String> employeeReport(){
         pdfGenerator.generatePdfReport();
        return ResponseEntity.ok().body("PDF generated");
    }
    
}
