package controller;

import java.util.Scanner;


import model.InfoVO;
import model.ReservationVO;
import model.SitesVO;

public class ReservationRegisterManager {
    public static Scanner scan = new Scanner(System.in);

    // 예약사이트 확인
    public void ReservationList() throws Exception {
        String reservation_id; // 예약자 아이디
        String reservation_pw; // 예약자 비밀번호
        String mainMenu; // 메인메뉴

        boolean flag = false;

        ReservationDAO rdo = new ReservationDAO();
        InfoDAO ido = new InfoDAO();

        System.out.println("예약한 사이트");
        do {
            System.out.print("아이디 : ");
            reservation_id = scan.nextLine();
            System.out.print("비밀번호 : ");
            reservation_pw = scan.nextLine();
            flag = ido.getInfoLogin(reservation_id, reservation_pw);

            if (!flag) {
                System.out.println("아이디 또는 비밀번호가 틀립니다.");
                System.out.print("메인 메뉴로 이동합니다.(Y) : ");
                mainMenu = scan.nextLine();
                if (mainMenu.equalsIgnoreCase("Y")) {
                    return;
                }
                System.out.println();
            }

        } while (!flag);

        InfoVO info = ido.getInfo(reservation_id, reservation_pw); // 정보를 받아옴
        System.out.println();
        System.out.println("예약한 좌석");
        rdo.getReservationTotalList(info); // InfoVO 객체를 전달하여 예약 정보를 가져옴
        System.out.println();
    }

    // 예약 신청 관리
    public void reservationRegister() throws Exception {
        ReservationDAO rdo = new ReservationDAO();
        ReservationVO rv = new ReservationVO();

        SitesDAO sdo = new SitesDAO();
        SitesVO sv = new SitesVO();
        InfoDAO ido = new InfoDAO();

        String site_id; // 사이트 구역
        String site_num; // 사이트 번호
        String reservation_id; // 예약자 ID
        String reservation_pw; // 예약자 PW
        String mainMenu; // 메인메뉴
        boolean flag = false;

        System.out.println("예약 가능 사이트 목록");
        sdo.getSitesTotalList();
        System.out.println();

        System.out.println("예약을 위한 정보 입력");
        do {
            System.out.print("아이디 : ");
            reservation_id = scan.nextLine();
            System.out.print("비밀번호 : ");
            reservation_pw = scan.nextLine();

            flag = ido.getInfoLogin(reservation_id, reservation_pw);

            if (!flag) {
                System.out.println("아이디 또는 비밀번호가 틀립니다. 다시 입력해주세요.");
                System.out.print("메인 메뉴로 이동(Y) : ");
                mainMenu = scan.nextLine();
                if (mainMenu.equalsIgnoreCase("Y")) {
                    return;
                }
                System.out.println();
            }
        } while (!flag);

        InfoVO info = ido.getInfo(reservation_id, reservation_pw); // 정보를 받아옴

        System.out.print("사이트 구역: ");
        site_id = scan.nextLine();
        System.out.print("사이트 번호: ");
        site_num = scan.nextLine();
        
        
        rv.setSite_id(site_id);
        rv.setSite_num(site_num);
        

        // 예약 등록
        rdo.setReservationRegiste(rv);

        System.out.println();
        System.out.println("예약 목록 현황");
        rdo.getReservationTotalList(info);
        System.out.println();
    }

    // 예약 취소 관리
    public void ReservationDelete() throws Exception {
        ReservationDAO rdo = new ReservationDAO();
        ReservationVO rv = new ReservationVO();
        InfoDAO ido = new InfoDAO();

        String site_id; // 사이트 번호
        String r_no; // 예약 일련번호
        String reservation_id; // 예약자 ID
        String reservation_pw; // 예약자 PW
        String mainMenu; // 메인메뉴

        boolean flag = false;

        System.out.println("예약 취소를 위한 정보 입력");

        do {
            System.out.print("아이디 : ");
            reservation_id = scan.nextLine();
            System.out.print("비밀번호 : ");
            reservation_pw = scan.nextLine();

            flag = ido.getInfoLogin(reservation_id, reservation_pw);

            if (!flag) {
                System.out.println("아이디 또는 비밀번호가 틀립니다. 다시 입력해주세요.");
                System.out.print("메인 메뉴로 이동(Y) : ");
                mainMenu = scan.nextLine();
                if (mainMenu.equalsIgnoreCase("Y")) {
                    return;
                }
                System.out.println();
            }

        } while (!flag);
        InfoVO info = ido.getInfo(reservation_id, reservation_pw); // 정보를 받아옴

        System.out.println();
        System.out.println("예약한 사이트");
        rdo.getReservationTotalList(info);
        System.out.println();

        System.out.println("예약 취소할 일련번호 입력");
        System.out.print("일련번호 : ");
     
     int reservationNumber = Integer.parseInt(scan.nextLine());
     rdo.setReservationDelete(reservationNumber);


        System.out.println();
        System.out.println("예약 취소 후 목록");
        rdo.getReservationTotalList(info);
        System.out.println();
    }
}

