package com.enviro.assessment.grad001.TshepisoMolefi.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.enviro.assessment.grad001.TshepisoMolefi.models.TransactionHistory;
import com.enviro.assessment.grad001.TshepisoMolefi.models.User;

@Controller
//CSV FILE EXPORTER

public class FileExporter {
	
	public void exportToCSV(List<TransactionHistory> userTransactHistory, HttpServletResponse response)throws IOException {
		
		DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		String timeStamp = dateformat.format(new Date());
		String filename = "TransactionHistory_" + timeStamp + ".csv";
		
		
		
		
		response.setContentType("text/csv");
		
		 
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename" + filename;
		response.setHeader(headerKey, headerValue);

	


		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
		String[] csvHeader = {"Transaction_ID", "Transaction Type", "Amount","Previous Balance", "Closing Balance", "Source", "Status","Reason Code", "Created At"};
		String[] nameMapping = {"transaction_id", "transaction_type", "amount","previous_balance","closing_balance", "source", "status", "reason_code", "created_at"};
		 
		csvWriter.writeHeader(csvHeader);

		for (TransactionHistory transactionhistory : userTransactHistory) {
		    csvWriter.write(transactionhistory, nameMapping);
		}

		csvWriter.close();
		
	}

}

