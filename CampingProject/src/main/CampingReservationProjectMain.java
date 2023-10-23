package main;

import java.awt.Menu;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import controller.InfoRegisterManager;
import controller.ReservationRegisterManager;
import controller.SitesRegisterManager;
import view.INFO_CHOICE;
import view.MENU_CHOICE;
import view.MenuViewer;
import view.RESERVATION_CHOICE;
import view.SITES_CHOICE;

public class CampingReservationProjectMain {

	public static void main(String[] args) {
		mainMenu();

	}

	public static void mainMenu() {
		int choice;
		boolean flag = false;

		while (!flag) {

			try {
				MenuViewer.mainMenuView();
				choice = MenuViewer.scan.nextInt();
				MenuViewer.scan.nextLine();

				switch (choice) {
				case MENU_CHOICE.SITES:
					SitesMenu();
					break;
				case MENU_CHOICE.INFO:
					InfoMenu();
					break;
				case MENU_CHOICE.RESERVATION:
					ReservationMenu();
					break;
				case MENU_CHOICE.EXIT:
					flag = true;
					System.out.println("프로그램을 종료합니다.");
					break;
				default:
					System.out.println("올바른 숫자를 입력해주세요.");

				}

			} catch (Exception e) {
				System.out.println("입력에 오류가 있습니다. \n 프로그램을 다시 시작하세요.");
				break;
			}
		}

	}

	public static void ReservationMenu() throws Exception{
		int choice;
		
		ReservationRegisterManager reservationManger = new ReservationRegisterManager();
		MenuViewer.reservationMenuView();
		choice = MenuViewer.scan.nextInt();
		MenuViewer.scan.nextLine();
		
		switch(choice) {
		case RESERVATION_CHOICE.LIST :
			System.out.println("");
			reservationManger.ReservationList();
			break;
		case RESERVATION_CHOICE.INSERT :
			System.out.println("");
			reservationManger.reservationRegister();
			break;
		case RESERVATION_CHOICE.DELETE :
			System.out.println("");
			reservationManger.ReservationDelete();
		case RESERVATION_CHOICE.MAIN :
			return;
		default : 
			System.out.println("올바른 숫자를 입력해주세요.");
		}
		
	}

	public static void InfoMenu() throws Exception{
		int choice;
		
		InfoRegisterManager infoManager = new InfoRegisterManager();
		MenuViewer.reservationInfoMenuView();
		choice = MenuViewer.scan.nextInt();
		MenuViewer.scan.nextLine();
		
		switch(choice) {
		case INFO_CHOICE.LIST :
			System.out.println("");
			infoManager.infoTotalList();
			break;
		case INFO_CHOICE.INSERT :
			System.out.println("");
			infoManager.infoRegister();
			break;
		case INFO_CHOICE.UPDATE :
			System.out.println("");
			infoManager.InfoUpdate();
			break;
		case INFO_CHOICE.MAIN :
			return;
		default :
			System.out.println("정확한 숫자를 입력해주세요.");
		}
		
	}

	public static void SitesMenu() throws Exception {
		int num;
		SitesRegisterManager sitesManger = new SitesRegisterManager ();
		MenuViewer.reservationSitesMenuView();
		num = MenuViewer.scan.nextInt();
		MenuViewer.scan.nextLine();
		
		switch(num) {
		case SITES_CHOICE.LIST :
			System.out.println("");
			sitesManger.sitesList();
			break;
		case SITES_CHOICE.INSERT :
			System.out.println("");
			sitesManger.sitesRegister();
			break;
		case SITES_CHOICE.UPDATE :
			System.out.println("");
			sitesManger.sitesUpdate();
			break;
		case SITES_CHOICE.DELETE :
			System.out.println("");
			sitesManger.sitesDelete();
			break;
		case SITES_CHOICE.MAIN :
			return;
		default :
			System.out.println("정확한 숫자를 입력하세요.");
		
		}
		
		
		
	}

}
