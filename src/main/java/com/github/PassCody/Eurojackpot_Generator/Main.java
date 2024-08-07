package com.github.PassCody.Eurojackpot_Generator;

import com.github.PassCody.Eurojackpot_Generator.GUI.*;
import com.github.PassCody.Eurojackpot_Generator.Generator.GeneratorMain;

public class Main {

    private GeneratorMain generator;

    public Main() {
        generator = new GeneratorMain();
        System.out.println(generator.lotto.getNormalNumbers());
        System.out.println(generator.lotto.getEuroNumbers());
    }

    public static void main(String[] args) {
        new Main();
    }
}
