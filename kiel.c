#include<lpc214x.h>
void uart_init(void);
unsigned int delay;
unsigned char *ptr;
unsigned char arr[]="KISHORE \r";
int main()
{
while(1)                                                                                                                                                                                                                                                                                                                                                                            
{
uart_init();
ptr=arr;
while(*ptr!='\0')                      
{
U0THR=*ptr++;
while(!(U0LSR & 0x40)==0*40)
for(delay=0;delay<=600;delay++);
   

}
for(delay=0;delay<=60000;delay++);
}
}
void uart_init(void)
{
PINSEL0=0x00000005;
U0LCR=0x00000083;
U0DLM=0x00;
U0DLL=0x13;
U0LCR=0x00000003;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
}


002

  #include<lpc214x.h>
void clock_wise(void);
void anti_clock_wise(void);
unsigned int j=0;
int main()
{
IO0DIR=0X00000900;
IO0SET=0X00000100;
while(1)
{
clock_wise();
for (j=0;j<400000;j++);
anti_clock_wise();
for (j=0;j<400000;j++);
}
}
void clock_wise(void)
{
IO0CLR=0X00000900;
for (j=0;j<10000;j++);
IO0SET=0X00000900;
}
void anti_clock_wise(void)
	{
IO0CLR=0X00000900;
for(j=0;j<10000;j++);
IO0SET=0X00000100;
}


003
  
	#include <LPC21xx.H>
void clock_wise(void); 
void anti_clock_wise(void);
unsigned long int var1,var2; 
unsigned int i=0,j=0,k=0; 
int main(void) 
{ 
PINSEL0 = 0x00FFFFFF; //P0.12 to P0.15 GPIo 
IO0DIR = 0x0000F000; //P0.12 to P0.15 output
while(1) 
{ 
for(j=0;j<50;j++) // 50 times in Clock wise Rotation(360 degree) 
clock_wise(); 
for(k=0;k<650000;k++);  // Delay to show anti_clock Rotation 
for(j=0;j<50;j++) // 50 times in Anti Clock wise Rotation(360 degree) 
anti_clock_wise(); 
	for(k=0;k<650000;k++); // Delay to show clock Rotation
} // End of while(1)
} // End of main 
void clock_wise(void) 
{ var1 = 0x00000800; //For Clockwise 
for(i=0;i<=3;i++) // for A B C D Stepping 
{ var1 = var1<<1; //For Clockwise
IO0PIN = var1; 
for(k=0;k<3000;k++); //for step speed variation 
} 
}
void anti_clock_wise(void) 
{ 
var1 = 0x00010000;  //For Anticlockwise 
for(i=0;i<=3;i++) // for A B C D Stepping
{ 
var1 = var1>>1; //For Anticlockwise 
IO0PIN = var1; 
for(k=0;k<3000;k++); //for step speed variation
}
}



004

  #include <LPC21xx.h> 
/*\\\\\\\\\\\\\\\DISPLAY ARE CONNECTED IN COMMON CATHODE 
MODE\\\\\\\\\\\\\\\\\\\\\ Port0 Connected to data lines of all 7 segment displays
a ---- f| g |b |----| e| |c ---- . dot d
a = P0.10
b = P0.11
c = P0.12 
d = P0.13
e = P0.18
f = P0.19
g = P0.20
dot = P0.21 
Select lines for four 7 Segments
DIS1 P0.28 
DIS2 P0.29 
DIS3 P0.30 
DIS4 P0.31 */ 
unsigned int delay, count=0, Switchcount=0; 
unsigned int Disp[16]={0x003F0000, 0x00060000, 0x005B0000, 
0x004F0000, 0x00660000,0x006D0000, 0x007D0000, 0x00070000, 
0x007F0000, 0x006F0000, 0x00770000,0x007C0000,0x00390000, 
0x005E0000, 0x00790000, 0x00710000 }; 
#define SELDISP1 0x10000000 //P0.28 
#define SELDISP2 0x20000000 //P0.29 
#define SELDISP3 0x40000000 //P0.30 
#define SELDISP4 0x80000000 //P0.31 
#define ALLDISP  0xF0000000 //Select all display 
#define DATAPORT 0x00FF0000   //P0.16 to P0.23 : Data lines connected to drive Seven Segments
int main (void) 
{
PINSEL0 = 0x00000000; 
PINSEL1 = 0x00000000;
IO0DIR = 0xF0FF0000; 
IO1DIR = 0x01000000; 
while(1) { //Display values on Seven Segment 
IO0SET |= ALLDISP; 
IO0CLR = 0x00FF0000;
//for(delay=0;delay<100;delay++)
IO0SET = Disp[Switchcount]; 
// display the values 0 to F one after the other
for(delay=0;delay<1000000;delay++) 
{ } 
Switchcount++; 
if(Switchcount == 16) // after F go back to 0
{ 
Switchcount = 0; 
} 
}
} 

005

  #include <lpc214x.h>
void Extint0_Isr(void)__irq;
unsigned char int_flag=0,flag=0;
int main()
{
 IO1DIR=0x02000000;
 IO1SET=0x02000000;
 PINSEL1=0x00000001;
 EXTMODE=0x01;
 EXTMODE=0x00;
 VICVectAddr0=(unsigned long)Extint0_Isr;
 VICVectCntl0=0x20|14;
 VICIntEnable|=0x00004000;
 while(1)
 {
  if(int_flag==0x01)
  {
   if(flag==0)
   {
    IO1CLR=0x02000000;
	flag=1;
   }
   else if(flag==1)
   {
    IO1SET=0x02000000;
	flag=0;
   }
   int_flag=0x00;
  }
 }
}
void Extint0_Isr(void)__irq
{
 EXTINT|=0X01;
 int_flag=0x01;
 VICVectAddr=0;
}

006

  #include <lpc21xx.h> 
unsigned int var; 
void delay(void); 
int main () 
{
PINSEL0 = 0x00000000 ; // Configure P0.0 to P0.15 as GPIO 
PINSEL1 = 0x00000000 ; // Configure P0.16 to P0.31 as GPIO 
IO0DIR = 0x00FF0000 ; 
while(1) 
{ 
IO0PIN = 0x00000000;
var= 0x00000000; 
delay(); 
IO0PIN = 0x00FF0000;
var= 0x00FF0000;
delay(); 
}
} 
void delay(void)
{ 
unsigned int i=0; 
for(i=0;i<=70000;i++); 
	
}

007
  #include <LPC21xx.h> 
unsigned long int temp=0x00000000; 
int main ()
{
unsigned int i=0; 
IO0DIR=0x00FF0000; 
while(1) 
{ 
// output 0 to FE 
for(i=0;i!=0xFF;i++) 
{ 
temp=i; 
temp = temp << 16;
IO0PIN=temp;
} 
// output FF to 1 
for(i=0xFF; i!=0;i--)
{ 
temp=i; 
temp = temp << 16; 
IO0PIN=temp;
}
}
//End of while(1)
}//End of main( )
