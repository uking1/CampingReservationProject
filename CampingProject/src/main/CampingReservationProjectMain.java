package main;

import controller.SitesRegisterManager;
import view.MENU_CHOICE;
import view.MenuViewer;
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
//					InfoMenu();
					break;
				case MENU_CHOICE.RESERVATION:
//					ReservationMenu();
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
			sitesManger.sitesRegistr();
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
