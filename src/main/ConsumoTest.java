package main;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Rule;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class ConsumoTest {
    public static void main(String[] args) {
        FIS fis = FIS.load("src/resource/consumo_carro.fcl", true);

        JFuzzyChart.get().chart(fis.getFunctionBlock("consumo_carro"));

        fis.setVariable("potencia", 80);
        fis.setVariable("peso", 2200);
        fis.setVariable("aceleracao", 22);

        fis.evaluate();

        Variable consumo = fis.getFunctionBlock("consumo_carro").getVariable("consumo");
        JFuzzyChart.get().chart(consumo, consumo.getDefuzzifier(), true);

        System.out.println(consumo.getValue());

        for (Rule r : fis.getFunctionBlock("consumo_carro").getFuzzyRuleBlock("No1").getRules()) {
            System.out.println(r);
        }

    }
}


