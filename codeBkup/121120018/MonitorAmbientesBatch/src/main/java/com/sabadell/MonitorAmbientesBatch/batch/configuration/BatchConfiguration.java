package com.sabadell.MonitorAmbientesBatch.batch.configuration;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.sabadell.MonitorAmbientesBatch.batch.processor.NodosyServidoresProcessor;
import com.sabadell.MonitorAmbientesBatch.batch.reader.JobCompletionNotificationListener;
import com.sabadell.MonitorAmbientesBatch.batch.reader.NodosyServidoresReader;
import com.sabadell.MonitorAmbientesBatch.dto.MONTOperacionDTO;
import com.sabadell.MonitorAmbientesBatch.dto.NodosyServidoresDTO;

@Configuration
@EnableBatchProcessing
@EnableScheduling
public class BatchConfiguration {
		
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;
    
    private static final int NUMERO_HILOS=10;
        
    private static final String INSERT_MONTOPERACIONES = "INSERT INTO MONT_OPERACION "
    		+ "(IDOPERACION, IDSERVIDOR, IDESTATUS, FECHA, TIEMPORESPUESTA, IDTIPOVERIFICACION) "
    		+ "VALUES (:idOperacion,:idServidor,:idEstatus,:fecha,:tiempoRespuesta,1)";
 
    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }
    
    @Bean
    @StepScope
    public NodosyServidoresReader monitorAmbienteItemReader() {
    	 return new NodosyServidoresReader();
    }
    
    @Bean
    @StepScope
    public NodosyServidoresProcessor processor() {
        return new NodosyServidoresProcessor();
    }
    
    @Bean
    @StepScope
    public ItemWriter<MONTOperacionDTO> monitorAmbientesWriter() {
        JdbcBatchItemWriter<MONTOperacionDTO> databaseItemWriter = new JdbcBatchItemWriter<MONTOperacionDTO>() {

            @Override
            public void write(List<? extends MONTOperacionDTO> items) throws Exception {
                super.write(items);
            }
        };
        databaseItemWriter.setDataSource(jdbcTemplate.getDataSource());
        databaseItemWriter.setSql(INSERT_MONTOPERACIONES);
        databaseItemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<MONTOperacionDTO>());
        databaseItemWriter.afterPropertiesSet();
        
        return databaseItemWriter;
    }
    
    @Bean
    public TaskExecutor taskExecutor() {
    	SimpleAsyncTaskExecutor taskExecutor = new SimpleAsyncTaskExecutor();
    	taskExecutor.setConcurrencyLimit(NUMERO_HILOS);
    	return taskExecutor;
    }
    
    @Bean
    public JobCompletionNotificationListener jobExecutionListener() {
    	return new JobCompletionNotificationListener();
    }
    
    @Bean(name="monitorAmbientesJob")
    public Job monitorAmbientesJob(Step step1) {
        return jobBuilderFactory.get("monitorAmbientesJob")
            .incrementer(new RunIdIncrementer())
            .flow(step1)
            .end()
            .build();
    }

    @Bean
    public Step step1() throws Exception {
        return stepBuilderFactory.get("step1")
        	.<NodosyServidoresDTO, MONTOperacionDTO> chunk(8)
            .reader(monitorAmbienteItemReader())
            .processor(processor())
            .writer(monitorAmbientesWriter())
            .taskExecutor(taskExecutor())
            .build();
    }
}
