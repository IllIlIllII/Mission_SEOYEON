package com.ll;

import java.util.Scanner;

public class App {
    Scanner scanner;

    public App(){
        scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                break;
            }
            else if (cmd.equals("등록")) {
                System.out.print("명언: ");
                String content = scanner.nextLine();
                System.out.print("작가: ");
                String authorName = scanner.nextLine();
                System.out.println("명언이 등록되었습니다.");
            }
        }
    }
}
