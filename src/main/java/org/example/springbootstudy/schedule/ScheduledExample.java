package org.example.springbootstudy.schedule;

import org.springframework.scheduling.annotation.Scheduled;

public class ScheduledExample {
    @Scheduled(cron = "0 */5 * * * *")
    public void scheduled() {
        System.out.println("scheduled");
    }
}
