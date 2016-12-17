package test;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/17.
 */
public class FreemarkerTest {
    public static void main(String[] args) throws IOException, TemplateException {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        FreeMarkerConfig freeMarkerConfig=(FreeMarkerConfig) applicationContext.getBean("freemarker");
        // 1. template
        //Template template=freeMarkerConfig.getConfiguration().getTemplate("test.ftl");
        Template template = freeMarkerConfig.getConfiguration().getTemplate("model.ftl");
        // 2. java object
        //Map<String,String> map=new HashMap<>();
        //map.put("name","world");
        Map<String, Object> map = new HashMap<>();
        map.put("model", "Student");
        LinkedHashMap<String, String> properties = new LinkedHashMap<>();
        properties.put("name", "String");
        properties.put("age", "int");
        properties.put("gender", "String");
        map.put("properties", properties);
        // 3. out
        //Writer writer=new FileWriter("data/test.html");
        Writer writer = new FileWriter("src/main/java/model/Student.java");
        // 4. processing
        //template.process(map,writer);
        template.process(map, writer);
    }

}
