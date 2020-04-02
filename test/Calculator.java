
import java.util.Scanner;

public class Calculator {

    


	private static Member[] operands = new Member[2];
	private static String arithActionString ;
	
	
	public static void main ( String[] args ) 
	{
		operands[0] = new Member();
		operands[1] = new Member();
		System.out.println( "Enter an operation (for example: 4 + 6)" ) ;
		Scanner in = new Scanner(System.in);
		String aStr = in.nextLine();
		ParseString(aStr);
		int Output = arithAction();
		if(!conditions(Output)) 
		{
			if (operands[0].isRoman) 
                        {
                            String sOutput = operands[0].getRomanValue(Math.abs(Output));
                            if(Output<0) sOutput = "-"+sOutput;
                            System.out.println(sOutput);
                        }
			else System.out.println(Output+"");
			
		}else System.out.println("Errors");
	}
	
	private static void ParseString(String aStr1)
	{
		String[] act = {"+","-","*","/"} ;
		
		int k ;
		for ( int j = 0 ; j < act.length ; j++ )
		{
			k = aStr1.indexOf(act[j]);
			if( k>-1 )
			{
				arithActionString = act[j].trim();
				operands[0].setValue(aStr1.substring(0,k).trim());				
				operands[1].setValue(aStr1.substring(k+1).trim());		
								
				break;
			}
		}	
	}
	
	
	
	private static Integer arithAction()
	{
            int ret = -1000;
            try
            {
                if(arithActionString.equals("+")) ret = operands[0].getValue()+operands[1].getValue();
		if(arithActionString.equals("-")) ret = operands[0].getValue()-operands[1].getValue();
		if(arithActionString.equals("*")) ret = operands[0].getValue()*operands[1].getValue();
		if(arithActionString.equals("/")) ret = operands[0].getValue()/operands[1].getValue();
		
            }catch(Exception e)
            {
                System.out.println("Недопустимая операция!");
            }
            
            return ret;
                    
	}
	
	private static boolean conditions(int Result)
	{
		boolean ret = false;	//нет ошибок
		//проверка на арабские или римские цифры  в обоих операндах
		if(operands[0].isRoman ^ operands[1].isRoman)  {ret = true; System.out.println( "Operands Arab and Roman !" );} 
		//проверка , если римские результат не больше 10
		if(operands[0].isRoman && Result>10)  {ret = true; System.out.println( "Operands Roman and Result > 10 !" );} 
		//проверка слагаемые не больше 10
                if(operands[0].getValue() > 10 || operands[1].getValue() > 10)  {ret = true; System.out.println( "Operands  > 10 !" );} 
		
		return ret;
	}
}
