package miniProject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import miniProject.LibDataSet;
import miniProject.LibraryVO;
import miniProject.pubDataSet;
import miniProject.publishingHouseVO;
import miniProject.auDataSet;
import miniProject.authorVO;

public class LibStart {
	Scanner scan = new Scanner(System.in);

	public LibStart() {
		start();
	}

	public void start() {

		// pubDataSet pub = new pubDataSet();
		// publishingHouseVO pVO = new publishingHouseVO();
		// 작성자 표시
		System.out.println("작성자: 이민호");
		System.out.println("관리자 아이디:dlalsgh242");
		System.out.println("관리자 비밀번호:ehd159");
		System.out.println("사용자 아이디:user");
		System.out.println("사용자 비밀번호:123");
		// 1이면 관리자 모드,2이면 사용자 모드
		System.out.println("1:관리자 모드,2:사용자 모드");
		int number = scan.nextInt();
		scan.nextLine();

		// 기본데이터 셋팅
		LibDataSet.basicDataSet();
		pubDataSet.basicDataSet1();
		auDataSet.basicDataSet2();

		if (number == 1) {
			String manId = conInput("관리자 아이디");
			String manPwd = conInput("비밀번호");
			LoginTest lo = new LoginTest(manId, manPwd);
			if (lo.LogChk()) {// 로그인시

				do {
					String menu = conInput("메뉴(1:전체 책목록,2:책을 등록,3:출판사 정보,4:저자 정보,5:수정,6:삭제7:종료):");
					if (menu.equals("1")) {
						// 전체 책목록
						allBook();

					} else if (menu.equals("2")) {
						// 책을 등록
						try {
							LibRegister();// 등록
							System.out.println("책이 등록되었습니다.");
							allBook();// 전체 책목록

						} catch (NumberFormatException cfe) {
							System.out.println("책은 문자여야 합니다.다시 입력하세요.");
						}
					} else if (menu.equals("3")) {
						// 출판사 정보 등록
						System.out.println("출판사 정보 등록");
						pbCrystal();
						System.out.println("출판사 목록");
						pbRegister();
					} else if (menu.equals("4")) {
						// 저자 정보 등록
						System.out.println("저자 정보 등록");
						auCrystal();
						System.out.println("저자 목록");

						auRegister();
					} else if (menu.equals("5")) {
						// 수정
						LibEdit();
						// allBook();
						allBook();
					} else if (menu.equals("6")) {
						// 삭제
						LibRemove();
						allBook();
					} else if (menu.equals("7")) {// 종료
						System.out.println("프로그램이 종료되었습니다.");
						break;
					} else {// 문자를 입력했을떄
						System.out.println("존재하지 않은 메뉴이거나, 메뉴는 숫자여야 합니다.");

					}

				} while (true);
			} else {// 로그인이 실패했을떄
				System.out.println("아이디 또는 비밀번호를 잘못입력하였습니다.");
				start();
			}
		} else if (number == 2) {// 사용자

			String userId = conInput("사용자 아이디");
			String userPwd = conInput("비밀번호");

			LoginTest userLo = new LoginTest(userId, userPwd);
			if (userLo.LogChk()) {// 사용자로 로그인 했을떄

				// 기본데이터 셋팅
				LibDataSet.basicDataSet();
				do {
					String menu = conInput("메뉴(1:책 목록,2:도서명 검색,3:저자명 검색,4:출판사명 검색,5:출판사 정보,6:저자 정보):");
					if (menu.equals("1")) {// 책 목록
						allBook();
					} else if (menu.equals("2")) {// 도서명 검색
						bookSeach();
					} else if (menu.equals("3")) {// 저자명 검색
						auSeach();
					} else if (menu.equals("4")) {// 출판사명 검색
						pubSeach();
					} else if (menu.equals("5")) {// 출판사 정보
						pbRegister();
					} else if (menu.equals("6")) {// 저자 정보
						auRegister();
					} else {
						System.out.println("메뉴를 다시 입력하세요(메뉴는 숫자입니다.)");
					}
				} while (true);
			} else {// 로그인 실패했을떄
				System.out.println("잘못입력 하였습니다.");
				start();
			}
		} else {// 잘못 입력 했을떄
			System.out.println("다시 입력하세요.");

			start();
		}

	}

	// 책목록
	public void allBook() {
		Set<String> key = LibDataSet.list.keySet();
		Iterator<String> keyList = key.iterator();
		while (keyList.hasNext()) {
			LibraryVO ry = LibDataSet.list.get(keyList.next());
			System.out.printf(" %16s %6s %8s %16s %6s %8s\n", ry.getBookName(), ry.getAuthor(), ry.getGenre(),
					ry.getPublishingHouse(), ry.getAuthorEmail(), ry.getMoney());

		}
		System.out.println("총" + key.size() + "권");
	}

	// 책 등록
	public void LibRegister() {
		// 책을 등록할려는 데이터를 입력받아 HashMap에 추가한다.
		LibraryVO ry = new LibraryVO();
		ry.setBookName(conInput("책이름"));
		ry.setAuthor(conInput("저자"));
		ry.setGenre(conInput("장르"));
		ry.setPublishingHouse(conInput("출판사"));
		ry.setAuthorEmail(conInput("저자 이메일"));
		ry.setMoney(conInput("가격"));
		LibDataSet.list.put(ry.getBookName(), ry);

	}

	// 수정
	public void LibEdit() {
		// 책이름,저자,장르,출판사,이메일
		String LibName = conInput("수정할 책:");
		LibraryVO ry = LibDataSet.list.get(LibName);

		if (ry != null) {
			String part = conInput("수정할 목록[1:책이름,2:저자,3:장르,4:출판사,5:이메일,6:가격]:");
			if (part.equals("1")) {// 책이름 수정
				String editData = conInput("책이름");
				ry.setBookName(editData);
			} else if (part.equals("2")) {// 저자명 수정
				String editData = conInput("저자명");
				ry.setAuthor(editData);
			} else if (part.equals("3")) {// 장르 수정
				String editdata = conInput("장르명");
				ry.setGenre(editdata);
			} else if (part.equals("4")) {// 출판사
				String editdata = conInput("출판사 명");
				ry.setPublishingHouse(editdata);
			} else if (part.equals("5")) {// 이메일
				String editdata = conInput("이메일 명");
				ry.setAuthorEmail(editdata);
			} else if (part.equals("6")) {// 가격
				String editdata = conInput("가격");
				ry.setMoney(editdata);
			} else {// 예외 처리
				System.out.println("입력하신 목록이 없습니다.");
			}
		} else {
			System.out.println("수정하지 못하였습니다. 다시 수정하세요.");
		}
	}

	// 책 삭제
	public void LibRemove() {
		String bookName = conInput("삭제할 책이름 입력");
		LibDataSet.list.remove(bookName);
	}

	// 출판사 정보
	public void pbRegister() {
		Set<String> key = pubDataSet.list1.keySet();
		Iterator<String> keyList = key.iterator();
		// System.out.println(keyList.hasNext());
		while (keyList.hasNext()) {
			publishingHouseVO pb = pubDataSet.list1.get(keyList.next());
			System.out.printf(" %8s %16s %16s %8s \n", pb.getPubName(), pb.getPubPhone(), pb.getPubEmail(),
					pb.getPubFirstName());
		}
	}

	// 출판사 정보 등록
	public void pbCrystal() {
		// 책을 등록할려는 데이터를 입력받아 HashMap에 추가한다.
		publishingHouseVO pb = new publishingHouseVO();
		pb.setPubName(conInput("출판사 이름"));
		pb.setPubPhone(conInput("출판사 전화번호"));
		pb.setPubEmail(conInput("출판사 이메밀"));
		pb.setPubFirstName(conInput("출판사 대표자명"));

		pubDataSet.list1.put(pb.getPubName(), pb);
	}

	// 저자 정보
	public void auRegister() {
		Set<String> key = auDataSet.list2.keySet();
		Iterator<String> keyList = key.iterator();
		while (keyList.hasNext()) {
			authorVO au = auDataSet.list2.get(keyList.next());
			System.out.printf("%10s %16s %10s %16s %16s \n", au.getAuthorName(), au.getDebutDate(), au.getDebutWork(),
					au.getAuEmail(), au.getAuHomeAdress());
		}
	}

	// 저자 정보 등록
	public void auCrystal() {
		// 책을 등록할려는 데이터를 입력받아 HashMap에 추가한다.
		authorVO au = new authorVO();
		au.setAuthorName(conInput("저자명"));
		au.setDebutDate(conInput("데뷔 일자"));
		au.setDebutWork(conInput("데뷔 작품"));
		au.setAuEmail(conInput("저자 이메일"));
		au.setAuHomeAdress(conInput("저자 홈페이지주소"));

		auDataSet.list2.put(au.getDebutDate(), au);
	}

	// 도서명 검색
	public void bookSeach() {
		String str = conInput("찾으실 도서명을 입력하세요:");
		Set<String> key = LibDataSet.list.keySet(); // 객체로 변환
		Iterator<String> keyList = key.iterator();
		while (keyList.hasNext()) { // key값이 있는지 확인하고 실행한다.
			String key1 = keyList.next();
			LibraryVO vo = LibDataSet.list.get(key1); // get객체로 내보내기
			if (vo.getBookName().indexOf(str) != -1) {
				System.out.printf("%6s %6s\t %6s\t %6s\t %10s\t %10s\n ", vo.getBookName(), vo.getAuthor(),
						vo.getGenre(), vo.getPublishingHouse(), vo.getAuthorEmail(), vo.getMoney());
			}

		}
	}

	// 출판사 검색
	public void pubSeach() {
		String str = conInput("찾으실 출판사를  입력하세요:");
		Set<String> key = pubDataSet.list1.keySet(); // 객체로 변환
		Iterator<String> keyList = key.iterator();
		while (keyList.hasNext()) {
			String key1 = keyList.next();
			publishingHouseVO vo = pubDataSet.list1.get(key1);
			if (vo.getPubName().indexOf(str) != -1) {
				System.out.printf("%6s %6s\t %6s\t %6s\n ", vo.getPubName(), vo.getPubPhone(), vo.getPubEmail(),
						vo.getPubFirstName());
			}
		}
	}

	// 저자명 검색
	public void auSeach() {
		String str = conInput("찾으실 저자명을 입력하세요:");
		Set<String> key = auDataSet.list2.keySet();
		Iterator<String> keyList = key.iterator();
		while (keyList.hasNext()) {
			String key1 = keyList.next();
			authorVO vo = auDataSet.list2.get(key1);
			if (vo.getAuthorName().indexOf(str) != -1) {
				System.out.printf("%s\t %-8s\t %s\t %s\t %s\n ", vo.getAuthorName(), vo.getDebutDate(),
						vo.getDebutWork(), vo.getAuEmail(), vo.getAuHomeAdress());
			}
		}
	}

	public String conInput(String msg) {
		System.out.println(msg + "=");
		return scan.nextLine();

	}

	public static void main(String[] args) {
		new LibStart();

	}

}
