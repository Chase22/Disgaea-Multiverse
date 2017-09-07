

public class stats {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int anzahl = 5;
		
		String[] name = new String[anzahl];
		int runde = 0;
		int grenzwert_init = 0;
		
		int modus = 0;
		
		//ab hier wird gerechnet
		if(modus == 0){
            
            int basis = 17;
            int multi = 127;
            int lev = 0;
            double def1;
            double def2;
            double def3;
            int def4;
            int def5;
            int def6;
            while(lev <= 10){
 

                def1 = (((basis * basis) + (lev*0.1)) * ((1 + lev) * 0.0001) + (lev*0.1));
                def2 = (((multi * multi) + (lev*0.1)) * ((1 + lev) * 0.0001) + (lev*0.1));
                def3 = ((lev+1)*0.25)*((lev+1)*0.25);
                def4 = (int) ((int)(def1 * def2 + def3) + basis*1.25 + (lev*(basis*0.3)));
                
                def1 = (((basis * basis) + (lev*0.05)) * ((1 + lev) * 0.000065) + (lev*0.0005));
                def2 = (((multi * multi) + (lev*0.05)) * ((1 + lev) * 0.000065) + (lev*0.0005));
                def5 = (int) ((int)(def1 * def2) + basis + ((lev*(basis*0.2))));
                
                def1 = (((basis * basis) + (lev*0.05)) * ((1 + lev) * 0.000055) + (lev*0.0005));
                def2 = (((multi * multi) + (lev*0.05)) * ((1 + lev) * 0.000055) + (lev*0.0005));
                def6 = (int) ((int)(def1 * def2) + basis*0.75 + ((lev*(basis*0.1))));
                
                System.out.println("Level " + lev + " = HP:" + def4 + ", SP:" + def5 + ", Status:" + def6);
                lev++;


            }
 }
 if(modus == 2){
	 
	 boolean doppelatri = false;
	 boolean magisch = false;
	 
     double atr1 = 11;
     double atr2 = 20.6;
     double multi = 2.5;
     
     double atr3 = 18;
     double atr4 = 0;
     
     double attack;
     double defense;
     
     double min1;
     double min2;
     double min3;
     double min4;
     double max1;
     double max2;
     double max3;
     double max4;
     int minimum;
     int maximum;
     int damage;
     
     
     
     
	 if(doppelatri == true){
		 min1 = ((atr1*0.95) + ((atr1*0.1)*0))*multi;
		 max1 = ((atr1*0.95) + ((atr1*0.1)*1))*multi;
		 atr1 = ((atr1*0.95) + ((atr1*0.1)*Math.random()))*multi;
		 
		 min2 = ((atr2*0.95) + ((atr2*0.1)*0))*multi;
		 max2 = ((atr2*0.95) + ((atr2*0.1)*1))*multi;
		 atr2 = ((atr2*0.95) + ((atr2*0.1)*Math.random()))*multi;
		 
		 min3 = (min1+min2)/2;
		 max3 = (max1+max2)/2;
		 attack = (atr1+atr2)/2;
	 } else {
		 min1 = ((atr1*0.95) + ((atr1*0.1)*0))*multi;
		 max1 = ((atr1*0.95) + ((atr1*0.1)*1))*multi;
		 min3 = min1;
		 max3 = max1;
		 attack = ((atr1*0.95) + ((atr1*0.1)*Math.random()))*multi;
	 }
	 
	 if(magisch == true){
		 min1 = (((atr3*0.2)*0.95) + (((atr3*0.2)*0.1)*0));
		 max1 = (((atr3*0.2)*0.95) + (((atr3*0.2)*0.1)*1));
		 atr3 = (((atr3*0.2)*0.95) + (((atr3*0.2)*0.1)*Math.random()));
		 
		 min2 = (((atr4*0.8)*0.95) + (((atr4*0.8)*0.1)*0));
		 max2 = (((atr4*0.8)*0.95) + (((atr4*0.8)*0.1)*1));
		 atr4 = (((atr4*0.8)*0.95) + (((atr4*0.8)*0.1)*Math.random()));
		 
		 min4 = min1+min2;
		 max4 = max1+max2;
		 defense = atr3 + atr4;
	 } else {
		 
		 min4 = ((atr3*0.95) + ((atr3*0.1)*0));
		 max4 = ((atr3*0.95) + ((atr3*0.1)*1));
		 defense = ((atr3*0.95) + ((atr3*0.1)*Math.random()));
	 }
	 minimum = (int) Math.round((min3 - max4/2));
	 maximum = (int) Math.round((max3 - min4/2));
	 damage = (int) Math.round((attack - defense/2));
	 if(damage < 0) damage = 0;
	 System.out.println("Diese Attacke richtet " + minimum + " bis " + maximum + " Schaden an.\nZiel erleidet " + damage + " Schaden.");
	 
 }

if(modus == 3){
	double atr1 = 10;
	double atr2 = 31;
	int erfolg;
	
	int chance = (int)Math.round(((atr1/atr2)*100));
	if(chance > 100) chance = 100;
	System.out.println("Chance: " + chance + "%");
	erfolg = (int)(100*Math.random()+1);
	if(erfolg <= chance){
		System.out.println("Treffer");
	} else{
		System.out.println("Fehlschlag");
	}
	
	
}

if(modus == 4){

	for(double a = 1 ; a <= 20 ; a++){
		a = a-0.0;
		System.out.println(a + " = " +(a*2.5)*(a*2.5));
	}
	
}
		
		if(modus == 10){
			for(int a = 0 ; a < anzahl ; a++)
			{
				name[a] = "Player " + (a+1);
			}
			// Grenzwerte bestimmen
			while(runde <= 10)
			{
				System.out.println("\nRunde " + runde + "\n");
				
				runde++;
			}
			System.out.println("\nGrenzwert der Initiative " + grenzwert_init + "\nGrenzwert der Bewegung " + grenzwert_init + "\n");
		}
		
		
	}
}
