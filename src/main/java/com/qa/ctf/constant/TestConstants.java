package com.qa.ctf.constant;

/**
 * This class contains constants used across the application for test configuration,
 * file paths, test case details, browser details, environment details, browser options,
 * application URL, wait times, test statuses, and extent report configurations.
 * <p>
 * The constants are organized into categories and include file paths for configuration,
 * report generation, and test data; test case execution settings; browser-specific options;
 * environment modes; and reporting details.
 * <p>
 * These constants provide a centralized location for managing static configuration
 * values, promoting reusability and reducing duplication in the codebase.
 *
 * @author Jagatheshwaran N
 * @version 1.1
 */
public class TestConstants {

	// Browser Details
	public static final String CHROME = "Chrome";
	public static final String FIREFOX = "Firefox";
	public static final String EDGE = "Edge";

	// Run Type Details
	public static final String LOCAL = "LOCAL";
	public static final String REMOTE = "REMOTE";

	// Env Details
	public static final String ENV_TYPE = "EnvType";
	public static final String STAGE = "STAGE";
	public static final String PROD = "PROD";

	public static final String OPTION_YES = "Yes";
	public static final String OPTION_NO = "No";

	// Browser Option Details
	public static final String BROWSER_PRIVATE_MODE = "Private";
//	public static final String BROWSER_PRIVATE_MODE_YES = "Yes";
	public static final String CHROME_REMOTE_ORIGIN = "--remote-allow-origins=*";
	public static final String BROWSER_MAXIMIZE = "--start-maximized";
	public static final String EDGE_BROWSER_MAXIMIZE = "start-maximized";
	public static final String CHROME_INCOGNITO = "incognito";
	public static final String EDGE_PRIVATE = "-inprivate";
	public static final String FIREFOX_PRIVATE = "--private";

	// User Directory
	public static final String CWD = System.getProperty("user.dir");

	// File Path Details
	public static final String CONFIG_FILE_PATH = "/src/test/resources/config/$.properties";
	public static final String EXCEL_FILE_PATH = "/src/test/resources/data/testData.xlsx";

	// App URL
	public static final String APP_URL = "AppUrl";
	public static final String BASE_URI = "https://askomdch.com";

	// Grid URL
	public static final String GRID_URL = "RemoteUrl";

	// Wait Time Details
	public static final int EXPLICIT_WAIT_TIME = 5;
	public static final int WAIT_TIME = 5000;

	// Date Time Details
	public static final String DATE_FORMAT = "dd_MM_yyyy_hh_mm_ss";
	public static final String MONTH_FORMAT = "MMMM";
	public static final String TIME_HR_FORMAT = "hh";

	// Encryption Details
	public static final String ALGORITHM = "AES";
	public static final String SECRET_KEY = "MySecretKeyForSecurity25";

	// Screenshot Details
	public static final String SNAPSHOT_PATH = "//src//test//resources//screenshots//";
	public static final String FULL_PAGE_SCREENSHOT = "FullPageScreenShot";
	public static final String IMG_PNG_FORMAT = "image/png";

}
