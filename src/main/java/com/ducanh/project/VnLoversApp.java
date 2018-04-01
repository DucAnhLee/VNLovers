package com.ducanh.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;

import org.bouncycastle.asn1.x509.qualified.TypeOfBiometricData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.MetricFilterAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.MetricRepositoryAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.util.ResourceUtils;

import com.ducanh.project.config.ApplicationProperties;
import com.ducanh.project.config.DefaultProfileUtil;
import com.ducanh.project.domain.Mess;
import com.ducanh.project.domain.VNLoverInfo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.jhipster.config.JHipsterConstants;

@ComponentScan
@EnableAutoConfiguration(exclude = {MetricFilterAutoConfiguration.class, MetricRepositoryAutoConfiguration.class})
@EnableConfigurationProperties({LiquibaseProperties.class, ApplicationProperties.class})
@EnableDiscoveryClient
public class VnLoversApp implements CommandLineRunner{

    private static final Logger log = LoggerFactory.getLogger(VnLoversApp.class);

    private final Environment env;

    public VnLoversApp(Environment env) {
        this.env = env;
    }

    /**
     * Initializes VnLovers.
     * <p>
     * Spring profiles can be configured with a program arguments --spring.profiles.active=your-active-profile
     * <p>
     * You can find more information on how profiles work with JHipster on <a href="http://www.jhipster.tech/profiles/">http://www.jhipster.tech/profiles/</a>.
     */
    @PostConstruct
    public void initApplication() {
        Collection<String> activeProfiles = Arrays.asList(env.getActiveProfiles());
        if (activeProfiles.contains(JHipsterConstants.SPRING_PROFILE_DEVELOPMENT) && activeProfiles.contains(JHipsterConstants.SPRING_PROFILE_PRODUCTION)) {
            log.error("You have misconfigured your application! It should not run " +
                "with both the 'dev' and 'prod' profiles at the same time.");
        }
        if (activeProfiles.contains(JHipsterConstants.SPRING_PROFILE_DEVELOPMENT) && activeProfiles.contains(JHipsterConstants.SPRING_PROFILE_CLOUD)) {
            log.error("You have misconfigured your application! It should not " +
                "run with both the 'dev' and 'cloud' profiles at the same time.");
        }
        
    }

    /**
     * Main method, used to run the application.
     *
     * @param args the command line arguments
     * @throws UnknownHostException if the local host name could not be resolved into an address
     */
    public static void main(String[] args) throws UnknownHostException {
        SpringApplication app = new SpringApplication(VnLoversApp.class);
        DefaultProfileUtil.addDefaultProfile(app);
        Environment env = app.run(args).getEnvironment();
        String protocol = "http";
        if (env.getProperty("server.ssl.key-store") != null) {
            protocol = "https";
        }
        log.info("\n----------------------------------------------------------\n\t" +
                "Application '{}' is running! Access URLs:\n\t" +
                "Local: \t\t{}://localhost:{}\n\t" +
                "External: \t{}://{}:{}\n\t" +
                "Profile(s): \t{}\n----------------------------------------------------------",
            env.getProperty("spring.application.name"),
            protocol,
            env.getProperty("server.port"),
            protocol,
            InetAddress.getLocalHost().getHostAddress(),
            env.getProperty("server.port"),
            env.getActiveProfiles());
        
    }

	@Override
	public void run(String... arg0) throws Exception {
//		SparkConf sparkConfig = new SparkConf().setAppName("SparkAppName").setMaster("local[*]");
//        JavaSparkContext sc = new JavaSparkContext(sparkConfig);
//        
//        JavaRDD<String> textFile = sc.textFile("F:\\scrapy\\VietNamLovers\\vnlovers\\vnlovers_postv2.json");
//        
//        List<String> ls = textFile.take(3);
//        ls.stream().forEach(s -> System.out.println(s));
		
        ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<VNLoverInfo>> typeReference = new TypeReference<List<VNLoverInfo>>(){};
//		InputStream inputStream = TypeReference.class.getResourceAsStream("F:/scrapy/VietNamLovers/vnlovers/mess.json");
		try {
//			List<VNLoverInfo> users = mapper.readValue(new FileInputStream("vnlover_info.json"),typeReference);
			List<VNLoverInfo> users = mapper.readValue(new FileInputStream(ResourceUtils.getFile("classpath:vnlover_info.json")),typeReference);
			
			System.out.println("Users Saved!");
			System.out.println(users.size());
			users.stream().forEach(u -> System.out.println(u));
		} catch (IOException e){
			System.out.println("Unable to save users: " + e.getMessage());
			e.printStackTrace();
		}
		
		try {
			List<List<Long>> ll = mapper.readValue(new FileInputStream(ResourceUtils.getFile("classpath:post_timestampv2.json")), new TypeReference<List<List<Long>>>(){});
			ll.stream().forEach(l -> System.out.println(l.get(0) + ": "+ l.get(1)));
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}
}
