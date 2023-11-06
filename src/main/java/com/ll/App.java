package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    Scanner scanner;
    int lastQuotationId;
    List<Quotation> quotations;

    public App(){
        scanner = new Scanner(System.in);
        lastQuotationId = 0;
        quotations = new ArrayList<>();
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

                lastQuotationId++;
                int id = lastQuotationId;

                Quotation quotation = new Quotation(id, content, authorName);
                quotations.add(quotation);

                System.out.printf("%d번 명언이 등록되었습니다.\n", lastQuotationId);
            }
        }
    }
}
