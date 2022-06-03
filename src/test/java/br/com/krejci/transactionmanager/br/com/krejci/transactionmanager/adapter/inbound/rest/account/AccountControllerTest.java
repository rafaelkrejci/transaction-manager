//package br.com.krejci.transactionmanager.br.com.krejci.transactionmanager.adapter.inbound.rest.account;
//
//import br.com.krejci.transactionmanager.adapter.inbound.rest.account.AccountController;
//import br.com.krejci.transactionmanager.adapter.inbound.rest.account.AccountRequestDTO;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class AccountControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Autowired
//    private AccountController accountController;
//
//
//    @Test
//    void createAccountSuccessAndExpectHttpCodeCreated() throws Exception {
//
//        AccountRequestDTO request = new AccountRequestDTO();
//        request.setAccount_number(207813049L);
//
//        mockMvc.perform(post("/accounts")
//                        .contentType("application/json")
//                        .content(objectMapper.writeValueAsString(request)))
//                .andExpect(status().isCreated());
//    }
//}
