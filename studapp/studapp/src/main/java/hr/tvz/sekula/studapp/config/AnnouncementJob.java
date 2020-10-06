package hr.tvz.sekula.studapp.config;

import hr.tvz.sekula.studapp.student.StudentService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class AnnouncementJob extends QuartzJobBean {

    @Autowired
    private StudentService service;

    private String name;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        System.out.println("Trenutno upisani studenti:");
        System.out.println("---------------------------------");

        service.findAll().stream().forEach( e -> System.out.println(e.getJmbag() + " - " + e.getFirst_name() + " " + e.getLast_name()));

        System.out.println("---------------------------------");


    }
}
