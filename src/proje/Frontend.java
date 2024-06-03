package proje;
import java.util.Scanner;


public class Frontend
{
	
    static String[] kasiyerler = new String[100]; 
    static int kasiyer = 0;
	////////////////////////////////////////////////
	static void SifreKontrol()  
	{
		Scanner girdi = new Scanner(System.in);
		Okan alıcı = new Okan();
		System.out.println("*** Market otomasyonu uygulamamıza hoşgeldiniz ***");
		 int yanlisGirisHakki = 3;
		 
		    for (int i = 0; i < yanlisGirisHakki; i++)
		    {
		        System.out.print("Lütfen hesabınızın şifresini giriniz: ");
		        int girilenSifre = girdi.nextInt();

		        if (girilenSifre == alıcı.getSifre()) 
		        {
		            System.out.println("Şifre doğru! Giriş yapılıyor...");
		            return; 
		        } else 
		        {
		            System.out.println("Hatalı şifre! Tekrar deneyin. Kalan hakkınız: " + (yanlisGirisHakki - i - 1));
		        }
		    }
		    System.out.println("Giriş hakkınız kalmadı. Hesabınız bloke edilmiştir. Lütfen daha sonra tekrar deneyin.");
		    System.exit(0);
		}
	///////////////////////////////////////////////////
	static class OdemeTipi {
        void odemeYap(int tutar) {
            System.out.println("Ödeme yapıldı. Tutar: " + tutar + " TL");
            System.out.println("Kasiyer: " + kasiyerler[kasiyer - 1]);
        }
    }
    
    static class NakitOdeme extends OdemeTipi {
        @Override
        void odemeYap(int tutar) {
            System.out.println("Nakit ödeme yapıldı. Tutar: " + tutar + " TL");   
            System.out.println("Kasiyer: " + kasiyerler[kasiyer - 1]);
        }
    }
    
    static class KrediKartiOdeme extends OdemeTipi {
        @Override
        void odemeYap(int tutar) {
            System.out.println("Kredi kartı ile ödeme yapıldı. Tutar: " + tutar + " TL");
            System.out.println("Kasiyer: " + kasiyerler[kasiyer - 1]);
        }
    }
	/////////////////////////////////////////////////
	static int method(int a, int b) {    	
	    return a * b;
	}
	
	static int method(int a, int b , int c) {    //overloading
	    return a * b * c;
	}
	/////////////////////////////////////////////////	
	
	public class indirim
	{
		String indirimkart;
		double indirimtutar;
		
		public indirim(String indirimkart ,double indirimtutar)
		{
			this.indirimkart = indirimkart;
			this.indirimtutar = indirimtutar;
		}
		
		public void ekranayazdır()
		{
			System.out.println("Kart : " + indirimkart);
			System.out.println("Kart : " + (indirimtutar * 25));

		} 
	}
	///////////////////////////////////////////////////
	public static void main(String[] args) 
	{
	    Scanner girdi = new Scanner(System.in);
	    
		
		System.out.print("Lütfen kasiyer ismini giriniz: ");
        String kasiyerIsmi = girdi.nextLine();
        kasiyerler[kasiyer++] = kasiyerIsmi;
		
        SifreKontrol();
        
		boolean devam = true;
		int toplamTutar = 0;
		
	    while (devam) 
	    {
	        System.out.println(" ");
	        System.out.println("***************************");
	        System.out.println("*   1. Manav Ürünleri     *");
	        System.out.println("*   2. Market Ürünleri    *");
	        System.out.println("*   3. Şarküteri ürünleri *");
	        System.out.println("*   4. Pastane Ürünleri   *");
	        System.out.println("*   5. Ödeme              *");
	        System.out.println("*   6. Çıkış              *");
	        System.out.println("***************************");
	        System.out.println("Alışveriş yapılan kategoriyi seçiniz =");

        int kategoriSecimi = girdi.nextInt(); 	

        switch (kategoriSecimi) 
        {
        
            case 1:
            	Okan alıcı = new Okan();
                System.out.println("*** Manav Ürünleri kategorisi seçildi.***");
                System.out.println(" ");
                System.out.println("İçindekiler : ");
                System.out.println("(1) Patates KG......9  TL/kg ");
                System.out.println("(2) Domates KG......10 TL/kg");
                System.out.println("(3) Salatalık KG....20 TL/kg ");
                System.out.println("(4) Biber KG........30 TL/kg");
                System.out.println(" ");

                System.out.println("Lütfen bir manav ürünü seciniz : ");
                int ManavSec = girdi.nextInt();

                if (ManavSec == 1)
                {
                    System.out.println(" * Patates sectiniz *");
                    System.out.println("kaç kilo tercih edersiniz ? = ");
                    int kilotercih = girdi.nextInt();
                    int hesap = method(kilotercih , alıcı.getPatates());
                    toplamTutar += hesap;
                    System.out.println("Ücret ="+hesap);

                }
                else if (ManavSec == 2)
                {
                    System.out.println(" * Domates sectiniz *");
                    System.out.println("kaç kilo tercih edersiniz ? = ");
                    int kilotercih2 = girdi.nextInt();
                    int hesap = method(kilotercih2 , alıcı.getDomates());
                    toplamTutar += hesap;
                    System.out.println("Ücret ="+hesap);
                }
                else if (ManavSec == 3)
                {
                    System.out.println(" * Salatalık sectiniz *");
                    System.out.println("kaç kilo tercih edersiniz ? = ");
                    int kilotercih3 = girdi.nextInt();
                    int hesap = method(kilotercih3 , alıcı.getSalatalik());
                    toplamTutar += hesap;
                    System.out.println("Ücret ="+hesap);                }
                else if (ManavSec == 4)
                {
                    System.out.println(" * Biber sectiniz *");
                    System.out.println("kaç kilo tercih edersiniz ? = ");
                    int kilotercih4 = girdi.nextInt();
                    int hesap = method(kilotercih4 , alıcı.getBiber());
                    toplamTutar += hesap;
                    System.out.println("Ücret ="+hesap);
                }
                break;
                
            case 2:
            	Okan alıcı2 = new Okan();
                System.out.println("*** Market Ürünleri kategorisi seçildi.***");
                System.out.println(" ");
                System.out.println("İçindekiler : ");
                System.out.println("(1) Süt...............25 TL/adet ");
                System.out.println("(2) Ekmek.............10 TL/adet");
                System.out.println("(3) Yumurta...........5  TL/adet ");
                System.out.println("(4) Makarna...........20 TL/adet");
                System.out.println(" ");
                System.out.println("Lütfen bir market ürünü seciniz : ");
                int Murunu = girdi.nextInt();

                if (Murunu == 1)
                {
                    System.out.println(" * süt seçtiniz *");
                    System.out.println(" kaç adet tercih edersiniz = ");
                    int Adet = girdi.nextInt();
                    int hesap = method(Adet, alıcı2.getSut());
                    toplamTutar += hesap;
                    System.out.println("Ücret ="+hesap);
                }
                else if (Murunu == 2)
                {
                    System.out.println(" * ekmek seçtiniz *");
                    System.out.println(" kaç adet tercih edersiniz = ");
                    int Adet = girdi.nextInt();
                    int hesap = method(Adet, alıcı2.getEkmek());
                    toplamTutar += hesap;
                    System.out.println("Ücret ="+hesap);
                }
                else if (Murunu == 3)
                {
                    System.out.println(" * yumurta seçtiniz *");
                    System.out.println(" kaç adet tercih edersiniz = ");
                    int Adet = girdi.nextInt();
                    int hesap = method(Adet, alıcı2.getYumurta());
                    toplamTutar += hesap;
                    System.out.println("Ücret ="+hesap);
                }
                else if (Murunu == 4)
                {
                    System.out.println(" * makarna seçtiniz *");
                    System.out.println(" kaç adet tercih edersiniz = ");
                    int Adet = girdi.nextInt();
                    int hesap = method(Adet, alıcı2.getMakarna());
                    toplamTutar += hesap;
                    System.out.println("Ücret ="+hesap);
                }
                break;
                
            case 3:
            	Okan alıcı3 = new Okan();
                System.out.println("*** Şarküteri Ürünleri kategorisi seçildi.***");
                System.out.println(" ");
                System.out.println("İçindekiler : ");
                System.out.println("(1) Peynir.............125 TL/kg");
                System.out.println("(2) Zeytin.............70  TL/kg");
                System.out.println("(3) Bal................90  TL/kg");
                System.out.println("(4) Reçel..............45  TL/kg");

                System.out.println("Lütfen bir kahvaltılık ürünü seciniz : ");
                int Kurunu = girdi.nextInt();

                if (Kurunu == 1)
                {
                    System.out.println(" * peynir sectiniz *");
                    System.out.println("kaç kilo tercih edersiniz ? = ");
                    int kilotercih = girdi.nextInt();
                    int hesap = method(kilotercih, alıcı3.getPeynir());
                    toplamTutar += hesap;
                    System.out.println("Ücret ="+hesap);
                }

                else if (Kurunu == 2)
                {
                    System.out.println(" * zeytin sectiniz *");
                    System.out.println("kaç kilo tercih edersiniz ? = ");
                    int kilotercih = girdi.nextInt();
                    int hesap = method(kilotercih, alıcı3.getZeytin());
                    toplamTutar += hesap;
                    System.out.println("Ücret ="+hesap);
                }

                else if (Kurunu == 3)
                {
                    System.out.println(" * Bal sectiniz *");
                    System.out.println("kaç kilo tercih edersiniz ? = ");
                    int kilotercih = girdi.nextInt();
                    int hesap = method(kilotercih, alıcı3.getBal());
                    toplamTutar += hesap;
                    System.out.println("Ücret ="+hesap);
                }

                else if (Kurunu == 4)
                {
                    System.out.println(" * reçel sectiniz *");
                    System.out.println("kaç kilo tercih edersiniz ? = ");
                    int kilotercih = girdi.nextInt();
                    int hesap = method(kilotercih, alıcı3.getRecel());
                    toplamTutar += hesap;
                    System.out.println("Ücret ="+hesap);
                }
                break;
                
            case 4:
            	Okan alıcı4 = new Okan();
                System.out.println("*** Pastane Ürünleri kategorisi seçildi.***");
                System.out.println(" ");
                System.out.println("İçindekiler : ");
                System.out.println("(1) Cİkolatalı Pasta....130 TL/adet");
                System.out.println("(2) Cheesecake..........95  TL/adet");
                System.out.println("(3) Frutti di Mare......110 TL/adet");
                System.out.println("(4) Muffin..............125 TL/adet");

                System.out.println("Lütfen bir kahvaltılık ürünü seciniz : ");
                int Purunu = girdi.nextInt();

                if (Purunu == 1)
                {
                    System.out.println(" * Cikolatalı pasta seçtiniz *");
                    System.out.println(" kaç adet tercih edersiniz = ");
                    int Adet = girdi.nextInt();
                    int hesap = method(Adet, alıcı4.getCikpasta());
                    toplamTutar += hesap;
                    System.out.println("Ücret ="+hesap);
                }

                else if (Purunu == 2)
                {
                    System.out.println(" * Cheesecake seçtiniz *");
                    System.out.println(" kaç adet tercih edersiniz = ");
                    int Adet = girdi.nextInt();
                    int hesap = method(Adet, alıcı4.getCheesecake());
                    toplamTutar += hesap;
                    System.out.println("Ücret ="+hesap);
                }

                else if (Purunu == 3)
                {
                    System.out.println(" * Frutti di Mare seçtiniz *");
                    System.out.println(" kaç adet tercih edersiniz = ");
                    int Adet = girdi.nextInt();
                    int hesap = method(Adet, alıcı4.getFruttidimare());
                    toplamTutar += hesap;
                    System.out.println("Ücret ="+hesap);
                }

                else if (Purunu == 4)
                {
                    System.out.println(" * Muffin seçtiniz *");
                    System.out.println(" kaç adet tercih edersiniz = ");
                    int Adet = girdi.nextInt();
                    int hesap = method(Adet, alıcı4.getMuffin());
                    toplamTutar += hesap;
                    System.out.println("Ücret ="+hesap);
                }
                break;
            case 5:
            	Okan alıcı1 = new Okan();
            	System.out.println("*** *** *** *** *** *** *** ");
            	System.out.println("Alişverişleriniz tamamlandı.");
            	System.out.println("Toplam tutar: " + toplamTutar + " TL");
            	
            	System.out.println("Ödeme tutarı giriniz = ");
                int Ödeme = girdi.nextInt();
                
                System.out.println("Ödeme tipini seçiniz: ");
                System.out.println("1. Nakit");
                System.out.println("2. Kredi Kartı");
                int odemeSecimi = girdi.nextInt();
                
                OdemeTipi odemeTipi;
                if (odemeSecimi == 1) {
                    odemeTipi = new NakitOdeme();
                    alıcı1.islemTamamlandi();
                } else if (odemeSecimi == 2) {
                    odemeTipi = new KrediKartiOdeme();
                    alıcı1.islemTamamlandi();
                } else {
                    System.out.println("Geçersiz ödeme tipi seçildi.");
                    return;
                }
                
                odemeTipi.odemeYap(Ödeme);              
                System.exit(0);
		case 6:
                devam = false; 
                System.out.println("Programdan çıkılıyor...");
                break;
            default:
                System.out.println("Geçersiz bir seçim yaptınız.");
	}   	
	}
}
}
