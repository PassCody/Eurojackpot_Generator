package com.github.PassCody.Eurojackpot_Generator.Generator;

public class GeneratorMain {

    private ProbabilityCalculator pc;
    private GenerateNumbers numbers;
    public LottoNumbers lotto = new LottoNumbers();

    public GeneratorMain() {
        pc = new ProbabilityCalculator();
        generateAndCalculateProbabilities();
        lotto.executeLotto(pc.getTopEntries(pc.getNNumb(), 50), pc.getTopEntries(pc.getENumb(), 12));
    }

    private void generateAndCalculateProbabilities() {
        for (int index = 0; index < 140000000; index++) {
            this.numbers = new GenerateNumbers();
            this.numbers.executeGenerator();
            pc.executeCalculator(this.numbers.getNormalNumbers(), this.numbers.getEuroNumbers());
        }
    }
}
