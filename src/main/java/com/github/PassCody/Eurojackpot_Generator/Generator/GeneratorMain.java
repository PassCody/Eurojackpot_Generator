package com.github.PassCody.Eurojackpot_Generator.Generator;

public class GeneratorMain {

    private final GenerateNumbers numbers;

    public GeneratorMain() {
        this.numbers = new GenerateNumbers();
        this.numbers.executeGenerator();
        System.out.println(this.numbers.getNormalNumbers());
        System.out.println(this.numbers.getEuroNumbers());
    }


}
