package com.uiFramework.inszoom.regrationTesting.FormsLoad.testSccripts.addFormsFromExcel;

import com.uiFramework.inszoom.regrationTesting.FormsLoad.pageObject.AddFormsFromExcel.LoadFormsFromExcel;
import com.uiFramework.inszoom.regrationTesting.testbase.TestBase;

public class AddFromsFromExcel extends TestBase {
	
	public void testAddFormsFromExcelSheet(String formIDs) {
		LoadFormsFromExcel loadForms = new LoadFormsFromExcel(driver);
		loadForms.loadFormsListFromExcel(formIDs);
		
	}

}
