package com.xd.myspringbootblog.controller;

import com.xd.myspringbootblog.SpringRestDocApplication;
import com.xd.myspringbootblog.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.restdocs.payload.JsonFieldType;

import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;

public class UserControllerTest extends SpringRestDocApplication {

    @Autowired
    private UserService userService;

    @Test
    public void getUser() throws Exception {

        this.mockMvc.perform(
                get("/v1/users/{uid}", 1))
                .andExpect(status().isOk())
                .andDo(print())
                .andDo(document("get-user-by-id",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        pathParameters(
                                parameterWithName("uid").description("user_id")),
                        responseFields(
                                fieldWithPath("code").description("Status Code").type(JsonFieldType.NUMBER),
                                fieldWithPath("message").description("Response Message"),
                                fieldWithPath("data.userId").description("User Id"),
                                fieldWithPath("data.userName").description("User Name"),
                                fieldWithPath("data.credits").description("User Credits"),
                                fieldWithPath("data.lastIp").description("User Last Login Ip"),
                                fieldWithPath("data.lastVisit").description("User Last Visit Time")

                        )));
    }

    @Test
    public void listUsers() throws Exception {

        this.mockMvc.perform(get("/v1/users"))
                .andExpect(status().isOk())
                .andDo(print())
                .andDo(document("get-user-list",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        responseFields(
                                fieldWithPath("code").description("Status Code").type(JsonFieldType.NUMBER),
                                fieldWithPath("message").description("Response Message"),
                                fieldWithPath("data[].userId").description("User Id"),
                                fieldWithPath("data[].userName").description("User Name"),
                                fieldWithPath("data[].credits").description("User Credits"),
                                fieldWithPath("data[].lastIp").description("User Last Login Ip"),
                                fieldWithPath("data[].lastVisit").description("User Last Visit Time")
                        )));
    }
}
