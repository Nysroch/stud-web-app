package hr.tvz.sekula.studapp.config;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchedulerConfig {

    @Bean
    public JobDetail announcementJobDetail() {
        return JobBuilder.newJob(AnnouncementJob.class).withIdentity("announcementJob").storeDurably().build();

    }
    @Bean
    public Trigger announcementJobTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(10).repeatForever();
        return TriggerBuilder.newTrigger().forJob(announcementJobDetail()).withIdentity("announcementTrigger").withSchedule(scheduleBuilder).build();
    }
}
