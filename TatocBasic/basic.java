class basic
{
	public static void main(String args[])
	{
		File binaryPath=new File("/home/anuraggarg/Downloads/firefox/firefox");
		FirefoxBinary ffbinary=new FirefoxBinary(binaryPath);
		FirefoxPrifile ffprofile=new FirefoxProfile();
		WebDriver driver=new FirefoxDriver(ffbinary,ffprofile);
		driver.get("http://10.0.1.86/tatoc/basic/grid/gate");
		
	}
}