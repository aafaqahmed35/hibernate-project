package org.aafaq;

import org.aafaq.util.WorkerOperations;

public class Main {

    public static void main(String[] args) {

        WorkerOperations work = new WorkerOperations();

        work.insertEmployee();

        work.getEmployeeRow();

        work.closeFactory();
    }
}