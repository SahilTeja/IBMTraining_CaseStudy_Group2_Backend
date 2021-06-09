package com.ibm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ibm.entity.EMIChart;
import com.ibm.entity.EMIChart2;

@Service
public class EMIService {

	
	public void addition(EMIChart emi,int a,int b) {
		int result = a+b;
		emi.setAdd(result);
	}
	public void subtraction(EMIChart emi,int a,int b) {
		int result = a-b;
		emi.setSubtract(result);
	}
	public void multiplication(EMIChart emi,int a,int b) {
		int result = a*b;
		emi.setMult(result);
	}
	public void division(EMIChart emi,int a,int b) {
		int result = a/b;
		emi.setDivide(result);
	}

	public EMIChart getTest(int a, int b) {
		EMIChart emi = new EMIChart();
		addition(emi,a,b);
		subtraction(emi,a,b);
		multiplication(emi,a,b);
		division(emi,a,b);
		System.out.println("=============="+emi.toString());
		return emi;
		
	}
	//////////////////////////////////////////////////////
	
	public List<EMIChart2> getEmi(double principal, double time) {
		List<EMIChart2> charttest = new ArrayList<EMIChart2>();
		EMIChart(charttest,principal,time,10.0);
		System.out.println("++++++++==================="+charttest);
		return charttest;
	}
	int calculateEMI(double principal,double time,double interest) {
		double rate = interest/100;
		double emi = principal*rate*Math.pow((1+rate), time)/(Math.pow((1+rate), time)-1);
//		System.out.println("EMI is :"+(int)Math.ceil(emi) +"--"+ principal +"--"+ time +"--"+ rate);
		return (int)Math.ceil(emi);
	}
	public List<EMIChart2> EMIChart(List<EMIChart2> charttest,double principal,double time,double interest) {
		
		double openingBal = principal;
		double closingBal;
		double interestPaidYearly;
		double principlePaidYearly;
		double FinalEMI = 0;
		FinalEMI = calculateEMI(principal,time,interest);
		System.out.println(String.format("| %-4s | %-10s | %-8s | %-18s | %-19s | %-10s |","Year","OpeningBal","EMI","InterestPaidYearly","PrinciplePaidYearly","ClosingBal"));
		System.out.println(String.format("|%-6s|%-12s|%-10s|%-20s|%-21s|%-11s|","------","------------","----------","--------------------","---------------------","------------"));

		for(int i=1; i<=time; i++) {
			EMIChart2 temp = new EMIChart2();
			interestPaidYearly = (int) (openingBal *(interest/100.0));
			principlePaidYearly = FinalEMI-interestPaidYearly;
			closingBal = openingBal - principlePaidYearly;
			if(i==time) {
				closingBal=0;
			}
			System.out.println(String.format("|  %-4s|  %-10s|  %-8s|  %-18s|  %-19s|  %-10s|",i,openingBal,FinalEMI,interestPaidYearly,principlePaidYearly,closingBal));
			temp.setOpeningBal(openingBal);
			openingBal=closingBal;
			temp.setYear(i);
			temp.setEmi(FinalEMI);
			temp.setInterestPaidYearly(interestPaidYearly);
			temp.setPrinciplePaidYearly(principlePaidYearly);
			temp.setClosingbal(closingBal);
			charttest.add(temp);
		}
		return charttest;
		
		
	}

}
