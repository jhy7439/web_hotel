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
		// �ۼ��� ǥ��
		System.out.println("�ۼ���: �̹�ȣ");
		System.out.println("������ ���̵�:dlalsgh242");
		System.out.println("������ ��й�ȣ:ehd159");
		System.out.println("����� ���̵�:user");
		System.out.println("����� ��й�ȣ:123");
		// 1�̸� ������ ���,2�̸� ����� ���
		System.out.println("1:������ ���,2:����� ���");
		int number = scan.nextInt();
		scan.nextLine();

		// �⺻������ ����
		LibDataSet.basicDataSet();
		pubDataSet.basicDataSet1();
		auDataSet.basicDataSet2();

		if (number == 1) {
			String manId = conInput("������ ���̵�");
			String manPwd = conInput("��й�ȣ");
			LoginTest lo = new LoginTest(manId, manPwd);
			if (lo.LogChk()) {// �α��ν�

				do {
					String menu = conInput("�޴�(1:��ü å���,2:å�� ���,3:���ǻ� ����,4:���� ����,5:����,6:����7:����):");
					if (menu.equals("1")) {
						// ��ü å���
						allBook();

					} else if (menu.equals("2")) {
						// å�� ���
						try {
							LibRegister();// ���
							System.out.println("å�� ��ϵǾ����ϴ�.");
							allBook();// ��ü å���

						} catch (NumberFormatException cfe) {
							System.out.println("å�� ���ڿ��� �մϴ�.�ٽ� �Է��ϼ���.");
						}
					} else if (menu.equals("3")) {
						// ���ǻ� ���� ���
						System.out.println("���ǻ� ���� ���");
						pbCrystal();
						System.out.println("���ǻ� ���");
						pbRegister();
					} else if (menu.equals("4")) {
						// ���� ���� ���
						System.out.println("���� ���� ���");
						auCrystal();
						System.out.println("���� ���");

						auRegister();
					} else if (menu.equals("5")) {
						// ����
						LibEdit();
						// allBook();
						allBook();
					} else if (menu.equals("6")) {
						// ����
						LibRemove();
						allBook();
					} else if (menu.equals("7")) {// ����
						System.out.println("���α׷��� ����Ǿ����ϴ�.");
						break;
					} else {// ���ڸ� �Է�������
						System.out.println("�������� ���� �޴��̰ų�, �޴��� ���ڿ��� �մϴ�.");

					}

				} while (true);
			} else {// �α����� ����������
				System.out.println("���̵� �Ǵ� ��й�ȣ�� �߸��Է��Ͽ����ϴ�.");
				start();
			}
		} else if (number == 2) {// �����

			String userId = conInput("����� ���̵�");
			String userPwd = conInput("��й�ȣ");

			LoginTest userLo = new LoginTest(userId, userPwd);
			if (userLo.LogChk()) {// ����ڷ� �α��� ������

				// �⺻������ ����
				LibDataSet.basicDataSet();
				do {
					String menu = conInput("�޴�(1:å ���,2:������ �˻�,3:���ڸ� �˻�,4:���ǻ�� �˻�,5:���ǻ� ����,6:���� ����):");
					if (menu.equals("1")) {// å ���
						allBook();
					} else if (menu.equals("2")) {// ������ �˻�
						bookSeach();
					} else if (menu.equals("3")) {// ���ڸ� �˻�
						auSeach();
					} else if (menu.equals("4")) {// ���ǻ�� �˻�
						pubSeach();
					} else if (menu.equals("5")) {// ���ǻ� ����
						pbRegister();
					} else if (menu.equals("6")) {// ���� ����
						auRegister();
					} else {
						System.out.println("�޴��� �ٽ� �Է��ϼ���(�޴��� �����Դϴ�.)");
					}
				} while (true);
			} else {// �α��� ����������
				System.out.println("�߸��Է� �Ͽ����ϴ�.");
				start();
			}
		} else {// �߸� �Է� ������
			System.out.println("�ٽ� �Է��ϼ���.");

			start();
		}

	}

	// å���
	public void allBook() {
		Set<String> key = LibDataSet.list.keySet();
		Iterator<String> keyList = key.iterator();
		while (keyList.hasNext()) {
			LibraryVO ry = LibDataSet.list.get(keyList.next());
			System.out.printf(" %16s %6s %8s %16s %6s %8s\n", ry.getBookName(), ry.getAuthor(), ry.getGenre(),
					ry.getPublishingHouse(), ry.getAuthorEmail(), ry.getMoney());

		}
		System.out.println("��" + key.size() + "��");
	}

	// å ���
	public void LibRegister() {
		// å�� ����ҷ��� �����͸� �Է¹޾� HashMap�� �߰��Ѵ�.
		LibraryVO ry = new LibraryVO();
		ry.setBookName(conInput("å�̸�"));
		ry.setAuthor(conInput("����"));
		ry.setGenre(conInput("�帣"));
		ry.setPublishingHouse(conInput("���ǻ�"));
		ry.setAuthorEmail(conInput("���� �̸���"));
		ry.setMoney(conInput("����"));
		LibDataSet.list.put(ry.getBookName(), ry);

	}

	// ����
	public void LibEdit() {
		// å�̸�,����,�帣,���ǻ�,�̸���
		String LibName = conInput("������ å:");
		LibraryVO ry = LibDataSet.list.get(LibName);

		if (ry != null) {
			String part = conInput("������ ���[1:å�̸�,2:����,3:�帣,4:���ǻ�,5:�̸���,6:����]:");
			if (part.equals("1")) {// å�̸� ����
				String editData = conInput("å�̸�");
				ry.setBookName(editData);
			} else if (part.equals("2")) {// ���ڸ� ����
				String editData = conInput("���ڸ�");
				ry.setAuthor(editData);
			} else if (part.equals("3")) {// �帣 ����
				String editdata = conInput("�帣��");
				ry.setGenre(editdata);
			} else if (part.equals("4")) {// ���ǻ�
				String editdata = conInput("���ǻ� ��");
				ry.setPublishingHouse(editdata);
			} else if (part.equals("5")) {// �̸���
				String editdata = conInput("�̸��� ��");
				ry.setAuthorEmail(editdata);
			} else if (part.equals("6")) {// ����
				String editdata = conInput("����");
				ry.setMoney(editdata);
			} else {// ���� ó��
				System.out.println("�Է��Ͻ� ����� �����ϴ�.");
			}
		} else {
			System.out.println("�������� ���Ͽ����ϴ�. �ٽ� �����ϼ���.");
		}
	}

	// å ����
	public void LibRemove() {
		String bookName = conInput("������ å�̸� �Է�");
		LibDataSet.list.remove(bookName);
	}

	// ���ǻ� ����
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

	// ���ǻ� ���� ���
	public void pbCrystal() {
		// å�� ����ҷ��� �����͸� �Է¹޾� HashMap�� �߰��Ѵ�.
		publishingHouseVO pb = new publishingHouseVO();
		pb.setPubName(conInput("���ǻ� �̸�"));
		pb.setPubPhone(conInput("���ǻ� ��ȭ��ȣ"));
		pb.setPubEmail(conInput("���ǻ� �̸޹�"));
		pb.setPubFirstName(conInput("���ǻ� ��ǥ�ڸ�"));

		pubDataSet.list1.put(pb.getPubName(), pb);
	}

	// ���� ����
	public void auRegister() {
		Set<String> key = auDataSet.list2.keySet();
		Iterator<String> keyList = key.iterator();
		while (keyList.hasNext()) {
			authorVO au = auDataSet.list2.get(keyList.next());
			System.out.printf("%10s %16s %10s %16s %16s \n", au.getAuthorName(), au.getDebutDate(), au.getDebutWork(),
					au.getAuEmail(), au.getAuHomeAdress());
		}
	}

	// ���� ���� ���
	public void auCrystal() {
		// å�� ����ҷ��� �����͸� �Է¹޾� HashMap�� �߰��Ѵ�.
		authorVO au = new authorVO();
		au.setAuthorName(conInput("���ڸ�"));
		au.setDebutDate(conInput("���� ����"));
		au.setDebutWork(conInput("���� ��ǰ"));
		au.setAuEmail(conInput("���� �̸���"));
		au.setAuHomeAdress(conInput("���� Ȩ�������ּ�"));

		auDataSet.list2.put(au.getDebutDate(), au);
	}

	// ������ �˻�
	public void bookSeach() {
		String str = conInput("ã���� �������� �Է��ϼ���:");
		Set<String> key = LibDataSet.list.keySet(); // ��ü�� ��ȯ
		Iterator<String> keyList = key.iterator();
		while (keyList.hasNext()) { // key���� �ִ��� Ȯ���ϰ� �����Ѵ�.
			String key1 = keyList.next();
			LibraryVO vo = LibDataSet.list.get(key1); // get��ü�� ��������
			if (vo.getBookName().indexOf(str) != -1) {
				System.out.printf("%6s %6s\t %6s\t %6s\t %10s\t %10s\n ", vo.getBookName(), vo.getAuthor(),
						vo.getGenre(), vo.getPublishingHouse(), vo.getAuthorEmail(), vo.getMoney());
			}

		}
	}

	// ���ǻ� �˻�
	public void pubSeach() {
		String str = conInput("ã���� ���ǻ縦  �Է��ϼ���:");
		Set<String> key = pubDataSet.list1.keySet(); // ��ü�� ��ȯ
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

	// ���ڸ� �˻�
	public void auSeach() {
		String str = conInput("ã���� ���ڸ��� �Է��ϼ���:");
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
