package domain.recruitment;

import domain.recruitment.Candidate;

public class Main{
    public static void main(String[] args){
        System.out.println("Hello, world!");

        Candidate marius = new Candidate();
        marius.setName("bunaaaa");
        System.out.println(marius.getName());

        Position salahorSoftware = new Position();

        salahorSoftware.startRecruitment();
    }
}