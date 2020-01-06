package model;

public class TCPData 
{
	private PunchingIO punchData;
	
	public TCPData()
	{
		setPunchData(null);
	}
	
	public TCPData(PunchingIO listPunching)
	{
		setPunchData(listPunching);
	}

	public PunchingIO getPunchData() {
		return punchData;
	}

	public void setPunchData(PunchingIO punchData) {
		this.punchData = punchData;
	}
}
