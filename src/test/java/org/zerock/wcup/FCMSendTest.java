package org.zerock.wcup;


import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;

@SpringBootTest

public class FCMSendTest {


    @Autowired
    FirebaseMessaging firebaseMessaging;

    @Autowired
    GoogleCredentials googleCredentials;

    @Test
    public void test1()throws Exception{

        googleCredentials.refreshIfExpired();
        System.out.println(googleCredentials.getAccessToken().getTokenValue());

    }



    @Test
    public void testSend1() throws Exception{

        System.out.println(firebaseMessaging);

        String registrationToken =
                "c2UYW7FdAdPjudmRNgiiIL:APA91bF8XB7asv3XrNJVkgHHyT75l5a9Z0ugVt3ipqRv20e4hsmiL2JDUR2BQM79ZIgfkTL5b2V1X3S5ZQeqSuYj_k7vSQkhbbMUYkzz1Ey477OqRyn9QVyNI8h936pRdvmKO6ZJPlyy";
        Message message = Message.builder()
                .setNotification(Notification.builder().setTitle("Boot Test Title").setBody("Boot Test Body").build())
                .setToken(registrationToken)
                .build();

        String response = FirebaseMessaging.getInstance().send(message);
        System.out.println("Successfully sent message: " + response);


    }

}
