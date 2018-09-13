package com.xd.myspringbootblog;

import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.restdocs.http.HttpDocumentation;
import org.springframework.restdocs.payload.PayloadDocumentation;
import org.springframework.restdocs.snippet.Snippet;
import org.springframework.restdocs.templates.TemplateFormats;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
public class SpringRestDocApplication {

    @Rule
    public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation();

    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUp() {
        Snippet[] defaultSnippets = new Snippet[]{
                HttpDocumentation.httpRequest(),
                HttpDocumentation.httpResponse(),
                PayloadDocumentation.requestBody(),
                PayloadDocumentation.responseBody()};

        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
                .apply(documentationConfiguration(this.restDocumentation)
                .snippets().withTemplateFormat(TemplateFormats.asciidoctor()).withEncoding("UTF-8")
                .withDefaults(defaultSnippets)
                )
                .build();
    }
}
