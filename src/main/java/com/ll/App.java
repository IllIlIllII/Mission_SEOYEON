package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    Scanner scanner;
    int lastQuotationId;
    List<Quotation> quotations;

    public App() {
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
            } else if (cmd.equals("등록")) {
                actionWrite();
            } else if (cmd.equals("목록")) {
                actionList();
            } else if (cmd.startsWith("삭제")) {
                actionRemove(cmd);
            }
        }
    }

    void actionRemove(String cmd) {
        int id = getParamAsInt(cmd, "id", 0);

        if (id == 0) {
            System.out.println("id를 정확히 입력해주세요.");
            return;
        }

        System.out.printf("%d번 명언을 삭제합니다.\n", id);
    }

    int getParamAsInt(String cmd, String paramName, int defaultValue) {
        String[] cmdBits = cmd.split("\\?", 2);
        String quertString = cmdBits[1];

        String[] queryStringBits = quertString.split("&");

        for (int i = 0; i < queryStringBits.length; i++) {
            String queryParam = queryStringBits[i];

            String[] queryParamBits = queryParam.split("=", 2);

            String _paramName = queryParamBits[0];
            String paramValue = queryParamBits[1];

            if (_paramName.equals(paramName)) {
                try {
                    return Integer.parseInt(paramValue);
                } catch (NumberFormatException e) {
                    return defaultValue;
                }
            }
        }
        return defaultValue;
    }

    void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("------------------");

        if (quotations.isEmpty())
            System.out.println("등록된 명언이 없습니다.");

        for (int i = quotations.size() - 1; i >= 0; i--) {
            Quotation quotation = quotations.get(i);
            System.out.printf("%d / %s / %s\n", quotation.id, quotation.authorName, quotation.content);
        }
    }

    void actionWrite() {
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
