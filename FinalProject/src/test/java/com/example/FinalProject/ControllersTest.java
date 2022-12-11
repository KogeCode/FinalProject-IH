package com.example.FinalProject;


import com.example.FinalProject.models.account.Checking;
import com.example.FinalProject.models.embedded.Address;
import com.example.FinalProject.models.users.AccountHolder;
import com.example.FinalProject.models.users.ThirdParty;
import com.example.FinalProject.repositories.accounts.AccountRepository;
import com.example.FinalProject.repositories.accounts.CheckingRepository;
import com.example.FinalProject.repositories.users.AccountHolderRepository;
import com.example.FinalProject.repositories.users.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class ControllersTest {
    @Autowired
    private WebApplicationContext context;

    @Autowired
    private AccountHolderRepository accountHolderRepository;

    MockMvc mockMvc;

    ObjectMapper objectMapper = JsonMapper.builder()
            .addModule(new JavaTimeModule())
            .build();

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CheckingRepository checkingRepository;
    @Autowired
    private AccountRepository accountRepository;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    void commandLineRunnerRuns() {
        assertEquals(4, userRepository.findAll().size());
    }

    @Test
    void shouldAddNewAccountHolder() throws Exception {
        AccountHolder accountHolder = new AccountHolder("Juan", "2222", LocalDate.of(1986, 6, 23), new Address("Juan Carlos", 8350, "Montcada", "España"));

        String body = objectMapper.writeValueAsString(accountHolder);

        MvcResult result = mockMvc.perform(post("/account-holder/add").content(body).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated()).andReturn();

        System.out.println(result.getResponse().getContentAsString());

    }

    @Test
    void shouldAddNewThirdParty() throws Exception {
        ThirdParty thirdParty = new ThirdParty("BBVA", "12223", "C45");

        String body = objectMapper.writeValueAsString(thirdParty);

        MvcResult result = mockMvc.perform(post("/thirdparty-account/add").content(body).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated()).andReturn();

        assertTrue(result.getResponse().getContentAsString().contains("BBVA"));
    }

    @Test
    void shouldAddnewCheckingAccount() throws Exception {
        Checking checking = new Checking(BigDecimal.valueOf(10000), accountHolderRepository.findById(2L).get(), "456456", BigDecimal.valueOf(251));

        String body = objectMapper.writeValueAsString(checking);

        MvcResult result = mockMvc.perform(post("/checking-accounts/add").content(body).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated()).andReturn();

        System.out.println(result.getResponse().getContentAsString());

        assertTrue(result.getResponse().getContentAsString().contains("456456"));

    }

    @Test
    void shouldDeleteAndAccountById() throws Exception {
        //Creamos la cuenta Checking que vamos a proceder a eliminar
        Checking checking = new Checking(BigDecimal.valueOf(10000), accountHolderRepository.findById(2L).get(), "456456", BigDecimal.valueOf(251));

        String body = objectMapper.writeValueAsString(checking);

        MvcResult result = mockMvc.perform(post("/checking-accounts/add").content(body).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated()).andReturn();

        //Obtenemos la ID de la cuenta que hemos creado que debería ser la única cuenta con lo cual tendrá ID = 1
        Long id = checkingRepository.findById(1L).get().getAccountId();

        //Procedemos a eliminar la cuenta buscando por ID
        MvcResult result2 = mockMvc.perform(delete("/account-admin/delete-account/{id}", id))
                .andDo(print())
                .andExpect(status().isNoContent()).andReturn();

        assertEquals(0, accountRepository.findAll().size());
    }

}


