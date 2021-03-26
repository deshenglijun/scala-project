package com.offcn.bigdata.p1;

public class OverrideOps {
    public static void main(String[] args) {
        Fu fu = new Zi();
        fu.llllllllllllll();
    }
}
class Fu {
    public void llllllllllllll() {
        System.out.println("fu");
    }
}

class Zi extends Fu {

    public void lllllll1llllll() {
        System.out.println("zi");
    }

    @Override
    public void llllllllllllll() {
        super.llllllllllllll();
        System.out.println("zi");
    }
}
