package Utilities;

public class excelster {

	public static void main(String[] args) throws Exception {
		
		xlutils efu=new xlutils();
		
		int totalRows=efu.rowcount("MasterTestCases");
		System.out.println(totalRows);
		
		int totalColumns=efu.colcount("MasterTestCases");
		System.out.println(totalColumns);
		
		String celldata=efu.gatdata("MasterTestCases", 4, 2);
		System.out.println(celldata);
		
	}

}
