package ru.job4j.inheritance;

public class ReportUsage {
    public static void main(String[] args) {
        JSONReport j = new JSONReport();
        System.out.println(j.generate("Report's name", "Report's body"));
    }
}
