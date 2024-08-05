package com.github.PassCody.Eurojackpot_Generator;

import com.github.PassCody.Eurojackpot_Generator.GUI.*;
import com.github.PassCody.Eurojackpot_Generator.Generator.GeneratorMain;

public class Main {

    private GeneratorMain generator;

    public Main() {
        for (int i = 0; i < 140000000; i++) {
            generator = new GeneratorMain();
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
