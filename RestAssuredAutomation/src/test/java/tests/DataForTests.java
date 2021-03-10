package tests;

import org.testng.annotations.DataProvider;

public class DataForTests {

	@DataProvider (name="DataToPost") // TestNG data provider, any arbitary name can be used
	public Object[][] dataForPost() {

		//method 1

		//		Object[][] data=new Object[2][3];
		//
		//		data[0][0] = "Albert";
		//		data[0][1] = "Einstein";
		//		data[0][2] = 2;
		//
		//		data[1][0] = "Thomas";
		//		data[1][1] = "Edison";
		//		data[1][2] = 1;
		//
		//
		//		return data;


		//method 2

		return new Object[][] {
			{"Graham","Bell",1},
			{"Henry","Ford",2}
		};
	}

}
