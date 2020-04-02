
class Member 
{	
	public boolean isRoman = false;
	private String[] numRoman = {"0","I","II","III","IV","V","VI","VII","VIII","IX","X"};
	private  Integer Value =0;
	
	
	public void setValue( String aStr)
	{
		int ret=0;				
		
		for ( int j = 0 ; j < numRoman.length ; j++ )
		{
			if( aStr.equals(numRoman[j]) )
			{
				isRoman = true;
				Value = j;
				
			}
		}
		
		try
		{
                    if (!isRoman) Value = Integer.parseInt(aStr) ;
		}
		catch( Exception e )
		{ 
			System.out.println( "Not a number" ) ;
		}
                
                
		
	}
	
	public Integer getValue()
	{
		return Value;
	}
	
	public String getRomanValue(int iVal)
	{
		String ret = numRoman[iVal];		
		return ret;
	}
	
	
}
