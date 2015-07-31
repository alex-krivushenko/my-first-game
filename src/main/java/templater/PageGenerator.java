package templater;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;
/**
 * Created by Александр on 31.07.2015.
 */
public class PageGenerator {
    private static final String HTML_DIR = "templates";
    private static final Configuration CFG = new Configuration(Configuration.VERSION_2_3_23);

    public static String getPage(String filename, Map<String, Object> data) throws IOException {
        Writer stream = new StringWriter();
        try {
            CFG.setDirectoryForTemplateLoading(new File(HTML_DIR));
            Template template = CFG.getTemplate(filename);
            template.process(data, stream);
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
        return stream.toString();
    }
}
