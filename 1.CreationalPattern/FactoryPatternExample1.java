import java.io.*;

abstract class Plan{

   protected double  rate ;

   abstract void getRate();

   public void calculateBill(int units ){

       System.out.println(units * rate ) ;
   }

 }


 class DomesticPlan extends Plan{


    public void getRate(){
        rate = 3.50;
    }
 }




 class InstitutionalPlan  extends Plan {


    public void getRate(){
        rate = 5.50;
    }
 }



 class CommercialPlan extends Plan {

      public void getRate(){
        rate = 7.50 ;
      }
 }




 class GetPlanFactory {


     public Plan getPlan(String planType){

        if(planType == null){
            return null;
        }
  
         if(planType.equalsIgnoreCase("DomesticPlan")){
            return new DomesticPlan();
        }
        else if(planType.equalsIgnoreCase("InstitutionalPlan")){
            return new InstitutionalPlan();
        }
        else if(planType.equalsIgnoreCase("CommercialPlan")){
            return new CommercialPlan();
        }
     return null;
      
     }

 }


class FactoryPatternExample1 {

   public static void main(String[] arg) throws Exception {

         GetPlanFactory  planFactory = new GetPlanFactory();
  
         System.out.print("Enter the name of plan for which the bill will be generated: ");  
         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

         String planName = br.readLine();
         System.out.println("Enter the number of unites for bill to be calculated");
         int units = Integer.parseInt(br.readLine());


         Plan p = planFactory.getPlan(planName);  
         //call getRate() method and calculateBill()method of DomesticPaln.  
  
        System.out.print("Bill amount for "+planName+" of  "+units+" units is: ");  
           p.getRate();  
           p.calculateBill(units); 

   }

    
}