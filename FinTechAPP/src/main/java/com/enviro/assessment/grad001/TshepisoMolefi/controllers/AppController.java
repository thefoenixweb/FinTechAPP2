package com.enviro.assessment.grad001.TshepisoMolefi.controllers;

import com.enviro.assessment.grad001.TshepisoMolefi.models.Account;
import com.enviro.assessment.grad001.TshepisoMolefi.models.PaymentHistory;
import com.enviro.assessment.grad001.TshepisoMolefi.models.TransactionHistory;
import com.enviro.assessment.grad001.TshepisoMolefi.models.User;
import com.enviro.assessment.grad001.TshepisoMolefi.repository.AccountRepository;
import com.enviro.assessment.grad001.TshepisoMolefi.repository.PaymentHistoryRepository;
import com.enviro.assessment.grad001.TshepisoMolefi.repository.TransactHistoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/app")
public class AppController {

    @Autowired
    private AccountRepository accountRepository;
    
   @Autowired
   private PaymentHistoryRepository paymentHistoryRepository;

 

    @Autowired
    private TransactHistoryRepository transactHistoryRepository;
    
    @Autowired
    private FileExporter export;

    User user;

    //Dashboard View
    
    @GetMapping("/dashboard")
    public ModelAndView getDashboard(HttpSession session){
        ModelAndView getDashboardPage = new ModelAndView("dashboard");

        // Get the details of the logged i user:
        user = (User)session.getAttribute("user");

        // Get The Accounts Of The Logged In User:
        List<Account> getUserAccounts = accountRepository.getUserAccountsById(user.getUser_id());

        // Get Balance:
        BigDecimal totalAccountsBalance = accountRepository.getTotalBalance(user.getUser_id());

        // Set Objects:
        getDashboardPage.addObject("userAccounts", getUserAccounts);
        getDashboardPage.addObject("totalBalance", totalAccountsBalance);

        return getDashboardPage;
    }
    
    //User Details View
    @GetMapping("/user_details")
    public ModelAndView getUserDetails(HttpSession session){
        // Set View:
        ModelAndView getUserDetailsPage = new ModelAndView("userDetails");

        // Get Logged In User:\
        user = (User) session.getAttribute("user");
        return getUserDetailsPage;

    }

   

    //Transaction History View
    @GetMapping("/transact_history")
    public ModelAndView getTransactHistory(HttpSession session){
        // Set View:
        ModelAndView getTransactHistoryPage = new ModelAndView("transactHistory");

        // Get Logged In User:\
        user = (User) session.getAttribute("user");

        // Get Payment History / Records:
        List<TransactionHistory> userTransactHistory = transactHistoryRepository.getTransactionRecordsById(user.getUser_id());

        getTransactHistoryPage.addObject("transact_history", userTransactHistory);

        return getTransactHistoryPage;

    }
    
    //Payment History View
    @GetMapping("/payment_history")
    public ModelAndView getPaymentHistory(HttpSession session){
        // Set View:
        ModelAndView getPaymentHistoryPage = new ModelAndView("paymentHistory");

        // Get Logged In User:\
        user = (User) session.getAttribute("user");

        // Get Payment History / Records:
        List<PaymentHistory> userPaymentHistory = paymentHistoryRepository.getPaymentRecordsById(user.getUser_id());

        getPaymentHistoryPage.addObject("payment_history", userPaymentHistory);

        return getPaymentHistoryPage;

    }
    
   
    
    //Transaction History Export
    
    @GetMapping("/transact_history/export")
    public void exportToCSV(HttpSession session,HttpServletResponse response) throws IOException {
    	
    	user = (User) session.getAttribute("user");
    	List<TransactionHistory> userTransactHistory = transactHistoryRepository.getTransactionRecordsById(user.getUser_id());
    	export.exportToCSV(userTransactHistory, response);
        
    }
}
