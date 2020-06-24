import java.io.*;
import java.net.*;
public class CalcServer
{
  public static void main(String[] args) throws Exception
  {
      ServerSocket sersock = new ServerSocket(3000);
      System.out.println("Server  ready for calculating");
      Socket sock = sersock.accept( );                          
                              // reading from keyboard (keyRead object)
      //BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
	                      // sending to client (pwrite object)
      OutputStream ostream = sock.getOutputStream(); 
      PrintWriter pwrite = new PrintWriter(ostream, true);

                              // receiving from server ( receiveRead  object)
      InputStream istream = sock.getInputStream();
      BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));

      String receiveMessage/*, sendMessage*/,operator; 
        double operand1,operand2,result=0.0;              
      while(true)
      {
        if((receiveMessage = receiveRead.readLine()) != null)  
        {  
            try
				{  
                    String[] expr= receiveMessage.split(" ");
                    operand1= Integer.parseInt(expr[0]);
                    operator= expr[1];
                    operand2=Integer.parseInt(expr[2]);
                    switch(operator){
                        case "+" : result = operand1 + operand2 ;
                                    break;
                        case "-" : result = operand1 - operand2 ;
                                    break;
                        case "*" : result = operand1 * operand2 ;
                                    break;
                        case "/" : result = operand1 / operand2 ;
                                    break;
                        case "%" : result = operand1 % operand2 ;
                                    break;
                        default: System.out.println("Wrong Operator");
                    } 
            }      
           
            catch(Exception i) 
				{ 
					System.out.println(i); 
				}
        }
        //sendMessage = keyRead.readLine(); 
        System.out.println(receiveMessage+ " Calculated.");
        pwrite.println(result);             
        pwrite.flush();
      }               
    }                    
}                        
