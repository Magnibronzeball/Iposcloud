package com.lefu.iposcloudadmin.config;

import de.codecentric.boot.admin.event.ClientApplicationEvent;
import de.codecentric.boot.admin.event.ClientApplicationStatusChangedEvent;
import de.codecentric.boot.admin.notify.AbstractStatusChangeNotifier;
import de.codecentric.boot.admin.notify.Notifier;
import de.codecentric.boot.admin.notify.RemindingNotifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.TimeUnit;

/**
 * 重写doNotify方法实现自定义监控.
 *
 * @author zhou.zhao
 */
@Configuration
@EnableScheduling
public class NotifierConfiguration {

    private Notifier notifier = new LefuNotifier();;
    private final Logger log = LoggerFactory.getLogger(NotifierConfiguration.class);

    @Bean
    @Primary
    public RemindingNotifier remindingNotifier() {
        RemindingNotifier remindingNotifier = new RemindingNotifier(notifier);
        remindingNotifier.setReminderPeriod(TimeUnit.MINUTES.toMillis(5));
        return remindingNotifier;
    }

    @Scheduled(fixedRate = 60_000L)
    public void remind() {
        remindingNotifier().sendReminders();
    }
        class LefuNotifier extends AbstractStatusChangeNotifier {
            @Override
            protected void doNotify(ClientApplicationEvent event) throws Exception {
                if (event instanceof ClientApplicationStatusChangedEvent) {
                    log.info("Application {} ({}) is {}", event.getApplication().getName(),
                            event.getApplication().getId(), ((ClientApplicationStatusChangedEvent) event).getTo().getStatus());
                } else {
                    log.info("Application {} ({}) {} ", event.getApplication().getName(),
                            event.getApplication().getId(), event.getType());
                }
            }

        }
}